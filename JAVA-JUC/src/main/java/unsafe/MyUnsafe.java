package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @ClassName: MyUnsafe
 * @Description: unsafe 测试
 * @Author: LiaNg
 * @Date: 2020/3/29 23:50
 */
public class MyUnsafe {

    static Unsafe unsafe;

    static long stateOffset = 0;

    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(MyUnsafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyUnsafe myUnsafe = new MyUnsafe();
        Boolean success = unsafe.compareAndSwapInt(myUnsafe, stateOffset, 0, 1);
        System.out.println("success = " + success);
    }

}
