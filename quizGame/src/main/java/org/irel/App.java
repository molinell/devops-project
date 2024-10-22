package org.irel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Log in 
 */
public class App {
	
    private List<String[]> friends;

public String[] FBfriends(String name) {
    	
    	for (String[] listofFriends : friends) {
    		if (listofFriends[0].equalsIgnoreCase(name)) {
                return Arrays.copyOfRange(listofFriends, 1, listofFriends.length);
    		}
    	}
    	return new String[]{};
    	}
    public static void main(String[] args) {
    	
    	 App app = new App();
    	 Scanner scanner = new Scanner(System.in); 
        System.out.println("Hello World!");
        
        
        System.out.println("Enter the name of the person to get their friends: ");
        
		
		String name = scanner.nextLine();  // Get user input from the terminal

       
		String[] result = app.FBfriends(name);

         if (result.length > 0) {
             System.out.println(name + "'s friends: " + String.join(", ", result));
         } else {
             System.out.println("No friends found for " + name);
         }

         scanner.close();  // Close the scanner to avoid resource leaks
    }
}
