package com.company.test1;

import com.company.test1.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {

//        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
//
//        myList.stream() // (1)  return a Stream
//                .filter(s -> s.startsWith("c")) // (2)  return a new Stream
//                .map(String::toUpperCase)  // (3)  return a new Stream
//                .sorted()   // (4)  return a new Stream
//                .forEach(System.out::println); // (5)


//        Employee john = new Employee("John P.", 1500, "M");
//        Employee sarah = new Employee("Sarah M.", 2000, "F");
//        Employee charles = new Employee("Charles B.", 1700, "M");
//        Employee mary = new Employee("Mary T.", 5000, "F");
//        Employee sophia = new Employee("Sophia B.", 7000, "F");
//
//        List<Employee> employees = Arrays.asList(john, sarah, charles, mary, sophia);
//
//        List<Employee> employeesé1 = employees
//                .stream()
//                .filter(e -> e.isFemale() && e.getSalary() > 2500)
//                .collect(Collectors.toList());
//        System.out.println(employeesé1);


//        employees //
//                .stream() //
//                .sorted (
//                        (e1,e2) -> (int) (e2.getSalary() - e1.getSalary())
//                ) //
//                .forEach(e -> System.out.println(e.getSalary() + " : " + e.getName()));

//        employees //
//                .stream() //
//                .filter(e -> e.isFemale() && e.getSalary() > 2500) //
//                .forEach(e -> System.out.println(e.getName()+ " : " + e.getSalary()));


//        employees //
//                .stream() // a Stream.
//                .map((e) -> e.getSalary()* 2) // a new Stream.
//                .forEach(c -> System.out.println(c));

//       Stream.of("a", "b", "hello") // Stream of String
//                .map(String::toUpperCase) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
//                .forEach(System.out::println);
//
//
//        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) // Stream of List<Integer>
//                .flatMap(List::stream)
//                .map(integer -> integer + 1)
//                .forEach(System.out::println);


//        List<String> lst = Arrays.asList("STACK","STACK","OOOVER");
//        List< String[]> res =lst.stream().map(w->w.split("")).distinct().collect(Collectors.toList());
//
//        //res.forEach(e->System.out.println(Arrays.toString(e)));
//
//        System.out.println(Arrays.deepToString(res.toArray()));


//        String[] arrayOfWords = {"STACK", "OOOVVVER"};
//        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
//        List<Stream<String>> res=streamOfWords.map(s->s.split("")) //Converting word in to array of letters
//                .map(Arrays::stream).distinct() //Make array in to separate stream
//                .collect(Collectors.toList());
//               // .forEach(System.out::println);


//        String[] arrayOfWords = {"STACK", "OOOVVVER"};
//        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
//        streamOfWords.map(s->s.split("")) //Converting word in to array of letters
//                .flatMap(Arrays::stream).distinct() //flattens each generated stream in to a single stream
//                .forEach(System.out::println);
//        Stream.of("dog", "cat")             // stream of 2 Strings
//                .flatMapToInt(s -> s.chars()).forEach(System.out::println);
//
//        List<Integer> result = Stream.of(Arrays.asList(1,2), Arrays.asList(2, 3))
//                .flatMap(Collection::stream).distinct()
//                .collect(Collectors.toList());
//
//        System.out.println(result);

        int nb=getTotalNumberOfLettersOfNamesLongerThanFive("med","med","1452","joujou");
        //System.out.println(nb);


        System.out.println(getString(Arrays.asList(3,44)));

    }

//    Stream<Character> characterStream = testString.chars()
//            .mapToObj(c -> (char) c);

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
//        double d= Arrays.stream(names)
//                .map(CharSequence::chars)
//                .map(c -> (char) c)
//                .filter(e->Character.isLetter(e))
//                .filter(e->e.length()>5)
//                .mapToInt(String::length).count();
        //.flatMap(Stream::of).filter(e->Character.isLetter(e))

