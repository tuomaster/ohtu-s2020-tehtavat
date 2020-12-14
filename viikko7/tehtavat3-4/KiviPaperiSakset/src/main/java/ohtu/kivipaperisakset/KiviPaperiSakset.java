package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KiviPaperiSakset {

    protected Scanner lukija = new Scanner(System.in);
    protected String ekanSiirto;

    public static KiviPaperiSakset luoPeli(String pelimoodi) {
        switch (pelimoodi) {
            case "a":
                return new KPSPelaajaVsPelaaja();
            case "b":
                return new KPSTekoaly();
            case "c":
                return new KPSParempiTekoaly();
            default:
                return null;
        }
    }

    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        
        ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected String ensimmaisenSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return lukija.nextLine();
    }

    abstract protected String toisenSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
