package gr.aueb.cf.ch7;

import java.util.Scanner;

/** Πρόγραμμα κρυπτογράφησης και αποκρυπτογράφησης και δημιουργήστε τον
 αλγόριθμο κρυπτογράφησης / αποκρυπτογράφηση του Καίσαρα **/

public class CaesarEncryptionDecryption {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String trimmed = "";
        int key = 0;
        String encryptedWord;
        String decryptedWord;


        System.out.println("Θέλετε κρυπτογράφηση ή αποκρυπτογράφηση;");
        System.out.println("Πληκτρολογήστε 1 για κρυπτογράφηση, 2 για αποκρυπτογράφηση ή -1 για έξοδο από το πρόγραμμα.");
        int choice = in.nextInt();

         do {
            if (choice == 1) {
                trimmed = InsertWord();
                key = InsertKey();
                encryptedWord = Encryption(trimmed, key);
                System.out.println(encryptedWord);
                System.out.println("Πληκτρολογήστε 1 για κρυπτογράφηση, 2 για αποκρυπτογράφηση ή -1 για έξοδο από το πρόγραμμα.");
                choice = in.nextInt();

            } else if (choice == 2) {
                trimmed = InsertWord();
                key = InsertKey();
                decryptedWord = Decryption(trimmed, key);
                System.out.println(decryptedWord);
                System.out.println("Πληκτρολογήστε 1 για κρυπτογράφηση, 2 για αποκρυπτογράφηση ή -1 για έξοδο από το πρόγραμμα.");
                choice = in.nextInt();
            } else {
                System.out.println("Λάθος επιλογή.");
                System.out.println("Πληκτρολογήστε 1 για κρυπτογράφηση, 2 για αποκρυπτογράφηση ή -1 για έξοδο από το πρόγραμμα.");
                choice = in.nextInt();
            }
        } while (choice != -1);

        System.out.println("See you next time!");
    }

    public static String InsertWord() {
        System.out.println("Παρακαλώ εισάγετε μία λέξη για κρυπτογράφηση/αποκρυπτογράφηση.");
        String word;
        Scanner in = new Scanner(System.in);
        word = in.nextLine();
        return word.trim();
    }

    public static int InsertKey() {
        Scanner in = new Scanner(System.in);
        System.out.println("Παρακαλώ εισάγετε έναν ακέραιο ως κλειδί κρυπτογράφησης/αποκρυπτογράφησης.");
        return in.nextInt();
    }


    public static String Encryption (String trimmed,int key){
            char newChar = 0;
            StringBuilder sb = new StringBuilder();

            for (char ch : trimmed.toCharArray()) {
                int chConverter = ch;

                if (((chConverter > 64) && (chConverter < 91)) || ((chConverter > 96) && (chConverter < 123))){
                    newChar = (char) (chConverter + key);
                } else {
                    newChar = (char) (chConverter);
                }
                sb.append(newChar);
            }
            return sb.toString();
        }

    public static String Decryption (String trimmed,int key){
        char newChar = 0;
        StringBuilder sb = new StringBuilder();

        for (char ch : trimmed.toCharArray()) {
            int chConverter = ch;

            if (((chConverter > 64) && (chConverter < 91)) || ((chConverter > 96) && (chConverter < 123))){
                newChar = (char) (chConverter - key);
            } else {
                newChar = (char) (chConverter);
            }
            sb.append(newChar);
        }
        return sb.toString();
    }
}
