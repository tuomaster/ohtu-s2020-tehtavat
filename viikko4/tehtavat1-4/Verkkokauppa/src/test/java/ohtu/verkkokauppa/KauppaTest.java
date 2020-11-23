package ohtu.verkkokauppa;

import org.junit.Test;
import static org.mockito.Mockito.*;


public class KauppaTest {
    
    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // Luodaan ensin mock-oliot
        Pankki pankki = mock(Pankki.class);
        
        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // Määritellään, että viitegeneraattori palauttaa viitteen 42
        when(viite.uusi()).thenReturn(42);
        
        Varasto varasto = mock(Varasto.class);
        // Määritellään, että tuote numero 1 on maito, jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        
        // Sitten testattava kauppa
        Kauppa k = new Kauppa(varasto, pankki, viite);
        
        // Tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);   // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");
        
        // Sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
        // Toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }
    
}
