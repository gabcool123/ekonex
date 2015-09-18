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
public class DansNomProduitCritere extends AbstractCritereRechercheSimple {

	private  String nomProduitRecherche;

	public DansNomProduitCritere(String nomProduitRecherche, List<Item> source, OrAndNot jointure) {
		super(source, jointure);
		assert nomProduitRecherche != null : "null nom de produit recherche";

		this.nomProduitRecherche = nomProduitRecherche;
	}

	@Override
	boolean estSatisfait(Item elementExamine) {
		boolean retVal = false;
		if (contains(elementExamine.getNomDeProduit(), nomProduitRecherche)) {
			retVal = true;
		}
		return retVal;
	}

	@Override
	public String getCritere() {
		return nomProduitRecherche;
	}

	@Override
	public void setCritere(String nouveau) {
		nomProduitRecherche = nouveau;
		
	}


}
