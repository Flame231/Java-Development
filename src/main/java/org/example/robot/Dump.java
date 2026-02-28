package org.example.robot;

import java.util.EnumMap;
import java.util.Map;

public class Dump {

    public Map<Detail, Integer> parts = new EnumMap<>(Detail.class);

    public void fillWithStartDetails(int startDetails) {
        for (int i = 0; i < startDetails; i++) {
            add(Utils.getRandomDetail());
        }
    }

    public synchronized void add(Detail detail) {
        parts.merge(detail, 1, Integer::sum);
        System.out.println(Thread.currentThread().getName() + " добавила " + detail);
    }

    public synchronized boolean take(Detail detail) {
        Integer count = parts.get(detail);

        if (count == null || count == 0) {
            System.out.println(Thread.currentThread().getName() + " ушел с пустыми руками, на свалке нет деталей!");
            return false;
        }
        parts.put(detail, count - 1);
        if (count - 1 == 0) {
            parts.remove(detail);
        }
        System.out.println(Thread.currentThread().getName() + " забрал " + detail);
        return true;
    }

    public synchronized boolean isEmpty() {
        return parts.isEmpty();
    }
}