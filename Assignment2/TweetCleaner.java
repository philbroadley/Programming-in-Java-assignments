package com.bham.pij.assignments.twit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TweetCleaner {

    private static ArrayList<String> raw = new ArrayList<String>();
    private static ArrayList<String> cleaned = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        new TweetCleaner();

        System.out.println("Done.");
    }

    public TweetCleaner() throws IOException {

        loadRaw();

        clean();

        saveClean();
    }

    private void clean() {

        for (String line: raw) {
            String cln = clean(line);
            if (cln != null) {

                String[] toks = cln.split(" ");

                for (String s: toks) {
                    addClean(s);
                }
            }
        }
    }

    public String clean(String fullTweet) {
        int startIndex = -1;
        String allowedCharacters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        String importantPunctuation = "@#!?'";
        String temp = fullTweet;
        for (int i = 0; i < fullTweet.length(); i++) {
            char character = fullTweet.charAt(i);
            if ((!allowedCharacters.contains("" + character) && !importantPunctuation.contains("" + character))){
                temp = temp.replace(""+character,"");
            }
        }
        fullTweet = temp;
        if (fullTweet.length() == 0) {
            return null;
        }

        String[] tempArray = fullTweet.split(" ");
        ArrayList<String> tweetArray = new ArrayList<>();

        for (String word: tempArray) {
            if (word.length() > 0 && !word.equals("RT") && !word.equals("rt")) {
                tweetArray.add(word);
            }
        }
        if (fullTweet.length() == 0) {
            return null;
        }
        fullTweet = "";
        for (String word:tweetArray) {
            fullTweet += " "+word;
        }
        for (int i = 0; i < fullTweet.length(); i++) {
            if (startIndex != -1 && (fullTweet.charAt(i) == ' ')) {
                fullTweet = fullTweet.replace(fullTweet.substring(startIndex, i), "");
                i = startIndex;
                startIndex = -1;
            } else if (fullTweet.charAt(i) == '@' || fullTweet.charAt(i) == '#') {
                startIndex = i;
            } else if (i > 2 && fullTweet.charAt(i - 3) == 'h' && fullTweet.charAt(i - 2) == 't' && fullTweet.charAt(i - 1) == 't' && fullTweet.charAt(i) == 'p') {
                startIndex = i - 3;
            }
            if (fullTweet.length() == 0) {
                return null;
            }

        }
        if (startIndex != -1) {
            fullTweet = fullTweet.replace(fullTweet.substring(startIndex), "");
        }
        if (fullTweet.length() == 0) {
            return null;
        }
        String tempTweet = "";
        for (int i = 0; i < fullTweet.length(); i++) {

            if (allowedCharacters.indexOf(fullTweet.charAt(i)) != -1 || ((fullTweet.charAt(i) == '?' || fullTweet.charAt(i) == '!') && allowedCharacters.indexOf(fullTweet.charAt(i - 1)) != -1) || (fullTweet.charAt(i) == ("'").charAt(0) && (fullTweet.charAt(i - 1) == 's' || fullTweet.charAt(i + 1) == 's'))) {
                tempTweet += fullTweet.charAt(i);

            } else if (fullTweet.charAt(i) == '-') {
                tempTweet += ' ';
            }
        }

        String newTweet = "";
        String digits = "1234567890";
        List<String> arrayTweet = new LinkedList<>(Arrays.asList(tempTweet.split(" ")));
        if (arrayTweet.size() == 0) {
            return null;
        }
        for (int i = 0; i < arrayTweet.size(); i++) {
            if (!arrayTweet.get(i).equals(" ") && !arrayTweet.get(i).equals("")) {
                boolean addIn = true;
                for (String j : arrayTweet.get(i).split("")) {
                    if (digits.contains(j)) {
                        addIn = false;
                    }
                }
                if (addIn == true) {
                    newTweet += arrayTweet.get(i) + " ";
                }
                if (arrayTweet.get(i).equals("!") || arrayTweet.get(i).equals("?")){
                    return null;
                }


            }

        }
        if (newTweet.length() == 0) {
            return null;
        }
        return newTweet;
    }


    private void addClean(String clean) {

        cleaned.add(clean);
    }

    private void saveClean() throws FileNotFoundException {

        PrintWriter pw = new PrintWriter("cleaned.txt");

        for (String s: cleaned) {
            pw.print(s + " ");
        }

        pw.close();

    }

    private void loadRaw() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("donald.txt")));

        String line = "";

        while ((line = br.readLine())!= null) {

            raw.add(line);

        }

        br.close();
    }
}
