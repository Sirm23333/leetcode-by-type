package ali.gaode.first;
//两个线程不断互相唤醒和等待
public class ThreadTest {
    private static Object obj = new Object();


    public static void main(String[] args) {
        Th a = new Th();
        Th b = new Th();
        a.start();
        b.start();
    }

    static class Th extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+"唤醒");
                    obj.notifyAll();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
