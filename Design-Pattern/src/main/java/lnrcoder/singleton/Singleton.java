package lnrcoder.singleton;

/**
 * 推荐:实现了线程安全又避免了同步带来的性能影响
 *
 * @ClassName: Singleton
 * @Description: 设计模式之「单例模式」
 * @Author: LiaNg
 * @Date: 2020/1/6 16:59
 */
public class Singleton {

    private Singleton() {

    }

    private volatile static Singleton singleton = null;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
