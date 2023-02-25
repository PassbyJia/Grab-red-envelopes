package com.leibin.thread;

//1 定义一个类继承Thread类
//2 重写这个类的run方法
public class MyThread extends Thread{

    //多线程执行时具体做的事情
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
            System.out.println("MyThread 开始执行"+i);
        }
    }
}
