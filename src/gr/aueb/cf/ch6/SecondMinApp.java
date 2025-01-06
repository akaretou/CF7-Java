package gr.aueb.cf.ch6;

import java.util.Arrays;

/**
 * Πρόγραμμα που βρίσκει το 2ο μικρότερο στοιχείο ενός πίνακα,
 * το στοιχείο δηλαδή που είναι αμέσως μεγαλύτερο από το ελάχιστο στοιχείο
 */
public class SecondMinApp {
    public static void main(String[] args) {
        int[] arr = {2, 12, 2, 4};
        int SecMinPosition = 0;

        SecMinPosition = getSecMin(arr);


        for (int i = 0; i < arr.length; i++ ) {
            System.out.printf("%d ",arr[i]);
        }
        System.out.println();

        if (SecMinPosition == -1) {
            System.out.println("Δεν βρέθηκε μικρότερο στοιχείο.");
        } else {
            System.out.printf("Το 2ο μικρότερο στοιχείο του πίνακα είναι: %d.", arr[SecMinPosition]);
        }
    }

    public static int getSecMin(int[] arr) {
        if ((arr == null) || (arr.length < 1)) return -1;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i+1]) return i+1;
        }
        return -1;
    }
}
