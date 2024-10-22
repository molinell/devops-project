package org.irel;

import java.util.ArrayList;
import java.util.Arrays;

//change
public class Question {

    private Categories category;
    private String question;
    private int correctAnswer;
    private ArrayList<String> answerOptions;

    public enum Categories {
        POLITICS,
        GEOGRAPHY,
        POP_CULTURE,
        FOOD,
        CONTROVERSY
    }

    Question(Categories category, String question, int correctAnswer, String[] answerOptions){
        this.category = category;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answerOptions = new ArrayList<>(Arrays.asList(answerOptions));
    }

    public String getQuestion() {
            return question;
        }
    public int getCorrectAnswer() {
            return correctAnswer;
        }
    public ArrayList<String> getAnswerOptions() {
            return answerOptions;
        }
    public Categories getCategory() {
            return category;
        }

}


