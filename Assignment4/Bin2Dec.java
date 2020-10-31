package com.bham.pij.assignments.converters;
import java.lang.Math;
public class Bin2Dec implements BaseConverter{
    @Override
    public String convert(String startNum){
        String binNumReversed = new StringBuilder(startNum).reverse().toString();
        Integer decNum = 0;
        for (int i = 0; i < binNumReversed.length(); i++) {
            if (binNumReversed.charAt(i) == '1') {
                decNum += (int) Math.pow(2, i);
            }
        }
        return String.valueOf(decNum);
    }
}


