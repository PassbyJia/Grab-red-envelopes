import com.leibin.threadname.MyThread;

public class TestThreadName {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("我是0");
        MyThread myThread1 = new MyThread("我是1");
//        myThread.setName("我是0");
//        myThread1.setName("我是1");
        myThread.start();
        myThread1.start();
        System.out.println(Thread.currentThread().getName());
    }
}
