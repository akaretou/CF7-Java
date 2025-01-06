package gr.aueb.cf.ch6;

/** Έστω ένας ταξινομημένος πίνακας με επαναλαμβανόμενα στοιχεία. Γράψτε μία μέθοδο int[] getLowAndHighIndexOf(int[]
 arr, int key) που να υπολογίζει και να επιστρέφει τα low και high index ενός πίνακα arr, για ένα ακέραιο key που λαμβάνει ως
 παράμετρο.
 • Γράψτε και μία main() που να βρίσκει το low και high index για τον πίνακα {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8}. Για παράδειγμα, αν
 δώσουμε ως τιμή το 8, θα πρέπει να επιστρέφει {7, 11}.
 • Hint. Ελέγξτε αν το key περιέχεται στον πίνακα και σε ποια θέση. Αν ναι, τότε από τη θέση αυτή μετρήστε τα στοιχεία όσο
 υπάρχουν στοιχεία με ίδια τιμή και μέχρι να βρείτε το τέλος του πίνακα.
 */
public class LowAndHighApp {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8};
        int key = 8;
        int[] arr2 = new int[2];

        arr2 = getLowAndHighIndexOf(arr, key);
        System.out.printf("Ο αριθμός %d βρίσκεται στη θέση %d έως τη θέση %d.", key, arr2[0], arr2[1]);
    }

    public static int[] getLowAndHighIndexOf(int[] arr, int key) {
        int low = -1;
        int high = 0;
        int count = 0;
        int[] index = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (low == -1) {
                    low = i;
                } else {
                    count++;
                }
            }
        }

        high = low + count;
        index[0] = low;
        index[1] = high;
        return index;
    }
}
