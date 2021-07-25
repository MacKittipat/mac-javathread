package com.mackittipat.javathread;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceTest {

    @Test
    public void testSingleThreadExecutor() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(() -> {
                System.out.println("Running thread : " + Thread.currentThread().getName() + " - " + i);
            });
        });
    }

    @Test
    public void testFixedThreadPool() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        IntStream.range(0, 10).forEach(i -> {
            executorService.submit(() -> {
                System.out.println("Running thread : " + Thread.currentThread().getName() + " - " + i);
            });
        });
    }

    @Test
    public void testScheduleThreadPool() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(() -> {
            System.out.println("Running thread : " + Thread.currentThread().getName());
        }, 5, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println("Running thread : " + Thread.currentThread().getName());
//        }, 1, 3, TimeUnit.SECONDS);
    }

    @Test
    public void testFixedThreadPools() throws InterruptedException, ExecutionException {

        Callable<String> c1 = () -> "Thread 1";

        Callable<String> c2 = () -> "Thread 2";

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<String>> results = executorService.invokeAll(Arrays.asList(c1, c2));

        for (Future<String> result : results) {
            System.out.println(result.get());
        }
    }

}
