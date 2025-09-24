package algorithms;

import org.example.algorithms.QuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {
    int[] quickSort(int[] arr) {
        QuickSort.quickSort(arr, 0, arr.length - 1, 0);
        return arr;
    }

    @Test
    void testSort() {
        int[] unsortedArr = {5, 4, 2, 3, 1};
        int[] sortedArr = {1, 2, 3, 4, 5};

        assertArrayEquals(sortedArr, quickSort(unsortedArr));
    }

    @Test
    void testEmpty() {
        assertArrayEquals(new int[] {}, quickSort(new int[] {}));
    }
}
