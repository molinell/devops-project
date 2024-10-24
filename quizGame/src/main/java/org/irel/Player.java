package org.irel;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int age;
    private String password;
    private int score;



    public Player (String name, int age, String password, int score) {
        this.name = name;
	    this.age = age;
        this.password = password;
        this.score = score;
    }

    public Player (String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
