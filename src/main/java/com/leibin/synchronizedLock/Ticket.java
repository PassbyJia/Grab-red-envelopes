package com.leibin.synchronizedLock;

public class Ticket implements Runnable {
    //总票数
    private static int ticketNum = 150;

    //生成任意锁对象，实现同步
//    private Object lock = new Object();

    //编写需要同步的方法
//    private synchronized boolean sellTicket(){
//        //需同步的代码
//        if (ticketNum <= 0) {
//            System.out.println("售完了");
//            return true;
//        } else {
//            System.out.println(Thread.currentThread().getName() + "正在售卖第" + (150 - ticketNum + 1) +
//                    "张票，还剩" + (ticketNum - 1) + "张票");
//            //问题1 --不是原子操作，而是有下面三步
//            //1 将值从内存中拷贝到寄存器（cpu中）
//            //2 寄存器自减
//            //3 将值写回内存
//            ticketNum--;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return false;
//        }
//    }
    //编写需要同步的静态方法
//    private static synchronized boolean sellTicket(){
//        //需同步的代码
//        if (ticketNum <= 0) {
//            System.out.println("售完了");
//            return true;
//        } else {
//            System.out.println(Thread.currentThread().getName() + "正在售卖第" + (150 - ticketNum + 1) +
//                    "张票，还剩" + (ticketNum - 1) + "张票");
//            //问题1 --不是原子操作，而是有下面三步
//            //1 将值从内存中拷贝到寄存器（cpu中）
//            //2 寄存器自减
//            //3 将值写回内存
//            ticketNum--;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return false;
//        }
//    }
    @Override
    public void run() {
        //一直卖，卖完退出
        //问题1：重复票
//        售票窗口3正在售卖第138张票，还剩12张票
//        售票窗口2正在售卖第138张票，还剩12张票
        //问题2：超卖
//        售票窗口1正在售卖第151张票，还剩-1张票
        //解决方法：利用synchronized锁，让线程同步执行
        while (true) {
            System.out.println(Thread.currentThread().getName() + "正在争抢...");
//            //1 同步代码块
//            synchronized (lock) {
//                //需同步的代码
//                if (ticketNum <= 0) {
//                    System.out.println("售完了");
//                    break;
//                } else {
//                    System.out.println(Thread.currentThread().getName() + "正在售卖第" + (150 - ticketNum + 1) +
//                            "张票，还剩" + (ticketNum - 1) + "张票");
//                    //问题1 --不是原子操作，而是有下面三步
//                    //1 将值从内存中拷贝到寄存器（cpu中）
//                    //2 寄存器自减
//                    //3 将值写回内存
//                    ticketNum--;
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
            //2 同步方法
//            if(sellTicket()) break;
            //3 修饰静态方法
//            if(sellTicket()) break;
            //4 修饰类
            synchronized (Ticket.class) {
                //需同步的代码
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

            }
        }
    }
}
