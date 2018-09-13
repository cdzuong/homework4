package test;

import arrays.MyArray;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/** Contains JUnit tests for testing methods of class MyArray. */
public class MyArrayTester {
    private MyArray arr;
    public final static int MAX_SIZE = 10;

    /**
     * Method that will be executed before every test
     */
    @Before
    public void setup() {
        arr = new MyArray(MAX_SIZE);
        arr.addElement(5);
        arr.addElement(16);
        arr.addElement(1);
        arr.addElement(21);
        arr.addElement(9);
        arr.addElement(10);
        arr.addElement(11);
    }

    /**
     * Test toString method
     */
    @Test
    public void testToString() {
        String res = arr.toString();
        String expected = "5 16 1 21 9 10 11";
        assertTrue("In testToString the result is not as expected", res.equals(expected));
    }

    /**
     * Test addElement method when trying to add elements when the array is full
     */
    @Test
    public void testAddElementFullArray() {
        // in setup(), we added 7 elements; now let's try to add 4 more
        // when MAX_SIZE is 10 (your code should not allow to add the last element)
        boolean b1 = arr.addElement(12);
        boolean b2 = arr.addElement(13);
        boolean b3 = arr.addElement(14);
        boolean b4 = arr.addElement(15);
        assertTrue(b1 && b2 && b3);
        assertTrue("Error: You should not allow adding elements to the array " +
                "when it is full!", !b4);
    }

    /**
     * Tests find method when the element is present in the array
     */
    @Test
    public void testFindTrue() {
        assertTrue("testFind method did not find 9 at the correct index", arr.find(9) == 4);
    }

    /**
     * Tests find method when the element is not present in the array
     */
    @Test
    public void testFindFalse() {
        assertTrue("testFind method found 20, but 20 is not in the array.", arr.find(20) == -1);

    }

    /** Tests remove method when we remove existing element from the array.
     *
     */
    @Test
    public void testRemoveExistingElement() {
        boolean res = arr.remove(21);
        assertTrue(res);
        assertTrue("remove method does not shift elements correctly", arr.find(9) == 3);
        assertTrue("remove method does not shift elements correctly", arr.find(10) == 4);
        assertTrue("remove method does not shift elements correctly", arr.find(11) == 5);
    }

    /** Tests remove method when we try to remove the element that is not in the array.
     *
     */
    @Test
    public void testRemoveNonExistingElement() {
        boolean res = arr.remove(20);
        assertTrue("remove should not remove an element if it was not in the array", !res);
    }

    /** Tests reverse method */
    @Test
    public void testReverse() {
        arr.reverse();
        String res = arr.toString();
        String expected = "11 10 9 21 1 16 5";
        assertTrue("reverse method does not reverse array correctly", res.equals(expected));
    }

    /** Test removeEveryOtherElement() */
    @Test
    public void testRemoveEveryOtherElement() {
        arr.removeEveryOtherElement();
        String res = arr.toString();
        String expected = "5 1 9 11";
        assertTrue("testRemoveEveryOtherElement does not work correctly", res.equals(expected));
        assertTrue( arr.find(1) == 1);
        assertTrue( arr.find(9) == 2);
        assertTrue( arr.find(11) == 3);
    }

    /** Tests repeat method */
    @Test
    public void testRepeat() {
        arr.repeat(3);
        String res = arr.toString();
        String expected = "5 16 1 21 9 10 11 5 16 1 21 9 10 11 5 16 1 21 9 10 11";
        assertTrue("In testRepeat the result is not as expected", res.equals(expected));
    }

    /** testFindLargestCommonElement */
    @Test
    public void testFindLargestCommonElement() {
        MyArray otherArray = new MyArray(3);
        otherArray.addElement(3);
        otherArray.addElement(11);
        otherArray.addElement(8);

        int res = arr.findLargestCommonElement(otherArray);
        assertTrue("findLargestCommonElement did not return the correct element", res == 11);
    }
}