package gr.aueb.cf.ch2;

import java.util.Scanner;

/** Πρόγραμμα που μετατρέπει ακέραιες θερμοκρασίες Φαρενάιτ
 * (Fahrenheit) στην κλίμακα Κελσίου, αφού διαβάσει την ακέραιη θερμοκρασία από τον χρήστη
 */
public class FahrenheitConverter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int fahrenheit = 0;
        int celsius = 0;

        System.out.println("Παρακαλώ εισάγετε ακέραιη τιμή θερμοκρασίας στην κλίμακα Fahrenheit");
        fahrenheit = in.nextInt();
        celsius = 5 * (fahrenheit - 32) / 9;

        System.out.printf("Η θερμοκρασία %d Fahrenheit ισούται με %d βαθμούς Celsius", fahrenheit, celsius);
    }
}
