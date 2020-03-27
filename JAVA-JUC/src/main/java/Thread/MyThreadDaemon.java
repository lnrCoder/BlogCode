package Thread;

/**
 * @ClassName: MyThreadDaemon
 * @Description: 设置守护线程
 * @Author: LiaNg
 * @Date: 2020/3/27 21:22
 */
public class MyThreadDaemon {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            System.out.println(" daemonThread start ");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" daemonThread end ");
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println(" main thread finish ");
    }
}
