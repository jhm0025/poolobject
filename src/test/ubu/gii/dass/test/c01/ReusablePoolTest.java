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
	 * testAcquireReusable()
	 * 
	 * 
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * @throws NotFreeInstanceException 
	 * @throws DuplicatedInstanceException 
	 */
	@Test
	public void testAcquireReusable() throws NotFreeInstanceException, DuplicatedInstanceException {
		
		reu = pool.acquireReusable();
		reu2 = pool.acquireReusable();
					
		assertEquals(pool.acquireReusable(), null);
				
		pool.releaseReusable(reu);
		assertEquals(reu, pool.acquireReusable());
		
		}


    /**
     * testReleaseReusable()
     * 
     * Test method for
     * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
     * @throws NotFreeInstanceException 
     * 
     * @throws DuplicatedInstanceException
     * 
     */
    @Test
    public void testReleaseReusable() throws NotFreeInstanceException, DuplicatedInstanceException {

        reu = pool.acquireReusable();
        reu2 = pool.acquireReusable();     

        try {
            pool.releaseReusable(null);
            pool.releaseReusable(reu);
            pool.releaseReusable(reu2);
            pool.releaseReusable(reu2);
        } catch (DuplicatedInstanceException e) {
            assertEquals("Ya existe esa instancia en el pool.", e.getMessage());

        } 
    }

}
