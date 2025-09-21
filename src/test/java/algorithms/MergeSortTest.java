package algorithms;

import org.example.algorithms.MergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    int[] mergeSort(int[] arr) {
        int[] buffer = new int[arr.length];
        MergeSort.mergeSort(arr, buffer, 0, arr.length, 0);

        return arr;
    }

    @Test
    void testSort() {
        int[] unsortedArr = {5, 4, 2, 3, 1};
        int[] sortedArr = {1, 2, 3, 4, 5};

        assertArrayEquals(sortedArr, mergeSort(unsortedArr));
    }

    @Test
    void testEmpty() {
        assertArrayEquals(new int[] {}, mergeSort(new int[] {}));
    }
}
