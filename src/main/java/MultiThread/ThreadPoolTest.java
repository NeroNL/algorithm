package MultiThread;

import java.util.concurrent.CountDownLatch;

public class ThreadPoolTest {

    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {

        
        System.out.println(countDownLatch.getCount());
    }
}
