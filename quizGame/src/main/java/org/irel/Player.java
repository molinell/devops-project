package org.irel;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int age;
    private String password;


    public Player (String name, int age, String password) {
        this.name = name;
	    this.age = age;
        this.password = password;
    }

    public Player (String name, int age){
        this.name = name;
        this.age = age;
    }
    
}
