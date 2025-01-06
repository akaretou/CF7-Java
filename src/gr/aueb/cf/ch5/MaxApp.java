package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * Μέθοδος που δέχεται τρεις ακέραιους αριθμούς και επιστρέφει τον μεγαλύτερο από αυτούς.
 */
public class MaxApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Παρακαλώ δώστε τρεις ακέραιους αριθμούς.");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
        int max = findMax(num1, num2, num3);
        System.out.printf("Ο μεγαλύτερος αριθμός είναι:  %d", max);
    }

    public static int findMax(int num1, int num2, int num3){
        int max1 = Math.max(num1, num2);
        return Math.max(max1, num3);
    }
}
