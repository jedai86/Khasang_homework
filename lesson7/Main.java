package lesson7;

/**
 * Created by Jedai86 on 20.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Murka", 5);
        Cat cat2 = new Cat("Tom", 3);
        Cat cat3 = new Cat("Jerry", 7);
        Miska miska = new Miska(200);

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);

        cat1.drink();
        miska.eat(cat1);
        cat2.drink();
        miska.eat(cat2);
        cat3.drink();
        miska.eat(cat3);

    }
}
