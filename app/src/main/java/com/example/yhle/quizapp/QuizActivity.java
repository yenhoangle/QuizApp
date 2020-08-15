package com.example.yhle.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity implements android.view.View.OnClickListener {
    private Button trueBtn;
    private Button falseBtn;
    private ImageButton nextBtn;
    private TextView questionTextView;
    private  int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueBtn = findViewById(R.id.true_button);
        falseBtn = findViewById(R.id.false_button);
        nextBtn= findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.answer_text_view);

        //instead of having to override onclick every time for both true and false button, we can use
        //OnClickListener interface and switch statement for multiple buttons
        trueBtn.setOnClickListener(this);
        falseBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.true_button:
                break;
            case R.id.false_button:
                break;
            case R.id.next_button:
                //makes sure questions cycle back to the beginning
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
        }
    }
}