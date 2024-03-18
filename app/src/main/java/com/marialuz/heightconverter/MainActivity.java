package com.marialuz.heightconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButtonListener();
    }

    private void findViews(){
        inchesEditText = findViewById(R.id.edit_text_height_in_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }

    private void calculateButtonListener(){
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inchesEditText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "No value has been inserted", Toast.LENGTH_LONG).show();
                } else {
                    double inches = Double.parseDouble(inchesEditText.getText().toString());
                    String meters = convertToMeters(inches);
                    displayResult("Your height: " + meters+"m");
                }
            }
        });
    }
    private void displayResult(String meters) {
        resultTextView.setText(meters);
    }

    private String convertToMeters(double inches) {
        DecimalFormat myDF = new DecimalFormat("0.00");
        return myDF.format(inches * 0.0254);
    }
}