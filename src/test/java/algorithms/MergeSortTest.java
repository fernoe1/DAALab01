package algorithms;

import org.example.algorithms.sorting.impl.MergeSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    Integer[] mergeSort(Integer[] arr) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);

        return arr;
    }

    @Test
    void testSort() {
        Integer[] unsortedArr = {5, 4, 2, 3, 1};
        Integer[] sortedArr = {1, 2, 3, 4, 5};

        assertArrayEquals(sortedArr, mergeSort(unsortedArr));
    }

    @Test
    void testEmpty() {
        assertArrayEquals(new Integer[] {}, mergeSort(new Integer[] {}));
    }
}
