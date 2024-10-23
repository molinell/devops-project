package org.irel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    Question question;

    @BeforeEach
    void setUp() {
        question = new Question(Question.Categories.FOOD, "Which of the following is a traditional finnish food?", 0,
                    new String[] { "Lax soppa", "Janssons frestelse", "Smörrebröd", "Fårikål" });
    }
    @Test
    void getQuestion() {
        assertTrue(question.getQuestion().equalsIgnoreCase("Which of the following is a traditional finnish food?"));
        assertFalse(question.getQuestion().equalsIgnoreCase("Which of the following is a traditional swedish food?"));
    }

    @Test
    void getCorrectAnswer() {
        assertEquals(question.getCorrectAnswer(), 0);
        assertNotEquals(question.getCorrectAnswer(), 2);
    }

    @Test
    void getAnswerOptions() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList( "Lax soppa", "Janssons frestelse", "Smörrebröd", "Fårikål" ));
        assertEquals(question.getAnswerOptions(), expected);

        expected = new ArrayList<>(Arrays.asList( "Lax soppa", "Janssons frestelse", "Smörrebröd", "Memma" ));
        assertNotEquals(question.getAnswerOptions(), expected);
    }

    @Test
    void getCategory() {
        assertEquals(question.getCategory(), Question.Categories.FOOD);
        assertNotEquals(question.getCategory(), Question.Categories.GEOGRAPHY);
    }
}