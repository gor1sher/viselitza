import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("house");
        words.add("car");
        words.add("plane");
        words.add("animal");

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        String randomWord = words.get(random.nextInt(words.size()));

        int count = randomWord.length();
        String userWord;
        char[] word = new char[randomWord.length()];
        StringBuilder wholeWord = new StringBuilder();

        while (true) {
            if (count < 1) {
                System.out.println("больше нет попыток");
                break;
            }

            userWord = sc.next();
            char[] array = randomWord.toCharArray();
            if (userWord.length() == 1) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == userWord.charAt(0)) {
                        word[i] = array[i];
                        count--;
                        System.out.println(array[i]);
                    }
                }
                System.out.println("осталось " + count + "попыток");

                wholeWord.setLength(0);
                for (int i = 0; i < word.length; i++) {
                    if (word[i] != '\0') {
                        wholeWord.append(word[i]);
                    } else {
                        wholeWord.append("_");
                    }
                }
                System.out.println("текущее угаданное слово = " + wholeWord);

                if (wholeWord.toString().equals(randomWord)) {
                    System.out.println("угадали слово: " + randomWord);
                    break;
                }
            }
        }
    }
}