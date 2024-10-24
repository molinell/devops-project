package org.irel;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameV4 {
	// Suggest questions and category to game developers
	// Utils methods added 

	
		private int rounds;
		private Player player;
		private ArrayList<Question> questions;

		GameV4() {
			// Same code as earlier
			generateQuestions();
			Scanner scanner = new Scanner(System.in);
			System.out.print("How many rounds of questions?: ");
			String roundsString = scanner.nextLine();
			int r = Integer.parseInt(roundsString);
			if (r > questions.size())
				r = questions.size();
			this.rounds = r;

			System.out.println("*** Welcome to quiz game ***");

			System.out.print("Enter your name: ");
			String name = Utils.getStringInput();

			System.out.print("Enter your age: ");
			int age = Utils.getIntInput();

			if (age < 16) {
				System.out.println("ERROR: You're too young to play");
				System.exit(1);
			}

			this.player = new Player(name, age);

			// Version 2 code with category
			System.out.println("\nPlease select a category:");
			for (Question.Categories category : Question.Categories.values()) {
				System.out.println(category.ordinal() + 1 + ". " + category);
			}
			int categorySelection = scanner.nextInt();
			Question.Categories selectedCategory = Question.Categories.values()[categorySelection - 1];
			scanner.nextLine();

			System.out.println("\nYou selected: " + selectedCategory + "\n");

			run(selectedCategory);
		}

		public void run(Question.Categories selectedCategory) {
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
            	String [] questions = new String[ size ];
            	 
            	
            	for (int i=0; i < questions.length; i++) {
            		System.out.print("Please submit question " + (i + 1) + ": "); 
                    questions[i] =  Utils.getStringInput();
            	}
                System.out.println("Thank you for your submission!");
            	
            } 
            
            if (noYes.equalsIgnoreCase("no") || noYes.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing!");
                }

		}

		private void generateQuestions() {
			questions = new ArrayList<>();

			questions.add(new Question(Question.Categories.POLITICS, "Who is the current president of finland?", 0,
					new String[] { "Alexander Stubb", "Petteri Orpo", "Sauli Niinistö", "Donald Duck" }));
			questions.add(new Question(Question.Categories.POLITICS, "Who is the PM party of finland", 1,
					new String[] { "SDP", "Kok.", "PS", "Kesk." }));
			questions.add(new Question(Question.Categories.POLITICS, "Which percentage of alcohol can you buy in store?", 3,
					new String[] { "6%", "5,5%", "8,5%", "8%" }));
			questions.add(new Question(Question.Categories.POLITICS,
					"Which US state considers that pickles should bounce to be safe for human consumption", 0,
					new String[] { "Connecticut", "New York", "New Hampshire", "Pennsylvania" }));
			questions.add(new Question(Question.Categories.POLITICS, "Which italian politician dissed finnish food?", 1,
					new String[] { "Antonio Mazzone", "Silvio Berlusconi", "Lucio Magri", "Ernesto Nathan" }));

			questions.add(new Question(Question.Categories.FOOD, "Which of the following is not a grain?", 2,
					new String[] { "chia", "spelt", "potatoes", "peanuts" }));
			questions.add(new Question(Question.Categories.FOOD,
					"What fruit is known as 'the king of fruits' in many south asian countries?", 1,
					new String[] { "Mango", "Durian", "Pineapple", "Papaya" }));
			questions.add(new Question(Question.Categories.FOOD, "Which spice is commonly used in Indian curry dishes", 2,
					new String[] { "Basil", "Paprika", "Turmeric", "Rosemary" }));
			questions.add(new Question(Question.Categories.FOOD,
					"What fruit is known as 'the king of fruits' in many south asian countries?", 2,
					new String[] { "Mango", "Durian", "Pineapple", "Papaya" }));
			questions.add(
					new Question(Question.Categories.FOOD, "Which of the following food is the netherlands NOT famous for?",
							3, new String[] { "Apple pie", "Stroopwaffle", "Poffertjes", "Speculaas" }));
			questions.add(new Question(Question.Categories.FOOD, "Which of the following is a traditional finnish food?", 0,
					new String[] { "Lax soppa", "Janssons frestelse", "Smörrebröd", "Fårikål" }));

			questions.add(new Question(Question.Categories.POP_CULTURE, "How old is Elon Musk", 0,
					new String[] { "53", "40", "61", "57" }));
			questions.add(new Question(Question.Categories.POP_CULTURE, "Who founded amazon?", 1,
					new String[] { "Elon Musk", "Jeff Bezos", "Mark Zuckerberg", "Warren Buffet" }));
			questions.add(new Question(Question.Categories.POP_CULTURE, "What was the original version of facebook?", 2,
					new String[] { "TheFaceBook", "FaceSmash", "FaceMash", "Face Book" }));
			questions.add(new Question(Question.Categories.POP_CULTURE, "What is Warren Buffets favorite restaurant?", 0,
					new String[] { "Mac Donald's", "KFC", "Five guys", "Wendy's" }));
			questions.add(new Question(Question.Categories.POP_CULTURE, "Who did Steve Jobs exploit?", 2,
					new String[] { "Michal Solowow", "Robert Lewandowski", "Steve Wozniak", "Mikolaj Kopernik" }));

			questions.add(new Question(Question.Categories.GEOGRAPHY, "Which of the following countries is not in europe?",
					1, new String[] { "Cyprus", "Kazakhstan", "Poland", "England" }));
			questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of India?", 0,
					new String[] { "New Delhi", "Budaun Sadar", "Mumbai", "Nagpur" }));
			questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Egypt?", 3,
					new String[] { "Alexandria", "Bani Mazar", "Mallawi", "Cairo" }));
			questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Mongolia?", 2,
					new String[] { "Uliastai", "Sergelen", "Ulaanbaatar", "Altanbulag" }));
			questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Cote D'Ivore?", 0,
					new String[] { "Abidjan", "Divo", "Man", "Korhogo" }));
			questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Brazil?", 2,
					new String[] { "La Paz", "Asuncion", "Brasilia", "Manaus" }));

			questions.add(new Question(Question.Categories.CONTROVERSY,
					"Who is the most erratic person on X (formerly known as Twitter)", 4,
					new String[] { "Donald Trump", "Andrew Tate", "Kanye West", "Elon Musk" }));
			questions.add(new Question(Question.Categories.CONTROVERSY,
					"Who of the following does not have allegations of sexual abuse (for now)", 1,
					new String[] { "P Diddy", "Tom Hanks", "R. Kelly", "Jeffrey Epstein" }));
			questions
					.add(new Question(Question.Categories.CONTROVERSY, "What scandal happened 2015 involving Steve Harvey?",
							0, new String[] { "He crowned the wrong miss universe", "Forgot his script in a SNL episode",
									"Falsely rumored to be dead", "Twerked during the VMA" }));
		}

		public int getGameRounds() {
			return rounds;
		}

		public Player getPlayer() {
			return player;
		}

	}

