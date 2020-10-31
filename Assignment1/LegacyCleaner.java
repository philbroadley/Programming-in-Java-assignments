package com.bham.pij.assignments.legacycleaner;

import java.util.Scanner;

public class LegacyCleaner {
    public static void main(String[] args) {
        LegacyCleaner lc = new LegacyCleaner();
        Scanner scan = new Scanner(System.in);
        System.out.println("pls enter the legacy");
        String badString = scan.nextLine();
        String[] legacy = (lc.clean(badString));
        for (int i = 0; i < legacy.length; i++) {
            System.out.print(legacy[i]);
        }
    }

    public String[] clean(String badString) {
        String name = null;
        String ID = null;
        String result = null;
        String postcode = null;
        String digits = "1234567890";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digalph = digits+alphabet;
        String[] badList = badString.split(",");
        for (int i = 0; i < badList.length; i++) {
            String temp = badList[i];
            if (!temp.equals("")) {
            if (temp.charAt(0) == ' ') {
                badList[i] = temp.substring(1);
                temp = badList[i];
            }
            alphabet = alphabet.toLowerCase();
            if (temp.length() == 6 && digalph.indexOf(temp.charAt(0)) != -1 && digalph.indexOf(temp.charAt(1)) != -1 && digalph.indexOf(temp.charAt(2)) != -1 && digalph.indexOf(temp.charAt(3)) != -1 && digalph.indexOf(temp.charAt(4)) != -1 && digalph.indexOf(temp.charAt(5)) != -1) {
                postcode = temp;
            } else if (temp.equals("PASS") || temp.equals("MERIT") || temp.equals("FAIL")) {
                result = temp;
            } else if (temp.length() == 7 && alphabet.indexOf(temp.charAt(0)) != -1 && alphabet.indexOf(temp.charAt(1)) != -1 && alphabet.indexOf(temp.charAt(2)) != -1 && digits.indexOf(temp.charAt(3)) != -1 && digits.indexOf(temp.charAt(4)) != -1 && digits.indexOf(temp.charAt(5)) != -1 && digits.indexOf(temp.charAt(6)) != -1) {
                ID = temp;

            } else {
                boolean noDigits = true;
                for (int j = 0; j < temp.length(); j++) {
                    if (digits.indexOf(temp.charAt(j)) != -1) {
                        noDigits = false;
                    }
                }
                if (noDigits) {
                    name = temp;
                }
            }
        }

        }
            String[] legacy = {name, ID,result,postcode};
            return legacy;
        }
    }

