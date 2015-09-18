/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climoilou.entrepot.rechercheSimple.critere;

import java.util.Set;

import climoilou.entrepot.items.Item;

/**
 *  Interface générique pour tous les critères de recherche du package entrepôt.
 * @author Martin simoneau
 */
public interface CritereRechercheSimple {
	public enum OrAndNot {OR, AND,NOT};

    /**
     * Retourne les éléments de la source qui satisfont  le critère de recherche
     * @return les éléments qui satisfont le critère.
     */
    Set<Item> getElementsTrouves();
    
    /**
     * Indique de quel type de jointure il s'agit (et, ou, non) 
     * @return le ype de jointure
     */
	 OrAndNot getJointure();
	 
	 /**
	  * Change la jointure
	  * @param nouvelle
	  */
	 void setJointure(OrAndNot nouvelle);
	 
	 /**
	  * Retourne le texte du critère
	  * @return le texte
	  */
	 String getCritere();
	 
	 /**
	  * Change le critère
	  */
	 void setCritere(String nouveau);
	
}
