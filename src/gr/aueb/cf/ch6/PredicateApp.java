package gr.aueb.cf.ch6;

import java.util.Scanner;

/** Ζητάμε από τον χρήστη να εισάγει έξι ακεραίους από 1 έως 49 και ελέγχουμε αν αυτή η εξάδα περνάει από τα
 παρακάτω φίλτρα (predicates):
 1. Δεν έχει πάνω από 3 άρτιους
 2. Δεν έχει πάνω από 3 περιττούς
 3. Δεν έχει πάνω από 3 συνεχόμενους
 4. Δεν έχει πάνω από 3 αριθμούς με τον ίδιο λήγοντα
 5. Δεν έχει πάνω από 3 αριθμούς στην ίδια δεκάδα
 */
public class PredicateApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[6];

        System.out.println("Παρακαλώ εισάγετε έξι ακεραίους από 1 έως 49");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        if (even(arr) < 3) System.out.printf("Δεν έχει πάνω από 3 άρτιους. Οι άρτιοι είναι %d", even(arr));
        System.out.println();

        if (odd(arr) < 3) System.out.printf("Δεν έχει πάνω από 3 περιττούς. Οι περιττοί είναι %d", odd(arr));
        System.out.println();

        if (!consecutiveNums(arr)) System.out.println("Δεν έχει πάνω από 3 συνεχόμενους.");

        if (endingNum(arr)) System.out.println("Δεν έχει πάνω από 3 αριθμούς με τον ίδιο λήγοντα.");

        if (decade(arr)) System.out.println("Δεν έχει πάνω από 3 αριθμούς στην ίδια δεκάδα.");
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
            if ((arr[i] == arr[i + 1] - 1) && (arr[i] == arr[i + 2] - 2)) return true;
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
