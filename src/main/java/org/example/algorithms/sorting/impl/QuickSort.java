package org.example.algorithms.sorting.impl;

import org.example.algorithms.IAlgorithm;
import org.example.algorithms.sorting.ISorter;
import org.example.utils.CsvWriter;
import org.example.utils.Metrics;

import java.io.IOException;
import java.util.Random;

/**
 * Optimized + Hoare's Partition Quick Sort
 * O(n log n) time complexity, O(n) space complexity
 */
public class QuickSort implements ISorter, IAlgorithm {
    private static final Random RANDOM = new Random();
    private static final Metrics METRICS = Metrics.getInstance();
    private static final CsvWriter CSV_WRITER = CsvWriter.getCsvWriter();

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        METRICS.reset();
        quickSort(arr, 0, arr.length - 1, 0);
    }

    @Override
    public void start() throws IOException {
        METRICS.setAlgorithm("Quick Sort");
        METRICS.setN(1000);

        Integer[] arr = new Integer[1000];
        for (int i = 0; i < arr.length; i++) arr[i] = RANDOM.nextInt(1, 1000);

        sort(arr);

        CSV_WRITER.write(METRICS);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int start, int end, int depth) {
        METRICS.setMaxDepth(depth);

        while (start < end) {
            METRICS.increaseComparisons(); // while
            int pivotIndex = hoarePartition(arr, start, end);
            METRICS.increaseAssignments();

            int leftSize = pivotIndex - start;
            METRICS.increaseAssignments();
            int rightSize = end - pivotIndex;
            METRICS.increaseAssignments();

            if (leftSize < rightSize) {
                METRICS.increaseComparisons();
                quickSort(arr, start, pivotIndex - 1, depth + 1);
                start = pivotIndex + 1;
                METRICS.increaseAssignments();
            } else {
                METRICS.increaseComparisons();
                quickSort(arr, pivotIndex + 1, end, depth + 1);
                end = pivotIndex - 1;
                METRICS.increaseAssignments();
            }
        }
        METRICS.increaseComparisons(); // fail
    }

    private static <T extends Comparable<T>> int hoarePartition(T[] arr, int start, int end) {
        int pivotIndex = RANDOM.nextInt(start, end + 1);
        METRICS.increaseAssignments();
        T pivot = arr[pivotIndex];
        METRICS.increaseAssignments();

        T temp = arr[start]; arr[start] = arr[pivotIndex]; arr[pivotIndex] = temp;
        METRICS.increaseAssignments(); METRICS.increaseAssignments(); METRICS.increaseAssignments();

        int left = start + 1;
        int right = end;
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();

        while (left <= right) {
            METRICS.increaseComparisons(); // while
            if (arr[left].compareTo(pivot) <= 0) {
                METRICS.increaseComparisons();
                left++;
                METRICS.increaseAssignments();
            } else if (arr[right].compareTo(pivot) > 0) {
                METRICS.increaseComparisons();
                right--;
                METRICS.increaseAssignments();
            } else {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
                METRICS.increaseAssignments();
                METRICS.increaseAssignments();
                METRICS.increaseAssignments();
                METRICS.increaseAssignments();
                METRICS.increaseAssignments();
            }
        }

        temp = arr[start]; arr[start] = arr[right]; arr[right] = temp;
        METRICS.increaseAssignments(); METRICS.increaseAssignments(); METRICS.increaseAssignments();

        return right;
    }
}