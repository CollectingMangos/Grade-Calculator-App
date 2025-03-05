package com.example.gradecalculatorapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText studentNameEditText, mathScoreEditText, scienceScoreEditText, englishScoreEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        studentNameEditText = findViewById(R.id.studentNameEditText);
        mathScoreEditText = findViewById(R.id.mathScoreEditText);
        scienceScoreEditText = findViewById(R.id.scienceScoreEditText);
        englishScoreEditText = findViewById(R.id.englishScoreEditText);
        resultTextView = findViewById(R.id.resultTextView);
        Button calculateButton = findViewById(R.id.calculateButton);

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(v -> calculateGrade());
    }

    private void calculateGrade() {
        // Retrieve input values
        String studentName = studentNameEditText.getText().toString();
        String mathScoreStr = mathScoreEditText.getText().toString();
        String scienceScoreStr = scienceScoreEditText.getText().toString();
        String englishScoreStr = englishScoreEditText.getText().toString();

        // Validate input
        if (studentName.isEmpty() || mathScoreStr.isEmpty() || scienceScoreStr.isEmpty() || englishScoreStr.isEmpty()) {
            resultTextView.setText("Please fill in all fields.");
            return;
        }

        // Parse scores
        int mathScore = Integer.parseInt(mathScoreStr);
        int scienceScore = Integer.parseInt(scienceScoreStr);
        int englishScore = Integer.parseInt(englishScoreStr);

        // Calculate average
        int average = (mathScore + scienceScore + englishScore) / 3;

        // Determine grade
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

        // Display result
        String result = "Student: " + studentName + "\nAverage: " + average + "\nGrade: " + grade;
        resultTextView.setText(result);
    }
}