package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: MyThreadSleep
 * @Description:
 * @Author: LiaNg
 * @Date: 2020/3/27 20:54
 */
public class MyThreadSleep {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(" threadA start ");
                Thread.sleep(2000);
                System.out.println(" threadA end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                System.out.println(" threadB start ");
                Thread.sleep(2000);
                System.out.println(" threadB end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        threadA.start();
        threadB.start();

        System.out.println(" main thread finish ");
    }
}
