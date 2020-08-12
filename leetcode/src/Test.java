import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 50));
        list.add(new Person("刘达", 32));
        list.add(new Person("李四", 24));
        list.add(new Person("王五", 73));
        list.add(new Person("赵六", 12));
        list.add(new Person("陈琦", 47));
        list.add(new Person("猪八", 17));
        List<Person> collect = list.stream().filter(person -> person.age < 18)
                .limit(2)
                .sorted((o1, o2) -> -Integer.compare(o2.age, o1.age)).collect(Collectors.toList());
        for (Person person : collect) {
            System.out.println(person.name);
        }
    }

    public static void threadTest1() {
        Thread thread = new Thread(() -> System.out.println("hahaha"));
        thread.start();
    }

    public static void threadTest2() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("lalala");
            }
        };
        thread.start();
    }

    public static void threadTest3() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hahaha");
            }
        });
        thread.start();
    }

    public static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
