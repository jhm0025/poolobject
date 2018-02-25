package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 *
 * ReusablePoolTest()
 * 
 * Clase Test que prueba la clase ReusablePool.
 *
 * @author Daniel Hernando Blanco
 * @author Joseba Hernando Moisen
 * 
 *         
 * 
 */
public class ReusablePoolTest {

	/**
	 * Pool con los objetos reusables
	 */
	private ReusablePool pool;
	private Reusable reu = null, reu2 = null;

	/**
	 * setUp()
	 * 
	 * Creamos la instancia pool para administrar los objetos reusable1 y reusable2.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		pool = ReusablePool.getInstance();
		
	}

	/**
     * tearDown()
     * 
     * Comprobamos que no existe otra instancia en el pool.
     * 
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
            pool = null;
    }

    /**
     * testGetInstance()
     * 
     * 
     * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
     */
    @Test
    public void testGetInstance() {

        assertEquals(pool, ReusablePool.getInstance());
    }

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
