package com.mackittipat.javathread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    @Test
    public void testCreateThread() {

        Thread thread = new MyThread();
        thread.start();
    }

    @Test
    public void testCreateRunnableThread() {

        Thread thread = new Thread(() -> {
            System.out.println("Running thread : " + Thread.currentThread().getName());
        });
        thread.start();
    }
    
    @Test
    public void testCreateCallableThread() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            return "Running thread : " + Thread.currentThread().getName();
        };

        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());
        System.out.println("Hello World");
    }
}