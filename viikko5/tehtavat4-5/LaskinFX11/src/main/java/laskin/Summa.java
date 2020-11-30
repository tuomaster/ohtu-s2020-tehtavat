package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {

    public Summa(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, plus, miinus, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        edellinenTuos = lueTuloskentta();
        sovellus.plus(lueSyote());
        paivitaKentat();
        paivitaNapit();
    }

    @Override
    public void peru() {

    }

}
