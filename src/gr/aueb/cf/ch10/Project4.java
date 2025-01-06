package gr.aueb.cf.ch10;

import java.util.Scanner;

/** Αναπτύξτε ένα παιχνίδι Τρίλιζα, όπου δύο παίκτες παίζουν Χ και Ο (ή 1 και 2 αν θέλετε
 να υλοποιήσετε με πίνακα ακεραίων και όχι με πίνακα char) και κερδίζει ο παίκτης
 που έχει συμπληρώσει τρία ίδια σύμβολα ή αριθμούς σε οποιαδήποτε διάσταση του
 πίνακα, οριζόντια, κάθετα ή διαγώνια.
 Η main() μπορεί να ελέγχει τη ροή του παιχνιδιού, όπως ποιος παίκτης παίζει κάθε
 φορά (εναλλαγή μεταξύ των δύο παικτών), να διαβάζει από το stdin το σύμβολο που
 δίνει ο κάθε παίκτης και να εμφανίζει με γραφικό τρόπο την τρίλιζα μετά από κάθε
 κίνηση κάθε παίκτη.
 Ενώ, μπορείτε να δημιουργήσετε και μία μέθοδο που να ελέγχει (μετά από κάθε
 κίνηση) αν ο παίκτης που έκανε την κίνηση έκανε τρίλιζα.
 Το πρόγραμμα θα πρέπει να λαμβάνει υπόψη την περίπτωση ισοπαλίας όπως και να
 μην επιτρέπει ένας παίκτης να παίξει σε θέση που είναι ήδη κατειλημμένη.
 */
public class Project4 {
    static int[][] game = new int[3][3];

    public static void main(String[] args) {
        int[] player = new int[2];
        int playerID = 1;
        int position = 0;
        int count = 0;
        Scanner in = new Scanner(System.in);

        reset(game);

        System.out.println("Ο παίκτης 1 πληκτρολογεί το '1' και ο παίκτης 2 το '2', ενώ με -1 γίνεται έξοδος από το παιχνίδι.   Ας ξεκινήσουμε!!");
        System.out.println("Οι θέσεις είναι οι εξής: ");
        System.out.println("1  2  3");
        System.out.println("4  5  6");
        System.out.println("7  8  9");

        do {
            System.out.printf("Ο παίκτης %d να πληκτρολογήσει τη θέση του.\n", playerID);
            position = in.nextInt();

            if ((position <= 9) && (position >= 1)) {
                if (!getPosition(position, playerID)) {
                    System.out.println("Η θέση είναι κατειλημμένη!");
                } else {
                    if (winner(game)) {
                        System.out.printf("Ο παίκτης %d έκανε τρίλιζα!\n", playerID);
                        player[playerID - 1]++;
                        System.out.printf("Ο παίκτης 1 έχει %d νίκες!\nΟ παίκτης 2 έχει %d νίκες!\n", player[0], player[1]);
                        reset(game);

                    } else {
                        if (draw()) {
                            System.out.println("Έχουμε ισοπαλία!");
                            reset(game);
                        }
                    }

                    if (playerID == 1) {
                        playerID = 2;
                    } else if (playerID == 2) {
                        playerID = 1;
                    }
                }
            } else if (position != -1) {
                System.out.println("Λάθος θέση");
            }

        } while (position != -1);

        System.out.println("See you next time!");
    }
    public static boolean getPosition(int position, int playerID) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (position == (i * 3) + (j + 1)) {
                    if (game[i][j] == 0) {
                        game[i][j] = playerID;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
        return true;
    }
    public static boolean winner(int[][] game) {
        for (int i = 0; i < 3; i++) {
            if ((game[i][0] != 0) && ((game[i][0] == game[i][1]) && (game[i][0]==game[i][2]))) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if ((game[0][j] != 0) && ((game[0][j] == game[1][j]) && (game[0][j]==game[2][j]))) {
                return true;
            }
        }

        if ((game[1][1] != 0) && ((game[0][0] == game[1][1]) && (game[0][0]==game[2][2]) ||
                (game[0][2] == game[1][1]) && (game[0][2]==game[2][0]))){
            return true;
        }
        return false;
    }

    public static boolean draw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void reset(int[][] game){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                game[i][j] = 0;
            }
        }
    }
}
