package lnrcoder.observer;

/**
 * @ClassName: ObserverPatternDemo
 * @Description:
 * @Author: LiaNg
 * @Date: 2020/1/25 18:44
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);

        subject.setState(5);

    }
}
