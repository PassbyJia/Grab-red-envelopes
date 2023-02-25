package com.leibin.thread;

//1 定义一个类实现Runnable接口
//2 重写这个类的run方法
public class MyRunnableThread implements Runnable{
    //线程启动后具体做的事情
    public void run() {
        for(int i = 0;i<=100;i++){
            System.out.println("MyRannableThread 正在执行"+i);
        }
    }
}
