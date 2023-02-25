package com.leibin.threadsleep;

public class MyThread extends Thread {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "---线程开始执行了");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "---线程开始执行结束了");
    }
}
