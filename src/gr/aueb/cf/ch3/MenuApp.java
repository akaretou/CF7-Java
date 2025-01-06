package gr.aueb.cf.ch3;

import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;

        System.out.println("Παρακαλώ επιλέξτε μία από τις παρακάτω επιλογές: \n" + "1. Εισαγωγή\n" +
                "2. Διαγραφή\n" +
                "3. Ενημέρωση\n" +
                "4. Αναζήτηση\n" +
                "5. Έξοδος");
        do {
            num = in.nextInt();
            if (num == 1){
                System.out.println("Επιλέξατε Εισαγωγή");
            } else if (num == 2){
                System.out.println("Επιλέξατε Διαγραφή");
            } else if (num == 3){
                System.out.println("Επιλέξατε Ενημέρωση");
            } else if (num == 4){
                System.out.println("Επιλέξατε Αναζήτηση");
            } else if (num == 5){
                System.out.println("Επιλέξατε Έξοδο");
                break;
            }
        } while ((num >= 0) && (num < 5));
    }
}
