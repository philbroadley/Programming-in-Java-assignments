package com.bham.pij.assignments.twit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TweetGenerator {
    
    private static final int TWEET_LENGTH = 30;
    private static ArrayList<Word> words;
    private static Random random = new Random();

    public static void main(String[] args) throws IOException {

    	new TweetGenerator();
    	
        System.out.println("Done.");
    }
    
    public TweetGenerator() throws IOException {

        ArrayList<String> cleaned = loadData();
        
        words = findWords(cleaned);

        System.out.println(createTweet(TWEET_LENGTH));
    }
    
    private ArrayList<String> loadData() throws IOException {
        
        ArrayList<String> data = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(new FileReader(new File("cleaned.txt")));
        
        String line = "";
        
        while ((line = br.readLine())!= null) {
            
            String[] tokens = line.split(" ");
            
            for (String t: tokens) {
                data.add(t);
            }
        }
        
        br.close();
        
        return data;
        
    }
    
    public String createTweet(int numWords) {
        ArrayList<String> tweet = new ArrayList<>();
        int randomNum = random.nextInt(words.size());
        Word startWord = words.get(randomNum);
        Word currentWord = startWord;
        for (int i = 0; i < numWords; i++) {
            String follower = currentWord.getRandomFollower();
            tweet.add(follower);
            for (int j = 0; j < words.size(); j++) {
                Word wordObject = words.get(j);
                if (wordObject.getWord().equals(follower)){
                    currentWord = wordObject;
                }
            }
        }
        System.out.println(numWords-tweet.size());
        String tweetString = "";
        for (String word:tweet) {
            tweetString+= " " + word;
        }
        return tweetString;
    }
    
    private Word getWord(String word) {
        
        for (Word w: words) {
            if (w.getWord().equalsIgnoreCase(word)) {
                return w;
            }
        }
        return null;
    }
    
    public ArrayList<Word> findWords(ArrayList<String> cleaned) {
        ArrayList<Word> wordObjects = new ArrayList<>();
        ArrayList<String> addedWords = new ArrayList<>();
        for (int i = 0; i < cleaned.size(); i++) {
            String word = cleaned.get(i);
            if (!(addedWords.contains(word))){
                addedWords.add(word);
                Word wordObject = new Word(word);
                wordObject.incrementFrequency();
                wordObjects.add(wordObject);
                if(cleaned.size() >= i+2) {
                    wordObject.addFollower(cleaned.get(i + 1));
                }
            }else if(addedWords.contains(word)){
                for (int j = 0; j < wordObjects.size(); j++) {
                    Word wordObject = wordObjects.get(j);
                    if (wordObject.getWord().equals(word)){
                        wordObject.incrementFrequency();
                        if(cleaned.size() >= i+2) {
                            if (!(wordObject.followerExists(cleaned.get(i + 1)))){
                                wordObject.addFollower(cleaned.get(i + 1));
                            }
                        }
                    }
                }
            }
        }
        return wordObjects;
    }    
}
