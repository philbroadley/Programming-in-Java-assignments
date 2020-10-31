package com.bham.pij.assignments.converters;

import java.io.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Converter {

    public static enum ConvertMode {BIN2HEX, HEX2BIN, BIN2DEC, DEC2BIN}

    private ConvertMode converterType;
    private ArrayList<String> raw;
    private ArrayList<String> converted;

    public Converter(Converter.ConvertMode cm) {
        this.converterType = cm;
        this.raw = new ArrayList<>();
        this.converted = new ArrayList<>();
    }

    public String convert(String startNum) throws InvalidFormatException{
        if (inputValidation(startNum,this.converterType)) {
            switch (converterType) {
                case DEC2BIN:
                    Dec2Bin d2B = new Dec2Bin();
                    return d2B.convert(startNum);
                case BIN2DEC:
                    Bin2Dec b2D = new Bin2Dec();
                    return b2D.convert(startNum);
                case BIN2HEX:
                    Bin2Hex b2H = new Bin2Hex();
                    return b2H.convert(startNum);
                case HEX2BIN:
                    Hex2Bin h2B = new Hex2Bin();
                    return h2B.convert(startNum);
            }
        }
        throw new InvalidFormatException();
    }
    public void fromFile(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line = "";
            while ((line = br.readLine()) != null) {
                raw.add(line);
            }
            br.close();
        } catch(IOException ex){
            return;
        }

        for (String s: raw) {
            converted.add(convert(s));
        }
    }
    public ArrayList<String>getInputValues(){
        return raw;
    }
    public ArrayList<String>getOutputValues(){
        return converted;
    }

    public boolean inputValidation(String input,ConvertMode cm){
        if (cm == ConvertMode.BIN2DEC||cm == ConvertMode.BIN2HEX) {
            String regEx = "([1]|[0]){8}$";
            if (input.matches(regEx)){
                return true;
            }
        }
        else if (cm ==ConvertMode.DEC2BIN){
            int decNum = Integer.parseInt(input);
            if (input.length() <= 3 && decNum >= 0 && decNum <= 255){
                return true;
            }
        }
        else if (cm ==ConvertMode.HEX2BIN){
            String regEx = "[A-F0-9][A-F0-9]";
            if( input.matches(regEx)){
                return true;
            }
        }
        return false;
    }
}
