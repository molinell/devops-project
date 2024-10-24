package org.irel;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//stop ignoring

public class GameV1 {
	private int rounds;
	private Player player;
	private ArrayList<Question> questions;

	GameV1() {
		questions = Question.generateQuestions();
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many rounds of questions?: ");
		String roundsString = scanner.nextLine();
		int r = Integer.parseInt(roundsString);
		if (r > questions.size())
			r = questions.size();
		this.rounds = r;

		System.out.println("*** Welcome to quiz game ***");

		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		System.out.print("Enter your age: ");
		int age = scanner.nextInt();

		if (age < 16) {
			System.out.println("ERROR: You're too young to play");
			System.exit(1);
		}

		this.player = new Player(name, age);
	}

	public void run() {
		int points = 0;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Question> unUsedQ = questions;
		int gameRounds = rounds;
		while (gameRounds > 0) {
			Question currentQ = unUsedQ.get((new Random()).nextInt(unUsedQ.size()));

			System.out.printf("*** %s ***\n", currentQ.getQuestion());
			System.out.printf("1: %s    2: %s\n3: %s    4: %s\n", currentQ.getAnswerOptions().get(0),
					currentQ.getAnswerOptions().get(1), currentQ.getAnswerOptions().get(2),
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
	}



	public int getGameRounds() {
		return rounds;
	}

	public Player getPlayer() {
		return player;
	}

}
