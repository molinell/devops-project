package org.irel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBTest {
	
	 DB db;
	 ArrayList<Player> users;
	 
	 @BeforeEach
     void setUp() {
		 db = new DB();
	 }

	 @Test
	 void getUsers() {
	     ArrayList<Player> users = db.getUsers();

         assertEquals("Elon", users.get(0).getName());
         assertEquals(53, users.get(0).getAge());
         assertEquals("space", users.get(0).getPassword());
         assertEquals(5, users.get(0).getScore());
         
         assertEquals("Jeff", users.get(1).getName());
         assertEquals(60, users.get(1).getAge());
         assertEquals("amazon", users.get(1).getPassword());
         assertEquals(1, users.get(1).getScore());

         assertEquals("Mark", users.get(2).getName());
         assertEquals(40, users.get(2).getAge());
         assertEquals("facebook", users.get(2).getPassword());
         assertEquals(4, users.get(2).getScore());
	 }
	

}
