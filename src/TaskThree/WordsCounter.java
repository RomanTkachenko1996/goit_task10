package TaskThree;


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class WordsCounter {
    public static void main(String[] args) {
        StringBuilder words = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/assets/words.txt"), 24)) {
            while (br.ready()) {
                String s = br.readLine();
                words.append(s).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] wordsArray = words.toString().split(" ");
        Map<String, Integer> map = new TreeMap<>();

        for (String word : wordsArray) {
            int counter = 1;
            if (!(word.equals(" "))) {
                if (map.containsKey(word)) {
                    int counterForKey = map.get(word);
                    map.put(word, ++counterForKey);
                } else {
                    map.put(word, counter);
                }
            }
        }
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
