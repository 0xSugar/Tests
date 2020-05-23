package interestingTasks.avia;

/**
 * Сгенерировать 1000 пасажиров (имена могуть быть пасажир1, пасажир2, пасажир3...)
 * Есть города: Москва, Киев, Париж по этим городам перелетают самолеты (всего 6 рейсов), каждым летают пассажиры.
 * Пассажир случайным образом перелетает 3 раза. Пасажир должен вылетать только с того города, в который прилетел.
 * Вывести на экран количество перелетов по всем рейсам например, Киев - Москва перелётов 100, Москва - Париж 900
 * Интерес в статистике перелетов
 */

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i < 1001; i++) {
            Passenger passenger = new Passenger("Passenger" + i);

            for (int j = 0; j < 3; j++) {
                Flights.goTo(passenger);
            }
        }

        final double total = Flights.totalFlights();
        System.out.println(total);
        Flights.getDirections().forEach((x, y) -> System.out.printf("%-45s %d (%.2f%%) %n", x, y, (y / total) * 100));
    }
}
