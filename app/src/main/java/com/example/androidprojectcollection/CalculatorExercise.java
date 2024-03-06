package com.example.androidprojectcollection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidprojectcollection.classes.Calculator;

public class CalculatorExercise extends AppCompatActivity {
    private TextView tvExpression;
    private EditText ettOutput;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnBackspace, btnEqualTo, btnDivision, btnMultiplication, btnSubtraction, btnAddition, btnDecimalPoint;
    private StringBuilder expression;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);

        expression = new StringBuilder();
        calculator = new Calculator();

        tvExpression = findViewById(R.id.tvExpression);
        ettOutput = findViewById(R.id.ettOutput);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnDecimalPoint = (Button) findViewById(R.id.btnDecimalPoint);
        btnEqualTo = (Button) findViewById(R.id.btnEquals);

        Button[] operandButtons = {btn0, btn1, btn2, btn3, btn4,
                btn5, btn6, btn7, btn8, btn9};
        Button[] operatorButtons = {btnDivision, btnMultiplication, btnSubtraction, btnAddition};

        for (Button btn : operandButtons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value = btn.getText().toString();

                    expression.append(value);

                    tvExpression.setText(expression.toString());

                    double result = calculator.evaluateSequential(expression.toString());
                    ettOutput.setText(String.valueOf(result == (int) result ? String.format("%d", (int) result) : result));
                }
            });
        }

        for (Button btn : operatorButtons) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value = btn.getText().toString();
                    int len = expression.length();

                    if (len == 0) {
                        return;
                    }

                    if (calculator.isOperator(expression.charAt(len - 1))) {
                        expression.replace(len - 1, len, value);
                    } else {
                        expression.append(value);
                    }

                    tvExpression.setText(expression.toString());

                    try {
                        double result = calculator.evaluateSequential(expression.toString());
                        ettOutput.setText(String.valueOf(result == (int) result ? String.format("%d", (int) result) : result));
                    } catch (ArithmeticException e) {
                        ettOutput.setText("Invalid input!");
                    } catch (Exception e) {
                    }
                }
            });
        }

        btnDecimalPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char value = '.';
                int len = expression.length();

                if (len == 0) {
                    return;
                }

                for (int i = len - 1; i >= 0; i--) {
                    if (calculator.isOperator(expression.charAt(i))) {
                        break;
                    }
                    if (expression.charAt(i) == '.') {
                        if (expression.charAt(len-1) == '.') {
                            expression.deleteCharAt(len-1);
                            tvExpression.setText(expression.toString());
                        }
                        return;
                    }
                }

                if (Character.isDigit(expression.charAt(len-1))) {
                    expression.append(value);
                }

                tvExpression.setText(expression.toString());
            }
        });

        btnEqualTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = calculator.evaluateMDAS(expression.toString());
                ettOutput.setText(String.valueOf(result == (int) result ? String.format("%d", (int) result) : result));
                expression.replace(0, expression.length() - 1, tvExpression.getText().toString());
            }
        });
    }
}