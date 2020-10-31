package com.bham.pij.assignments.shortaddresscreator;
import java.util.Scanner;

public class ShortAddressCreator {
    public static void main(String[] args) {
        ShortAddressCreator sc = new ShortAddressCreator();
        Scanner scan = new Scanner(System.in);
        System.out.println("pls enter your address");
        String address = scan.nextLine();

        System.out.println(sc.createShortAddress(address));
    }
    public String createShortAddress(String address){
        if (address == ""){
            System.out.println('a');
            return null;
        }
        String[] brokenAddress = address.split(", ");
        String digits = "1234567890";
        String alphabet =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (brokenAddress[brokenAddress.length-1].length() !=6 || alphabet.indexOf(brokenAddress[brokenAddress.length-1].charAt(0)) ==-1 || digits.indexOf(brokenAddress[brokenAddress.length-1].charAt(1)) ==-1 || digits.indexOf(brokenAddress[brokenAddress.length-1].charAt(2)) ==-1 || digits.indexOf(brokenAddress[brokenAddress.length-1].charAt(3)) ==-1|| alphabet.indexOf(brokenAddress[brokenAddress.length-1].charAt(4)) ==-1|| alphabet.indexOf(brokenAddress[brokenAddress.length-1].charAt(5)) ==-1){
            return null;
        }
        String shortAddress = brokenAddress[0] + ' ' +brokenAddress[brokenAddress.length-1];
        return shortAddress;
    }
}
