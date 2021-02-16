package com.stackroute.basics;


import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        new Palindrome().getValue();
    }

    // get values from the user using scanner
    public void getValue() {
        Scanner scn = new Scanner(System.in);
        String number;
        number = scn.nextLine();
        number = number.trim();
        outputPrinter(number);


    }

    // validate the input using inputValidator and print the error message or the result from palindromeValidator
    public void outputPrinter(String number) {
        if (!inputValidator(number)) {
            System.out.println("Wrong input, give proper positive integer");
            return;
        }
        String output = palindromeValidator(new BigInteger(number));
        System.out.println(output);
    }

    // check whether the input is a valid integer and return boolean
    public boolean inputValidator(String number) {
        if ( number.length() == 0
                || number.charAt(0) == '-'
                || number.contains(".")
                || isAlphabetPresent(number)
                || number.length() < 2
        ) {
            return false;
        }
        return true;
    }

    public boolean isAlphabetPresent(String number) {
        for (int digit : number.toLowerCase(Locale.ROOT).toCharArray()) {
            if (digit >= 97 && digit <= 97 + 32) {
                return true;
            }
        }
        return false;
    }


    // write logic to check for palindrome using BigInteger & Do-while
    public String palindromeValidator(BigInteger number) {
        BigInteger reverse = new BigInteger("0");
        BigInteger temp = number;

        if (!inputValidator(number.toString())) {
            return "The integer have to be at least a two digit positive integer";
        }

        do {
            reverse = reverse.multiply(new BigInteger("10")).add(temp.divideAndRemainder(new BigInteger("10"))[1]);
            temp = temp.divideAndRemainder(new BigInteger("10"))[0];
        } while (!temp.equals(new BigInteger("0")));

        if (reverse.equals(number)) {
            return number + " is a palindrome";
        } else {
            return number + " is not a palindrome";
        }

    }

}
