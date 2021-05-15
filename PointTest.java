import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
    private Point p;

    @Before
    public void setUp() {
        p = new Point(2, 3);
    }

    @After
    public void tearDown() {
        p = null;
    }

    @Test
    public void testSelfEqual() {
        assertEquals(true, p.equals(p));
    }

    @Test
    public void testNull() {
        assertEquals(false, p.equals(null));
    }

    @Test
    public void testOnePropertyEqual() {
        assertEquals(false, p.equals(new Point(2, 2)));
    }

    @Test
    public void testBothPropertyEqual() {
        assertEquals(true, p.equals(new Point(2, 3)));
    }
}
