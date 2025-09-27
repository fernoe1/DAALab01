package org.example.algorithms.sorting.impl;

import org.example.algorithms.IAlgorithm;
import org.example.algorithms.sorting.ISorter;
import org.example.utils.CsvWriter;
import org.example.utils.Metrics;

import java.io.IOException;
import java.util.Random;

/**
 * Buffer + Merge Sort + Insertion Sort
 * O(n log n) time complexity, O(n) space complexity
 */
public class MergeSort implements ISorter, IAlgorithm {
    private static final int RUN_SIZE = 16;
    private static final Metrics METRICS = Metrics.getInstance();
    private static final CsvWriter CSV_WRITER = CsvWriter.getCsvWriter();

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        T[] buffer = (T[]) new Comparable[arr.length];
        METRICS.reset();
        METRICS.increaseAssignments();
        mergeSort(arr, buffer, 0, arr.length, 0);
    }

    /**
     * Buffer + Merge Sort + Insertion Sort. <br>
     * O(n log n) time complexity, O(n) space complexity.
     */
    @Override
    public void start() throws IOException {
        METRICS.setAlgorithm("Merge Sort");
        METRICS.setN(1000);

        Integer[] arr = new Integer[1000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 1000);
        }

        sort(arr);

        CSV_WRITER.write(METRICS);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, T[] buffer, int start, int end, int depth) {
        METRICS.setMaxDepth(depth);

        METRICS.increaseComparisons(); // check (end - start <= RUN_SIZE)
        if (end - start <= RUN_SIZE) {
            insertionSort(arr, start, end);
            return;
        }

        int mid = (start + end) / 2;
        METRICS.increaseAssignments();

        mergeSort(arr, buffer, start, mid, depth + 1);
        mergeSort(arr, buffer, mid, end, depth + 1);

        merge(arr, buffer, start, mid, end);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] buffer, int start, int mid, int end) {
        int l = start;
        METRICS.increaseAssignments();
        int r = mid;
        METRICS.increaseAssignments();
        int b = start;
        METRICS.increaseAssignments();

        while (l < mid && r < end) {
            METRICS.increaseComparisons(); // (l < mid && r < end)

            METRICS.increaseComparisons(); // compare arr[l] <= arr[r]
            if (arr[l].compareTo(arr[r]) <= 0) {
                buffer[b] = arr[l];
                METRICS.increaseAssignments();

                b++;
                l++;
                METRICS.increaseAssignments(); // b++
                METRICS.increaseAssignments(); // l++
            } else {
                buffer[b] = arr[r];
                METRICS.increaseAssignments();

                b++;
                r++;
                METRICS.increaseAssignments(); // b++
                METRICS.increaseAssignments(); // r++
            }
        }

        while (l < mid) {
            METRICS.increaseComparisons(); // check (l < mid)
            buffer[b] = arr[l];
            METRICS.increaseAssignments();

            b++;
            l++;
            METRICS.increaseAssignments(); // b++
            METRICS.increaseAssignments(); // l++
        }
        METRICS.increaseComparisons(); // failed check

        while (r < end) {
            METRICS.increaseComparisons(); // check (r < end)
            buffer[b] = arr[r];
            METRICS.increaseAssignments();

            b++;
            r++;
            METRICS.increaseAssignments(); // b++
            METRICS.increaseAssignments(); // r++
        }
        METRICS.increaseComparisons(); // failed check

        for (int i = start; i < end; i++) {
            METRICS.increaseComparisons(); // check loop condition
            arr[i] = buffer[i];
            METRICS.increaseAssignments();
        }
        METRICS.increaseComparisons(); // failed check
    }

    private static <T extends Comparable<T>> void insertionSort(T[] arr, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            METRICS.increaseComparisons(); // loop condition

            T key = arr[i];
            METRICS.increaseAssignments();

            int j = i - 1;
            METRICS.increaseAssignments();

            while (j >= start && arr[j].compareTo(key) > 0) {
                METRICS.increaseComparisons(); // (j >= start && arr[j] > key)

                arr[j + 1] = arr[j];
                METRICS.increaseAssignments();

                j--;
                METRICS.increaseAssignments();
            }
            METRICS.increaseComparisons(); // failed while

            arr[j + 1] = key;
            METRICS.increaseAssignments();
        }
        METRICS.increaseComparisons(); // failed for
    }
}
