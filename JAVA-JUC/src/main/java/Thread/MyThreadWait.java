package Thread;

/**
 * @ClassName: MyThreadWait
 * @Description: 线程的通知与等待
 * @Author: LiaNg
 * @Date: 2020/3/26 22:51
 */
public class MyThreadWait {

    private static volatile Object resourceA = new Object();

    private static volatile Object resourceB = new Object();

    /**
     *  执行输出结果：
     *  threadA get resourceA lock
     *  threadA get resourceB lock
     *  threadA release resourceA lock
     *  threadB get resourceA lock
     *  threadB tyr get resourceB lock
     */
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println(" threadA get resourceA lock ");

                        synchronized (resourceB) {
                            System.out.println(" threadA get resourceB lock ");
                            System.out.println(" threadA release resourceA lock ");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println(" threadB get resourceA lock ");
                        System.out.println(" threadB try get resourceB lock ");
                        synchronized (resourceB) {
                            System.out.println(" threadB get resourceB lock ");
                            System.out.println(" threadB release resourceA lock ");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        Thread.sleep(1000);

        threadA.join();
        threadB.join();
        System.out.println(" main over ");

    }

}
