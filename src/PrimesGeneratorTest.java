import java.util.*;

//Проверочный класс
public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int n = 10;
        PrimesGenerator generator = new PrimesGenerator(n);

        List<Integer> primes = new ArrayList<>();

        //Перебор с помощью интерфейса Iterator
        Iterator<Integer> iterator = generator.iterator();
        while (iterator.hasNext()) {
            primes.add(iterator.next());
        }

        System.out.println("Первые " + n + " простых чисел: " + primes);

        Collections.reverse(primes);
        System.out.println("Обратный порядок: " + primes);
    }
}