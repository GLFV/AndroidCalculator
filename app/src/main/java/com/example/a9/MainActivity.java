package com.example.a9;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView solutionTv,resultTv;
    MaterialButton dot,equals,zero,one,two,three,four,five,six,seven,eight,nine,ac,procent,fact,plus,minus,div,mult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        solutionTv = findViewById(R.id.solution_tv);
        resultTv = findViewById(R.id.result_tv);
        assignId(zero,R.id.button_zero);
        assignId(one,R.id.button_one);
        assignId(two,R.id.button_two);
        assignId(three ,R.id.button_three);
        assignId(four ,R.id.button_four);
        assignId(five ,R.id.button_five);
        assignId(six ,R.id.button_six);
        assignId(seven ,R.id.button_seven);
        assignId(eight ,R.id.button_eight);
        assignId(nine ,R.id.button_nine);
        assignId(ac ,R.id.button_C);
        assignId(procent,R.id.button_procent);
        assignId(fact ,R.id.button_fact);
        assignId(plus ,R.id.button_plus);
        assignId(minus ,R.id.button_subtract);
        assignId(div ,R.id.button_div);
        assignId(mult ,R.id.button_mult);
        assignId(equals ,R.id.button_equals);
        assignId(dot ,R.id.button_dot);


    }
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    String action = "";
    float result = 0,number = 0;
    String inputData = "";
    public static float factorial(float n){
        if (n == 0) {
            return 1;
        }
        else {
            return (n * factorial(n - 1));
        }
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        if(buttonText.equals("%") || buttonText.equals("+") || buttonText.equals("/") || buttonText.equals("-") || buttonText.equals("X") || buttonText.equals("!")){
            if(result == 0.0){
                result = number;
            }
            if(buttonText.equals("!")){
                result = factorial(result);
            }
            inputData = "";
            solutionTv.setText(String.valueOf(result));
            resultTv.setText("0");
            action = buttonText;
            return;
        }else if(buttonText.equals("AC")){
            inputData = "";
            solutionTv.setText("");
            resultTv.setText("0");
            result = 0;
            number = 0;
            action = "";
            return;
        }else if(buttonText.equals("=")){
            if(action.equals("+")){
                result+=number;
                solutionTv.setText(String.valueOf(result));
                resultTv.setText("0");
                inputData = "";
            } if(action.equals("-")){
                result-=number;
                solutionTv.setText(String.valueOf(result));
                resultTv.setText("0");
                inputData = "";
            } if(action.equals("X")){
                result*=number;
                solutionTv.setText(String.valueOf(result));
                resultTv.setText("0");
                inputData = "";
            } if(action.equals("/")){
                if(number!=0) {
                    result /= number;
                    solutionTv.setText(String.valueOf(result));
                    resultTv.setText("0");
                    inputData = "";
                }else{
                    resultTv.setText("ERROR");
                }
            }
            if(action.equals("%")){
                result%=number;
                solutionTv.setText(String.valueOf(result));
                resultTv.setText("0");
                inputData = "";
            }
        }
        else{
            if(!inputData.contains(".") || (inputData.contains(".") && !buttonText.equals(".") )) {
                inputData += buttonText;
                number = Float.parseFloat(inputData);
                resultTv.setText(inputData);
            }
            return;
        }
    }
}