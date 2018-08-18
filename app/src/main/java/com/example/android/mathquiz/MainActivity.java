package com.example.android.mathquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView txtQuestion;

    private Button btnAnswerA;
    private Button btnAnswerB;
    private Button btnAnswerC;
    private Button btnAnswerD;

    private TextView txtScore;

    private int currentQuestionIndex = 0;
    private Question currentQuestion;
    private int score = 0;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        prepareNextQuestion();

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.music);
        mediaPlayer.start();
    }

    private void prepareNextQuestion() {

        if(currentQuestionIndex < Questions.allQuestions.length) {

            currentQuestion = Questions.allQuestions[currentQuestionIndex];

            txtQuestion.setText(currentQuestion.getQuestion());

            btnAnswerA.setText(currentQuestion.getAnswerA());
            btnAnswerB.setText(currentQuestion.getAnswerB());
            btnAnswerC.setText(currentQuestion.getAnswerC());
            btnAnswerD.setText(currentQuestion.getAnswerD());
        }
        else {
            txtQuestion.setText("You have successfuly ended the quiz!");

            btnAnswerA.setVisibility(View.INVISIBLE);
            btnAnswerB.setVisibility(View.INVISIBLE);
            btnAnswerC.setVisibility(View.INVISIBLE);
            btnAnswerD.setVisibility(View.INVISIBLE);

            mediaPlayer.stop();
        }
    }

    private void initializeViews() {
        txtQuestion = (TextView)findViewById(R.id.txtQuestion);

        btnAnswerA = (Button)findViewById(R.id.btnAnswerA);
        btnAnswerB = (Button)findViewById(R.id.btnAnswerB);
        btnAnswerC = (Button)findViewById(R.id.btnAnswerC);
        btnAnswerD = (Button)findViewById(R.id.btnAnswerD);

        txtScore = (TextView)findViewById(R.id.txtScore);
    }

    private void updateScore(int by)
    {
        score += by;
        txtScore.setText("Score: " + score);
    }

    private void performAnswerCheck(char answer) {
        if(currentQuestion.isAnswerCorrect(answer)) {
            currentQuestionIndex++;
            updateScore(2);
            prepareNextQuestion();
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();

        }
        else {
            updateScore(-1);
            Toast.makeText(this, "Wrong answer!", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnAnswerA_OnClick(View view) {
        performAnswerCheck('A');

    }

    public void btnAnswerB_OnClick(View view) {
        performAnswerCheck('B');
    }

    public void btnAnswerC_OnClick(View view) {
        performAnswerCheck('C');
    }

    public void btnAnswerD_OnClick(View view) {
        performAnswerCheck('D');
    }
}
