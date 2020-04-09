package lesson5.HomeWorklesson5;

import java.util.DoubleSummaryStatistics;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    private static final int CARS_COUNT = 4;


    static CountDownLatch Go = new CountDownLatch(CARS_COUNT);
    static CyclicBarrier Distaition = new CyclicBarrier(CARS_COUNT);
    static Semaphore tunnel = new Semaphore(CARS_COUNT/2,true);
    static CountDownLatch Finish = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            new Thread(car).start();
        }

        while (Go.getCount() > 0)
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


        while (Finish.getCount() > 0)
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}
