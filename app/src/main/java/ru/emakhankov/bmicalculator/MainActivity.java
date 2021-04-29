package ru.emakhankov.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private RadioButton maleButton;
    private RadioButton femaleButton;

    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;

    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();;

        setupButtonClickListener();

        //resultText.setText("Woohoo, I can update my textView using code");


//        String alertText = "Wow I can make an alert";
//        Toast.makeText(this, alertText, Toast.LENGTH_LONG).show();

    }



    private void findViews() {

        resultText  = findViewById(R.id.text_view_result);
        maleButton  = findViewById(R.id.radio_button_male);
        femaleButton   = findViewById(R.id.radio_button_female);
        ageEditText   = findViewById(R.id.edit_text_age);
        feetEditText  = findViewById(R.id.edit_text_feet);
        inchesEditText  = findViewById(R.id.edit_text_inches);
        weightEditText  = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmiResult = calculateBmi();

                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }
                //Toast.makeText(MainActivity.this, "Wow! We can react to button click", Toast.LENGTH_LONG).show();
            }
        });
    }



    private double calculateBmi() {

        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;
        double heightInMeters = totalInches * 0.0254;

        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);
        //String bmiTextResult = String.valueOf(bmi);

        String fullResultString;
        if (bmi < 18.5) {
            fullResultString = bmiTextResult + " - You are underweight";
        } else if (bmi > 25) {
            fullResultString = bmiTextResult + " - You are overweight";
        } else {
            fullResultString = bmiTextResult + " - You are healthy weight";
        }
        resultText.setText(fullResultString);
    }


    private void displayGuidance(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);
        String fullResultString;
        if (maleButton.isChecked()) {
            fullResultString = bmiTextResult + " - As you under 18, please consult with your doctor for heathy boys";
        } else if (femaleButton.isChecked()) {
            fullResultString = bmiTextResult + " - As you under 18, please consult with your doctor for heathy girls";
        } else {
            fullResultString = bmiTextResult + " - As you under 18, please consult with your doctor";
        }

        resultText.setText(fullResultString);
    }
}