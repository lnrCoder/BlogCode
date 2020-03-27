package Thread;

/**
 * @ClassName: MyThreadLocal
 * @Description:
 * @Author: LiaNg
 * @Date: 2020/3/27 21:57
 */
public class MyThreadLocal {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            System.out.println(" threadA start ");
            threadLocal.set(" threadA ");
            System.out.println("threadA = " + threadLocal.get());
        });

        Thread threadB = new Thread(() -> {
            System.out.println(" threadB start ");
            threadLocal.set(" threadB ");
            System.out.println("threadB.get() = " + threadLocal.get());
        });

        threadA.start();
        threadB.start();
    }
}
