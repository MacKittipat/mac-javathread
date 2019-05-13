package com.mackittipat.javathread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Running thread : " + Thread.currentThread().getName());
        }, 1, 3, TimeUnit.SECONDS);
    }
}
