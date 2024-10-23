package org.irel;

import java.util.ArrayList;

public class GameV2 {
	// Add accounts
	// sign-up and login
	// Store scores, name and age
	
	GameV2(){
		DB db = new DB(); 
        ArrayList<Player> users = db.getUsers();
		
		for (Player player : users) {
            System.out.printf("Player: %s, Age: %d, Score: %d\n", player.getName(), player.getAge(), player.getScore());
        }

	}

}
