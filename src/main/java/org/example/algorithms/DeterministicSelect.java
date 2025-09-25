package org.example.algorithms;

import org.example.utils.CsvWriter;
import org.example.utils.Metrics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Median of Medians Deterministic Select
 * O(n) time complexity, O(n) space complexity
 */
public class DeterministicSelect {
    private static final Metrics METRICS = new Metrics("Deterministic Select", 1000);
    private static final CsvWriter CSV_WRITER = CsvWriter.getCsvWriter();

    public static void start() throws IOException {
        int[] arr = new int[1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt(1, 1000);
        }

        METRICS.reset();

        select(arr, random.nextInt(1, 1000), 0);

        CSV_WRITER.write(METRICS);
    }

    public static int select(int[] arr, int k, int depth) {
        METRICS.setMaxDepth(depth);

        if (arr.length < 5) {
            METRICS.increaseComparisons();
            sort(arr);
            METRICS.increaseAssignments();

            return findK(arr, k);
        }
        METRICS.increaseComparisons(); // fail

        ArrayList<Integer>[] chunks = new ArrayList[Math.ceilDiv(arr.length, 5)];
        METRICS.increaseAssignments();
        ArrayList<Integer> currentChunk = new ArrayList<>(5);
        METRICS.increaseAssignments();

        for (int i = 0, j = 0; i < arr.length; i++) {
            METRICS.increaseComparisons();
            currentChunk.add(arr[i]);
            METRICS.increaseAssignments();

            if (currentChunk.size() == 5 || i == arr.length - 1) {
                chunks[j++] = currentChunk;
                METRICS.increaseAssignments();
                currentChunk = new ArrayList<>(5);
                METRICS.increaseAssignments();
            }
        }
        METRICS.increaseComparisons(); // fail

        int[] medians = new int[chunks.length];
        METRICS.increaseAssignments();

        for (int i = 0; i < chunks.length; i++) {
            METRICS.increaseComparisons();
            int[] chunkArray = chunks[i].stream().mapToInt(Integer::intValue).toArray();
            METRICS.increaseAssignments();
            sort(chunkArray);
            int medianIndex = chunkArray.length / 2;
            METRICS.increaseAssignments();
            medians[i] = chunkArray[medianIndex];
            METRICS.increaseAssignments();
        }
        METRICS.increaseComparisons(); // fail

        int medianOfMedians = getMOM(medians);
        METRICS.increaseAssignments();

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> middle = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();

        for (int num : arr) {
            METRICS.increaseComparisons();
            if (num < medianOfMedians) {
                METRICS.increaseComparisons();
                left.add(num);
            } else if (num == medianOfMedians) {
                METRICS.increaseComparisons();
                middle.add(num);
            } else {
                right.add(num);
            }
            METRICS.increaseComparisons(); // fail
            METRICS.increaseComparisons(); // fail
        }

        int[] leftArr = left.stream().mapToInt(Integer::intValue).toArray();
        int[] rightArr = right.stream().mapToInt(Integer::intValue).toArray();
        METRICS.increaseAssignments();
        METRICS.increaseAssignments();

        if (k <= left.size()) {
            METRICS.increaseComparisons();
            return select(leftArr, k, depth + 1);
        } else if (k <= left.size() + middle.size()) {
            METRICS.increaseComparisons();
            return medianOfMedians;
        } else {
            return select(rightArr, k - left.size() - middle.size(), depth + 1);
        }
    }

    public static int getMOM(int[] medians) {
        Arrays.sort(medians);
        return medians[medians.length / 2];
    }

    public static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    public static int findK(int[] arr, int k) {
        return arr[k - 1];
    }
}
