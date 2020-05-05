package archive;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Практика_МапаДата_1 {

    public static void main(String[] args) throws ParseException {
        Map<String, String> map = createMap();  // создаем и заполняем
        printMap(map);                          // выводим на экран
        String theKey = theOldestObj(map);      // получаем ключ самого старого объекта
        System.out.println("\nА теперь выведи самый старый объект: " + theKey + " - " + map.get(theKey));   // выводим

        System.out.println("\n\nА теперь удалим все, что позже 1950 года");
        deleteAllBefore1950(map);               // удаляет все раньше 1950
        printMap(map);                          // выводит на эакрн
    }

    // Создает и заполняет
    private static Map<String, String> createMap () {
        HashMap<String, String> map = new HashMap();
        map.put("Великий", "17.08.1998");
        map.put("Провозглашенный Солшнышком", "23.02.1172");
        map.put("Камикадзе", "12.11.1941");
        map.put("Районный Чел", "04.03.1982");
        map.put("Железная консерва (новая)", "05.03.2020");
        return map;
    }

    // Выводит на экран весю мапу
    private static void printMap (Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("Рождение/создание - " + entry.getKey() + ", год - " + entry.getValue());
        }
    }

    private static String theOldestObj (Map<String, String> map) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");      // ставим формат для считывания
        Date theOldest = new Date();                                            // просто дата сайчас
        String theKey = "";                                                     // переменная для занесения ключа

        // практикуем итератор:
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();

            Date date1 = sdf.parse(entry.getValue());       // Вставляем по очереди каждую дату в date1
            if (date1.before(theOldest)){                   // Если date1 - раньше theOldest (раньше сейчас)
                theOldest = date1;                          // theOldest принимает нынешнее значение даты (с которым
                theKey = entry.getKey();                    // сравнивалось) и записывает КЛЮЧ этого значения в theKey
            }
        }
        return theKey;                                      // после окончания возвращаем ключ
    }

    private static void deleteAllBefore1950(Map<String, String> map) throws ParseException {
        Map<String, String> copy = new HashMap(map);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        for (Map.Entry<String, String> entry : copy.entrySet()){
            Date date = sdf.parse(entry.getValue());    // парсим дату
            Calendar calendar = Calendar.getInstance(); // создаем каленьдарь
            calendar.setTime(date);                     // присваиваем календарю дату
            int year = calendar.get(Calendar.YEAR);
            if (year > 1950) {
                map.remove(entry.getKey());
            }
        }
    }
}