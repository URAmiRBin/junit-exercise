import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RemoveTest {
    List<Integer> list;
    int length;

    @Before
    public void setUp() {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        length = 3;
    }

    @After
    public void tearDown() {
        list = null;
        length = -1;
    }

    @Test
    public void testTT() {
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        // Next is called and remove is not called yet

        iterator.remove();
        assertEquals(length - 1, list.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testTF() {
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.remove();
        // Next is called and remove is also called

        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void testF() {
        Iterator<Integer> iterator = list.iterator();
        // Next is not called

        iterator.remove();
    }

    
}