import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @ClassName DateUtils
 * @description LocalDate 时间工具
 * @Author LiaNg
 * @Date 2019-10-17
 */
public class DateUtils {

    public static String nowDate(){
        LocalDate now = LocalDate.now();
        return now.toString();
    }

    public static String nowTime(){
        LocalTime now = LocalTime.now();
        return now.toString();
    }

    public static String nowDateTime(){
        LocalDateTime now = LocalDateTime.now();
        return now.toString();
    }

    public static void main(String[] args) {
        System.out.println("nowTime() = " + nowDateTime());
    }
}
