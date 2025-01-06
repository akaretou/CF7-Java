package gr.aueb.cf.ch5;

import java.util.Scanner;

/** Μέθοδος που δέχεται έναν ακέραιο αριθμό ως παράμετρο και επιστρέφει το τετράγωνό του.
 */
public class SquareApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Παρακαλώ δώστε έναν ακέραιο αριθμό.");
        int num = in.nextInt();
        int squareNum = square(num);
        System.out.printf("Το τετράγωνο του αριθμού %d είναι %d", num, squareNum);

    }

    public static int square(int num) {
        return num * num;
    }
}
