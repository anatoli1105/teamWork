package com.skypro.teamwork.interfase;

public class MethodOperator {
    public  boolean operator(int number, String typeCompare, int number2) {
        if (typeCompare == ">") {
            return number > number2;
        } else if (typeCompare == "<") {
            return number < number2;

        } else if (typeCompare == "=") {
            return number == number2;

        } else if (typeCompare == ">=") {
            return number >= number2;

        } else if (typeCompare == "<=") {
            return number <= number2;

        }
        return false;
    }


}



