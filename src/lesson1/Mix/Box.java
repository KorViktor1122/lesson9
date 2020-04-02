package lesson1.Mix;

public class Box <T extends Fruit> {

    private T obj;
    private  int fruitCount;

    public Box(T obj, int fruitCount) {
        this.obj = obj;
        this.fruitCount = fruitCount;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    float getWeigh(){
        return fruitCount * obj.getWeigth();
    }

    public boolean compare (Box<?> box) {
        return this.getWeigh() == box.getWeigh();
    }
}
