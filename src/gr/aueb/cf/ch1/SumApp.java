package gr.aueb.cf.ch1;

/**
 * Πρόγραμμα που δηλώνει δύο μεταβλητές
 * ακεραίων num1 και num2 και αποθηκεύει το αποτέλεσμα
 * της πρόσθεσης num1 + num2 στην μεταβλητή sum. Στη
 * συνέχεια εκτυπώνει με println.
 */
public class SumApp {
    public static void main(String[] args) {
        //Δήλωση και αρχικοποίηση μεταβλητών
        int num1 = 19;
        int num2 = 30;
        int sum = 0;

        //Εντολές
        sum = num1 + num2;

        //Εκτύπωση αποτελεσμάτων
        System.out.println("Το αποτέλεσμα της πρόσθεσης είναι ίσο με " + sum);
    }
}
