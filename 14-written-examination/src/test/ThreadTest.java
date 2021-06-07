package test;

/**
 * 阿里高德一面
 * 多个线程循环打印abc
 */
public class ThreadTest {
    private static Integer cnt = 0;
    private static int threadSum = 5;


    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < threadSum; i++){
            new Th(i+"" , i).start();
        }
    }

    static class Th extends Thread{
        public String print;
        public int sign;
        public Th(String print , int sign){
            this.print = print;
            this.sign = sign;
        }
        @Override
        public void run() {
            while (true){
                synchronized (ThreadTest.class){
                    if(cnt == sign){
                        System.out.println(print);
                        cnt = ( cnt + 1 ) % threadSum;
                    }
                    ThreadTest.class.notifyAll();
                    try {
                        ThreadTest.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}
