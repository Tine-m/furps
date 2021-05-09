package experiment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCount {
    // unique words
    private ArrayList<String> wordCountList;
    // number of occurences
    private ArrayList<Integer> wordCounts = new ArrayList<>();

    public WordCount(String fileName){
       wordCountList = getCountList(fileName);
    }

    // Indlæser bogen i en ArrayList: ord og antal forekomster
    private ArrayList<String> getCountList(String fileName) {
        ArrayList<String> wordCountList = new ArrayList();
        try {
            Scanner in = new Scanner(new File(fileName));
            int index = 0;
            int count = 0;
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                if (!wordCountList.contains(word)) {
                    wordCountList.add(word); //tilføj i listen
                    wordCounts.add(1); // set antal forekomster = 1
                } else {
                    // hvis vi har set ordet før, tæller vi count én op
                    index = wordCountList.indexOf(word);
                    count = wordCounts.get(index);
                    wordCounts.set(index, count + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordCountList;
    }
    
    public String occurrenceOfWord(String word) {
        String result = "";
        word = word.toLowerCase();
        int index = wordCountList.indexOf(word);
        int count = wordCounts.get(index);
        result = "Ordet lykkelig forekommer s\u00e5 mange gange: " + count;
        return result;
    }

    public int total() {
        return wordCountList.size();
    }
}
