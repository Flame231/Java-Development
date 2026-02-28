package org.example.robot;


public class Factory implements Runnable {

    private final Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {

        for (int night = 0; night < Constants.COUNT_OF_NIGHTS_IN_COMPETITION; night++) {
            int count = Utils.getRandomCountOfDetails();

            for (int i = 0; i < count; i++) {
                dump.add(Utils.getRandomDetail());
            }
            Utils.sleepNight();
        }
    }
}