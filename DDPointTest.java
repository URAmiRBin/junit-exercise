import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class DDPointTest {
    @DataPoints
    public static Object[] p = {
        new Point(2, 3),
        new Point(3, 4),
        new Point(1, 1),
        null,
        2
    };

    @Theory
    public void ReflexiveProperties(Point a) {
        assumeTrue(a != null);
        
        assertTrue(a.equals(a));
    }

    @Theory
    public void symmetricProperty(Point a, Point b) {
        assumeTrue(a != null);
        assumeTrue(b != null);

        assertEquals(a.equals(b), b.equals(a));
    }

    @Theory
    public void transitiveProperty(Point a, Point b, Point c) {
        assumeTrue(a != null);
        assumeTrue(b != null);
        assumeTrue(c != null);

        assumeTrue(a.equals(b));
        assumeTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Theory
    public void hashCodeIsEqual(Point a, Point b) {
        assumeTrue(a != null);
        assumeTrue(b != null);

        assumeTrue(a.equals(b));

        assertEquals(a.hashCode(), b.hashCode());
    }
}
