package Thread;

/**
 * @ClassName: MyThreadJoinInterrupt
 * @Description: join() 方法出现 Interrupt 的情况
 * @Author: LiaNg
 * @Date: 2020/3/27 11:44
 */
public class MyThreadJoinInterrupt {

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            System.out.println(" threadA start ");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("i = " + i);
            }
        });

        Thread mainThread = Thread.currentThread();

        Thread threadB = new Thread(() -> {
            System.out.println(" threadB start ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" main thread interrupt ");
            mainThread.interrupt();
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" main thread finish ");
    }
}
