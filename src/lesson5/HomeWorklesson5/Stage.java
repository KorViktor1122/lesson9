package lesson5.HomeWorklesson5;

public abstract class Stage  {

    int length;
    String description;

    public String getDescription() {
        return description;
    }
    public abstract void go(Car c, int stagePos, int stageCount, long startTime);

}
