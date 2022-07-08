//Done by:
//Name: Manoj Kumar Reddy Guttikonda
//ID: A00258697

package com.zeezaglobal.converterapp;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //user input text fields
    private EditText et_one, et_two;
    //checking  status
    private boolean etOneStatus = false, etTwoStatus = false;
    //spinner to select the conversion
    private Spinner spinner;
    //units textview to view units
    private TextView unitOne, unitTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating components that we required to perform the task
        initComponents();
        setSpinner();
        spinnerListener();
        //Adding  Main Heading name
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Conversion");

        et_one.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    etOneStatus = true;
                } else {
                    etOneStatus = false;
                }
            }
        });
        et_two.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    etTwoStatus = true;
                } else {
                    etTwoStatus = false;
                }
            }
        });
        et_one.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {


            }
            // before the user entered the value it shows 0.00bin the textfield
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            // after user enter the value is display the user entered value in textfield
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (etOneStatus)
                    if (!s.toString().equals(""))
                        et_two.setText(doConversion(Double.parseDouble(s.toString())));
            }
        });

        // adding textchanged listener to do start operations
        et_two.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {


            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etTwoStatus)
                    if (!s.toString().equals(""))
                        et_one.setText(doBackConversion(Double.parseDouble(s.toString())));
            }
        });
    }
    //adding text and unit to the text field and the spinner to choose the option by the user;
    private void spinnerListener() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    // adding text to textview when the user select the CM-IN conversion
                    case Constants.CENTIMETER_TO_INCH:
                        et_one.setText("");
                        et_two.setText("");
                      unitOne.setText("CENTIMETER");
                      unitTwo.setText("INCHES");
                      break;
                    // adding text to textview when the user select the KG-LB conversion
                    case Constants.KILOGRAM_TO_LB:
                        et_one.setText("");
                        et_two.setText("");
                        unitOne.setText("KILOGRAMS");
                        unitTwo.setText("POUNDS");
                        break;
                        // adding text to textview when the user select the Km-m conversion
                    case Constants.KILOMETER_TO_MILES:
                        et_one.setText("");
                        et_two.setText("");
                        unitOne.setText("KILOMETERS");
                        unitTwo.setText("MILES");
                        break;



                }
            }
// if the user selects nothing it displays null
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    //user can do conversion in both the text fields;
    private String doBackConversion(double parseDouble) {
        Conversions conversions = new Conversions();
        switch (spinner.getSelectedItemPosition()) {
            case Constants.CENTIMETER_TO_INCH:
                return conversions.roundFunction(conversions.InchToCentimeter(parseDouble)).toString();

            case Constants.KILOMETER_TO_MILES:
                return conversions.roundFunction(conversions.MilesToKilometer(parseDouble)).toString();
            case Constants.KILOGRAM_TO_LB:
                return conversions.roundFunction(conversions.LbtoKilogram(parseDouble)).toString();
            default:
                return "";
        }

    }
    // making conversion work, dropdown list to select the conversion;
    private String doConversion(double parseDouble) {
        Conversions conversions = new Conversions();
        //getting from the conversions

        //switch case to check the condition
        switch (spinner.getSelectedItemPosition()) {
            case Constants.CENTIMETER_TO_INCH:
                return conversions.roundFunction(conversions.centimeterToInch(parseDouble)).toString();
            case Constants.KILOMETER_TO_MILES:
                return conversions.roundFunction(conversions.kilometerToMiles(parseDouble)).toString();
            case Constants.KILOGRAM_TO_LB:
                return conversions.roundFunction(conversions.KilogramToLb(parseDouble)).toString();
            default:
                return "";
        }

    }
// setting the spinner to select the conversions
    private void setSpinner() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

// assigning the spinner value and textfields values by ID's
    private void initComponents() {
        et_one = findViewById(R.id.editTextTextOne);
        et_two = findViewById(R.id.editTextTextTwo);
        spinner = (Spinner) findViewById(R.id.spinner);
        unitOne =  findViewById(R.id.unit_one);
        unitTwo =  findViewById(R.id.unit_two);
    }
}