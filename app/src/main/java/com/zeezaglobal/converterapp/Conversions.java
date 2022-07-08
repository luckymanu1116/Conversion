package com.zeezaglobal.converterapp;

import android.util.Log;

import java.text.DecimalFormat;

public class Conversions {


// adding conversion equations to convert the values entered by the user
    public Double centimeterToInch(double parseDouble) {
        return 0.39 * parseDouble;
    } // CM to IN

    public Double InchToCentimeter(double parseDouble) {
        return  parseDouble*2.54;
    } // IN to CM

    public Double kilometerToMiles(double parseDouble) {
        return  parseDouble*0.62;
    } // KM to Miles

    public Double KilogramToLb(double parseDouble) {
        return  parseDouble*2.2;
    }  // KG to LB

    public Double MilesToKilometer(double parseDouble) {
        return  parseDouble/0.62;
    } //Miles to KM

    public Double LbtoKilogram(double parseDouble) {
        return  parseDouble/2.2;
    } // LB to KG

    //adding decimal format
    public Double roundFunction(double parseDouble) {
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(parseDouble));
    }
}
