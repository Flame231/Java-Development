package org.example.robot;

public class Program {
    public static void main(String[] args) throws InterruptedException {

        Dump dump = new Dump();
        Scientist s1 = new Scientist();
        Scientist s2 = new Scientist();

        dump.fillWithStartDetails(20);

        Thread factory = new Thread(new Factory(dump), "Фабрика!!!!!!!");
        Thread servant1 = new Thread(new Servant(dump, s1), "Прислужник-1");
        Thread servant2 = new Thread(new Servant(dump, s2), "Прислужник-2");
        factory.start();
        servant1.start();
        servant2.start();

        factory.join();
        servant1.join();
        servant2.join();

        Utils.printResult(s1, s2);
    }
}