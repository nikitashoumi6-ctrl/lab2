import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        int n = 15;
        Integer[] array = new Integer[n];
        Random rnd = new Random();

        //1.Создайте массив из N случайных чисел от 0 до 100
        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(101);
        }
        System.out.println("1. Массив: " + Arrays.toString(array));

        //2.На основе массива создайте список List
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("2. Список: " + list);

        //3.Отсортируйте список по возрастанию
        Collections.sort(list);
        System.out.println("3. По возрастанию: " + list);

        //4.Отсортируйте список в обратном порядке
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("4. В обратном порядке: " + list);

        //5.Перемешайте список
        Collections.shuffle(list);
        System.out.println("5. Перемешанный: " + list);

        //6.Выполните циклический сдвиг на 1 элемент
        Collections.rotate(list, 1);
        System.out.println("6. Циклический сдвиг на 1: " + list);

        //7.Оставьте в списке только уникальные элементы (удаляем дубликаты)
        List<Integer> uniqueList = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("7. Только уникальные (без дубликатов): " + uniqueList);

        //8.Оставьте в списке только дублирующиеся элементы
        List<Integer> duplicatesList = new ArrayList<>();
        for (Integer item : list) {
            if (Collections.frequency(list, item) > 1 && !duplicatesList.contains(item)) {
                duplicatesList.add(item);
            }
        }
        System.out.println("8. Только дублирующиеся: " + duplicatesList);

        //9.Из списка получите массив
        Integer[] resultArray = uniqueList.toArray(new Integer[0]);
        System.out.println("9. Массив из списка: " + Arrays.toString(resultArray));

        //10.Подсчитайте количество вхождений каждого числа (используя Collections.frequency)
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer item : uniqueList) {
            counts.put(item, Collections.frequency(list, item));
        }
        System.out.println("10. Количество вхождений: " + counts);
    }
}