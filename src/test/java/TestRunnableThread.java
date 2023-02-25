import com.leibin.thread.MyRunnableThread;

public class TestRunnableThread {
    public static void main(String[] args){
        //3 创建这个类的对象
        MyRunnableThread mrt = new MyRunnableThread();
        //4 把第三步中创建的对象作为Thread类的构造方法的参数创建Thread类对象
        Thread t = new Thread(mrt);
        //5 启动线程
        t.start();
        for(int i = 0;i<100;i++){
            System.out.println("main线程正在执行"+i);
        }
        //其他的Runnable创建线程的写法
        // 匿名函数
        new Thread(()->{
            for(int i = 0;i<100;i++){
                System.out.println("匿名函数线程正在执行"+i);
            }
        }).start();
    }
}
