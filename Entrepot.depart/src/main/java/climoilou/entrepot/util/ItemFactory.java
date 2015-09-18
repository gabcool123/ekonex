package climoilou.entrepot.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import climoilou.entrepot.items.Item;
import climoilou.entrepot.items.TypeItem;

public class ItemFactory {

	private static final String MOTS_FRANCAIS = "liste.de.mots.francais.frgut.utf8.txt";
	private static int uidCount;
	private static ItemFactory instance = new ItemFactory(MOTS_FRANCAIS);
	static List<String> mots;

	private ItemFactory(String fichier_source) {
		super();
		try {
			mots = new ChargeurDeDonnees(fichier_source).charger();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	static public ItemFactory getInstance(){
		return instance;
		
	}

	/**
	 * Fabrique un item avec un uid unique et un nom de produit unique. (le nom
	 * de produit est ridicule c'est garantie!).
	 * 
	 * @return le nouvel item.
	 */
	public Item getNewItem() {
		Item retItem;

		// on choisit le type d'item au hasard
		TypeItem[] types = TypeItem.values();
		int nombreDeType = types.length;
		TypeItem type = types[(int) (Math.random() * nombreDeType)];

		// On choisit le poids au hasard
		float poids = (float) (Math.random() * 99 + 1);

		retItem = new Item(mots.get(uidCount), uidCount++, "fabriquant" + (uidCount % 25), new Date(), type, poids);
		return retItem;
	}

	/**
	 * Fabrique "nombre" de nouveaux items.
	 * @param nombre d'items à fabriquer
	 * 
	 */
	public List<Item> getnewItems(int nombre){
		List<Item> retList = new ArrayList<>(nombre);
		
		for(int i=0; i< nombre; i++){
			retList.add(this.getNewItem());
		}
		
		return retList;
	}

}
