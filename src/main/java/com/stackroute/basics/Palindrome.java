package com.stackroute.basics;


import java.math.BigInteger;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        new Palindrome().getValue();
    }

    // get values from the user using scanner
    public void getValue() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Number:");
        String number = scan.nextLine();
        if (number.isBlank() || number.matches(".*[^0-9].*")) {
            System.out.println("Wrong input give proper positive integer");
        } else
            System.out.println(palindromeValidator(new BigInteger(number)));
    }

    //write logic to check for palindrome using BigInteger & Do-while
    public String palindromeValidator(BigInteger number) {
        if (number.toString().length() == 1 || number.toString().matches(".*[^0-9].*"))
            return "The integer have to be at least a two digit positive integer";
        else {
            BigInteger result = new BigInteger("0");
            BigInteger referNumber = number;
            do {
                result = result.multiply(new BigInteger("10")).add(number.mod(new BigInteger("10")));
                number = number.divide(new BigInteger("10"));
            } while (number.compareTo(new BigInteger("0")) == 1);
            if (result.equals(referNumber))
                return referNumber + " is a palindrome";
            else
                return referNumber + " is not a palindrome";
        }
    }
}
