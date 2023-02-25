import com.leibin.countdownlatch.Sence1;

import java.util.concurrent.CountDownLatch;

public class TestSence1 {
    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        CountDownLatch countDownLatch = new CountDownLatch(n);
        Sence1 sence1 = new Sence1(countDownLatch);
        for(int i = 0;i<n;i++){
            new Thread(sence1).start();
        }
        System.out.println("main线程阻塞");
        countDownLatch.await();
        System.out.println("main线程恢复运行");

    }
}
