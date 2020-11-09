package ohtu.verkkokauppa;

import ohtu.rajapinnat.Viite;

public class Viitegeneraattori implements Viite {
    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
