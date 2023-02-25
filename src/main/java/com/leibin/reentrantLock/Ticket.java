package com.leibin.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {

    //总票数
    private Integer ticketNum = 150;

    private Lock lock = new ReentrantLock();
    //使用lock加锁
    @Override
    public void run() {
        //同步代码
        while (true){
            System.out.println(Thread.currentThread().getName() + "正在争抢...");
            //加锁
            lock.lock();
            try {
                if (ticketNum <= 0) {
                    System.out.println("售完了");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + "正在售卖第" + (150 - ticketNum + 1) +
                            "张票，还剩" + (ticketNum - 1) + "张票");
                    //问题1 --不是原子操作，而是有下面三步
                    //1 将值从内存中拷贝到寄存器（cpu中）
                    //2 寄存器自减
                    //3 将值写回内存
                    ticketNum--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }
}
