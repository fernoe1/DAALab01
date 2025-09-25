package algorithms;

import org.example.algorithms.DeterministicSelect;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeterministicSelectTest {
    int select(int[] arr, int k) {
        return DeterministicSelect.select(arr, k, 0);
    }

    @Test
    void testSmallArray() {
        int[] arr = {4, 2, 1, 3};
        int k = 3;
        assertEquals(3, select(arr, k));
    }

    @Test
    void testLargeArray() {
        int[] arr = {9, 3, 7, 1, 8, 2, 5, 4, 6, 10, 15, 12, 11, 13, 14, 20, 18, 16, 17, 19, 21};
        int k = 10;
        assertEquals(10, select(arr, k));
    }
}
