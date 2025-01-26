package gr.aueb.cf.ch10;

/** Έστω ένας πίνακας n ακεραίων. Τότε ο maximum sum subarray ο είναι ο συνεχόμενος
 υποπίνακας (contiguous subarray - δυνητικά κενό) με το μεγαλύτερο άθροισμα.
 Σχεδιάστε έναν γραμμικό αλγόριθμο (με πολυπλοκότητα O(n)) για να επιλύσετε τα
 παραπάνω πρόβλημα. Για παράδειγμα, αν έχουμε τον πίνακα {−2, 1, −3, 4, −1, 2, 1,
 −5, 4} τότε ο συνεχόμενος υποπίνακας με το μέγιστο άθροισμα είναι ο {4, −1, 2, 1},
 του οποίου το άθροισμα είναι 6.
 */
public class Project2 {
    public static void main(String[] args) {
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arrMax = max(arr);

        for (int i = 0; i < arrMax.length; i++) {
            System.out.printf("%d ", arrMax[i]);
        }
    }

    public static int[] max(int[] arr) {
        int max = arr[0];
        int localMax = arr[0];
        int position = -1;
        int start = 0;
        int end = 0;


        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max+arr[i], arr[i]);
            //System.out.println(max);

            if(max+arr[i] < arr[i]){
                position = i + 1;
            }

            if(localMax < max) {
                localMax = max;
                start = position;
                end = i;
            }
        }

        int[] arr2 = new int[end-start+1];
        //System.out.println(start);
        //System.out.println(end);
        for (int i = start;  i < end; i++) {
            arr2[i-start] = arr[i];
        }
        return arr2;
    }
}
