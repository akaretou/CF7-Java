package gr.aueb.cf.ch6;

/**
 * Έστω ένας πίνακας με στοιχεία της επιλογής σας με μεθόδους που κάνουν τα παρακάτω:
 * 1. Αναζήτηση ενός στοιχείου στον πίνακα (Επιστρέφει τη θέση του στοιχείου)
 * 2. Φιλτράρισμα των ζυγών (επιστρέφει void, μόνο εκτύπωση των ζυγών)
 * 3. Mapping κάθε στοιχείου του πίνακα με το διπλάσιο (η μέθοδος επιστρέφει πίνακα)
 * 4. Έλεγχος αν υπάρχει έστω ένας θετικός αριθμός (η μέθοδος επιστρέφει boolean)
 * 5. Έλεγχος αν όλα τα στοιχεία του πίνακα είναι θετικοί (η μέθοδος επιστρέφει boolean)
 */
public class MethodApp {
    public static void main(String[] args) {
        int[] arr = {2, 12, 2, 3};
        int key = 2;
        int[] arrNew;

        int position = getPosition(arr, key);

        System.out.printf("Η θέση του στοιχείου %d είναι: %d. ", arr[position], position);
        System.out.println();

        System.out.print("Οι ζυγοί αριθμοί είναι: ");
        filtering(arr);
        System.out.println();

        System.out.print("Ο νέος πίνακας με τα διπλασιασμένα στοιχεία είναι: ");
        arrNew = mapping(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arrNew[i]+" ");
        }
        System.out.println();


        positive(arr);
        System.out.printf("Στον πίνακα υπάρχει τουλάχιστον ένας θετικός αριθμός: %b", positive(arr));
        System.out.println();

        positiveAll(arr);
        System.out.printf("Στον πίνακα είναι όλοι θετικοί αριθμοί: %b",positiveAll(arr));
    }

    public static int getPosition(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    public static void filtering(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) System.out.printf("%d ", arr[i]);;
        }
        return;
    }

    public static int[] mapping(int[] arr) {
        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i] * 2;
        }
        return arr2;
    }

    public static boolean positive(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
           if (arr[i] > 0) return true;
        }
        return false;
    }

    public static boolean positiveAll(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) count++;
        }
        if (count == arr.length) return true;
        return false;
    }
}
