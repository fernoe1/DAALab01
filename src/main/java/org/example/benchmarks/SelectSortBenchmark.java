package org.example.benchmarks;

import org.example.algorithms.impl.DeterministicSelect;
import org.example.algorithms.sorting.impl.MergeSort;
import org.example.algorithms.sorting.impl.QuickSort;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Fork(value = 1, warmups = 1)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SelectSortBenchmark {

    @Benchmark
    public void benchMergeSort(ExecutionPlan plan) {
        Integer[] copy = Arrays.copyOf(plan.array, plan.array.length);
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(copy);
    }

    @Benchmark
    public void benchQuickSort(ExecutionPlan plan) {
        Integer[] copy = Arrays.copyOf(plan.array, plan.array.length);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(copy);
    }

    @Benchmark
    public void benchDeterministicSelect(ExecutionPlan plan) {
        Random random = new Random();
        Integer[] copy = Arrays.copyOf(plan.array, plan.array.length);
        int[] primitiveCopy = Arrays.stream(plan.array)
                .mapToInt(Integer::intValue)
                .toArray();

        DeterministicSelect.select(primitiveCopy, random.nextInt(1, plan.array.length), 0);
    }
}
