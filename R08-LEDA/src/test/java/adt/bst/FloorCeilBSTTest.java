package adt.bst;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.SimpleBSTManipulationImpl;
import adt.bst.extended.FloorCeilBST;
import adt.bst.extended.FloorCeilBSTImpl;

public class FloorCeilBSTTest {

    private FloorCeilBST floor;
    private BST<Integer> groot;

    @Before
    public void setUp() {

        floor = new FloorCeilBSTImpl();
        groot = new BSTImpl<>();

    }

    @Test
    public void floor() {

        Integer[] array = {2, 5, 3, -12, -1};
        Integer[] array2 = {};
        assertEquals(new Integer(-12), floor.floor(array, -10));
        assertNull(floor.floor(array, -15));
        assertNull(floor.floor(array2, 2));
        assertEquals(new Integer(5), floor.floor(array, 100));

    }

    @Test
    public void ceil() {

        Integer[] array = {2, 5, 3, -12, -1};
        Integer[] array2 = {};
        assertEquals(new Integer(3), floor.ceil(array, 3));
        assertEquals(new Integer(-12), floor.ceil(array, -14));
        assertNull(floor.ceil(array, 10));
        assertNull(floor.ceil(array2, 2));
        assertEquals(new Integer(5), floor.ceil(array, 4));

    }

}