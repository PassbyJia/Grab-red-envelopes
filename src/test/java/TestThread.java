import com.leibin.thread.MyThread;

public class TestThread {
    public static void main(String[] args){
        //3 创建这个类的对象
        MyThread myThread = new MyThread();
        //4 启动这个线程
        myThread.start();
        //myThread.run();//没有创建一个线程
        for(int i = 0;i<100;i++){
            System.out.println("main线程正在执行"+i);
        }
    }
}
