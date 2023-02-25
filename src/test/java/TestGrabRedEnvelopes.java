import com.leibin.qhb.GrabRedEnvelopes;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class TestGrabRedEnvelopes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int redEnvelopes,redEnvelopesNum,n;
        System.out.println("请输入红包金额：");
        redEnvelopes = scanner.nextInt();
        System.out.println("请输入红包个数：");
        redEnvelopesNum = scanner.nextInt();
        System.out.println("请输入人数：");
        n = scanner.nextInt();

        //保证抢红包同时开始
        CountDownLatch countDownLatch = new CountDownLatch(1);
        GrabRedEnvelopes grabRedEnvelopes = new GrabRedEnvelopes(redEnvelopes, redEnvelopesNum,countDownLatch);
        for(int i = 0; i < n;i++){
            new Thread(grabRedEnvelopes).start();
        }
        //全部线程创建完毕，开始唤醒
        countDownLatch.countDown();

    }
}
