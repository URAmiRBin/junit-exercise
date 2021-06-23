import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoodFastCheapTest {
    GoodFastCheap instance;
    
    @Before
    public void setUp() {
        instance = new GoodFastCheap();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testTTF() {
        instance.makeGood();
        instance.makeFast();
        assertTrue(instance.isSatisfactory());
    }

    @Test
    public void testTFT() {
        instance.makeGood();
        instance.makeCheap();
        assertTrue(instance.isSatisfactory());
    }

    @Test
    public void testTFF() {
        instance.makeGood();
        assertFalse(instance.isSatisfactory());
    }

    @Test
    public void testFTF() {
        instance.makeFast();
        assertFalse(instance.isSatisfactory());
    }
}
