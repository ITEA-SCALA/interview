package com.thread;

import java.util.Random;

/**
 * @see https://russianblogs.com/article/9415826053
 *
 * Этот пример демонстрирует работу с класической Java-реализацией Thread/Runnable.
 * Когда из побочного потока выбрасывается Exception, в этом случае главный поток об этом никогда не узнает.
 */

public class ThreadRunnable {

    public static void main(String[] args) {
        var t1 = new Thread(
                new MyRunnable("one", new Random()));
        var t2 = new Thread(
                new MyRunnable("two", new Random()));
        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable {
    private String name;
    private Random generator;

    public MyRunnable(String name, Random generator) {
        this.name = name;
        this.generator = generator;
    }

    @Override
    public void run() {
        for (int i = 0; i < generator.nextInt(10); i++) {
            System.out.println(name + "> " + i);
        }
    }
}
