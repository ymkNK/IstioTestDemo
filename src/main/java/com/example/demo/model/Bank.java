package com.example.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by Yangmingkai on 2019-12-06.
 */
@Data
@Slf4j
public class Bank {
    private final double[] accounts;

    /**
     * 给银行账户赋初始值值
     *
     * @param n              账户的个数
     * @param initialBalance 初始资金
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 转移资金
     *
     * @param from   从哪个账户上面转移资金
     * @param to     转移到哪个资金上面去
     * @param amount 转移的资金的额度
     */
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        log.info("当前所在的线程：{}", Thread.currentThread());
        accounts[from] -= amount;
        log.info("从账户[{}]转移了{}到账户[{}]", from, amount, to);
        accounts[to] += amount;
        log.info("银行中总金额 {}", getTotalBalance());
    }

    /**
     * 获取银行中所有的资金的总和
     *
     * @return 资金总和
     */
    public double getTotalBalance() {
        double sum = 0;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    /**
     * 返回银行的账户个数
     * @return 账户的个数
     */
    public int size() {
        return accounts.length;
    }
}
