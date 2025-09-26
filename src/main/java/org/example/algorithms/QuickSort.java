package org.example.algorithms;

import org.example.utils.CsvWriter;
import org.example.utils.Metrics;

import java.io.IOException;
import java.util.Random;

/**
 * Optimized + Hoare's Partition Quick Sort
 * O(n log n) time complexity, O(n) space complexity
 */
public class QuickSort {
    private static final Random RANDOM = new Random();
    private static final Metrics METRICS = Metrics.getInstance();
    private static final CsvWriter CSV_WRITER = CsvWriter.getCsvWriter();

    public static void start() throws IOException {
        METRICS.setAlgorithm("Quick Sort");
        METRICS.setN(1000);

        int[] arr = new int[1000];

        for (int i = 0; i < 1000; i++) {
            arr[i] = RANDOM.nextInt(1, 1000);
        }

        METRICS.reset();

        quickSort(arr, 0, arr.length - 1, 0);

        CSV_WRITER.write(METRICS);
    }

    public static void quickSort(int[] arr, int start, int end, int depth) {
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

    public static int hoarePartition(int[] arr, int start, int end) {
        int pivotIndex = RANDOM.nextInt(start, end + 1);
        METRICS.increaseAssignments();
        int pivot = arr[pivotIndex];
        METRICS.increaseAssignments();

        int temp = arr[start];
        arr[start] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();

        int left = start + 1;
        int right = end;
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();

        while (left <= right) {
            METRICS.increaseComparisons(); // while
            if (arr[left] <= pivot) {
                METRICS.increaseComparisons();
                left++;
                METRICS.increaseAssignments();
            } else if (arr[right] > pivot) {
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

        temp = arr[start];
        arr[start] = arr[right];
        arr[right] = temp;
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();

        return right;
    }
}