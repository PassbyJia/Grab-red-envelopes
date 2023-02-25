import com.leibin.thread.MyCallableThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCallableThread {
    public static void main(String [] args) throws ExecutionException, InterruptedException, TimeoutException {
        //3 创建这个类的对象
        MyCallableThread myCallableThread = new MyCallableThread();
        //4 把第三步创建的对象作为构造方法的参数创建FutureTask类的对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallableThread);
        //5 把第四步创建的FutrueTask类的对象作为构造方法的参数创建Thread类对象
        Thread thread = new Thread(futureTask);
        //6 启动线程
        thread.start();
        Integer integer = futureTask.get(3, TimeUnit.SECONDS);
        System.out.println(integer);
//        for(int i = 0;i<100;i++){
//            System.out.println("main线程正在执行"+i);
//            System.out.println("Callable线程正在执行"+futureTask.get());
//        }
    }
}
