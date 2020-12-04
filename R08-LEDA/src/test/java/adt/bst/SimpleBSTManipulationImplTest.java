package adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleBSTManipulationImplTest {

    private SimpleBSTManipulationImpl<Integer> mani;
    private BST<Integer> groot1;
    private BST<Integer> groot2;
    private BST<Integer> groot3;
    private BST<Integer> groot4;

    @Before
    public void setUp() {
        mani = new SimpleBSTManipulationImpl<>();
        groot1 = new BSTImpl<>();
        groot2 = new BSTImpl<>();
        groot3 = new BSTImpl<>();
    }

    @Test
    public void test() {
        groot1.insert(3);
        groot1.insert(1);
        groot1.insert(4);
        groot1.insert(7);
        groot2.insert(3);
        groot2.insert(1);
        groot2.insert(4);
        groot2.insert(7);

        assertTrue(mani.equals(groot1, groot2));
        assertTrue(mani.isSimilar(groot1, groot2));
        
        groot3.insert(3);
        groot3.insert(1);
        groot3.insert(5);
        groot3.insert(10);
        
        assertTrue(mani.isSimilar(groot3, groot2));
        
        assertFalse(mani.equals(groot3, groot2));
        
        assertEquals( new Integer(3), mani.orderStatistic(groot1, 2));
        
        assertEquals( new Integer(10), mani.orderStatistic(groot3, 4));
        assertEquals( new Integer(1), mani.orderStatistic(groot3, 1));
        
        assertNull(  mani.orderStatistic(groot3, 0));
        assertNull(  mani.orderStatistic(groot3, 5));
    }

}

