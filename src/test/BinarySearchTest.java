package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.basealgorithm.BinarySearch;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void searchInArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(BinarySearch.searchInArray(array, 5));
    }
}