package gr.aueb.cf.ch7;

import java.util.Scanner;

/**
 * Αποκρυπτογράφηση: Ένα πρόγραμμα που να αποκρυπτογραφεί / αντικαθιστά κάθε χαρακτήρα του String με τον λεξικογραφικά
 * (ASCII-κογραφικα!) προηγούμενο
 */
public class DecryptionApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word;
        String trimmed;
        StringBuilder sb = new StringBuilder();
        char newChar;

        System.out.println("Παρακαλώ εισάγετε μία λέξη για κρυπτογράφηση.");
        word = in.nextLine();
        trimmed = word.trim();

        for (char ch : trimmed.toCharArray()){
            //System.out.println(ch);
            int chConverter = ch;
            //System.out.println(chConverter);
            newChar = (char) (chConverter - 1);
            //System.out.println(newChar);
            sb.append(newChar);
        }
        System.out.println(sb);
    }
}
