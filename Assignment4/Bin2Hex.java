package com.bham.pij.assignments.converters;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Bin2Hex implements BaseConverter{
    @Override
    public String convert (String startNum){
        ArrayList<Character> hexChars = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'));
        ArrayList<String> hexDigitsInBin = new ArrayList<>();

        hexDigitsInBin.add(new StringBuilder(startNum.substring(0,4)).reverse().toString());
        hexDigitsInBin.add(new StringBuilder(startNum.substring(4)).reverse().toString());

        ArrayList<Integer> decNums = new ArrayList<>();
        for (int i =0; i<hexDigitsInBin.size();i++) {
            int decNum = 0;
            for (int x = 0; x < hexDigitsInBin.get(i).length(); x++) {
                if (hexDigitsInBin.get(i).charAt(x) == '1') {
                    decNum += (int) Math.pow(2, x);
                }
            }
            decNums.add(decNum);
        }
        return ""+ hexChars.get(decNums.get(0)) + hexChars.get(decNums.get(1));
    }
}
