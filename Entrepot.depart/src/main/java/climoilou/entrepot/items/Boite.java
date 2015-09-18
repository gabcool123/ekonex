package climoilou.entrepot.items;

import java.util.Date;

public class Boite extends Item  {

	private static final long serialVersionUID = -5794447797509201863L;

	private float poids;
	private boolean ouverte;

	public Boite(String nom, int uID, String fabriquant,
			Date dateDernierInventaire, TypeItem type, float poids) {
		super(nom, uID, fabriquant, dateDernierInventaire, type, poids);
		this.poids = poids;
		this.ouverte = false;
	}

	public boolean isOuverte() {
		return ouverte;
	}

	public void ouvre() {
		this.ouverte = true;
	}

	public void ferme() {
		this.ouverte = false;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}





	public String toString() {
		String retVal = "Boite " + (ouverte ? "ouverte " : "fermée ") + "("
				+ poids + "Kg, " + ") contenant: \n";
		return retVal + "\n";
	}
}
