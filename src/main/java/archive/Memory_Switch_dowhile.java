package archive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Memory_Switch_dowhile {
    public static void main(String[] args) throws IOException {
        do {
            BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("");
            System.out.print("Введите число от 1го до 10ти: ");
            int number = Integer.parseInt(reader.readLine());
            switch (number){
                case 1:
                    System.out.println("Я так и знал, что это будет 1");
                    break;
                case 2:
                    System.out.println("Блин, а я ставил на 1");
                    break;
                case 3:
                    System.out.println("Да это обман! Мне гадалка сказала, что будет 1!!");
                    break;
                case 4:
                    System.out.println("Ну, и такое бывает...");
                    break;
                case 5:
                    System.out.println("Псс псс, если что, то я так и знал, что будет 5, а не 1");
                    break;
                case 6:
                    System.out.println("Оу ее, я мастерски предугадал твой выбор");
                    break;
                case 7:
                    System.out.println("тотал дестроед, я проиграл...");
                    break;
                case 8:
                    System.out.println("Снова эти кодеры подшаманили программу, её не победить");
                    break;
                case 9:
                    System.out.println("Все, поцелуй мой блестящий зад, я ухожу!");
                    break;
                default:
                    if (number > 10)
                        System.out.println("Да иди ты в жопу со своим " + number);
                    else {
                        System.out.println("Ты что, идиот? Я же сказал, от 1го до 9ти.. что? Там до 10 написано? Ты что, совсем идиот?");
                    }
                    break;

            }
        } while (1<2);
    }
}
