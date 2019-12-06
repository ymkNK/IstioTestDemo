package com.example.demo;

import com.example.demo.model.Bank;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yangmingkai on 2019-12-06.
 */
@Slf4j
public class ThreadMainTest {
    private static final int DELAY = 10;
    private static final int STEPS = 100;
    private static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        var bank = new Bank(4, 10000);
        Runnable task1 = () -> {
            for (int i = 0; i < STEPS; i++) {
                double amount = MAX_AMOUNT * Math.random();
                bank.transfer(0, 1, amount);
                try {
                    Thread.sleep((int) (DELAY * Math.random()));
                } catch (InterruptedException e) {
                    log.error("interruptedException",e);
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < STEPS; i++) {
                double amount = MAX_AMOUNT * Math.random();
                bank.transfer(2, 3, amount);
                try {
                    Thread.sleep((int) (DELAY * Math.random()));
                } catch (InterruptedException e) {
                    log.error("interruptedException",e);
                }
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
