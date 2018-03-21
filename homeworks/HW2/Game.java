//package ru.atom;
import java.util.*; // ArrayList
import java.io.*;   // FileReader, BufferedReader

public class Game{
    // assuming word and guess are of one length
    // returns bulls
    private static int count_bulls_n_cows(String word, String guess){
        int bulls = 0;
        int cows = 0;
        int[] wordLetters = new int[26];
        int[] guessLetters = new int[26];
        for (int i = 0; i < word.length(); ++i){
            if (guess.charAt(i) < 'a' || guess.charAt(i) > 'z') {
                System.out.println("Only small letters are acceptable");
                System.out.println("Try again:");
                return 0;
            }
            if (word.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++wordLetters[word.charAt(i) - 'a'];
                ++guessLetters[guess.charAt(i) - 'a'];
            }
        }
        for (int i = 0; i < 26; ++i){
            if (wordLetters[i] > guessLetters[i]){
                cows += guessLetters[i];
            } else {
                cows += wordLetters[i];
            }
        }
        if (bulls != word.length()) {
            System.out.println("You have bulls - " + bulls + " and cows - " + cows);
            System.out.println("Give it another try");
        }
        return bulls;
    }

    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<String>();

        System.out.println("Welcome to Bulls and cows game!");
        String filename = "dict.txt";
        String word = null;
        // read all words from dictionary and add to dict
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((word = bufferedReader.readLine()) != null) {
                dict.add(word);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '"
                                + filename + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '"
                                + filename + "'");
        }

        Random rand = new Random();
        Scanner reader = new Scanner(System.in);
        System.out.println("Do you want to play? If YES print 1, if NO print 0");
        int ans = reader.nextInt();
        int counter = 1;
        while (ans == 1) {
            int idx = rand.nextInt(dict.size());
            word = dict.get(idx);
            System.out.println(word);
            int wordLen = word.length();
            int bulls = 0;
            System.out.println("You have to guess the word, which has " + wordLen + " letters");
            while (bulls != wordLen && counter != 11) {
                System.out.println("And your " + counter + " suggestion is:");
                String guess = reader.next();
                while (guess.length() != wordLen) {
                    System.out.println("You have to type the word with length " + wordLen);
                    guess = reader.next();
                }
                bulls = count_bulls_n_cows(word, guess);
                ++counter;
            }
            if (bulls == wordLen) {
                System.out.println("Hooray! You have guessed the word " + dict.get(idx)
                        + " in " + counter + " attempts.");
            } else {
                System.out.println("You lost :(");
            }

            System.out.println("Do you want to play again? If YES print 1, if NO print 0");
            ans = reader.nextInt();
        }
        reader.close();
    }
}