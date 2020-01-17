package optimize.byEnum;

/**
 * @ClassName: User2Ohter
 * @Description: 枚举优化测试
 * @Author: LiaNg
 * @Date: 2020/1/17 10:28
 */
public enum User2Ohter {

    /**
     * enum
     */
    A("AAA", "1"),
    B("BBB", "2"),
    C("CCC", "3");

    String name;

    String id;

    User2Ohter(String name, String id) {
        this.id = id;
        this.name = name;
    }

    public static String getNameById(String id) {
        for (User2Ohter value : User2Ohter.values()) {
            if (value.id.equals(id)) {
                return value.name;
            }
        }
        return null;
    }
}
