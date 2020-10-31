package com.bham.pij.assignments.converters;

public class Dec2Bin implements BaseConverter{
    @Override
    public String convert(String startNum) {
        int decNum = Integer.parseInt(startNum);
        String binNum = "";
        for (int i = 0; i < 8; i++) {
            int x = 7 - i;
            x = (int) Math.pow(2, x);
            if ((decNum / x) >= 1) {
                decNum -= x;
                binNum += "1";
            } else {
                binNum += "0";
            }
        }
        return binNum;
    }
}
