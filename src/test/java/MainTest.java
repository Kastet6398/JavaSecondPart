import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSearchNull() {
        assertArrayEquals(new int[] {-1, -1}, Main.search(null, 8));
    }

    @Test
    public void testSearchEmpty() {
        assertArrayEquals(new int[] {-1, -1}, Main.search(new int[0], 8));
    }

    @Test
    public void testSearchOnceFound() {
        assertArrayEquals(new int[] {10, 10}, Main.search(new int[] {1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 8, 9}, 8));
    }

    @Test
    public void testSearchNotFound() {
        assertArrayEquals(new int[] {-1, -1}, Main.search(new int[] {1, 2, 3, 4, 4, 9, 10, 10}, 8));
    }

    @Test
    public void testSearchFound1() {
        assertArrayEquals(new int[] {5, 6}, Main.search(new int[] {1, 2, 3, 4, 4, 8, 8, 9, 10, 10}, 8));
    }

    @Test
    public void testSearchFound2() {
        assertArrayEquals(new int[] {5, 7}, Main.search(new int[] {1, 2, 3, 4, 4, 8, 8, 8, 9, 10, 10}, 8));
    }

    @Test
    public void testMultiplyNullNull() {
        assertEquals("0", Main.multiply(null, null));
    }

    @Test
    public void testMultiplyNullReal() {
        assertEquals("0", Main.multiply(null, "3"));
    }

    @Test
    public void testMultiplyRealNull() {
        assertEquals("0", Main.multiply("5", null));
    }

    @Test
    public void testMultiplyZeroReal() {
        assertEquals("0", Main.multiply("0", "9"));
    }

    @Test
    public void testMultiplyRealZero() {
        assertEquals("0", Main.multiply("5", "0"));
    }

    @Test
    public void testMultiplyZeroZero() {
        assertEquals("0", Main.multiply("0", "0"));
    }

    @Test
    public void testMultiplyEmptyEmpty() {
        assertEquals("0", Main.multiply("", ""));
    }

    @Test
    public void testMultiplyRealEmpty() {
        assertEquals("0", Main.multiply("3", ""));
    }

    @Test
    public void testMultiplyEmptyReal() {
        assertEquals("0", Main.multiply("", "3"));
    }

    @Test
    public void testMultiplyRealReal() {
        assertEquals("0", Main.multiply("0", "0"));
    }

    @Test
    public void testMultiplyLetterReal() {
        assertEquals("0", Main.multiply("f", "0"));
    }

    @Test
    public void testMultiplyRealLetter() {
        assertEquals("0", Main.multiply("0", "l"));
    }

    @Test
    public void testMultiplyLetterLetter() {
        assertEquals("0", Main.multiply("f", "l"));
    }

    @Test
    public void testMultiplyDoubleReal() {
        assertEquals("0", Main.multiply("44.66", "l"));
    }

    @Test
    public void testMultiplyRealDouble() {
        assertEquals("0", Main.multiply("4", "44.98"));
    }

    @Test
    public void testMultiplyDoubleDouble() {
        assertEquals("0", Main.multiply("3.4", "44.98"));
    }

    @Test
    public void testMultiplyCorrect1() {
        assertEquals("3125", Main.multiply("125", "25"));
    }

    @Test
    public void testMultiplyMaxValue() {
        assertEquals("0", Main.multiply("125", String.valueOf(Double.MAX_VALUE)));
    }

    @Test
    public void testMultiplyCorrect2() {
        assertEquals("1074404976", Main.multiply("23682", "45368"));
    }

    @Test
    public void testMultiplyStartsWithZero() {
        assertEquals("0", Main.multiply("0125", "5"));
    }

    @Test
    public void testMyPowNZero() {
        assertEquals(1, Main.myPow(10, 0), 100000);
    }

    @Test
    public void testMyPowXOne() {
        assertEquals(1, Main.myPow(1, 1234567), 100000);
    }

    @Test
    public void testMyPowXZero() {
        assertEquals(0, Main.myPow(0, 1234567), 100000);
    }

    @Test
    public void testMyPowNegativeN() {
        assertEquals(.0016, Main.myPow(5, -4), 100000);
    }

    @Test
    public void testMyPowNMinValue() {
        assertEquals(0, Main.myPow(5, Integer.MIN_VALUE), 100000);
    }

    @Test
    public void testMyPowNegativeX() {
        assertEquals(0, Main.myPow(-1, Integer.MIN_VALUE), 100000);
    }

    @Test
    public void testMyPowXNegativeOne() {
        assertEquals(-1, Main.myPow(-1, 5676), 100000);
    }

    @Test
    public void testMyPowNormal1() {
        assertEquals(15129, Main.myPow(123, 2), 100000);
    }

    @Test
    public void testMyPowMaxValue() {
        assertEquals(Double.POSITIVE_INFINITY, Main.myPow(125, Integer.MAX_VALUE), 100000);
    }

    @Test
    public void testMyPowNormal2() {
        assertEquals(2097152, Main.myPow(2, 21), 100000);
    }
}