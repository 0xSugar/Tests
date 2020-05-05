package threads;

import java.io.IOException;

public class Threads1_WhoIsFaster {
    private static boolean isDone = false;
    private static int oneCount;
    private static int twoCount;
    private static int mistake;

    public static void main(String[] args) throws IOException, InterruptedException {
        int count = 0;
        int hmtd = 1000; // how many times do
        Thread one = null;
        Thread two = null;
        while (count <= hmtd) {
            changeIsDone();

            // First Thread
            one = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    if (Threads1_WhoIsFaster.isDone) {
                        break;
                    }
                    System.out.println("First repeat #" + i);
                    if (i > 950) {
                        System.out.println("Winner - First, made " + i + " repeats.");
                        changeIsDone();
                        winner(oneCount);
                        break;
                    }
                }
            });
            // Second Thread
            two = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    if (Threads1_WhoIsFaster.isDone) {
                        break;
                    }
                    System.out.println("Second repeat #" + i);
                    if (i > 950) {
                        System.out.println("Winner - Second, made " + i + " repeats.");
                        changeIsDone();
                        winner(twoCount);
                        break;
                    }
                }
            });
            one.start();
            two.start();
            one.join();
            two.join();
            count++;
        }
        System.out.printf("Of " + hmtd + " tests First won - %,d times and Second - %,d times. Together: %,d%n", oneCount, twoCount, oneCount + twoCount);
    }

    static synchronized void changeIsDone() {
        isDone = !isDone;
    }

    static void winner(int who) {
        if (who == oneCount) {
            oneCount++;
        } else if (who == twoCount) {
            twoCount++;
        } else {
            mistake++;
        }
    }
}
