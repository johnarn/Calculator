package com.example.calculator.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.Model.CalculatorModel;
import com.example.calculator.R;

import java.util.ArrayList;


public class MainCalculatorActivity extends AppCompatActivity {

    /**
     * Views of Calculator
     */
    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
    private Button btnDelete, btnDoubleZero, btnDot, btnC;
    private Button btnSum, btnSub, btnMult, btnDiv, btnPer, btnEqual;
    private EditText editTextAnswer;

    /**
     * Model of Calculator
     */
    private CalculatorModel calculatorModel;

    /**
     * The expression that user gives as input to edittext
     */
    private ArrayList<String> expression = new ArrayList<>();

    /**
     * Initialize all the views and add them listeners
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);


        //initialize Calculator Model
        calculatorModel = new CalculatorModel();

        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnDoubleZero = findViewById(R.id.btnDoubleZero);
        btnDot = findViewById(R.id.btnDot);
        btnDelete = findViewById(R.id.btnDel);
        btnC = findViewById(R.id.btnC);
        btnSum = findViewById(R.id.btnSum);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnEqual = findViewById(R.id.btnEqual);
        btnPer = findViewById(R.id.btnPer);
        editTextAnswer = findViewById(R.id.edittxtAnswer);
        setListeners();

        //remove cursor from edittext
        editTextAnswer.setFocusable(false);
    }

    /**
     * Create Listeners for all the buttons of the Calculator
     * Each Listener updates the EditText for changes
     */
    private void setListeners() {

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextAnswer.setText(editTextAnswer.getText() + "1");
                expression.add("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextAnswer.setText(editTextAnswer.getText() + "2");
                expression.add("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "3");
                expression.add("3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "4");
                expression.add("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "5");
                expression.add("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "6");
                expression.add("6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "7");
                expression.add("7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextAnswer.setText(editTextAnswer.getText() + "8");
                expression.add("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "9");
                expression.add("9");
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "0");
                expression.add("0");
            }
        });

        btnDoubleZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextAnswer.setText(editTextAnswer.getText() + "00");
                expression.add("00");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.size() > 0) {
                    expression.remove(expression.size() - 1);
                    editTextAnswer.setText(editTextAnswer.getText().subSequence(0, editTextAnswer.getText().length() - 1));
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.size() > 0) {
                    editTextAnswer.setText(editTextAnswer.getText() + ".");
                    expression.add(".");
                }


            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expression.size() > 0) {
                    editTextAnswer.setText(editTextAnswer.getText() + "+");
                    expression.add("+");
                }

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.size() > 0) {
                    editTextAnswer.setText(editTextAnswer.getText() + "-");
                    expression.add("-");
                }

            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.size() > 0) {
                    editTextAnswer.setText(editTextAnswer.getText() + "*");
                    expression.add("*");
                }

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.size() > 0) {
                    editTextAnswer.setText(editTextAnswer.getText() + "/");
                    expression.add("/");
                }

            }
        });

        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.size() > 0) {
                    editTextAnswer.setText(editTextAnswer.getText() + "%");
                    expression.add("%");
                }

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.size() > 0) {
                    editTextAnswer.setText("");
                    expression.clear();
                }

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expression.size() > 0) {
                    editTextAnswer.setText(calculatorModel.findResult(expression));

                }

            }
        });
    }

    /**
     * Create the Hamburger icon at the ActionBar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return true;
    }

    /**
     * Start a new Activity from the option that the user has selected.
     * Destroy the old activity so it can not be accessed.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemCalculator:
                Intent calculatorIntent = new Intent(this, MainCalculatorActivity.class);
                startActivity(calculatorIntent);
                finish();
                return true;
            case R.id.menuItemConverter:
                Intent converterIntent = new Intent(this, MainConverterActivity.class);
                startActivity(converterIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}