package lesson1;

/**
 * Created by Jedai86 on 09.10.2016.
 */
public class Primitives {
    public static void main(String[] args) {
        Byte b = 3;
        Short s = 113;
        Integer i = 123243;
        Long l = 123243434545L;

        Float f = 2343.5f;
        Double d = 234.34;

        Boolean bul = true;
        Character ch = 'f';

        System.out.println("Primitives: " + b +", " + s + ", " + i + ", " + l + ", " + f + ", " + d + ", " + bul + ", " + ch + ".");
        System.out.print("Byte max/min: " + Byte.MAX_VALUE + " : ");
        System.out.println(Byte.MIN_VALUE);
        System.out.print("Short max/min: " + Short.MAX_VALUE + " : ");
        System.out.println(Short.MIN_VALUE);
        System.out.print("Int max/min: " + Integer.MAX_VALUE + " : ");
        System.out.println(Integer.MIN_VALUE);
        System.out.print("Long max/min: " + Long.MAX_VALUE + " : ");
        System.out.println(Long.MIN_VALUE);
        System.out.print("Float max/min: " + Float.MAX_VALUE + " : ");
        System.out.println(Float.MIN_VALUE);
        System.out.print("Double max/min: " + Double.MAX_VALUE + " : ");
        System.out.println(Double.MIN_VALUE);
        System.out.print("Char max/min: " + Character.MAX_VALUE + " : ");
        System.out.println(Character.MIN_VALUE + ".");

    }
}
