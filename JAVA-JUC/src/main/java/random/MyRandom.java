package random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName: MyRandom
 * @Description:
 * @Author: LiaNg
 * @Date: 2020/3/31 17:54
 */
public class MyRandom {

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println("random.nextInt(100) = " + random.nextInt(100));
        }

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (int i = 0; i < 10; i++) {
            System.out.println("threadLocalRandom.nextInt(100) = " + threadLocalRandom.nextInt(100));
        }
    }
}
