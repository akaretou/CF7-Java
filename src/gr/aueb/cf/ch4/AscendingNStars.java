package gr.aueb.cf.ch4;

import java.util.Scanner;

/** Πρόγραμμα όπου ο χρήστης θα δίνει το πλήθος των stars, έστω n
 – από 1 έως n αστεράκια */
public class AscendingNStars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;

        System.out.println("Παρακαλώ εισάγετε έναν ακέραιο αριθμό");
        num = in.nextInt();

        Stars(num);
    }
    public static void Stars(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
