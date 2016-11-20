package lesson7;

/**
 * Created by Jedai86 on 20.11.2016.
 */
public class Miska {
    private int foodCount;

    public Miska(int foodCount) {
        this.foodCount = foodCount;
    }

    public void eat(Cat cat) {
        foodCount -= 20;
        System.out.println(cat.getName() + " поел, осталось " + foodCount);
    }
}
