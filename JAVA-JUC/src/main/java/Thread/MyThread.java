package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: MyThread
 * @Description:
 * @Author: LiaNg
 * @Date: 2020/3/26 22:03
 */
public class MyThread {

    public static void main(String[] args) {
        // 继承 Thread
        TestThread thread = new TestThread();
        thread.start();

        // 实现 Runnable 接口
        TestRunable testRunnable = new TestRunable();
        testRunnable.run();

        // 通过 FutureTask 异步调用实现了 Callable 接口的类
        FutureTask<String> testFuture = new FutureTask<>(new CallerTask());
        new Thread(testFuture).start();
        try {
            System.out.println("testFuture.get() = " + testFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式一： 通过 Thread 类
     */
    public static class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println(" -- 通过集成 Thread 运行线程 -- ");
        }
    }

    /**
     * 方式二： 通过实现 Runnable 接口
     */
    public static class TestRunable implements Runnable {
        @Override
        public void run() {
            System.out.println(" -- 通过 Runable 运行线程-- ");
        }
    }

    /**
     * 方式三： 通过 FutureTask 异步调用
     */
    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Hello World !";
        }
    }
}
