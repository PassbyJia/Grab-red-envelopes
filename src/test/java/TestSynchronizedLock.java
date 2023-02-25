import com.leibin.synchronizedLock.Ticket;

public class TestSynchronizedLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Ticket ticket1 = new Ticket();
        Thread t4 = new Thread(ticket1);
        t1.setName("售票窗口1");
        t2.setName("售票窗口2");
        t3.setName("售票窗口3");
        t4.setName("售票窗口4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
