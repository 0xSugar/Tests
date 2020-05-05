package archive;
/**
 * Что делает - Если есть более 2х одинаковых имен - удаляет всех кроме одного.
 * Т.е. если имена "Коля" "Вася" "Коля", то оставит только "Коля" и "Вася"
 *
 * Так же ниже код, что при совпадении "Коля", "Вася", "Коля" оставит только "Вася"
 * (заменять только метод removeTheFirstNameDuplicates, все остальное так же)
 */

import java.util.*;

public class HashMap_Delete {

    // Метод Создания и Заполнения Мапы
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap();
        map.put("Иванов", "Димон");
        map.put("Франков", "Коля");
        map.put("Кусеров", "Коля");
        map.put("Коколенко", "Коля");
        map.put("Баранденко", "Коля");
        map.put("Куля", "Коля");
        map.put("Француа", "Коля");
        map.put("Бираду", "Александр");
        map.put("Рагулясь", "Роман");
        map.put("Нундоров", "Русик");
        return map;
    }

    // Удаление Повторяющихся Вторых Значений
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        removeItemFromMapByValue(map, "Рак"); // вызов метода по заданию

        Map<String, String> copy = new HashMap(map); //создание копии мапы

        Iterator<Map.Entry<String, String>> it = copy.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();

            int count = 0;
            Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<String, String> entry2 = it2.next();
                if (entry.getValue().equals(entry2.getValue())){
                    count++;
                    if (count >= 2){
                        it2.remove();
                    }
                }
            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();          // создание и заполнение
        removeTheFirstNameDuplicates(map);              // отправляем на удаление дубликатов
        for (Map.Entry<String, String> entry : map.entrySet()) {    // вывести на экран
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

// ВТОРОЙ КОД #1 (Через HashSet и метод)
//public static void removeTheFirstNameDuplicates(Map<String, String> map) {
//    HashSet<String> set = new HashSet<>();
//    HashMap<String, String> copy = new HashMap<>(map);
//    for (String line : copy.values()) {
//        if (!set.add(line)) {
//            removeItemFromMapByValue(map, line);
//        }
//    }
//}

// ВТОРОЙ КОД #2 (через два fori)
//public static void removeTheFirstNameDuplicates(Map<String, String> map) {
//    Map<String, String> copy = new HashMap(map); //создание копии мапы
//
//    for(Map.Entry<String,String> entry : copy.entrySet()) {
//        int count = 0;
//        for(Map.Entry<String, String> entry2 : copy.entrySet()) {
//            if (entry.getValue().equals(entry2.getValue())){
//                count++;
//                if (count > 2){
//                    map.remove(entry.getKey());
//                    map.remove(entry2.getKey());
//                }
//            }
//        }
//    }
//}



// ВТОРОЙ КОД #3 (через два итератора)
//    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
//        removeItemFromMapByValue(map, "Рак"); // вызов метода по заданию
//
//        Map<String, String> copy = new HashMap(map); //создание копии мапы
//        Map<String, String> copy2 = new HashMap(map); //создание копии мапы
//
//        Iterator<Map.Entry<String, String>> it = copy.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String, String> entry = it.next();
//
//            int count = 0;
//            Iterator<Map.Entry<String, String>> it2 = copy2.entrySet().iterator();
//            while (it2.hasNext()) {
//                Map.Entry<String, String> entry2 = it2.next();
//                if (entry.getValue().equals(entry2.getValue())){
//                    count++;
//                    if (count >= 2){
//                        it2.remove();
//                        map.remove(entry2.getKey());
//                        map.remove(entry.getKey());
//                    }
//                }
//            }
//        }
//
//    }

