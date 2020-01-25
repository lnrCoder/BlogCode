package lnrcoder.observer;

/**
 * @ClassName: BinaryObserver
 * @Description:
 * @Author: LiaNg
 * @Date: 2020/1/25 18:45
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
