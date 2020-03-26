package Thread;

/**
 * @ClassName: MyThreadNotify
 * @Description: 线程通知 nofity
 * @Author: LiaNg
 * @Date: 2020/3/26 23:48
 */
public class MyThreadNotify {

    public static Object resource = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println(" threadA get resource lock ");
                    try {
                        System.out.println(" threadA begin wait ");
                        resource.wait();
                        System.out.println(" threadA end wait ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
                    System.out.println(" threadB get resource lock ");
                    try {
                        System.out.println(" threadB begin wait ");
                        resource.wait();
                        System.out.println(" threadB end wait ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource) {
//                    System.out.println(" threadC begin notify ");
//                    resource.notify();
//                    System.out.println(" threadC end notify ");

                    System.out.println(" threadC begin notifyAll ");
                    resource.notifyAll();
                    System.out.println(" threadC end notifyAll ");
                }
            }
        });

        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println(" main over ");
    }
}
