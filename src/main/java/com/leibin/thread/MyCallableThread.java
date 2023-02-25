package com.leibin.thread;

import java.util.Random;
import java.util.concurrent.Callable;

//1 定义一个类实现Callable接口
//2 重写这个类的call()方法
public class MyCallableThread implements Callable<Integer> {
    //多线程执行时具体做的事情，可以有返回值
    @Override
    public Integer call() throws Exception {
//        for(int i = 0;i<=100;i++){
//            System.out.println("MyCallableThread 正在执行"+i);
//        }
        return new Random().nextInt();
    }
}
