package experiment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCount {

    private Map<String, Integer> wordCountMap;

    public WordCount(String fileName){
        wordCountMap= getCountMap(fileName);
    }

    // Indlæser bogen i en Map fra ord til antal forekomster
    private Map<String, Integer> getCountMap(String fileName) {
        Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();
        try {
            Scanner in = new Scanner(new File(fileName));
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                if (!wordCountMap.containsKey(word)) {
                    // hvis vi aldrig har mødt ordet før:
                    wordCountMap.put(word, 1);
                } else {
                    // hvis vi har set ordet før tæller vi count én op
                    int count = wordCountMap.get(word);
                    wordCountMap.put(word, count + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordCountMap;
    }

    public int numberOfUniqueWords() {
        return wordCountMap.keySet().size();
    }

    public String occurrenceOfWord(String word) {
        String result = "";
        word = word.toLowerCase();
        result = "Ordet " + word + " forekommer s\u00e5 mange gange: " + wordCountMap.get(word);
        return result;
    }
   
    public int total() {
        return wordCountMap.size();
    }

}
