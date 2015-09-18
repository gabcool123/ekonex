package climoilou.entrepot.items;

import java.util.Collection;
import java.util.Date;

public class Item  {

	public enum Where {
		DECHARGEMENT, GRANDE_ETAGERE, PETITE_ETAGERE, SURPLUS, EXPEDITION 
	};

	private static final long serialVersionUID = 4787832840454357431L;

	private int UID;
	private String fabriquant;
	private String nomDeProduit;
	private TypeItem type;
	private Date dateDernierInventaire;
	private float poids;
	private Where ou;
	private Commande commande;
	private Collection<Item> ConetenantReference;

	// ajouter le lieu où l'item se trouve dans l'entrepôt


	public Item(String nom, int uID, String fabriquant, Date dateDernierInventaire, TypeItem type, float poids) {
		super();
		UID = uID;
		this.fabriquant = fabriquant;
		this.dateDernierInventaire = dateDernierInventaire;
		this.type = type;
		this.nomDeProduit = nom;
		this.poids = poids;
		this.commande = null;

	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getFabriquant() {
		return fabriquant;
	}

	public void setFabriquant(String fabriquant) {
		this.fabriquant = fabriquant;
	}

	public Date getDateDernierInventaire() {
		return dateDernierInventaire;
	}

	public void setDateDernierInventaire(Date dateDernierInventaire) {
		this.dateDernierInventaire = dateDernierInventaire;
	}

	public TypeItem getType() {
		return type;
	}

	public void setType(TypeItem type) {
		this.type = type;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public String getNomDeProduit() {
		return nomDeProduit;
	}

	public void setNomDeProduit(String nomDeProduit) {
		this.nomDeProduit = nomDeProduit;
	}

	public String toString() {
		String retVal;
		String commandeString="";
		if(commande!=null){
			commandeString=commande.toString();
		}
		retVal = "" + nomDeProduit + " " + type + " " + "(UID " + UID + " " + fabriquant + " " + dateDernierInventaire
				+ ") " + poids + " Kg\n";
		return retVal;
	}

	public Where getOu() {
		return ou;
	}

	public void setOu(Where ou) {
		this.ou = ou;
	}

	public Collection<Item> getConetenantReference() {
		return ConetenantReference;
	}

	public void setConetenantReference(Collection<Item> conetenantReference) {
		ConetenantReference = conetenantReference;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
