import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static Card[][] cards = new Card[4][4];

    public static void main(String[] args) throws Exception {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");
        arrayList.add("G");
        arrayList.add("H");
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");
        arrayList.add("G");
        arrayList.add("H");

        Collections.shuffle(arrayList);
        int x = 0;

        for (int t = 0; t < 4; t++) {
            for(int y = 0 ; y<4; y++){
                cards[t][y] = new Card(arrayList.get(x));
                x++;
            }
        }

        while (gameOver() == false) {
            gameBoard();
            guess();
        }

    }

    static Scanner scanner = new Scanner(System.in);
    static int firstGuess;
    static int secondGuess;
    static int first2Guess;
    static int second2Guess;

    public static void guess() {

        System.out.print("First Guess (Please leave a space between the two words.): ");
        firstGuess = scanner.nextInt();
        secondGuess = scanner.nextInt();

        cards[firstGuess][secondGuess].setGuess(true);
        gameBoard();

        System.out.print("Second Guess (Please leave a space between the two words.): ");
        first2Guess = scanner.nextInt();
        second2Guess = scanner.nextInt();
        cards[first2Guess][second2Guess].setGuess(true);

        if (cards[firstGuess][secondGuess].getValue() == cards[first2Guess][second2Guess].getValue()) {
            System.out.println("Congrats! :)");
        } else {
            gameBoard();

            System.out.println("Sorry! It's not same..");

            try {

                Thread.sleep(1500);

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }

            cards[firstGuess][secondGuess].setGuess(false);
            cards[first2Guess][second2Guess].setGuess(false);
        }
    }

    public static void gameBoard() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (cards[i][j].getGuess()) {

                    System.out.print(" |" + cards[i][j].getValue() + "| ");

                } else {
                    System.out.print(" | | ");
                }
            }
            System.out.println("");
        }
    }

    public static boolean gameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].getGuess() == false)
                    return false;
            }
        }
        return true;
    }
}
