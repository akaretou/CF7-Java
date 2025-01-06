package gr.aueb.cf.ch10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/** Αναπτύξτε ένα πρόγραμμα σε Java που να διαβάζει από ένα αρχείο ακέραιους
 αριθμούς (το αρχείο πρέπει να περιέχει περισσότερους από 6 αριθμούς και το πολύ
 49 αριθμούς) με τιμές από 1 έως 49. Τους αριθμούς αυτούς τους εισάγει σε ένα
 πίνακα, τον οποίο ταξινομεί (π.χ. με την Arrays.sort()). Στη συνέχεια, το πρόγραμμα
 παράγει όλες τις δυνατές εξάδες (συνδυασμούς 6 αριθμών). Ταυτόχρονα και αμέσως
 μετά την παραγωγή κάθε εξάδας ‘φιλτράρει’ κάθε εξάδα ώστε να πληροί τα
 παρακάτω κριτήρια: 1) Να περιέχει το πολύ 4 άρτιους, 2) να περιέχει το πολύ 4
 περιττούς, 3) να περιέχει το πολύ 2 συνεχόμενους, 4) να περιέχει το πολύ 3 ίδιους
 λήγοντες, 5) να περιέχει το πολύ 3 αριθμούς στην ίδια δεκάδα.
 Τέλος, εκτυπώνει τις τελικές εξάδες σε ένα αρχείο με όνομα της επιλογής σας και
 κατάληξη.txt.
 */

public class Project1 {
    public static void main(String[] args) {
        int[] arr = new int[49];
        String line;
        int i = 0;
        int totalNumbers = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\tmp\\project1.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\tmp\\project1Output.txt", StandardCharsets.UTF_8)) ) {

            while ((line = br.readLine() )!= null) {
                arr[i] = Integer.parseInt(line);
                i++;
            }

            totalNumbers = i;

            Arrays.sort(arr, 0, totalNumbers);

            for (i = 0; i < totalNumbers; i++) {
                System.out.println(arr[i]);
            }

            int[] array2 = new int[6];

            for (i= 0; i <= totalNumbers - 6; i++) {
                for (int j = i + 1; j <= (totalNumbers - 5) ; j++) {
                    for (int k = j + 1; k <= (totalNumbers - 4); k++) {
                        for (int l = k + 1; l <= (totalNumbers - 3); l++) {
                            for (int m = l + 1; m <= (totalNumbers - 2); m++){
                                for (int n = m + 1; n <= (totalNumbers - 1); n++) {
                                    array2[0] = arr[i];
                                    array2[1] = arr[j];
                                    array2[2] = arr[k];
                                    array2[3] = arr[l];
                                    array2[4] = arr[m];
                                    array2[5] = arr[n];

                                    if ((even(array2) <= 4) && (odd(array2) <= 4) && (!consecutiveNums(array2)) && (endingNum(array2)) && (decade(array2))) {
                                        System.out.printf("%d, %d, %d, %d, %d, %d\n", array2[0], array2[1], array2[2], array2[3], array2[4], array2[5]);
                                        bw.write(String.valueOf(array2[0]) + " " );
                                        bw.write(String.valueOf(array2[1]) + " ");
                                        bw.write(String.valueOf(array2[2]) + " ");
                                        bw.write(String.valueOf(array2[3]) + " ");
                                        bw.write(String.valueOf(array2[4]) + " ");
                                        bw.write(String.valueOf(array2[5]) + "  \n");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int even(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) count++;
        }
        return count;
    }

    public static int odd(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) count++;
        }
        return count;
    }

    public static boolean consecutiveNums(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 1] - 1)  return true;
        }
        return false;
    }

    public static boolean endingNum(int[] arr) {
        int[] arr2 = new int[10];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {

            j = arr[i] % 10;
            arr2[j]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr2[j] < 3) return true;
        }
        return false;
    }

    public static boolean decade(int[] arr) {
        int[] arr2 = new int[10];
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            j = arr[i] / 10;
            arr2[j]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr2[j] < 3) return true;
        }
        return false;
    }
}