//        double d=Arrays.stream(names)
//                .filter(e->e.length()>5)
//                 .map(CharSequence::chars)
//                . map(e->e.map(c -> (char) c).toArray())
//                .flatMapToInt(Arrays::stream)
//                .mapToObj(c -> (char) c)
//                .filter(Character::isLetter).peek(System.out::println)
//                .count();


        double d=Arrays.stream(names)
                .filter(e->e.length()>5)
                .map(CharSequence::chars)
                . map(e->e.map(c -> (char) c).filter(Character::isLetter).toArray())
                .flatMapToInt(Arrays::stream)
                .mapToObj(c -> (char) c)
                .peek(System.out::println)
                .count();
        return (int) d;
    }

    public static List<String> transform(List<List<String>> collection) {

        collection.stream().flatMap(Collection::stream).  collect(Collectors.toList());

        return null;
    }

    public static Person getOldestPerson(List<Person> people) {
        Person oldestPerson=null;


        return  people.stream().max(Comparator.comparing(Person::getAge)).get();
    }

    public static int calculate(List<Integer> numbers) {

        return  numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static Set<String> getKidNames(List<Person> people) {
        Set<String> kids = new HashSet<>();
        for (Person person : people) {
            if (person.getAge() < 18) {
                kids.add(person.getName());
            }
        }
        return people.stream().filter(e->e.getAge()<18).map(Person::getName).collect(Collectors.toSet());
    }

//    Map<Integer, Animal> map = list.stream()
//            .collect(Collectors.toMap(Animal::getId, Function.identity()));

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
//        Map<Boolean, List<Person>> map = new HashMap<>();
//        map.put(true, new ArrayList<>());
//        map.put(false, new ArrayList<>());
//        for (Person person : people) {
//            map.get(person.getAge() >= 18).add(person);
//        }


        return people.stream()
                .collect(groupingBy(e->e.getAge() >= 18));
    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
//        Map<String, List<Person>> map = new HashMap<>();
//        for (Person person : people) {
//            if (!map.containsKey(person.getNationality())) {
//                map.put(person.getNationality(), new ArrayList<>());
//            }
//            map.get(person.getNationality()).add(person);
//        }

        return  people.stream()
                .collect(groupingBy(Person::getNationality));
    }

    public static String namesToString(List<Person> people) {
//        String label = "Names: ";
//        StringBuilder sb = new StringBuilder(label);
//        for (Person person : people) {
//            if (sb.length() > label.length()) {
//                sb.append(", ");
//            }
//            sb.append(person.getName());
//        }
//        sb.append(".");
//        return sb.toString();

        String result = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: ", "."));
        return result;


    }


    /*
    * Write a method that returns a comma separated string based on a given list of integers.
    *  Each element should be preceded by the letter 'e' if the number is even,
    *  and preceded by the letter 'o' if the number is odd. For example, if the input list is (3,44),
    *  the output should be 'o3,e44'.
    * */

    public static String getString(List<Integer> list) {

//        String result = list.stream()
//                .map(e->{
//                    if(e%2==0)
//                        return "e"+e;
//                    else
//                        return "o"+e;
//                })
//                .collect(Collectors.joining(","));

        String result = list.stream()
                .map(e->e%2==0?"e"+e:"o"+e)
                .collect(Collectors.joining(","));

        return result;
    }

}

/***********************************************************************************************************/

 class Employee {

    private String name;
    private float salary;
    private String gender; // "M", "F"

    public Employee(String name, float salary, String gender) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public boolean isFemale() {
        return "F".equals(this.getGender());
    }
}
class Person {

    private String name;
    private int age;
    private String nationality;

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public Person(String name, int age) {
        this(name, age, "");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }
}
 class Parcel {
    String name;
    List<String> items;

    public Parcel(String name, String... items) {
        this.name = name;
        this.items = Arrays.asList(items);
    }

    public List<String> getItems() {
        return items;
    }

    public static void main(String[] args) {
        Parcel amazon = new Parcel("amazon", "Laptop", "Phone");
        Parcel ebay = new Parcel("ebay", "Mouse", "Keyboard");
        List<Parcel> parcels = Arrays.asList(amazon, ebay);

        System.out.println("-------- Without flatMap() ---------------------------");
        List<List<String>> mapReturn = parcels.stream()
                .map(Parcel::getItems)
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + mapReturn);

        System.out.println("\n-------- With flatMap() ------------------------------");
        List<String> flatMapReturn = parcels.stream()
                .map(Parcel::getItems)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: " + flatMapReturn);
    }
}