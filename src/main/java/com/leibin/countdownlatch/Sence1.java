package com.leibin.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Sence1 implements Runnable {

    private CountDownLatch countDownLatch;

    public Sence1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        //模拟任务正在进行
        try {
            System.out.println(Thread.currentThread().getName()+"干活中~");
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //执行完毕
        countDownLatch.countDown();
    }


}
