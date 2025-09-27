package algorithms;

import org.example.algorithms.sorting.impl.QuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {
    Integer[] quickSort(Integer[] arr) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        return arr;
    }

    @Test
    void testSort() {
        Integer[] unsortedArr = {5, 4, 2, 3, 1};
        Integer[] sortedArr = {1, 2, 3, 4, 5};

        assertArrayEquals(sortedArr, quickSort(unsortedArr));
    }

    @Test
    void testEmpty() {
        assertArrayEquals(new Integer[] {}, quickSort(new Integer[] {}));
    }
}
