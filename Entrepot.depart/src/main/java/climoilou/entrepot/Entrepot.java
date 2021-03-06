package climoilou.entrepot;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import climoilou.entrepot.items.Boite;
import climoilou.entrepot.items.Commande;
import climoilou.entrepot.items.Item;
import climoilou.entrepot.items.Item.Where;
import climoilou.entrepot.items.TypeItem;

public class Entrepot {

	public static final int TAILLE_RANGEE = 5;
	public static final String CHEMIN_DEFAUT = ".";
	public static final char RANGEE_MIN = 'A';
	

	public static final char RANGEE_MAX = 'Z';
	public static final int CAPACITE_MAX_SECTION_PETITE_ETAGERE = 50;
	public static final String HISTORY_EXPEDITION_FILE_NAME = "expedition";
	public static final String HISTORY_FILE_EXT = ".ser";
	
	public static final Character CLE [] = {RANGEE_MIN,'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y',RANGEE_MAX};
	 

	// list, stack, queue, deque, map, set,
	// Les collections utilisées dans le projet d'entrepôt
	private EnumMap<TypeItem, Map<Character[], LinkedList<Item>>> grandeEtageres; // TODO
	private Map<String, Stack<Item>> petiteEtagere;// TODO choisir le type

	private Set<Item> surplus;
	private Queue<Item> sectionDechargement;
	private Queue<Item> sectionExpedition;

	public Entrepot() {
		// Allouez les difféentes sections de l'entrepôt.
		// ATTENTION: les section de la petite étagère (par nom de fabriquant)
		// sont allouées au besoin (lazy).
		super();
		
		
		grandeEtageres = new EnumMap<TypeItem, Map<Character[], LinkedList<Item>>>(TypeItem.class);
		Map<Character[], LinkedList<Item>> articleSport = new HashMap<Character[], LinkedList<Item>>();
		Map<Character[], LinkedList<Item>> articleCamping = new HashMap<Character[], LinkedList<Item>>();
		Map<Character[], LinkedList<Item>> vetements = new HashMap<Character[], LinkedList<Item>>();
		articleSport.put(CLE, null);
		articleCamping.put(CLE, null);
		vetements.put(CLE, null);
		
		
		surplus = new HashSet<Item>();
		sectionDechargement = new LinkedList<Item>();
		sectionExpedition = new LinkedList<Item>();
	}

	@Override
	public String toString() {
		String retVal;
		retVal = "Section déchargement: \n" + sectionDechargement.toString() + "\n";
		retVal += "Grande étagères: \n " + grandeEtageres.toString() + "\n";
		retVal += "Petite étagères: \n " + petiteEtagere.toString() + "\n";
		retVal += "Expédition: \n" + sectionExpedition.toString() + "\n\n";
		return retVal;
	}

