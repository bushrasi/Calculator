/**
 * Developer: Bushra Al Sibai
 * App: Calculator
 * application tested on 4.7,768 x 1280, xhdpi(Nexus4)
 */

package com.bushraalsibai.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // implementing an array of button ids:
        int[]ids={
                R.id.addButton,R.id.subButton,R.id.multipButton,R.id.divButton,R.id.clear,
                R.id.sqr_root,R.id.sin,R.id.cosin, R.id.tan, R.id.log10, R.id.power, R.id.fact
        };


       for(int i =0; i <ids.length;i++){
          int id = ids[i];
          Button button = findViewById(id);
          button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        // getting the result
        TextView result = (TextView) findViewById(R.id.result);

        //getting the first number:
        EditText firstNumber = (EditText) findViewById(R.id.editText_one);
        String numStr_1 = firstNumber.getText().toString();

        // getting the second number
        EditText secondNumber = (EditText) findViewById(R.id.editText_two);
        String numStr_2 = secondNumber.getText().toString();

        int calcResult = 0;
        String text = "";

        if(numStr_1.length() > 0 && numStr_2.length() > 0) {
            int value1 = Integer.valueOf(numStr_1);
            int value2 = Integer.valueOf(numStr_2);

            if (view.getId() == R.id.addButton) {

                calcResult = value1 + value2;
                result.setText(value1 + "+" + value2 + "=" + calcResult);

                //text = text.valueOf(calcResult);
            } else if (view.getId() == R.id.subButton) {
                calcResult = value1 - value2;
                result.setText(value1 + "-" + value2 + "=" + calcResult);
                //text = text.valueOf(calcResult);
            } else if (view.getId() == R.id.multipButton) {
                calcResult = value1 * value2;
                result.setText(value1 + "*" + value2 + "=" + calcResult);
                //text = text.valueOf(calcResult);

            } else if (view.getId() == R.id.divButton) {
                if (value2 == 0) {
                    result.setText("Error, division by 0");
                    firstNumber.setText("");
                    secondNumber.setText("");
                } else {

                    calcResult = value1 / value2;
                    result.setText(value1 + "/" + value2 + "=" + calcResult);
                }
                //text = text.valueOf(calcResult);
            } else if (view.getId() == R.id.clear) {
                text = "";
                result.setText(text);
                firstNumber.setText("");
                secondNumber.setText("");
            } else if (view.getId() == R.id.sqr_root) {
                secondNumber.setText("");
                calcResult = (int) Math.sqrt(value1);
                result.setText("sqrt(" + value1 + ")=" + calcResult);
            } else if (view.getId() == R.id.sin) {
                secondNumber.setText("");
                calcResult = (int) Math.sin(Math.toRadians(value1));
                result.setText("sin(" + value1 + ")=" + calcResult);
            } else if (view.getId() == R.id.cosin) {
                secondNumber.setText("");
                calcResult = (int) Math.cos(Math.toRadians(value1));
                result.setText("cos(" + value1 + ")=" + calcResult);
            } else if (view.getId() == R.id.tan) {
                secondNumber.setText("");
                calcResult = (int) Math.tan(value1);
                result.setText("tan(" + value1 + ")=" + calcResult);
            } else if (view.getId() == R.id.log10) {
                secondNumber.setText("");
                calcResult = (int) Math.log10(value1);
                result.setText("log10(" + value1 + ")=" + calcResult);
            } else if (view.getId() == R.id.power) {
                calcResult = (int) Math.pow(value1, value2);
                result.setText(value1 + "**" + value2 + "=" + calcResult);
            }else if(view.getId() == R.id.fact) {
                secondNumber.setText("");
                if(value1 < 0) {
                    result.setText("value must be positive number!");
                }else if (value1 == 0) {
                    calcResult = 1;
                    result.setText(value1 + "!" + "=" + calcResult);
                }else if (value1 >= 1) {
                    int fact = 1;
                    for (int i = 1; i <= value1; i++) {
                        fact = fact * i;
                    }
                    calcResult = fact;
                    result.setText(value1 + "!" + "=" + calcResult);
                }


        } else {
            throw new RuntimeException("not implemented");
        }

    }else{
            result.setText("Both fields must have a value!");
        }
    }


}

