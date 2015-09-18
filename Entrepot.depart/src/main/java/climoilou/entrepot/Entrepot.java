package climoilou.entrepot;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import climoilou.entrepot.items.Item;
import climoilou.entrepot.items.Item.Where;

public class Entrepot {

	public static final int TAILLE_RANGEE = 5;
	public static final String CHEMIN_DEFAUT = ".";
	public static final char RANGEE_MIN = 'A';
	public static final char RANGEE_MAX = 'Z';
	public static final int CAPACITE_MAX_SECTION_PETITE_ETAGERE = 50;
	public static final String HISTORY_EXPEDITION_FILE_NAME = "expedition";
	public static final String HISTORY_FILE_EXT = ".ser";

	// list, stack, queue, deque, map, set,
	// Les collections utilisées dans le projet d'entrepôt
	private List<Item> grandeEtageres; // TODO choisir le type
	private Stack<Item> petiteEtagere;// TODO choisir le type
	
	private Set<Item> surplus;
	private Queue<Item> sectionDechargement;
	private Queue<Item> sectionExpedition;

	public Entrepot() {
		super();
		// Allouez les différentes sections de l'entrepôt.
		// ATTENTION: les sections de la petite étagère (par nom de fabriquant)
		// sont allouées au besoin (lazy).
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
		
		try
		{
			while (fileName)
			fileName = HISTORY_EXPEDITION_FILE_NAME + HISTORY_FILE_EXT;
			
			
			FileOutputStream fos = new FileOutputStream("D:\\DEC\\TP1\\Entrepot.depart\\données\\" + fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			while (sectionExpedition != null)
			{	
				oos.writeObject(sectionExpedition.peek());
				sectionExpedition.poll();	
			}
			
			bos.flush();
			oos.close();
		}
		catch (IOException e)
		{
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
		// TODO On marque les items pour la commande
		// la date actuelle sert automatiquement de date de commande

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
		//TODO programmer cette méthode
		// ATTENTION à n'utilisez que les méthodes permise avec la pile


	}

	/**
	 * Retire les item de la section dechargement et on les places au bon
	 * endroit.
	 */
	private void videDechargement() {
		//TODO programmez cette méthode

	}

	/**
	 * Retourne tous les items qui sont dans l'entrepot.
	 */
	public List<Item> getToutItemDansEntrepot() {
		List<Item> retList = new LinkedList<>();
		// TODO programmez cette méthode


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

	// Uniquement pour les tests! ne pas utiliser ailleurs
	// TODO ajouter des méthode package pour vérifier vos tests

}
