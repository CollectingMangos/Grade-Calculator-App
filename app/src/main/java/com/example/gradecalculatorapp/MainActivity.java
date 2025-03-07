package com.example.gradecalculatorapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText studentNameEditText, mathScoreEditText, scienceScoreEditText, englishScoreEditText;
    private TextView studentNameTextView,mathsScoreTextView, scienceScoreTextView, englishScoreTextView, resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentNameTextView = findViewById(R.id.studentNameTextView);
        studentNameEditText = findViewById(R.id.studentNameEditText);
        mathsScoreTextView = findViewById(R.id.mathsScoreTextView);
        mathScoreEditText = findViewById(R.id.mathScoreEditText);
        scienceScoreTextView = findViewById(R.id.scienceScoreTextView);
        scienceScoreEditText = findViewById(R.id.scienceScoreEditText);
        englishScoreTextView = findViewById(R.id.englishScoreTextView);
        englishScoreEditText = findViewById(R.id.englishScoreEditText);
        resultTextView = findViewById(R.id.resultTextView);
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(v -> calculateGrade());
    }

    private void calculateGrade() {
        String studentName = studentNameEditText.getText().toString();
        String mathScoreStr = mathScoreEditText.getText().toString();
        String scienceScoreStr = scienceScoreEditText.getText().toString();
        String englishScoreStr = englishScoreEditText.getText().toString();

        if (studentName.isEmpty() || mathScoreStr.isEmpty() || scienceScoreStr.isEmpty() || englishScoreStr.isEmpty()) {
            resultTextView.setText("Please fill in ALL fields!");
            return;
        }

        int mathScore = Integer.parseInt(mathScoreStr);
        int scienceScore = Integer.parseInt(scienceScoreStr);
        int englishScore = Integer.parseInt(englishScoreStr);

        int average = (mathScore + scienceScore + englishScore) / 3;

        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else {
            grade = "F";
        }

        String result = "Name: " + studentName + "\nAverage Score: " + average + "\nGrade: " + grade;
        resultTextView.setText(result);
    }
}