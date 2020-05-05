package archive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HardExercise_Time_Lights {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("Введите время в минутах ");
        double t = Double.parseDouble(reader.readLine());
        t = (t % 5);
        if ((t >= 0) & (t < 3)) System.out.println("зелёный");
        if ((t >= 3) & (t < 4)) System.out.println("желтый");
        if ((t >= 4) & (t < 5)) System.out.println("красный");
    }
}

/* Первый вариант кода
    BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());

        int a = (int) t/60; // определяет на сколько раз число больше за 60
        a = a * 60;         // если 5 часов, то переводится в цифру 300

        if (t<60)          // если t меньше 60, то все ок
            t = t*60;
        else                // если больше, то отнимает целые часы
            t = (t-a)*60;   // (t-a) отнимает, что бы осталось от 1 до 59 минут
                            // и переводит в секунды (*60)


        int inGreen = 0, outGreen = 180, inYellow = 180, outYellow = 240, inRed = 240, outRed = 300;
        // созданно 6 переменных, начало и конец горения для каждого цвета

        for (int i = 0; i < 12; i++){ //цикл для переменных, если не подходит ни под 1 - переменные увеличиваются на 5 минут и проверяет снова.
            if ((t >= inGreen) & (t < outGreen)) System.out.println("зелёный"); //выведит зеленый, если время t в диапазоне от 0 до 179
            if ((t >= inYellow) & (t < outYellow)) System.out.println("желтый"); //выведит зеленый, если время t в диапазоне от 180 до 239
            if ((t >= inRed) & (t < outRed)) System.out.println("красный"); //выведит зеленый, если время t в диапазоне от 240 до 299

            inGreen = inGreen + 300; // если числа t нет в диапазоне от 0 до 299с, то все значения увеличиваются на 300 и снова проверяется.
            outGreen = outGreen + 300;
            inYellow = inYellow + 300;
            outYellow = outYellow + 300;
            inRed = inRed + 300;
            outRed = outRed + 300;
        }
 */