import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> words = initWords();

        Random random = new Random();
        String randomWord = words.get(random.nextInt(words.size()));

        int count = randomWord.length();
        char[] word = new char[randomWord.length()];
        StringBuilder wholeWord = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        do {
            String userWord = sc.next();
            char[] array = randomWord.toCharArray();

            if (userWord.length() == 1) {
                checkLetter(userWord, array, word);

                currentWord(randomWord, wholeWord, word);
            }

            count--;
            System.out.println(count < 1 ? "больше нет попыток" : "осталось " + count + "попыток");
        } while (count >= 1);
    }

    private static List<String> initWords(){
        List<String> words = new ArrayList<>();
        words.add("house");
        words.add("car");
        words.add("plane");
        words.add("animal");
        return words;
    }

    private static void checkLetter(String userWord, char[] array, char[] word){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == userWord.charAt(0)) {
                word[i] = array[i];
                System.out.println("угадали букву: " + array[i]);
            }
        }
    }

    private static void currentWord(String randomWord, StringBuilder wholeWord, char[] word){
        wholeWord.setLength(0);
        for(char c : word){
            wholeWord.append(c != '\0' ? c:"_");
        }

        System.out.println(wholeWord.toString().equals(randomWord) ? "угаданное слово = " + wholeWord :
                "текущее угаданное слово = " + wholeWord);
    }
}