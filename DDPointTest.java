import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import org.junit.*;

@RunWith (Parameterized.class)
public class DDPointTest {
    public Point a;
    public Point b;
    public boolean equals;

    public DDPointTest(Point a, Point b, boolean result) {
        this.a = a;
        this.b = b;
        this.equals = result;
    }

    @Parameters
    public static Collection<Object[]> equalValues() {
        return Arrays.asList(new Object[][] {
            {new Point(2, 3), new Point(3, 3), false},
            {new Point(2, 3), new Point(2, 2), false},
            {new Point(2, 3), new Point(3, 2), false},
            {new Point(2, 3), new Point(2, 3), true},
        });
    }

    @Test
    public void equalsTest() {
        assertTrue("Equals Test", equals == a.equals(b));
    }
}
