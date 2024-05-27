package com.example.multicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String input = "";
    private String operator = "";
    private double firstNumber = Double.NaN;
    private double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onNumberClick(View view) {
        if (input.length() < 15) {
            input += ((Button) view).getText().toString();
            resultTextView.setText(input);
        }
    }

    public void onOperatorClick(View view) {
        operator = ((Button) view).getText().toString();
        if (!Double.isNaN(firstNumber)) {
            if (input.equals("")) {
                operator = ((Button) view).getText().toString();
            } else {
                calculate();
            }
        } else {
            firstNumber = Double.parseDouble(input);
            input = "";
        }
    }

    public void onEqualsClick(View view) {
        calculate();
        operator = "";
    }

    public void onClearClick(View view) {
        input = "";
        firstNumber = Double.NaN;
        secondNumber = Double.NaN;
        operator = "";
        resultTextView.setText("0");
    }

    public void onDotClick(View view) {
        if (!input.contains(".")) {
            input += ".";
            resultTextView.setText(input);
        }
    }

    public void onBackspaceClick(View view) {
        if (input.length() > 0) {
            input = input.substring(0, input.length() - 1);
            resultTextView.setText(input);
        }
    }

    private void calculate() {
        if (!Double.isNaN(firstNumber)) {
            secondNumber = Double.parseDouble(input);
            switch (operator) {
                case "+":
                    firstNumber = firstNumber + secondNumber;
                    break;
                case "-":
                    firstNumber = firstNumber - secondNumber;
                    break;
                case "*":
                    firstNumber = firstNumber * secondNumber;
                    break;
                case "/":
                    firstNumber = firstNumber / secondNumber;
                    break;
            }
            resultTextView.setText(String.valueOf(firstNumber));
            input = "";
        }
    }
}