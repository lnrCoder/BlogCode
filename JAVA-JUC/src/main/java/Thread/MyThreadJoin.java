package Thread;

/**
 * @ClassName: MyThreadJoin
 * @Description: join() 方法测试
 * @Author: LiaNg
 * @Date: 2020/3/27 10:35
 */
public class MyThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" threadA finish ");
        });

        Thread threadB = new Thread(() ->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" threadB finish ");
        });

        threadA.start();
        threadB.start();

//        threadA.join();
        threadB.join();

        System.out.println(" main thread finish ");
    }
}
