package archive;

public class Class_пример {
    public static void main(String[] args) {

        /** Лучше начинать с класса Human (он ниже). Если уже все там понятно: */

        // Создаем этих людишек:
        Human grFath1 = new Human("Дедуля_1", 76, true); // первый конструктор у перывх 4х
        Human grFath2 = new Human("Дедуля_2", 75, true);
        Human grMoth1 = new Human("Бабуля_1", 75, false);
        Human grMoth2 = new Human("Бабуля_2", 75, false);
        Human fathD = new Human("Папуля", 26, true, grFath1, grMoth1); // второй конструктор, с радаками
        Human mothD = new Human("Мамуля", 25, false, grFath2, grFath2);
        Human child1 = new Human("Вандал_1", 10, true, fathD, mothD);
        Human child2 = new Human("Вандал_2", 9, true, fathD, mothD);
        Human child3 = new Human("Вандал_3", 12, false, fathD, mothD);

        // выводим всех их.. вот бы это в массив засунуть
        System.out.println(grFath1);
        System.out.println(grFath2);
        System.out.println(grMoth1);
        System.out.println(grMoth2);
        System.out.println(fathD);
        System.out.println(mothD);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human { // создали класс, добавили переменные имя / возраст / пол
        private String name;    // а так же объекты самого класса, типо --->.....
        private int age;        //                                              |
        private boolean sex;    //                                              |
        Human father = null;    // < ---------------------------------вот это <-'
        Human mother = null;

        // конструктор для тех, у кого нет ни father ни mother
        public Human (String name, int age, boolean sex){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        // конструток для тех, у кого есть и father и mother
        public Human (String name, int age, boolean sex, Human father, Human mother){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        // Изменение toString, что бы при вызове ссылки класса оно выдало результат в таком формате, как нам нужно
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}