	/**
	 * On vide la section expedition. On place tous les items de l'expédition
	 * dans un fichier d'historique "expedition.ser". Si le fichier existe déjà
	 * on ajoute un incrément entre le nom et l'Extension ex: expedition1.ser
	 * expedition2.ser jusqu'à ce qu'on trouve un fichier qui n'existe pas. On
	 * enlève les items au fur et à mesure qu'il sont écrit dans le fichier
	 * d'historique.
	 * 
	 * @return le nom du fichier utilisé pour la sérialisation
	 */
	public String expedie() {
		String fileName = null;
		int numFichier = 0;
		
		try {
			fileName = ("%sytem root%\\Temp\\" + HISTORY_EXPEDITION_FILE_NAME + numFichier + HISTORY_FILE_EXT);
			File file = new File(fileName);

			while (file.exists()) {
				fileName = ("%sytem root%\\Temp\\" + HISTORY_EXPEDITION_FILE_NAME + (numFichier++) + HISTORY_FILE_EXT);
			}

			FileOutputStream fos = new FileOutputStream("%System root%\\Temp\\" + fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			while (sectionExpedition != null) {
				oos.writeObject(sectionExpedition.peek());
				sectionExpedition.poll();
			}

			bos.flush();
			oos.close();
		} catch (IOException e) {
			System.out.println("Sérialisation non effectuée");
		}

		System.out.println("Sérialisation réussie");

		System.exit(0);

		return fileName;
	}

	/**
	 * Ajoute plusieurs items dans la section de déchargement
	 * 
	 * @param items
	 *            les items ajoutés
	 * @return vrai si tous les items ont pu être déchargés.
	 */
	public boolean ajouteItems(Item... items) {
		boolean retVal = true;
		for (Item item : items) {
			retVal &= sectionDechargement.offer(item);
			item.setOu(Where.DECHARGEMENT);
		}
		return retVal;
	}

	/**
	 * Marque les items reçus en paramètres pour la commande. Les items
	 * partiront à la prochaine expédition
	 * 
	 * @param items
	 *            les items commandés
	 */
	public void commandeItem(Item... items) {

		for (Item item : items) {
			item.setCommande(new Commande());
		}
		System.out.println(items.length);

	}

	/**
	 * Effectue le roulement des items. Déchargement de la section débarquement,
	 * classement dans l'entrepôt et expédition des items marqués.
	 */
	public void traiteEntrepot() {
		videDechargement();
		prepareExpedition();
		// On retourne les surplus
		for (Item item : surplus) {
			sectionExpedition.offer(item);
		}
	}

	/**
	 * Place les items marqués pour la commande dans la file de l'expédition.
	 */
	private void prepareExpedition() {

		/*
		 * //Pour chaque type d'items for (TypeItem type :
		 * grandeEtageres.keySet()){ //On doit rechercher dans les list pour
		 * trouver les boites marquées
		 * 
		 * }
		 */

		/*for (Item item : grandeEtageres.get(.getNomDeProduit().charAt(0)).get(1)) {

			if (item.getCommande() != null) {
				Commande commande = item.getCommande();
				commande.setDateExpedition(new Date());
				sectionExpedition.offer(item);
				item.setOu(Where.EXPEDITION);
				item.getConetenantReference().remove(item);
			}
		}*/

		for (Item item : petiteEtagere.get(1)) {
			if (item.getCommande() != null) {
				Commande commande = item.getCommande();
				commande.setDateExpedition(new Date());
				sectionExpedition.offer(item);
				item.setOu(Where.EXPEDITION);
				petiteEtagere.get(item).pop();
			}
		}
	}

	/**
	 * Retire les item de la section dechargement et on les places au bon
	 * endroit.
	 */
	private void videDechargement() {
		// TODO programmez cette méthode

		for (Item item : sectionDechargement) {
			System.out.println(item.getClass().getSimpleName());
			
			if (item.getClass().getSimpleName().equals("Boite")) {
				System.out.println("boite");
				if (item.getType().equals(TypeItem.ARTICLE_CAMPING)) {
					grandeEtageres.get(TypeItem.ARTICLE_CAMPING).get(item.getNomDeProduit().charAt(0)).add(item);
					item.setOu(Where.GRANDE_ETAGERE);
					item.setConetenantReference(grandeEtageres.get(TypeItem.ARTICLE_CAMPING).get(item.getNomDeProduit().charAt(0)));
					sectionDechargement.poll();
				}

				else if (item.getType().equals(TypeItem.ARTICLE_SPORT)) {
					grandeEtageres.get(TypeItem.ARTICLE_SPORT).get(item.getNomDeProduit().charAt(0)).add(item);
					item.setOu(Where.GRANDE_ETAGERE);
					sectionDechargement.poll();
				}

				else {
					grandeEtageres.get(TypeItem.VETEMENT).get(item.getNomDeProduit().charAt(0)).add(item);
					item.setOu(Where.GRANDE_ETAGERE);
					sectionDechargement.poll();
				}
			}
			

			else {
				if (petiteEtagere.get(item.getFabriquant()).size() <= 50) {
					petiteEtagere.get(item.getFabriquant()).push(item);
					item.setOu(Where.PETITE_ETAGERE);
					sectionDechargement.poll();
				}

				else {
					surplus.add(item);
					item.setOu(Where.SURPLUS);
				}
				
				
			}
		}

	}

	/**
	 * Retourne tous les items qui sont dans l'entrepot.
	 */
	public List<Item> getToutItemDansEntrepot() {
		List<Item> retList = new LinkedList<>();

		return retList;
	}

	/**
	 * On récupère l'historique correpondant au nom de fichier reçu en
	 * paramètre. La méthode retourne l'ensemble des items que contient le
	 * fichier
	 * 
	 * @param fileName
	 *            le nom du fichier à lire
	 * @return un ensemble contenant tous les objets du fichier.
	 */
	public static Set<Item> unserializeHistory(String fileName) {
		Set<Item> retSet = new HashSet<>();

		// TODO programmez cette méthode
		return retSet;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grandeEtageres == null) ? 0 : grandeEtageres.hashCode());
		result = prime * result + ((petiteEtagere == null) ? 0 : petiteEtagere.hashCode());
		result = prime * result + ((surplus == null) ? 0 : surplus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrepot other = (Entrepot) obj;
		if (grandeEtageres == null) {
			if (other.grandeEtageres != null)
				return false;
		} else if (!grandeEtageres.equals(other.grandeEtageres))
			return false;
		if (petiteEtagere == null) {
			if (other.petiteEtagere != null)
				return false;
		} else if (!petiteEtagere.equals(other.petiteEtagere))
			return false;
		if (surplus == null) {
			if (other.surplus != null)
				return false;
		} else if (!surplus.equals(other.surplus))
			return false;
		return true;
	}

	// Uniquement pour les tests! ne pas utiliser ailleurs
	// TODO ajouter des méthode package pour vérifier vos tests

}