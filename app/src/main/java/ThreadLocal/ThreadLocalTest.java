package ThreadLocal;

/**
 * Created by YellowHuang on 2019/6/20.
 */

public class ThreadLocalTest {


    public static void main(String[] a) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("");
    }

}
