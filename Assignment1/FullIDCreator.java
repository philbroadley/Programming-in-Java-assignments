package com.bham.pij.assignments.fullidcreator;

import java.util.*;

public class FullIDCreator {
    public static String FullID = "";
    public static Map<String, String> dictionary = new HashMap<String, String>();
    public static void main(String[] args) {
        FullIDCreator fc = new FullIDCreator();
        boolean done = false;
        while (!done) {
            Scanner scan = new Scanner(System.in);
            System.out.println("pls enter your name");
            String name = scan.nextLine();
            if (name.equals("done")) {
                done = true;

            }
            String ShortID = fc.createID(name);
            System.out.println("the full ID for this name is:" + fc.createFullID(ShortID));
        }
    }

    public String createFullID(String ShortID) {
	if (ShortID == null){
	    return null;
	    }
        if (dictionary.get(ShortID) == null) {
            FullID = ShortID + "0000";
            dictionary.put(ShortID, "0000");
        } else {
            String IDnum = Integer.toString(Integer.parseInt(dictionary.get(ShortID)) + 1);
            if (IDnum.length() == 1) {
                dictionary.put(ShortID, ("000" + IDnum));
            } else if ((IDnum.length() == 2)) {
                dictionary.put(ShortID, ("00" + IDnum));
            } else if ((IDnum.length() == 3)) {
                dictionary.put(ShortID, ("0" + IDnum));
            } else if ((IDnum.length() == 4)) {
                dictionary.put(ShortID, (IDnum));
            }
            FullID = ShortID + dictionary.get(ShortID);
        }
        return FullID;

        }
    public String createID(String name){
        name = name.toLowerCase();
        String[] names = name.split(" ");
        String ID = "";
	if (names.length > 3){
	    return null;
	    }
        for (int i = 0; i < names.length; i++) {
            char temp = names[i].charAt(0);
            System.out.println(temp);
            ID = ID + temp;
        }
        if (ID.length()==3) {
            return ID;
        }else if (ID.length()==2){
            ID = ID.substring(0, 1) + "x" + ID.substring(1);
            return ID;
        }else{
            return null;
        }
    }
}


