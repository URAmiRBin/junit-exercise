import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CalcTest {
    @DataPoints
    public static int[] firsts = {1, 2};

    @DataPoints
    public static int[] seconds = {2, 1};
    
    @Theory
    public void symmetricProperty(int a, int b) {
        assertEquals(Calc.add(a, b), Calc.add(b, a));
    }

    @Test
    public void testAdd() {
        assertEquals(5, Calc.add(2, 3));
    }
}