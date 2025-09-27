package algorithms;

import org.example.algorithms.impl.DeterministicSelect;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

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

    @Test
    void testRandomTrials() {
        Random random = new Random();
        for (int t = 0; t < 100; t++) {
            int n = 200 + t;

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(1, n);
            }

            int k = random.nextInt(n);
            Arrays.sort(arr);
            assertEquals(arr[k], select(arr, k + 1));
        }
    }
}
