
package ohtu.verkkokauppa;

import java.util.ArrayList;
import ohtu.rajapinnat.Rekisteri;

public class Kirjanpito implements Rekisteri {
    
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
