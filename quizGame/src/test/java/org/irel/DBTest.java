package org.irel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBTest {
	
	 DB db;
	 ArrayList<Player> users;
	 
	 @BeforeEach
     void setUp() {
    	users = new ArrayList<>();
	   	users.add(new Player("Name", 00, "password", 10));
	   	users.add(new Player("Name2", 22, "pass", 22));
	   	
    	db = new DB(users);

	 }


	@Test
	void getUsers() {
		ArrayList<Player> users = db.getUsers();
    	assertEquals(2, users.size());
    	
    	assertEquals("Name", users.get(0).getName());
        assertEquals(00, users.get(0).getAge());
        assertEquals("password", users.get(0).getPassword());
        
        assertEquals("Name2", users.get(1).getName());
        assertEquals(22, users.get(1).getAge());
        assertEquals("pass", users.get(1).getPassword());
		
	}

}
