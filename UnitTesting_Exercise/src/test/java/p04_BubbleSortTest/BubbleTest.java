package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    private final static int[] NUMBERS = {-5, 2, 18, 73, 9};
    private final static int[] SORTED_NUMBERS = {-5, 2, 9, 18, 73};

    @Test
    public void bubbleSortSuccess() {
        Bubble.sort(NUMBERS);

        Assert.assertArrayEquals(NUMBERS, SORTED_NUMBERS);
    }
}