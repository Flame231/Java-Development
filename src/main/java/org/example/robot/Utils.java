package org.example.robot;

import java.util.Random;

public class Utils {

    static Random random = new Random();

    public static Detail getRandomDetail() {
        Detail[] values = Detail.values();
        return values[random.nextInt(values.length)];
    }

    public static int getRandomCountOfDetails() {
        return random.nextInt(Constants.RANDOM_COUNT_OF_DETAILS_BOUND) + 1;
    }

    public static void sleepNight() {
        try {
            Thread.sleep(Constants.ONE_NIGHT_DURATION);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printResult(Scientist s1, Scientist s2) {
        int r1 = s1.getCountOfRobots();
        int r2 = s2.getCountOfRobots();

        System.out.println("\n" + "=========================================" + "\n");
        System.out.println("Ученый 1 собрал " + r1 + " роботов.");
        System.out.println("Ученый 2 собрал " + r2 + " роботов.");

        if (r1 > r2) {
            System.out.println("Ученый 1 победил!");
        } else if (r2 > r1) {
            System.out.println("Ученый 2 победил!");
        } else {
            System.out.println("Ничья!");
        }
    }
}