package com.bham.pij.assignments.passwordchecker;

import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker();
        Scanner scan = new Scanner(System.in);
        System.out.println("pls enter your password");
        String password = scan.nextLine();
        System.out.print(pc.checkPassword(password));

    }
    public String checkPassword(String password){
        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasLowerCase = !password.equals(password.toUpperCase());
        if (!hasLowerCase || !hasUpperCase){
            return "NOT MIXED CASE";
        }
        if (password.length() < 8) {
            return "TOO SHORT";
        }else if(password.length() > 12){
            return "TOO LONG";
        }

        String alphabet = "abcdefghijklmnopqrstuvwxyz_1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < password.length(); i++) {
            if (alphabet.indexOf(password.charAt(i)) == -1){
                return "WRONG CHARACTERS";
            }
            String digits = alphabet.substring(27,36);
            if(i==0 && digits.indexOf(password.charAt(i)) != -1) {
                return "LEADING DIGIT";
            }
            }
         return "OK";
         }

            }

