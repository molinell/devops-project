package org.irel;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameV4 {
    // Suggest questions and category to game developers
    // Utils methods added

    private int rounds;
    private Player player;
    private ArrayList<Question> questions;

    private DB db = new DB();
    private ArrayList<Player> users;
    private boolean loggedIn = false;
    private boolean loginComplete = false;
    private HttpServer server;
    Question.Categories selectedCategory;

    GameV4() {
        this.users = db.getUsers();
        this.player = null;
        questions = Question.generateQuestions();

        if (!login()) {
            System.out.println("An error occured, try again later");
            System.exit(1);
        }

        //https://stackoverflow.com/questions/21124879/how-do-i-make-java-wait-for-a-method-to-finish-before-continuing
        //https://www.baeldung.com/java-wait-notify
        synchronized (this) {
            while (!loginComplete) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        server.stop(0);

        if (!loggedIn) System.exit(1);

        System.out.println("*** Quiz game ***");
        System.out.println("Welcome back " + player.getName());
        // Same code as earlier
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rounds of questions?: ");
        String roundsString = scanner.nextLine();
        int r = Integer.parseInt(roundsString);
        if (r > questions.size())
            r = questions.size();
        this.rounds = r;

        // Version 2 code with category
        System.out.println("\nPlease select a category:");
        for (Question.Categories category : Question.Categories.values()) {
            System.out.println(category.ordinal() + 1 + ". " + category);
        }
        int categorySelection = scanner.nextInt();
        this.selectedCategory = Question.Categories.values()[categorySelection - 1];
        scanner.nextLine();

        System.out.println("\nYou selected: " + selectedCategory + "\n");

    }

    public void run() {
        String noYes;
        int points = 0;
        Scanner scanner = new Scanner(System.in);
        // ArrayList<Question> unUsedQ = questions;
        int gameRounds = rounds;

        // Only show the selected category questions
        ArrayList<Question> filteredQuestions = new ArrayList<>();
        for (Question q : questions) {
            if (q.getCategory() == selectedCategory) {
                filteredQuestions.add(q);
            }
        }
        ArrayList<Question> unUsedQ = filteredQuestions;

        // Same code as earlier
        while (gameRounds > 0) {
            Question currentQ = unUsedQ.get((new Random()).nextInt(unUsedQ.size()));

            System.out.printf("*** %s ***\n", currentQ.getQuestion());
            System.out.printf("1: %s    2: %s\n3: %s    4: %s\n",
                    currentQ.getAnswerOptions().get(0),
                    currentQ.getAnswerOptions().get(1),
                    currentQ.getAnswerOptions().get(2),
                    currentQ.getAnswerOptions().get(3));

            while (true) {
                try {
                    String ans = scanner.nextLine();
                    if (!ans.matches("[1-4]"))
                        throw new IllegalArgumentException("Invalid input");
                    if (Integer.parseInt(ans) - 1 == currentQ.getCorrectAnswer()) {
                        System.out.println("Correct!");
                        points++;
                    } else {
                        System.out.println("Wrong");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            unUsedQ.remove(currentQ);
            gameRounds--;
        }
        System.out.println("\n*** Game Over ***");
        System.out.printf("You got %d / %d points\n", points, rounds);

        System.out.println("Would you like to suggest a category and questions to the game developers? yes/no ");
        noYes = Utils.getStringInput();
        if (noYes.equalsIgnoreCase("yes") || noYes.equalsIgnoreCase("y")) {
            System.out.print("Please submit a category:");
            String cat = Utils.getStringInput();
            System.out.print("\nHow many questions would you like to submit?:");
            int size = Utils.getIntInput();
            String[] questions = new String[size];


            for (int i = 0; i < questions.length; i++) {
                System.out.print("Please submit question " + (i + 1) + ": ");
                questions[i] = Utils.getStringInput();
            }
            System.out.println("Thank you for your submission!");

        }

        if (noYes.equalsIgnoreCase("no") || noYes.equalsIgnoreCase("n")) {
            System.out.println("Thank you for playing!");
        }

    }

    private boolean login() {
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/", new FormHandler());
            server.setExecutor(null); // creates a default executor
            server.start();
            System.out.println("Please navigate to the following link to login: http://localhost:8080/");
            return true;
        } catch (final IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    private class FormHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                String response = "<html><head><style>"
                        + "body {"
                        + "    display: flex;"
                        + "    justify-content: center;"
                        + "    align-items: center;"
                        + "    height: 100vh;"
                        + "    margin: 0;"
                        + "}"
                        + "form {"
                        + "    display: flex;"
                        + "    flex-direction: column;"
                        + "    align-items: center;"
                        + "}"
                        + "</style></head><body>"
                        + "<form method='POST'>"
                        + "    <label for='username'>Username:</label>"
                        + "    <input type='text' id='username' name='username'><br><br>"
                        + "    <label for='password'>Password:</label>"
                        + "    <input type='password' id='password' name='password'><br><br>"
                        + "    <input type='submit' value='Submit'>"
                        + "</form></body></html>";

                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else if ("POST".equals(exchange.getRequestMethod())) {
                StringBuilder sb = new StringBuilder();
                try (var is = exchange.getRequestBody()) {
                    int i;
                    while ((i = is.read()) != -1) {
                        sb.append((char) i);
                    }
                }
                String[] params = sb.toString().split("&");
                String username = params[0].split("=")[1];
                String password = params[1].split("=")[1];

                String response = "<html><body><h1>Invalid username or password</h1><body></html>";
                for (Player p : users) {
                    if (p.getName().equals(username)) {
                        if (p.getPassword().equals(password)) {
                            response = "<html><body><h1>Login successful, return to program to play</h1><body></html>";
                            loggedIn = true;
                            player = p;
                            break;
                        }
                    }
                }

                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

                synchronized (GameV4.this) {
                    loginComplete = true;
                    GameV4.this.notify();
                }
            }
        }
    }


    public int getGameRounds() {
        return rounds;
    }

    public Player getPlayer() {
        return player;
    }

}

