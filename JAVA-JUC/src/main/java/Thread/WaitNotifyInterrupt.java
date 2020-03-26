package Thread;

/**
 * @ClassName: WaitNotifyInterrupt
 * @Description: 线程共享对象 wait() 后，其他线程中断该线程，抛出异常
 * @Author: LiaNg
 * @Date: 2020/3/26 23:33
 */
public class WaitNotifyInterrupt {

    public static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---begin---");
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("---end---");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        Thread.sleep(1000);
        System.out.println("---begin Interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end Interrupt threadA---");
    }
}
