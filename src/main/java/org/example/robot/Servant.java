package org.example.robot;

public class Servant implements Runnable {

    private final Dump dump;
    private final Scientist scientist;

    public Servant(Dump dump, Scientist scientist) {
        this.dump = dump;
        this.scientist = scientist;
    }

    @Override
    public void run() {

        for (int night = 0; night < Constants.COUNT_OF_NIGHTS_IN_COMPETITION; night++) {

            int count = Utils.getRandomCountOfDetails();

            for (int i = 0; i < count; i++) {
                if (dump.isEmpty()) break;
                Detail d = Utils.getRandomDetail();
                if (dump.take(d)) {
                    scientist.addDetail(d);
                }
            }
           Utils.sleepNight();
        }
    }
}
