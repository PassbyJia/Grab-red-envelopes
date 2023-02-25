package com.leibin.threadname;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("线程的名字："+this.getName());
    }
}
