package com.bham.pij.assignments.converters;

import java.util.ArrayList;
import java.util.Arrays;

public class Hex2Bin implements BaseConverter{
    @Override
    public String convert(String startNum) {
        ArrayList<Character> hexChars = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'));
        ArrayList<Integer> decNums = new ArrayList<>();
        decNums.add(hexChars.indexOf(startNum.charAt(0)));
        decNums.add(hexChars.indexOf(startNum.charAt(1)));
        String binNum = "";
        for (int num : decNums) {
            for (int i = 0; i < 4; i++) {
                int x = 3 - i;
                x = (int) Math.pow(2, x);
                if ((num / x) >= 1) {
                    num -= x;
                    binNum += "1";
                } else {
                    binNum += "0";
                }
            }
        }
        return binNum;
    }
}