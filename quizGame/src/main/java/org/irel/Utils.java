package org.irel;

import java.util.Scanner;

public class Utils {

	static int getIntInput() {
		Scanner scanner = new Scanner(System.in);
		String userInp = scanner.nextLine();

		while (true) {
			try {
				while (userInp.matches("[a-zA-Z- ]+")) {
					System.out.printf("Only use numbers, please ");
					userInp = scanner.nextLine();

				}
				break;

			} catch (Exception e) {
				System.out.println("Submit an Integer!");

			}
		}  return Integer.parseInt(userInp);

	}

	static String getStringInput() {
		Scanner scanner = new Scanner(System.in);
		String userInp = scanner.nextLine();

		while (true)
			try {
				while (!userInp.matches("[a-zA-Z- ]+")) {
					System.out.printf("Only use characters, please ");
					userInp = scanner.nextLine();
				}
				break;

			} catch (Exception e) {
				System.out.println("Something went wrong");

			}
		return userInp;
	}

}
