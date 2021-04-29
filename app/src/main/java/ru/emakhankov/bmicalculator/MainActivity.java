package ru.emakhankov.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView resultText  = findViewById(R.id.text_view_result);
        RadioButton maleButton   = findViewById(R.id.radio_button_male);
        RadioButton femaleButton   = findViewById(R.id.radio_button_female);

        EditText ageEditText   = findViewById(R.id.edit_text_age);
        EditText feetEditText  = findViewById(R.id.edit_text_feet);
        EditText inchesEditText  = findViewById(R.id.edit_text_inches);
        EditText weightEditText  = findViewById(R.id.edit_text_weight);

        Button calculateButton = findViewById(R.id.button_calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wow! We can react to button click", Toast.LENGTH_LONG).show();
            }
        });


        //resultText.setText("Woohoo, I can update my textView using code");





//        String alertText = "Wow I can make an alert";
//        Toast.makeText(this, alertText, Toast.LENGTH_LONG).show();

    }
}