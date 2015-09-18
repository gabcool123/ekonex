package climoilou.entrepot.rechercheSimple.critere;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AbstractCritereRechercheSimpleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContains() {
		
		assertTrue(AbstractCritereRechercheSimple.contains("abcdefghijklmnop", "abc"));
		assertTrue (AbstractCritereRechercheSimple.contains("abcdefghijklmnop", "fgh"));
		assertTrue (AbstractCritereRechercheSimple.contains("abcdefghijklmnop", "mnop"));
		assertFalse(AbstractCritereRechercheSimple.contains("abcdefghijklmnop", "bca"));
		assertFalse(AbstractCritereRechercheSimple.contains("abcdefghijklmnop", "hgf"));
		assertFalse(AbstractCritereRechercheSimple.contains("abcdefghijklmnop", "po"));


	}
	
	


}
