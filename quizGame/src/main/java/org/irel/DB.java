package org.irel;

import java.util.ArrayList;
import java.util.List;
import org.irel.Player;

public class DB {
	private ArrayList<Player> users;
	
	public DB() {
	users = new ArrayList<>();

    users.add(new Player("Elon", 53, "space", 5));
    users.add(new Player("Jeff", 60, "amazon", 1));
    users.add(new Player("Mark", 40, "facebook", 4));
    }
	
	public ArrayList<Player> getUsers() {
        return users;
    }
}
