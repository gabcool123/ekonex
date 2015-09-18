/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climoilou.entrepot.rechercheSimple.critere;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import climoilou.entrepot.items.Item;
import climoilou.entrepot.items.TypeItem;
import climoilou.entrepot.rechercheSimple.critere.MemeIDCritere;
import climoilou.entrepot.rechercheSimple.critere.CritereRechercheSimple.OrAndNot;

/**
 *
 * @author Martin Simoneau
 */
public class MemeIDCritereTest {
	private List<Item> source1;

	public MemeIDCritereTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws IOException, URISyntaxException {
		// ChargeurDeDonness cd = new
		// ChargeurDeDonness("liste.de.mots.francais.frgut.utf8.txt");
		// List<String> mots = cd.charger();

		source1 = new ArrayList<>();
		for (int i = 1; /* i < mots.size() && */ i < 200; i++) {
			// String mot = mots.get(i);
			source1.add(new Item("nom" + i, i, "fabriquant", new Date(i), TypeItem.ARTICLE_CAMPING, i));
		}
	}

	@After
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	@Test
	public void getElementTrouveTest() {

		MemeIDCritere crit0 = new MemeIDCritere(-5, source1, OrAndNot.OR);
		MemeIDCritere crit1 = new MemeIDCritere(0, source1, OrAndNot.OR);
		MemeIDCritere crit2 = new MemeIDCritere(1, source1, OrAndNot.OR);
		MemeIDCritere crit3 = new MemeIDCritere(50, source1, OrAndNot.OR);
		MemeIDCritere crit4 = new MemeIDCritere(200, source1, OrAndNot.OR);
		MemeIDCritere crit5 = new MemeIDCritere(250, source1, OrAndNot.OR);

		Item item2 = new Item("nom" + 1, 1, "fabriquant", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		Item item3 = new Item("nom" + 50, 50, "fabriquant", new Date(50), TypeItem.ARTICLE_CAMPING, 50);

		Set<Item> resultat0 = crit0.getElementsTrouves();
		assertTrue(resultat0.size() == 0);
		Set<Item> resultat1 = crit1.getElementsTrouves();
		assertTrue(resultat1.size() == 0);
		Set<Item> resultat2 = crit2.getElementsTrouves();
		assertTrue(resultat2.size() == 1);
		assertTrue(resultat2.contains(item2));
		Set<Item> resultat3 = crit3.getElementsTrouves();
		assertTrue(resultat3.size() == 1);
		assertTrue(resultat3.contains(item3));
		Set<Item> resultat4 = crit4.getElementsTrouves();
		assertTrue(resultat4.size() == 0);
		Set<Item> resultat5 = crit5.getElementsTrouves();
		assertTrue(resultat5.size() == 0);

	}

	@Test
	public void getJointureTest() {
		MemeIDCritere crit0 = new MemeIDCritere(1, source1, OrAndNot.OR);
		MemeIDCritere crit1 = new MemeIDCritere(2, source1, OrAndNot.AND);
		MemeIDCritere crit2 = new MemeIDCritere(3, source1, OrAndNot.NOT);

		assertTrue(crit0.getJointure() == OrAndNot.OR);
		assertTrue(crit1.getJointure() == OrAndNot.AND);
		assertTrue(crit2.getJointure() == OrAndNot.NOT);
	}
}
