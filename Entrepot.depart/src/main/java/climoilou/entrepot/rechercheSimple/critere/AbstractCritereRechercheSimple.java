package climoilou.entrepot.rechercheSimple.critere;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import climoilou.entrepot.items.Item;

public abstract class AbstractCritereRechercheSimple implements CritereRechercheSimple {

	List<Item> source;
	OrAndNot jointure;

	/**
	 * Indique si le critère se trouve dans la chaine. Algorithme développé en POO-I
	 * 
	 * @param pChaine
	 *            la chaine qui peut contenir le critère
	 * @param pCritere
	 *            le critère de recherche
	 * @return vrai si le critere est contenu dans la chaine
	 */
	protected static boolean contains(String pChaine, String pCritere) {
		boolean retVal = false;
		String chaine = pChaine.toUpperCase();
		String critere = pCritere.toUpperCase();

		// pour chaque position dans la chaine recherchée
		for (int i = 0; i < chaine.length() - critere.length() + 1; i++) {
			boolean trouve = true;

			// il doit y avoir égalité entre tous les éléments correspondant
			for (int j = 0; j < critere.length() && trouve; j++) {
				if (chaine.charAt(i + j) != critere.charAt(j)) {
					trouve = false;
				}
			}
			retVal |= trouve;
		}
		return retVal;
	}

	public OrAndNot getJointure() {
		return jointure;
	}

	/**
	 * 
	 * @param source
	 *            Les données sources pour effectuer la recherche du critère
	 * @param jointure
	 *            si le critère est un Or un Et ou un non.
	 */
	protected AbstractCritereRechercheSimple(List<Item> source, OrAndNot jointure) {
		assert source != null : "null source";

		this.source = source;
		this.jointure = jointure;
	}

	@Override
	public Set<Item> getElementsTrouves() {
		Set<Item> retVal = new HashSet<>();

		for (Item elementExamine : source) {
			if (estSatisfait(elementExamine)) {
				retVal.add(elementExamine);
			}
		}

		return retVal;
	}

	@Override
	public void setJointure(OrAndNot nouvelle) {
		jointure = nouvelle;

	}

	/**
	 * Vérifie si la chaine de charactère est un nombre
	 * 
	 * @param str
	 *            la chaine contenant le nombre
	 * @return
	 */
	protected static boolean isNumeric(String chaine) {
		boolean retVal = true;
		try {
			Double.parseDouble(chaine);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return retVal;
	}

	abstract boolean estSatisfait(Item elementExamine);

}
