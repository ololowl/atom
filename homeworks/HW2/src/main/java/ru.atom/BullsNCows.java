package ru.atom;

list<String> dict = new ArratList<String>();

public class BullsNCows {
    public static void main (String[] args) {
        System.out.println("Welcome to Bulls and cows game!");
        String filename = "../../../dict.txt";
        String word = null;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new bufferedReader(filereader);
            while ((line = bufferedReader.readline()) != null) {
                dict.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '"
                                + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '"
                                + fileName + "'");
        }
    }
}