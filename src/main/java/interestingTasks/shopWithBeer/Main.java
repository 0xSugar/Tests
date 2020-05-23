package interestingTasks.shopWithBeer;

import java.util.List;
import java.util.SplittableRandom;

/**
 *
 В магазине хранится несколько сортов пива (бочки например по 100л). У каждого сорта пива своя цена за литр.
 В магазин ЕЖЕДНЕВНО заходит какое-то количество людей (например от 100 до 500), каждый человек выпивает какое то кол-во
    пива (например от 0.33 до 5л).
 Задача: посчитать сколько пива каждого сорта было выпито за день. Посчитать сколько нужно докупить пива. Вывести доход
    за день. Пример отчета:

 Дата dd.mm.yy
 Выпито пива:
 - оболонь X1-литров
 - львовское X2-литров - ...
 Доход составил:
 - оболонь Y1-грн
 - львовское Y2-литров - ...
 Всего: Y1+Y2+...
 Необходимо закупить пива на Zгрн
 Количество дней пусть будет 10
 по истечению дней, вывести общий доход
 Уточнение: цена закупки пива в 2 раза меньше чем цена продажи Дополнительно:
 - клиенты чаще должны покупать 1 литровый обём (тобиш человек приоритетно будет выпивать 1 литр, а не 2.5 если
    использовать обычный рандом)
 */
public class Main {
    private static final SplittableRandom RANDOM = new SplittableRandom();
    private static final int MIN_PEOPLE = 100;   // нет смысла ставить 100 - 500, если каждый будет покупать...
    private static final int MAX_PEOPLE = 500;  // человек 100х1 = 100л, из за чего уже не хватит "на всех"


    public static void main(String[] args) {
        Shop shop = new Shop("Пивная Бочка");

        for (int j = 0; j < 10; j++) {
            int peopleCount = RANDOM.nextInt(MIN_PEOPLE, MAX_PEOPLE);
            for (int i = 0; i < peopleCount; i++) {
                Customer customer = new Customer();

                String selectedBeer = getNameOfBeer(shop);
                Shop.Volume bottleSize = getBottleSize();
                shop.buy(customer, selectedBeer, bottleSize);
            }
            shop.printData();
            shop.saveData();
            shop.refresh();
        }
        shop.printTotal();
    }

    private static Shop.Volume getBottleSize() {
        int random = RANDOM.nextInt(1, 10);
        switch (random) {
            case 6:
                return Shop.Volume.BOTTLE_0p3;
            case 7:
                return Shop.Volume.BOTTLE_0p5;
            case 8:
                return Shop.Volume.BOTTLE_2p5;
            case 9:
                return Shop.Volume.BOTTLE_5p0;
            default:
                return Shop.Volume.BOTTLE_1p0;
        }
    }

    private static String getNameOfBeer(Shop shop) {
        List<String> list = shop.getBeerNames();
        int index = RANDOM.nextInt(10,1000) % list.size();
        return list.get(index);
    }

}
