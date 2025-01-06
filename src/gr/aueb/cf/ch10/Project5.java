package gr.aueb.cf.ch10;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Έστω ένα θέατρο που έχει θέσεις όπου η κάθε θέση περιγράφεται με ένα χαρακτήρα
 που είναι η στήλη και ένα αριθμό που είναι η σειρά. Για παράδειγμα η θέση C2
 βρίσκεται στην 2η σειρά και 3η στήλη.
 Αναπτύξτε ένα πρόγραμμα διαχείρισης θεάτρου με 30 σειρές και 12 στήλες. Πιο
 συγκεκριμένα γράψτε μία μέθοδο void book(char column, int row) που να κάνει book
 μία θέση αν δεν είναι ήδη booked και μία μέθοδο void cancel(char column, int row)
 που να ακυρώνει την κράτηση μία θέσης αν είναι ήδη booked.
 */

public class Project5 {
    static Scanner in = new Scanner(System.in);
    static int c = 0;
    static String seat = " ";
    static boolean[][] theater = new boolean[30][12];

    public static void main(String[] args) {
        int choice = -1;
        String trimmed = " ";
        char col = 0;
        int num = 0;


        try {
            do {
                displaySeats();
                System.out.println("Εισάγετε τη θέση που επιθυμείτε (ΣΕΙΡΑ: 1-30, ΣΤΗΛΗ: A-L, ΕΞΟΔΟΣ: 0).");

                seat = in.nextLine();

                if (seat.equals("0")) {
                    break;
                }

                trimmed = seat.trim();

                col = column(trimmed);

                if (col == 0) {
                    System.out.println("Λάθος στήλη.");
                    System.out.println();
                    continue;
                }

                num = row(trimmed);

                if (num == 0) {
                    System.out.println("Λάθος σειρά.");
                    System.out.println();
                    continue;
                }

                System.out.println("Εισάγετε 1 για καταχώρηση θέσης, 2 για ακύρωση και 0 για έξοδο.");

                choice = choiceCheck();

                if (choice == 0) {
                    break;
                } else if (choice == 1) {
                    book(col, num);
                } else if (choice == 2) {
                    cancel(col, num);
                }

            } while (!seat.equals("0"));

            System.out.println("Επιλέξατε έξοδο! Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας!");

        } catch (InputMismatchException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }


    public static void displaySeats() {

        System.out.print("   ");
        for (int j = 0; j < 12; j++) {
            System.out.print(" " + ((char) (j+65)));
        }

        System.out.println();

        for (int i = 0; i < 30; i++) {
            System.out.printf("%02d: ", (i+1));
            for (int j = 0; j < 12; j++) {
               if (!theater[i][j]) {
                   System.out.print(" " + " ");
               } else {
                   System.out.print("x" + " ");
               }

            }
            System.out.println();
        }
    }

    public static char column(String trimmed) {
        char col = 0;

        try {
            Reader r = new StringReader(trimmed);
            c = r.read();
            r.close();

            if ((c >= 65) && (c <= 76)) {
                col = (char) c;
                return col;
            } else if ((c >= 97) && (c <= 108)) {
                col = (char) (c - 32);
                return col;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int row(String trimmed) {
        int num = 0;
        String number = "";
        try {
            Reader r = new StringReader(trimmed);
            c = r.read();

            while ((c = r.read()) > 0) {
                number = number + ((char) c);
            }

            num = Integer.valueOf(number);

            r.close();

            if ((num >= 1) && (num <= 30)) {
                return num;
            } else {

                return 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int choiceCheck() {
        int choice = -1;

        try {
            choice = in.nextInt();
            if ((choice != 1) && (choice != 2) && (choice != 0)) {
                throw new InputMismatchException();
            }
            return choice;

        } catch (InputMismatchException e) {
            System.out.println("Λάθος εισαγωγή.");
        } finally {
            in.nextLine();

        }
        return choice;
    }
    public static void book(char col, int num) {
        int i = 0;

        i= ((int) col - 65);

        if (theater[num-1][i] == false) {
            theater[num-1][i] = true;
            System.out.println("Η θέση καταχωρήθηκε.");
        } else {
            System.out.println("Η θέση είναι κατειλημμένη. Δοκιμάστε άλλη θέση.");
        }
    }

    public static void cancel(char col, int num) {
        int i = 0;

        i= ((int) col - 65);

        if (theater[num-1][i] == true) {
            theater[num - 1][i] = false;
            System.out.println("Η θέση ακυρώθηκε. Νέα εισαγωγή θέσης.");
        } else {
            System.out.println("Η θέση είναι ήδη κενή.");
        }
    }
}
