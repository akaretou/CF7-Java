package gr.aueb.cf.ch5;

import java.util.Scanner;

/**
 * Μέθοδος που δέχεται μια θερμοκρασία σε βαθμούς Κελσίου (double) και τη μετατρέπει σε Φαρενάιτ (double).
 */
public class FahrenheitConverter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Παρακαλώ δώστε θερμοκρασία σε βαθμούς Κελσίου.");
        double celsius = in.nextDouble();
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.printf("Η θερμοκρασία %4.02f σε βαθμούς κελσίου αντιστοιχεί σε τιμή Φαρενάιτ %4.02f.", celsius, fahrenheit);
    }

    public static double celsiusToFahrenheit(double celsius) {
                return celsius * 9/5 + 32;
    }
}
