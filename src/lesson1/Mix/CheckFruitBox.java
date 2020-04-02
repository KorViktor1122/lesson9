package lesson1.Mix;

public class CheckFruitBox {
    public static void main(String[] args) {
        Apple apple = new Apple(1);
        Orange orange = new Orange((float) 1.5);


        Box<Apple> appleBox = new Box<Apple>(apple,5);
        System.out.println(appleBox.getWeigh());
        Box<Orange> orangeBox = new Box<Orange>(orange, 6);
        System.out.println(orangeBox.getWeigh());

        System.out.println("------------------------");
        System.out.println(appleBox.compare(orangeBox));
    }
}
