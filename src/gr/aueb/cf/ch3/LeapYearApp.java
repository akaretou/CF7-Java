package gr.aueb.cf.ch3;

import java.util.Scanner;

/**Πρόγραμμα που δείχνει αν ένα έτος είναι δίσεκτο ή όχι */

public class LeapYearApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int leapYear = 0;

        System.out.println("Παρακαλώ εισάγετε ακέραιο αριθμό έτους, προκειμένου να μάθετε αν είναι δίσεκτο ή όχι. \n" +
                "Για έξοδο από το πρόγραμμα εισάγετε -1.");
        leapYear = in.nextInt();

        while ((leapYear <= 0) && (leapYear != -1)){
            System.out.println("Παρακαλώ εισάγετε ακέραιο αριθμό έτους");
            leapYear = in.nextInt();
        }

        while (leapYear != -1){
            if (((leapYear % 4 == 0) && (leapYear % 100 != 0)) || (leapYear % 400 == 0)) {
                System.out.printf("Το έτος %d είναι δίσεκτο", leapYear);
                System.out.println();
                leapYear = in.nextInt();
            } else {
                System.out.printf("Το έτος %d δεν είναι δίσεκτο", leapYear);
                System.out.println();
                leapYear = in.nextInt();
            }
        }

        System.out.println("See you next time!");
    }
}
