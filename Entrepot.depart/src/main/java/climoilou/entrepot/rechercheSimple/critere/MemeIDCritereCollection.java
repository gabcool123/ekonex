/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climoilou.entrepot.rechercheSimple.critere;

import java.util.Comparator;
import java.util.List;

import climoilou.entrepot.items.Item;

/**
 * Critère de recherche pour le nom de l'item
 * 
 * @author Martin Simoneau
 */
public class MemeIDCritereCollection extends AbstractCritereRechercheSimpleCollection {

	private Item itemRecherche;

	public MemeIDCritereCollection(long uidRecherche, List<Item> source, OrAndNot jointure) {
		super(source, jointure);

		assert uidRecherche > 0 : "negativeuid";
		itemRecherche = new Item("", (int) uidRecherche, "", null, null, 0.0f);

		//TODO initialisez les attributs requis.
	}

	@Override
	public void setCritere(String nouveau) {
		if (isNumeric(nouveau)) {
			itemRecherche = new Item("", new Long(nouveau).intValue(), "", null, null, 0.0f);
		}
	}

	@Override
	Comparator<Item> getComparator() {
		return comparateur;
	}

	@Override
	Item getItem() {
		// Seul le uid est utilisé dans la comparaison
		return itemRecherche;
	}

}
