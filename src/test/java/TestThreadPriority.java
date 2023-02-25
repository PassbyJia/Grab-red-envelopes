import com.leibin.threadpriority.MyThread;

public class TestThreadPriority {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setPriority(Thread.MAX_PRIORITY);
        myThread.start();
        for(int i = 0;i<100;i++){
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
        }
    }
}
