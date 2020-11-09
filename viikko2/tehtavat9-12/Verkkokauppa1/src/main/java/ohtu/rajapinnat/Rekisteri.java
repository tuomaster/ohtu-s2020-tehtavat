/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.rajapinnat;

import java.util.ArrayList;

/**
 *
 * @author tuomaste
 */
public interface Rekisteri {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
