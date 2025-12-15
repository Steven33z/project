package com.sz.steven;

import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    protected RadioButton addition;
    protected RadioButton subtraction;
    protected RadioButton multiplication;
    protected RadioButton division;
    protected RadioGroup radioGroup;
    protected LinearLayout activityButtons;
    protected Button backButton;
    protected ImageView calculatorPNG;
    protected Button currencyConversion;
    protected Button fingerPaintView;
    protected Button tempConversion;
    protected Button scientificMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);
        activityButtons = findViewById(R.id.activityButtons);
        backButton = findViewById(R.id.backButton);
        calculatorPNG = findViewById(R.id.calculatorPNG);
        currencyConversion = findViewById(R.id.currencyConversion);
        fingerPaintView = findViewById(R.id.fingerPaintView);
        tempConversion = findViewById(R.id.tempConversion);
        scientificMode = findViewById(R.id.scientificMode);

        FragmentManager fm = getSupportFragmentManager();

        backButton.setVisibility(View.INVISIBLE); // Set the back button inivisble until further notice

        //HANDLES BASIC MATH FUNCTIONS (ADD,SUB,MULT,DIV)=============================
        addition.setOnClickListener(new View.OnClickListener() { //Addition
            @Override
            public void onClick(View view) {
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new AdditionFragment());
                ft.commit();
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() { //Subtraction
            @Override
            public void onClick(View view) {
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new SubtractionFragment());
                ft.commit();
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() { //Multiplication
            @Override
            public void onClick(View view) {
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new MultiplicationFragment());
                ft.commit();
            }
        });

        division.setOnClickListener(new View.OnClickListener() { //Division
            @Override
            public void onClick(View view) {
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new DivisionFragment());
                ft.commit();
            }
        });
        //============================================================================

        //HANDLES Currency Conversion//===============================================
        currencyConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.setVisibility(View.INVISIBLE);
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new CurrencyFragment());
                ft.commit();
            }
        });
        //============================================================================

        //HANDLES FINGERPAINTVIEW=====================================================
        fingerPaintView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.setVisibility(View.INVISIBLE);
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new FingerPaintViewFragment());
                ft.commit();
            }
        });
        //============================================================================

        //HANDLES TEMPERATURE CONVERSION==============================================
        tempConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.setVisibility(View.INVISIBLE);
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new TemperatureConversionFragment());
                ft.commit();
            }
        });
        //============================================================================

        //HANDLES SCIENTIFIC MODE=====================================================
        scientificMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.setVisibility(View.INVISIBLE);
                activityButtons.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                calculatorPNG.setVisibility(View.GONE);
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, new ScientificModeFragment());
                ft.commit();
            }
        });
        //============================================================================

        //HANDLES BACK BUTTON=========================================================
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();

                // Removes fragment if one already exists
                if (fm.findFragmentById(R.id.container) != null) {
                    fm.beginTransaction()
                            .remove(fm.findFragmentById(R.id.container))
                            .commit();
                }

                // Make visuals either visible or invisible
                activityButtons.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.INVISIBLE);
                calculatorPNG.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
            }
        });
        //============================================================================
    }
}
