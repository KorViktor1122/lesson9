package lesson5.HomeWorklesson5;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdReady;
    private CountDownLatch cdFinish;
    private static CountDownLatch countDownLatch = new CountDownLatch(MainClass.CARS_COUNT);
    private long startTime;

    String getName() {
        return name;
    }
    int getSpeed() {
        return speed;
    }
    Car(Race race, int speed, CountDownLatch cdReady, CountDownLatch cdFinish) {
        this.race = race;
        this.speed = speed;
        this.cdReady = cdReady;
        this.cdFinish = cdFinish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.Go.countDown();
            MainClass.Go.await();
            cdReady.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, i + 1, race.getStages().size(), startTime);
        }
        cdFinish.countDown();
    }
}
