import java.util.*;

class Human implements Comparable<Human> {
    String firstName;
    String lastName;
    int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Human other) {
        int cmp = this.lastName.compareTo(other.lastName);
        if (cmp != 0) return cmp;
        cmp = this.firstName.compareTo(other.firstName);
        if (cmp != 0) return cmp;
        return Integer.compare(this.age, other.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && firstName.equals(human.firstName) && lastName.equals(human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + age + " лет)";
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.lastName.compareTo(h2.lastName);
    }
}

public class Task3 {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Ivan", "Ivanov", 25),
                new Human("Petr", "Petrov", 30),
                new Human("Anna", "Ivanova", 20),
                new Human("Ivan", "Ivanov", 25), //полный дубликат
                new Human("Sergey", "Vetrov", 25) // совпадает возраст с Ivanov
        );

        System.out.println("2.HashSet (произвольный порядок, без дубликатов):");
        System.out.println(new HashSet<>(humans));

        System.out.println("\n3.LinkedHashSet (порядок вставки, без дубликатов):");
        System.out.println(new LinkedHashSet<>(humans));

        System.out.println("\n4.TreeSet (естественный порядок Comparable: фамилия, имя, возраст):");
        System.out.println(new TreeSet<>(humans));

        System.out.println("\n5.TreeSet с HumanComparatorByLastName:");
        TreeSet<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println(treeSetByLastName);

        System.out.println("\n6.TreeSet с анонимным компаратором по возрасту:");
        TreeSet<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.age, h2.age);
            }
        });
        treeSetByAge.addAll(humans);
        System.out.println(treeSetByAge);

        /*
         * 7.Объяснение различий в выводах коллекций:
         * - HashSet: хранит элементы в произвольном порядке, удаляет полные дубликаты
         * - LinkedHashSet: сохраняет порядок добавления элементов, удаляет полные дубликаты
         * - TreeSet (Comparable): сортирует по фамилии, затем по имени, затем по возрасту. Удаляет полные дубликаты
         * - TreeSet (by LastName): сортирует только по фамилии. Если фамилии одинаковы, компаратор возвращает 0,
         *   и TreeSet считает элементы равными. В результате в множестве останется только ОДИН человек с такой фамилией
         * - TreeSet (by Age): сортирует по возрасту. Люди с одинаковым возрастом считаются равными
         *   и затирают друг друга. В выводе останется только по одному представителю каждого возраста
         */
    }
}