package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    TekoalyPerus tekoaly = new TekoalyPerus();

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }
}
