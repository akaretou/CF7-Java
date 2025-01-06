package gr.aueb.cf.ch10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** Αναπτύξτε μία εφαρμογή που διαβάζει έναν-έναν τους χαρακτήρες ενός αρχείου και
 τους εισάγει σε ένα πίνακα 128x2. Υποθέστε ότι οι χαρακτήρες είναι λατινικοί. Κάθε
 θέση του πίνακα είναι επομένως ένας πίνακας δύο θέσεων, όπου στην 1η θέση
 αποθηκεύεται ο χαρακτήρας που έχει διαβαστεί (αν δεν υπάρχει ήδη στον πίνακα)
 και στην 2η θέση αποθηκεύεται το πλήθος των φορών που έχει διαβαστεί (βρεθεί)
 κάθε χαρακτήρας. Αγνοήστε τα κενά και τις αλλαγές γραμμής και γενικά τα
 whitespaces.
 Στο τέλος η main() παρουσιάζει στατιστικά στοιχεία για κάθε χαρακτήρα όπως η
 συχνότητα εμφάνισής του στο κείμενο ταξινομημένα ανά χαρακτήρα και ανά
 συχνότητα εμφάνισης.
 */
public class Project3 {
    public static void main(String[] args) {
        int[][] array = new int[128][2];
        char ch = 0;
        int c = 0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\tmp\\project3.txt"))) {
            while ((c = br.read())!= -1) {
                ch = (char) c;
                if ((ch != ' ') && (ch != '\n'))  {
                       array[c][0] = ch;
                       array[c][1]++;
                }
            }

//            for (int i = 0; i < array.length; i++) {
//                    System.out.println((char) array[i][0] +  ":" + array[i][1]);
//            }

            int[][] arr = CleanArray(array);

            System.out.println("Ταξινομημένος πίνακας με βάση τους χαρακτήρες: ");

            for (int i = 0; i < arr.length; i++) {
                System.out.println((char) arr[i][0] + ":" + arr[i][1]);
            }

            SortArray(arr);

            System.out.println("Ταξινομημένος πίνακας με βάση το πλήθος εμφάνισης των χαρακτήρων: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.println((char) arr[i][0] + ":" + arr[i][1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] CleanArray(int[][] array) {

        int n = 0;

        for (int k = 0; k < array.length; k++) {
            if (array[k][1]!=0) {
                n++;
            }
        }

        int[][] arr = new int[n][2];

        n = 0;

        for (int k = 0; k < array.length; k++) {
            if (array[k][1]!=0) {
                arr[n][0] = array[k][0];
                arr[n][1] = array[k][1];
                n++;
            }
        }
        return arr;
    }

    public static void SortArray(int[][] arr) {
        int min;
        int  minPosition;
        int[] tmp;

        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i][1];
            minPosition = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j][1] < min) {
                    min = arr[j][1];
                    minPosition = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minPosition];
            arr[minPosition] = tmp;
        }
    }
}
