import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        String text = "Hello world hello Java world JAVA java is cool";

        //Разделяем текст на слова по не-буквенным символам, приводим к нижнему регистру
        String[] words = text.toLowerCase().split("\\W+");

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Частота встречаемости слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}