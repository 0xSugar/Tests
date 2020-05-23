package interestingTasks.autoRent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Если не ставить свою метку на sleep(), то происходит жесть... вот что выдает, когда main метод вызывает
 * interrupt() в нити:
 *
 * Person_3: AUTOMOBILE просто БОМБА! Возврашаю обратно
 * Person_3: ЕсС, я получил MOTORCYCLE на 1 дней. С ветерком!
 * ================ ИСКЛЮЧЕНИЕ ============= Person_3
 * Person_3: MOTORCYCLE просто БОМБА! Возврашаю обратно
 * Person_3: ЕсС, я получил AUTOMOBILE на 3 дней. С ветерком!
 * ================ ИСКЛЮЧЕНИЕ ============= Person_3
 * Person_3: AUTOMOBILE просто БОМБА! Возврашаю обратно
 * Person_3: ЕсС, я получил MOTORCYCLE на 2 дней. С ветерком!
 * ================ ИСКЛЮЧЕНИЕ ============= Person_3
 * Person_3: MOTORCYCLE просто БОМБА! Возврашаю обратно
 * Person_3: ЕсС, я получил AUTOMOBILE на 2 дней. С ветерком!
 * ================ ИСКЛЮЧЕНИЕ ============= Person_3
 * Person_3: AUTOMOBILE просто БОМБА! Возврашаю обратно
 * Person_3: ЕсС, я получил AUTOMOBILE на 1 дней. С ветерком!
 * ================ ИСКЛЮЧЕНИЕ ============= Person_3
 * Person_3: AUTOMOBILE просто БОМБА! Возврашаю обратно
 * Person_3: я наигрался, хочу тепла и удомашний уют, Всем пока.
 *
 * т.е. она просто продолжает наматывать круги.. хоть это делать она не должна, ведь её давно остановили.
 */

public class Person extends Thread {        // изменено на Thread вместо Runnable
    private String name;
    private List<RentStory> rentStories;
    private Company company;

    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
        rentStories = new ArrayList<>();
    }

    public void addNewRent(RentStory rentStory) {
        rentStories.add(rentStory);
    }

    public List<RentStory> getRentHistory() {
        return Collections.unmodifiableList(rentStories);
    }

    @Override
    public void run() {
        while (true) {   // пока "игра" не закончена
            try {
                int from = 0;
                int to = 1 + ((int) (Math.random() * Company.MAX_TIME_FOR_RENT));   // рандом сколько времени
                Company.AutoTransport transport = company.getAnyFreeTransport(this, from, to);  // получаем
                // (или выскакивает ошибка и мы летим в catch, где ждем 2с и начинаем заново

                // если не летим в catch, тогда все ок.. ждем выделенное время
                System.out.println(name + ": ЕсС, я получил " + transport + " на " + to + " дней. С ветерком!");
                if (sleep(to * 1000)) {
                    company.freeTransport(transport);   // и возвращаем транспорт
                    return;
                }
                System.out.println(name + ": " + transport + " просто БОМБА! Возврашаю обратно");
                company.freeTransport(transport);   // и возвращаем транспорт
                if (goHome()) {
                    return;   // с шансом 20% человек заканчивает игру сам
                }
            } catch (NoAvailableTransport e) {

            }
        }
    }

        private boolean goHome () {
            if (Math.random() < 0.05) {
                System.out.println(name + ": я наигрался, хочу тепла и удомашний уют, Всем пока.");
                return true;
            }
            return false;
        }

        // что бы проверить жесть..
        private boolean sleep(int time) {  // поставить void - вместо boolean
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(name + ": меня зовут домой, я ухожу.");
//                System.out.println("================ ИСКЛЮЧЕНИЕ ============= " + name);
                Thread.currentThread().interrupt();
                return true;                // убрать
            }
            return false;                   // убрать
        }                                   // + в run() вместо if (sleep(2000)) return; поставить просто sleep(2000);


        public String toString () {
            return name;
        }
    }
