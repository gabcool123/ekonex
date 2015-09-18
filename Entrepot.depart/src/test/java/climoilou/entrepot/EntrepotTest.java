package climoilou.entrepot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import climoilou.entrepot.items.Boite;
import climoilou.entrepot.items.Item;
import climoilou.entrepot.items.TypeItem;

public class EntrepotTest {
	private static Item item1;
	private static Item item2;
	private static Item item3;
	private static Item item4;
	private static Item item5;
	private static Item item6;
	
	private static Item item7;// pas dans la petite etagere
	 
	private static Boite boite1;
	private static Boite boite2;
	private static Boite boite3;
	private static Boite boite4;
	private static Boite boite5;
	private static Boite boite6;
	
	private static Boite boite7;// pas dans la grande etagere
	
	

	@Before
	public void createObjects() {
		item1 = new Item("item1", 1, "fabA", new Date(0), TypeItem.ARTICLE_CAMPING, 4.0f);
		item2 = new Item("item2", 2, "fabA", new Date(10000), TypeItem.ARTICLE_SPORT, 5.0f);
		item3 = new Item("item3", 3, "fabB", new Date(20000), TypeItem.VETEMENT, 6.0f);
		item4 = new Item("item4", 4, "fabA", new Date(0), TypeItem.ARTICLE_CAMPING, 4.0f);
		item5 = new Item("item5", 5, "fabA", new Date(10000), TypeItem.ARTICLE_SPORT, 5.0f);
		item6 = new Item("item6", 6, "fabB", new Date(20000), TypeItem.VETEMENT, 6.0f);
		
		item7 = new Item("item7", 7, "fabC", new Date(20000), TypeItem.VETEMENT, 7.0f);

		
		boite1 = new Boite("boite1", 101, "fabA", new Date(0), TypeItem.ARTICLE_CAMPING, 4.0f);
		boite2 = new Boite("boite2", 102, "fabA", new Date(10000), TypeItem.ARTICLE_CAMPING, 5.0f);
		boite3 = new Boite("paquet3", 103, "fabB", new Date(20000), TypeItem.ARTICLE_CAMPING, 6.0f);
		boite4 = new Boite("boite1", 104, "fabA", new Date(0), TypeItem.ARTICLE_SPORT, 4.0f);
		boite5 = new Boite("boite2", 105, "fabA", new Date(10000), TypeItem.ARTICLE_SPORT, 5.0f);
		boite6 = new Boite("emballage3", 106, "fabB", new Date(20000), TypeItem.ARTICLE_SPORT, 6.0f);
		
		boite7 = new Boite("emballage5", 107, "fabC", new Date(20000), TypeItem.VETEMENT, 7.0f);

	}

	@Test
	public void ConstructorGrandeSectionTest() {
		Entrepot entrepot = new Entrepot();

		//TODO assurez-vous que l'entrepot contient toutes les éléments nécessaires
		// Ajoutez au besoin les accesseurs nécessaires dans la classe entrepôt.
	}

	@Test
	public void ConstructorSectionGrandeEtagereTest() {
		Entrepot entrepot = new Entrepot();
		//TODO Assurez-vous que la seciton grande étagère est complète

	}

	@Test
	public void ajouteUnItemTest() {
		Entrepot entrepot = new Entrepot();

		Item item1 = new Item("item1", 1, "fabA", new Date(0), TypeItem.ARTICLE_CAMPING, 4.0f);

		entrepot.ajouteItems(item1);
		//TODO Assurez-vous que l'item a bien été ajouté.


	}

	@Test
	public void ajouteTroisItemTest() {
		Entrepot entrepot = new Entrepot();

		Item item1 = new Item("item1", 1, "fabA", new Date(0), TypeItem.ARTICLE_CAMPING, 4.0f);
		Item item2 = new Item("item2", 2, "fabA", new Date(10000), TypeItem.ARTICLE_CAMPING, 5.0f);
		Item item3 = new Item("item3", 3, "fabB", new Date(20000), TypeItem.ARTICLE_CAMPING, 6.0f);

		entrepot.ajouteItems(item1, item2, item3);
		//TODO  Assurez-vous que tous les items ont été saisis.

	}

	@Test
	public void ajoutePlusieursItemTest() {
		Entrepot entrepot = new Entrepot();

		Item items[] = { item1, item2, item3 };

		entrepot.ajouteItems(items);

		//TODO  Assurez-vous que tout est conforme
	}

	@Test
	public void commandeItemTest() {
		Entrepot entrepot = new Entrepot();

		entrepot.commandeItem(boite1, boite4);

		//TODO  Assurez-vous que tout est conforme
	}
	
	@Test 
	public void getToutItemDansEntrepotTest(){
		Entrepot entrepot = new Entrepot();
		// TODO insérez des données connus dans l'entrepôt
		entrepot.ajouteItems(item7, boite7);
		
		List<Item> toutItems = entrepot.getToutItemDansEntrepot();
		
		//TODO  Assurez-vous que tout est conforme
	}
	
	@Test 
	public void traiteEntrepotFunctionalTest(){
		Entrepot entrepot = new Entrepot();
		
		entrepot.ajouteItems(item1);
		entrepot.ajouteItems(boite1);
		entrepot.ajouteItems(item2);
		entrepot.ajouteItems(boite2);	
		entrepot.traiteEntrepot();
		//TODO  Assurez-vous que tout est conforme
		
		entrepot.ajouteItems(item3);
		entrepot.ajouteItems(boite3);
		entrepot.ajouteItems(item4);
		entrepot.ajouteItems(boite4);
		entrepot.commandeItem(item1);
		entrepot.commandeItem(boite1);
		entrepot.traiteEntrepot();
		//TODO  Assurez-vous que tout est conforme
		
		entrepot.expedie();
		//TODO  Assurez-vous que l'entrepôt est vide
		
	}
	
	@Test 
	public void expedieTest(){
		Entrepot entrepot = new Entrepot();
		entrepot.ajouteItems(item1);
		entrepot.ajouteItems(boite1);
		entrepot.ajouteItems(item2);
		entrepot.ajouteItems(boite2);
		entrepot.ajouteItems(item3);
		entrepot.ajouteItems(boite3);
		entrepot.ajouteItems(item4);
		entrepot.ajouteItems(boite4);
		entrepot.traiteEntrepot();
		entrepot.commandeItem(item1);
		entrepot.commandeItem(boite1);
		entrepot.commandeItem(item1);
		entrepot.commandeItem(item2);
		entrepot.commandeItem(item3);
		entrepot.commandeItem(item4);
		entrepot.commandeItem(boite1);
		entrepot.commandeItem(boite2);
		entrepot.commandeItem(boite3);
		entrepot.commandeItem(boite4);
		entrepot.traiteEntrepot();
		String fileName = entrepot.expedie();
		Set<Item> historique = entrepot.unserializeHistory(fileName);
		// TODO Vérifier que tous les objets ont été récupérés
	}
	
	
	
	// méthodes utilitaires -------------------------------------------------------------------

	//TODO si vous avez besoin de traitements supplémentaires.
}
