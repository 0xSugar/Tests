package threads.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executor.execute(new WorkerThread("'some_command'"));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished");
    }
}
