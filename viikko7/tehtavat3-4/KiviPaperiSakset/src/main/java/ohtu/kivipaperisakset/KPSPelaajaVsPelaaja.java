package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    @Override
    protected String toisenSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        return lukija.nextLine();
    }
}
