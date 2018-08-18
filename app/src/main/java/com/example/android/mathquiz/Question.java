package com.example.android.mathquiz;

/**
 * Created by Emoke Hajdu on 1/28/2018.
 */

public class Question {

    public Question(String question, String answerA, String answerB, String answerC, String answerD, char correctAnswer) {
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public boolean isAnswerCorrect(char answer) {
        return answer == correctAnswer;
    }

    private String question;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    private char correctAnswer;
}
