package lnrcoder.observer;

/**
 * @ClassName: Observer
 * @Description:
 * @Author: LiaNg
 * @Date: 2020/1/25 18:40
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}
