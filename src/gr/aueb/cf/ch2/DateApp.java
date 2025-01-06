package gr.aueb.cf.ch2;

import java.util.Scanner;

/**
 * Πρόγραμμα που διαβάζει από τον χρήστη 3 ακέραιους αριθμούς
 * που αναπαριστούν ημέρα, μήνα, έτος
 * και εμφανίζει την ημερομηνία σε μορφή: ΗΗ/ΜΜ/ΕΕ
 */
public class DateApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int day = 0;
        int month = 0;
        int year = 0;

        System.out.println("Παρακαλώ εισάγετε 3 ακέραιους για ημέρα, μήνα, έτος");
        day = in.nextInt();
        month = in.nextInt();
        year = in.nextInt();

        year = year % 100;
        System.out.printf("Η ημερομηνία σε μορφή ΗΗ/ΜΜ/ΕΕ είναι %02d/%02d/%02d", day, month, year);
    }
}
