package TaskThree;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Напишіть метод, який буде рахувати частоту кожного слова у файлі words.txt.
 * <p>
 * Вважаємо що:
 * <p>
 * words.txt містить лише слова в нижньому регістрі, розділені пробілом
 * Кожне слово містить лише літери в нижньому регістрі
 * Слова розділені одним або декількома пробілами, або переносом рядка
 */
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
        Map<String, Integer> map = new HashMap<>();
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
        System.out.println(map);
    }
}
