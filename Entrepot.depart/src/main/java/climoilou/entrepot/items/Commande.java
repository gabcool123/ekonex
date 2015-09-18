package climoilou.entrepot.items;

import java.util.Date;

public class Commande {
	private Date dateCommande;
	private Date dateExpedition;
	
	
	public Commande() {
		super();
		this.dateCommande = new Date(); // maintenant!
		this.dateExpedition = null;
	}
	
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
		this.dateExpedition = null;
	}

	public String toString(){
		return "<date de commande: "+dateCommande+" date expédition: " +dateExpedition+">" ;
	}


	public void setDateExpedition(Date dateExpedition) {
		this.dateExpedition = dateExpedition;
	}
	
	
}
