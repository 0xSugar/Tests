package interestingTasks.autoRent;

import java.util.ArrayList;
import java.util.List;

public class Company {
    public static int MAX_TIME_FOR_RENT = 10;

    private String name;
    private List<RentStory> rentStories;

    public Company(String name) {
        this.name = name;
        rentStories = new ArrayList<>();
    }

    private boolean areFreeTransports() {       // есть ли свободный транспорт
        for (AutoTransport autoTransport : AutoTransport.values()) {
            if (autoTransport.isFree) {
                return true;
            }
        }
        return false;
    }

    /*
    Вообще есть задумка поприкольней, чем getAnyFreeTransport. Точнее, реализация. Можно просто
    напросто ввести список доступных объектов. Когда объект кто-то берет - он его удаляет из листа, а
    когда возвращает - добавляет в лист. Таким образом не нужно будет куча циклов и проверок внизу..
     */
                                                // получить любой свободный
    public AutoTransport getAnyFreeTransport(Person person, int from, int to) {
        synchronized (Company.class) {
            if (!areFreeTransports()) {             // проверка на свободность
                throw new NoAvailableTransport();   // если нет - выкинуть ошибку
            } else {                    // если есть
                List<AutoTransport> availableTransport = new ArrayList<>();

                for (AutoTransport autoTransport : AutoTransport.values()) {    // получить список доступных
                    if (autoTransport.isFree) {
                        availableTransport.add(autoTransport);
                    }
                }
                                                                                // рандомно выбрать один
                AutoTransport autoTransport = availableTransport.get((int) (Math.random() * 100) % availableTransport.size());
                RentStory rentStory = new RentStory(person, autoTransport, from, to);   // создать историю
                autoTransport.isFree = false;   // изменить флаг на "занят"
                autoTransport.person = person;  // добавить транспорту человека

                this.rentStories.add(rentStory);    // добавить историю в компанию
                person.addNewRent(rentStory);       // и человеку
                return autoTransport;               // вернуть транспорт
            }
        }
    }

    public void freeTransport(AutoTransport autoTransport) {    // освобождает транспорт
        autoTransport.isFree = true;
        autoTransport.person = null;
    }

    public enum AutoTransport {
        AUTOMOBILE,
        MOTORCYCLE,
        SCOOTER;

        private boolean isFree = true;
        private Person person;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n");
        rentStories.forEach(x -> stringBuilder.append("\t").append(x).append("\n"));
        return stringBuilder.toString();
    }
}
