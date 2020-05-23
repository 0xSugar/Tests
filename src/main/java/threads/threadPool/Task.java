package threads.threadPool;

public class Task implements Runnable {
    private String command;

    public Task(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " got this command - " + command + " Start to process");
        StringBuilder builder = new StringBuilder(command);
        for (int i = 0; i < 10; i++) {
            builder.append("_").append(i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FINISHED - " + Thread.currentThread().getName() + " = " + builder.toString());
    }

    @Override
    public String toString() {
        return "WorkerThread{" +
                Thread.currentThread().getName() + ", " +
                "command='" + command + '\'' +
                '}';
    }
}
