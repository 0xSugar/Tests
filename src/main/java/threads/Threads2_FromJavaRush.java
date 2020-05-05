package threads;

public class Threads2_FromJavaRush {
    public static volatile Runway RUNWAY_1 = new Runway("Amigo");
    public static volatile Runway RUNWAY_2 = new Runway("Kardes");
    public static volatile Runway RUNWAY_3 = new Runway("Overun");


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Plane("AirPlain #" + i);
        }
    }

    private static void waiting() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    private static void takingOff() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static class Plane extends Thread {
        private boolean isAlreadyTakenOff = false;

        public Plane(String name) {
            super(name);
            start();
        }

        public void run() {
            while (!isAlreadyTakenOff) {
                if (RUNWAY_1.trySetTakingOffPlane(this)) {
                    this.process(RUNWAY_1);
                } else if (RUNWAY_2.trySetTakingOffPlane(this)) {
                    this.process(RUNWAY_2);
                } else if (RUNWAY_3.trySetTakingOffPlane(this)) {
                    this.process(RUNWAY_3);
                } else if (!this.equals(RUNWAY_1.getTakingOffPlane()) &&
                           !this.equals(RUNWAY_2.getTakingOffPlane()) &&
                           !this.equals(RUNWAY_3.getTakingOffPlane())   ) {
                    System.out.println(getName() + " is waiting ");
                    waiting();
                } else {
                    run();
                }
            }
        }

        public void process(Runway runway) {
            System.out.println(getName() + " took free runway " + runway.getName() + ", takes off.");
            takingOff();//взлетает
            System.out.println(getName() + " is in the sky.");
            isAlreadyTakenOff = true;
            runway.setTakingOffPlane(null);
        }
    }

    public static class Runway { //взлетная полоса
        private Plane t;
        private String name;

        public Runway(String name) {
            this.name = name;
        }

        public Thread getTakingOffPlane() {
            return t;
        }

        public String getName() {
            return name;
        }

        public void setTakingOffPlane(Plane t) {
            synchronized (this) {
                this.t = t;
            }
        }

        public boolean trySetTakingOffPlane(Plane t) {
            synchronized (this) {
                if (this.t == null) {
                    this.t = t;
                    return true;
                }
                return false;
            }
        }
    }
}