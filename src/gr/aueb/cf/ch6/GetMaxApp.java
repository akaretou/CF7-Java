package gr.aueb.cf.ch6;

/** Γενική μέθοδος εύρεσης του μέγιστου ενός πίνακα getMaxPosition (int[] arr, int low, int high) που επιστρέφει
 * τη θέση στον πίνακα arr του μέγιστου στοιχείου του πίνακα.
 */

public class GetMaxApp {
    public static void main(String[] args) {
        int[] arr = {2,  5, 18, 0, 3};
        int maxPosition = getMaxPosition(arr, 0, arr.length - 1);

        System.out.println(maxPosition);
    }

    public static int getMaxPosition (int[] arr, int low, int high) {
        int max = arr[low];
        int maxPosition = low;

        if ((arr == null) || ((high + 1) < 1)) return -1;

        for (int i = low + 1; i < high; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    }
    /**
     public static int getMaxPosition (int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxPosition = 0;

        if ((arr == null) || (arr.length < 1)) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    } **/
}
