/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climoilou.entrepot.rechercheSimple;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;

import climoilou.entrepot.items.Item;
import climoilou.entrepot.rechercheSimple.critere.CritereRechercheSimple;

/**
 *
 * @author Martin Simoneau
 */
public class MoteurRechercheSimple implements ChercheurSimple {

	private LinkedList<CritereRechercheSimple> criteres;
	// sortedset est important parce que les critères sont appliqués dans l'ordre
	// saisi.

	@Override
	public Collection<Item> recherche() {
		Set<Item> retVal = new HashSet<>();
		//TODO programmez la recherche en tenant compte de chaque critère

		return retVal;
	}

	/**
	 * Ajoute un critère à la recherche
	 *
	 * @param critere
	 */
	public void addCritere(CritereRechercheSimple critere) {
		assert critere != null : "Null critere";
		// lazy initialisation
		if (criteres == null) {
			// L'ordre d'ajout des ensemble est important!
			criteres = new LinkedList<CritereRechercheSimple>();
		}
		this.criteres.add(critere);
	}
}
