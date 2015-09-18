/**
 * 
 */
package climoilou.entrepot.rechercheSimple;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import climoilou.entrepot.items.Item;
import climoilou.entrepot.items.TypeItem;
import climoilou.entrepot.rechercheSimple.MoteurRechercheSimple;
import climoilou.entrepot.rechercheSimple.critere.CritereRechercheSimple;

/**
 * @author Martin Simoneau
 *
 */
public class MoteurRechercheSimpleTest {

	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Item item6;
	private Item item7;
	private Item item8;
	private Item item9;
	private Item item11;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {


		item1 = new Item("item1", 1, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item2 = new Item("item2", 2, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item3 = new Item("item3", 3, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item4 = new Item("item4", 4, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item5 = new Item("item5", 5, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item6 = new Item("item6", 6, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item7 = new Item("item7", 7, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item8 = new Item("item8", 8, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item9 = new Item("item9", 9, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);
		item11 = new Item("item11", 11, "fab", new Date(1), TypeItem.ARTICLE_CAMPING, 1);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test method for
	 * {@link climoilou.entrepot.rechercheSimple.MoteurRechercheSimple#recherche()}.
	 */
	@Test
	public void testRechercheET() {
		MoteurRechercheSimple mr = new MoteurRechercheSimple();
		mr.addCritere(new DumbCritereBASE());// or en premier pour mettre un
												// ensemble de base
		mr.addCritere(new DumbCritereAND());// or en premier pour mettre un
											// ensemble de base

		Collection<Item> reponse = mr.recherche();
		assertTrue(reponse.size() == 3);
		assertTrue(reponse.contains(item4));
		assertTrue(reponse.contains(item5));
		assertTrue(reponse.contains(item6));
	}

	/**
	 * Test method for
	 * {@link climoilou.entrepot.rechercheSimple.MoteurRechercheSimple#recherche()}.
	 */
	@Test
	public void testRechercheOU() {
		MoteurRechercheSimple mr = new MoteurRechercheSimple();
		mr.addCritere(new DumbCritereBASE());// or en premier pour mettre un
												// ensemble de base
		mr.addCritere(new DumbCritereOR());// or en premier pour mettre un
											// ensemble de base

		Collection<Item> reponse = mr.recherche();
		assertTrue(reponse.size() == 10);
		assertTrue(reponse.contains(item1));
		assertTrue(reponse.contains(item2));
		assertTrue(reponse.contains(item3));
		assertTrue(reponse.contains(item4));
		assertTrue(reponse.contains(item5));
		assertTrue(reponse.contains(item6));
		assertTrue(reponse.contains(item7));
		assertTrue(reponse.contains(item8));
		assertTrue(reponse.contains(item9));
		assertTrue(reponse.contains(item11));
	}

	/**
	 * Test method for
	 * {@link climoilou.entrepot.rechercheSimple.MoteurRechercheSimple#recherche()}.
	 */
	@Test
	public void testRechercheNOT() {
		MoteurRechercheSimple mr = new MoteurRechercheSimple();
		mr.addCritere(new DumbCritereBASE());// or en premier pour mettre un
												// ensemble de base
		mr.addCritere(new DumbCritereNOT());// or en premier pour mettre un
											// ensemble de base

		Collection<Item> reponse = mr.recherche();
		assertTrue(reponse.size() == 3);
		assertTrue(reponse.contains(item2));
		assertTrue(reponse.contains(item4));
		assertTrue(reponse.contains(item6));
	}

	/**
	 * Test method for
	 * {@link climoilou.entrepot.rechercheSimple.MoteurRechercheSimple#addCritere(climoilou.entrepot.rechercheSimple.critere.CritereRechercheSimple)}
	 * .
	 */
	@Test
	public void testAddCritere() {

	}

	// Classes stub pour tester
	// ******************************************************************************************************

	class DumbCritereBASE implements CritereRechercheSimple {
		@Override
		public Set<Item> getElementsTrouves() {
			HashSet<Item> retSet = new HashSet<>();
			retSet.add(item1);
			retSet.add(item2);
			retSet.add(item3);
			retSet.add(item4);
			retSet.add(item5);
			retSet.add(item6);
			return retSet;
		}

		@Override
		public OrAndNot getJointure() {
			return OrAndNot.OR;
		}

		@Override
		public String getCritere() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setJointure(OrAndNot nouvelle) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCritere(String nouveau) {
			// TODO Auto-generated method stub
			
		}
	}

	class DumbCritereAND implements CritereRechercheSimple {
		@Override
		public Set<Item> getElementsTrouves() {
			HashSet<Item> retSet = new HashSet<>();
			retSet.add(item4);
			retSet.add(item5);
			retSet.add(item6);
			retSet.add(item7);
			retSet.add(item8);
			retSet.add(item9);
			return retSet;
		}

		@Override
		public OrAndNot getJointure() {
			return OrAndNot.AND;
		}

		@Override
		public String getCritere() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setJointure(OrAndNot nouvelle) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCritere(String nouveau) {
			// TODO Auto-generated method stub
			
		}
	}

	class DumbCritereOR implements CritereRechercheSimple {

		@Override
		public Set<Item> getElementsTrouves() {
			HashSet<Item> retSet = new HashSet<>();
			retSet.add(item4);
			retSet.add(item5);
			retSet.add(item6);
			retSet.add(item7);
			retSet.add(item8);
			retSet.add(item9);
			retSet.add(item11);
			return retSet;
		}

		@Override
		public OrAndNot getJointure() {
			return OrAndNot.OR;
		}

		@Override
		public String getCritere() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setJointure(OrAndNot nouvelle) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCritere(String nouveau) {
			// TODO Auto-generated method stub
			
		}
	}

	class DumbCritereNOT implements CritereRechercheSimple {

		@Override
		public Set<Item> getElementsTrouves() {
			HashSet<Item> retSet = new HashSet<>();
			retSet.add(item1);
			retSet.add(item3);
			retSet.add(item5);
			retSet.add(item7);
			retSet.add(item9);
			retSet.add(item11);
			return retSet;
		}

		@Override
		public OrAndNot getJointure() {
			return OrAndNot.NOT;
		}

		@Override
		public String getCritere() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setJointure(OrAndNot nouvelle) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCritere(String nouveau) {
			// TODO Auto-generated method stub
			
		}
	}

}
