import java.util.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

@RunWith (Parameterized.class)
public class MinTest {
    public List list;
    public Object minimum;
    public Class<? extends Exception> expectedException;


    @Rule
    public ExpectedException thrown = ExpectedException.none();


    public MinTest(List list, Object min, Class<? extends Exception> expectedException) {
        this.list = list;
        this.minimum = min;
        this.expectedException = expectedException;
    }
    

    @Parameters
    public static Collection<Object[]> minValues() {
        return Arrays.asList(new Object [][] {
            {new ArrayList<>(Arrays.asList(1)), 1, null},           // Single Element
            {new ArrayList<>(Arrays.asList(1, 2, 3)), 1, null},     // First element min
            {new ArrayList<>(Arrays.asList(2, 1, 3)), 1, null},     // Mid element min
            {new ArrayList<>(Arrays.asList(2, 3, 1)), 1, null},     // Last element min
            {new ArrayList<>(Arrays.asList(-1, 0, 1)), -1, null},   // Negative
            {new ArrayList<>(Arrays.asList("cat", "dog")), "cat", null},    // String
            {new ArrayList<>(Arrays.asList(null, "dog")), -1, NullPointerException.class},  // null element in list
            {new ArrayList<>() { {add(null);} }, -1, NullPointerException.class},           // only null element in list
            {new ArrayList<>(), -1, IllegalArgumentException.class},        // Empty list
            {null, -1, NullPointerException.class},                 // Null list
            {new ArrayList<>(Arrays.asList("cat", 1)), -1, ClassCastException.class},       // Different types
            
        });
    }

    @Test
    public void testMin() {
        if (expectedException != null ){
            thrown.expect(expectedException);
        }

        assertTrue("test Min", minimum == Min.min(list));
    }
}
