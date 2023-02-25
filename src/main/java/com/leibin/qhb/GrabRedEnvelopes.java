package com.leibin.qhb;

import java.util.concurrent.CountDownLatch;

public class GrabRedEnvelopes implements Runnable {

    //红包总额
    private int redEnvelope;
    //红包个数
    private int redEnvelopeNum;
    //红包大小
    private int redEnvelopeSize;
    //最后一个红包的大小
    private int laseRedEnvelopeSize;

    private CountDownLatch countDownLatch;
    //锁
    private Object lock = new Object();

    public GrabRedEnvelopes(int redEnvelope, int redEnvelopeNum, CountDownLatch countDownLatch) {
        this.redEnvelope = redEnvelope;
        this.redEnvelopeNum = redEnvelopeNum;
        this.redEnvelopeSize = redEnvelope/redEnvelopeNum;
        this.laseRedEnvelopeSize = redEnvelope-(redEnvelopeSize)*(redEnvelopeNum-1);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        //先阻塞，等待主线程创建好之后，一起唤醒
        try {
             countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){//上锁，保证线程安全
            if(redEnvelopeNum>0){
                if (redEnvelopeNum==1){
                    redEnvelopeSize = laseRedEnvelopeSize;
                }
                System.out.println(Thread.currentThread().getName()+":哈哈哈，我抢到了"+redEnvelopeSize+"分,今晚吃鸡！！！");
                redEnvelopeNum--;
            }else{
                System.out.println(Thread.currentThread().getName()+":呜呜呜，我没抢到，感觉亏了一个亿。。。");
            }
        }
    }
}
