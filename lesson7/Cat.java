package lesson7;

/**
 * Created by Jedai86 on 20.11.2016.
 */
public class Cat {
    private static int count;
    private static int plate;
    private String name;
    private int age;
    private int id;

    public Cat(String name, int age) {
        count++;
        this.name = name;
        this.age = age;
        this.id = count;
        plate = 100;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void drink() {
        plate -= 10;
        System.out.println(name + " попил, осталось " + plate);
    }

    @Override
    public String toString() {
        return name + ", age: " + age + ", id: " + id;
    }
}
