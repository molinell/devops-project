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

    public static ArrayList<Question> generateQuestions() {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(Question.Categories.POLITICS, "Who is the current president of finland?", 0,
                new String[] { "Alexander Stubb", "Petteri Orpo", "Sauli Niinistö", "Donald Duck" }));
        questions.add(new Question(Question.Categories.POLITICS, "Who is the PM party of finland", 1,
                new String[] { "SDP", "Kok.", "PS", "Kesk." }));
        questions.add(new Question(Question.Categories.POLITICS, "Which percentage of alcohol can you buy in store?", 3,
                new String[] { "6%", "5,5%", "8,5%", "8%" }));
        questions.add(new Question(Question.Categories.POLITICS,
                "Which US state considers that pickles should bounce to be safe for human consumption", 0,
                new String[] { "Connecticut", "New York", "New Hampshire", "Pennsylvania" }));
        questions.add(new Question(Question.Categories.POLITICS, "Which italian politician dissed finnish food?", 1,
                new String[] { "Antonio Mazzone", "Silvio Berlusconi", "Lucio Magri", "Ernesto Nathan" }));

        questions.add(new Question(Question.Categories.FOOD, "Which of the following is not a grain?", 2,
                new String[] { "chia", "spelt", "potatoes", "peanuts" }));
        questions.add(new Question(Question.Categories.FOOD,
                "What fruit is known as 'the king of fruits' in many south asian countries?", 1,
                new String[] { "Mango", "Durian", "Pineapple", "Papaya" }));
        questions.add(new Question(Question.Categories.FOOD, "Which spice is commonly used in Indian curry dishes", 2,
                new String[] { "Basil", "Paprika", "Turmeric", "Rosemary" }));
        questions.add(
                new Question(Question.Categories.FOOD, "Which of the following food is the netherlands NOT famous for?",
                        3, new String[] { "Apple pie", "Stroopwaffle", "Poffertjes", "Speculaas" }));
        questions.add(new Question(Question.Categories.FOOD, "Which of the following is a traditional finnish food?", 0,
                new String[] { "Lax soppa", "Janssons frestelse", "Smörrebröd", "Fårikål" }));

        questions.add(new Question(Question.Categories.POP_CULTURE, "How old is Elon Musk", 0,
                new String[] { "53", "40", "61", "57" }));
        questions.add(new Question(Question.Categories.POP_CULTURE, "Who founded amazon?", 1,
                new String[] { "Elon Musk", "Jeff Bezos", "Mark Zuckerberg", "Warren Buffet" }));
        questions.add(new Question(Question.Categories.POP_CULTURE, "What was the original version of facebook?", 2,
                new String[] { "TheFaceBook", "FaceSmash", "FaceMash", "Face Book" }));
        questions.add(new Question(Question.Categories.POP_CULTURE, "What is Warren Buffets favorite restaurant?", 0,
                new String[] { "Mac Donald's", "KFC", "Five guys", "Wendy's" }));
        questions.add(new Question(Question.Categories.POP_CULTURE, "Who did Steve Jobs exploit?", 2,
                new String[] { "Michal Solowow", "Robert Lewandowski", "Steve Wozniak", "Mikolaj Kopernik" }));

        questions.add(new Question(Question.Categories.GEOGRAPHY, "Which of the following countries is not in europe?",
                1, new String[] { "Cyprus", "Kazakhstan", "Poland", "England" }));
        questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of India?", 0,
                new String[] { "New Delhi", "Budaun Sadar", "Mumbai", "Nagpur" }));
        questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Egypt?", 3,
                new String[] { "Alexandria", "Bani Mazar", "Mallawi", "Cairo" }));
        questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Mongolia?", 2,
                new String[] { "Uliastai", "Sergelen", "Ulaanbaatar", "Altanbulag" }));
        questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Cote D'Ivore?", 0,
                new String[] { "Abidjan", "Divo", "Man", "Korhogo" }));
        questions.add(new Question(Question.Categories.GEOGRAPHY, "What is the capital of Brazil?", 2,
                new String[] { "La Paz", "Asuncion", "Brasilia", "Manaus" }));

        questions.add(new Question(Question.Categories.CONTROVERSY,
                "Who is the most erratic person on X (formerly known as Twitter)", 3,
                new String[] { "Donald Trump", "Andrew Tate", "Kanye West", "Elon Musk" }));
        questions.add(new Question(Question.Categories.CONTROVERSY,
                "Who of the following does not have allegations of sexual abuse (for now)", 1,
                new String[] { "P Diddy", "Tom Hanks", "R. Kelly", "Jeffrey Epstein" }));
        questions
                .add(new Question(Question.Categories.CONTROVERSY, "What scandal happened 2015 involving Steve Harvey?",
                        0, new String[] { "He crowned the wrong miss universe", "Forgot his script in a SNL episode",
                        "Falsely rumored to be dead", "Twerked during the VMA" }));

        return questions;
    }

}


