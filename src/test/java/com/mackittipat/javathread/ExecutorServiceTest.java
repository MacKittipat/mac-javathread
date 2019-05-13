package com.mackittipat.javathread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceTest {

    @Test
    public void testExecutor() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(() -> {
                System.out.println("Running thread : " + Thread.currentThread().getName() + " - " + i);
            });
        });
    }

    @Test
    public void testExecutor2Thread() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(() -> {
                System.out.println("Running thread : " + Thread.currentThread().getName() + " - " + i);
            });
        });
    }

    @Test
    public void testScheduleExecutor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(() -> {
            System.out.println("Running thread : " + Thread.currentThread().getName());
        }, 5, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println("Running thread : " + Thread.currentThread().getName());
//        }, 1, 3, TimeUnit.SECONDS);
    }

}
