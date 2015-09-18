/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climoilou.entrepot.rechercheSimple.critere;

import java.util.List;

import climoilou.entrepot.items.Item;

/**
 * Critère de recherche pour le nom de l'item
 * 
 * @author Martin Simoneau
 */
public class MemeIDCritere extends AbstractCritereRechercheSimple {

	private long uidRecherche;

	public MemeIDCritere(long uidRecherche, List<Item> source, OrAndNot jointure) {
		super(source, jointure);

		assert uidRecherche > 0 : "negativeuid";
		this.uidRecherche = uidRecherche;
	}

	@Override
	public boolean estSatisfait(Item elementExamine) {
		boolean retVal = false;
		//TODO programmez la comparaison

		return retVal;
	}

	@Override
	public String getCritere() {
		return new Long(uidRecherche).toString();
	}

	@Override
	public void setCritere(String nouveau) {
		uidRecherche = new Long(nouveau);
		
	}

}
