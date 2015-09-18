package climoilou.entrepot.rechercheSimple.critere;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import climoilou.entrepot.items.Item;

public abstract class AbstractCritereRechercheSimpleCollection extends AbstractCritereRechercheSimple {

	protected Comparator<Item> comparateur = null;

	protected AbstractCritereRechercheSimpleCollection(List<Item> source, OrAndNot jointure) {
		super(source, jointure);
	}

	@Override
	public Set<Item> getElementsTrouves() {
		Set<Item> retVal = new HashSet<>();
			//TODO faire la recherche à l'aide du comparateur
		return retVal;
	}

	abstract Item getItem();
	abstract Comparator<Item> getComparator();

	@Override
	final boolean estSatisfait(Item elementExamine) {
		throw new UnsupportedOperationException("estSatisfait n'est pas utilisable avec cette classe");
	}
	
	@Override
	final public String getCritere() {
		throw new UnsupportedOperationException("getCritere n'est pas utilisable avec cette classe");
	}

}
