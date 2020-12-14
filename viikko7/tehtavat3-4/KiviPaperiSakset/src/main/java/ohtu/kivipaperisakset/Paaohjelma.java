package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String pelimoodi = lukija.nextLine();
            KiviPaperiSakset peli = KiviPaperiSakset.luoPeli(pelimoodi);
            if(peli == null) {
                break;
            }
            peli.pelaa();

        }

    }
}
