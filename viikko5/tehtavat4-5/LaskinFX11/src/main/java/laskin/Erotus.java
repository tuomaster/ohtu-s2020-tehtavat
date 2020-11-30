package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Komento;
import laskin.Sovelluslogiikka;

public class Erotus extends Komento {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinenTuos = lueTuloskentta();
        sovellus.miinus(lueSyote());
        paivitaKentat();
        paivitaNapit();
    }

    @Override
    public void peru() {

    }

}
