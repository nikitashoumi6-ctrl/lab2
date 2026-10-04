import java.util.HashMap;
import java.util.Map;

public class Task5 {
    //Метод возвращает новую Map с обменёнными ключами и значениями
    public static <K, V> Map<V, K> swapKeyValue(Map<K, V> map) {
        Map<V, K> swapped = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            swapped.put(entry.getValue(), entry.getKey());
        }
        return swapped;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("one", 1);
        original.put("two", 2);
        original.put("three", 3);

        Map<Integer, String> swapped = swapKeyValue(original);

        System.out.println("Исходная Map: " + original);
        System.out.println("Обмененная Map: " + swapped);
    }
}