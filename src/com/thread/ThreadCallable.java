package com.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @see https://russianblogs.com/article/9415826053
 *      https://javarush.ru/groups/posts/2065-threadom-java-ne-isportishjh--chastjh-iv---callable-future-i-druzjhja
 *
 * Этот пример демонстрирует работу с реализацией Java-concurrent Thread/Callable.
 * Чтобы оповещать главный поток об результатах выполнения из побочных потоков - интерфейс Callable, возвращает тип Future
 * и когда в будущем, побочный поток закончит выполнение, тогда Future вернет результаты его выполнения.
 */

public class ThreadCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var task1 = new FutureTask<>(
                new MyCallable("one", new Random()));
        var task2 = new FutureTask<>(
                new MyCallable("two", new Random()));

        var t1 = new Thread(task1);
        var t2 = new Thread(task2);
        t1.start();
        t2.start();

        System.out.println ("Задача 'task1' вернула значение из побочного потока = " + task1.get());
        System.out.println ("Задача 'task2' вернула значение из побочного потока = " + task2.get());
    }
}

class MyCallable implements Callable<Integer> {
    private String name;
    private Random generator;

    public MyCallable(String name, Random generator) {
        this.name = name;
        this.generator = generator;
    }

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < generator.nextInt(10); i++) {
            System.out.println(name + "> " + i);
        }

        return i;
    }
}
