package gr.aueb.cf.ch5;

import java.util.Scanner;

/** Μέθοδος που δέχεται έναν ακέραιο αριθμό και επιστρέφει true αν ο αριθμός είναι πρώτος και false αν δεν είναι.
 */
public class PrimeNumApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Παρακαλώ δώστε έναν ακέραιο αριθμό.");
        int num = in.nextInt();
        boolean numP = isPrime(num);
        System.out.printf("Ο αριθμός %d είναι πρώτος: %b", num, numP);
    }
    public static boolean isPrime(int num){
        boolean isPrimeNumber = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return isPrimeNumber;
    }
}
