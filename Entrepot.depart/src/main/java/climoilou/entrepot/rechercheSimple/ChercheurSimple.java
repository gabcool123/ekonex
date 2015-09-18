/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climoilou.entrepot.rechercheSimple;

import climoilou.entrepot.items.Item;
import climoilou.entrepot.rechercheSimple.critere.CritereRechercheSimple;

import java.util.Collection;

/**
 *
 * @author martin
 */
public interface ChercheurSimple {
    Collection<Item> recherche( );
    public void addCritere(CritereRechercheSimple  critere) ;

}
