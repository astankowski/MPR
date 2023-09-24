import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(20, "Jan");

        try {
            Person person2 = new Person(10, "Adam");
        } catch (InvalidAgeException e) {
            System.out.println("Wyjątek: " + e.getMessage());
        }
        Person person2 = new Person(30, "Magda");
        Person person3 = new Person(25, "Ala");

        List<Person> personList = List.of(person1,person2, person3);
        List<Person> anotherPersonList = new ArrayList<>();
        anotherPersonList.add(person1);
        anotherPersonList.add(person2);
        anotherPersonList.add(person3);
        System.out.println("Lista 1: " + personList);
        System.out.println("Lista 2: " + anotherPersonList);

        Set<Person> personSet = Set.of(person1, person2, person3);
        Set<Person> anotherPersonSet = new HashSet<>();
        anotherPersonSet.add(person1);
        anotherPersonSet.add(person2);
        anotherPersonSet.add(person3);
        System.out.println("Set 1: " + personSet);
        System.out.println("Set 2: " + anotherPersonSet);

        Map<Integer, Person> personMap = Map.of(1, person1, 2, person2, 3, person2);
        Map<Integer, Person> anotherPersonMap = new HashMap<>();
        anotherPersonMap.put(1, person1);
        anotherPersonMap.put(2, person2);
        anotherPersonMap.put(1, person3);
        System.out.println("Map 1: " + personMap);

        System.out.println("Imie: " + person1.getName());
        System.out.println("Wiek: " + person1.getAge());

        List<Integer> ageList = personList.stream().map(Person::getAge).collect(Collectors.toList());
        System.out.println(ageList);

        int result = ageList.stream().reduce(0, Integer::sum);
        System.out.println("średni wiek osób w liście: " + result/3);

        List<String> personNameList = personList.stream().map(Person::getName).toList();
        System.out.println("4.2: " + personNameList);

        List<Person> personListAge25 = personList.stream().filter(person -> person.getAge() < 25).collect(Collectors.toList());
        System.out.println("4.3: " + personListAge25);

        List<Person> sortedByNamePersonList = personList.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        System.out.println("4.4: " + sortedByNamePersonList);

        System.out.println("4.5");
        personList.stream().forEach(person -> {
            System.out.println(person.getName() + person.getAge());
        });

        System.out.println("4.6");
        Person min = personList.stream().min(Comparator.comparing(Person::getAge)).get();
        Person max = personList.stream().max(Comparator.comparing(Person::getAge)).get();
        System.out.println("min: " + min.getName()+ min.getAge());
        System.out.println("max: " + max.getName()+ max.getAge());
    }
}
