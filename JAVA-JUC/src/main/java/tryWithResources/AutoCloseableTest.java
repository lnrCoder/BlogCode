package tryWithResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LiaNg
 * @date 2021/12/20 21:25
 */
public class AutoCloseableTest implements AutoCloseable {

    public static void main(String[] args) {
        try (AutoCloseableTest autoCloseableTest = new AutoCloseableTest()) {
            System.out.println("autoCloseableTest.getClass() = "
                                       + autoCloseableTest.getClass());
            Object obj = null;
            obj.toString();
        } catch (Exception e) {
            System.out.println("e.getClass() = " + e.getClass());
            System.out.println("出现异常");
        }
    }

    public String resdFile1(String filePath) {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            return bufferedReader.readLine();
        } catch (IOException e) {
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String resdFile2(String filePath) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(filePath))) {
            return bufferedReader.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("关闭资源！！！");
    }
}
