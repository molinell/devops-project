package org.irel;

import java.util.ArrayList;
import java.util.List;
import org.irel.Player;

public class DB {
	private List<Player> users;
	
	public DB() {
	users = new ArrayList<>();

    users.add(new Player("Elon", 53, "space"));
    users.add(new Player("Jeff", 60, "amazon"));
    users.add(new Player("Mark", 40, "facebook"));
    }
	
	// Logga in genom att se om index 0 (namnet) matchar index 2 (password) i arrayen
	public List<Player> getUsers() {
        return users;
    }
}
