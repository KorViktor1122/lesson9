package lesson5.HomeWorklesson5;

public class Tunnel extends Stage {
    private long finishTime;
    Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c, int stagePos, int stageCount, long startTime) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                MainClass.tunnel.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finishTime = System.currentTimeMillis() - startTime;
                System.out.println(c.getName() + " закончил этап: " + description);
                MainClass.tunnel.release();

                if(stagePos == stageCount && MainClass.firstFinish) {
                    MainClass.firstFinish = false;
                    System.out.println(c.getName() + " WIN !!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
