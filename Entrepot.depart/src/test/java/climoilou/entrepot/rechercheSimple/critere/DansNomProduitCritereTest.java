package climoilou.entrepot.rechercheSimple.critere;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
import climoilou.entrepot.rechercheSimple.critere.CritereRechercheSimple.OrAndNot;
import climoilou.entrepot.util.ChargeurDeDonnees;

public class DansNomProduitCritereTest {
	private List<Item> source1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws IOException, URISyntaxException {
		ChargeurDeDonnees cd = new ChargeurDeDonnees("liste.de.mots.francais.frgut.utf8.txt");
		List<String> mots = cd.charger();

		source1 = new ArrayList<>(2000);
		for (int i = 1; i < mots.size() && i < 10000; i++) {
			String mot = mots.get(i);
			source1.add(new Item(mot + i, i, "fabriquant", new Date(i), TypeItem.ARTICLE_CAMPING, i));
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getElementTrouveTest() {

		DansNomProduitCritere crit0 = new DansNomProduitCritere("bat", source1, OrAndNot.OR);
		DansNomProduitCritere crit1 = new DansNomProduitCritere("aba", source1, OrAndNot.OR);
		DansNomProduitCritere crit2 = new DansNomProduitCritere("ann", source1, OrAndNot.OR);
		DansNomProduitCritere crit3 = new DansNomProduitCritere("tro", source1, OrAndNot.OR);
		DansNomProduitCritere crit4 = new DansNomProduitCritere("ail", source1, OrAndNot.OR);
		DansNomProduitCritere crit5 = new DansNomProduitCritere("rio", source1, OrAndNot.OR);

		Item item2 = new Item("nom" + 1, 1, "fabriquant", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		Item item3 = new Item("nom" + 50, 50, "fabriquant", new Date(50), TypeItem.ARTICLE_CAMPING, 50);

		Set<Item> resultat0 = crit0.getElementsTrouves();
		// assertTrue(resultat0.size() == 0);
		Set<Item> resultat1 = crit1.getElementsTrouves();
		// assertTrue(resultat1.size() == 0);
		Set<Item> resultat2 = crit2.getElementsTrouves();
		// assertTrue(resultat2.size() == 1);
		// assertTrue(resultat2.contains(item2));
		Set<Item> resultat3 = crit3.getElementsTrouves();
		// assertTrue(resultat3.size() == 1);
		// assertTrue(resultat3.contains(item3));
		Set<Item> resultat4 = crit4.getElementsTrouves();
		// assertTrue(resultat4.size() == 0);
		Set<Item> resultat5 = crit5.getElementsTrouves();
		// assertTrue(resultat5.size() == 0);

	}

}
