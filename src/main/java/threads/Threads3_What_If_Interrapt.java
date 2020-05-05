package threads;

import java.io.*;

/**
 * Что если превать выполнение?
 *
 * Разберем 3 метода:
 * - someThread.interrupt() - при вызове оно дает команду о прекращении выполнения. Ну а там сама себе думает прекращать
 * или нет. А если и да, то когда.. в общем безпорядок. Но как-то работает.
 * - someThread.isInterrupted() - ну понятно, вернет false если прервали и true, если нет
 * - Thread.interrupted() - статический метод, можно вызывать только внутри самой нити.. очень коварный метод.
 * Он делает все тоже самое, что и isInterrupted(), вот только к дополнению СБРАСЫВАЕТ флажек. Т.е. если внутри нити
 * вызвать этот - он заставит сбросит флажек и нить снова будет работать до окончания run (если там не вечный цикл).
 *
 * Очень важно! На счет join и sleep:
 * Если вызвать interrupt у нити, когда она ожидает или спит, то произойдут 3 вещи:
 *      1. Оно выкинет InterruptedException, что его прервали (что если обрабатывается в try catch зачастую
 *          просто незаметно.
 *      2. Оно Сбрасывает значение interrupted. Т.е. по идеи, если мы его вызвали, то должно быть true...
 *          Прервали? - Прервали. Но если выбрасывается исключение во время join / sleep - флажек сбрасывается
 *          обратно на true. По этому в исключение нужно или вызывать заново остановку Thread.currentThread().interrupt();
 *          или выходить из цикла break; / метода return;
 *      3. Эта нить после прерывания сна сразу начинает работать дальше не дожидаясь окончания сна.. что можно
 *          увидеть на примере ниже
 *
 *  P.S.: join не проверено, может работать чуть иначе
 */


public class Threads3_What_If_Interrapt {
    public static void main(String[] args) throws IOException {
        // Это счетчик, он просто выводит цифры раз в секунду
        Thread count = new Thread(new Runnable() {                  // анонимный класс
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){    // пока не будет прервано
                    for (int i = 1; i < 11; i++) {
                        System.out.println(i);                      // выводи значение i
                        try {
                            Thread.sleep(1000);               // раз в секунду
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();     // если будет исключение - закончи работу
                        }
                    }
                }
            }
        });
        count.start();  // запустить анонимный класс
                                                            // дальше лень
        Abu abu = new Abu();
        Thread thread = new Thread(abu);
        thread.start();

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        while (rd.readLine().equals("")) {
            thread.interrupt();     // прервать
        }
        thread.interrupt();
        count.interrupt();
        System.out.println("Живая - " + thread.isAlive() + "\nПрервали - " + thread.isInterrupted());
    }
}

class Abu implements Runnable {

    Thread current = Thread.currentThread();

    public void run() {
        while (!current.isInterrupted()) {
            System.out.println("Я тут");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;   // вот без этого эта нить будет продолжать работать
            }
        }
    }
}
