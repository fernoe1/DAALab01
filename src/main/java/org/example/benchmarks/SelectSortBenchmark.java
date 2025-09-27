package org.example.benchmarks;

import org.example.algorithms.DeterministicSelect;
import org.example.algorithms.MergeSort;
import org.example.algorithms.QuickSort;
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
        int[] copy = Arrays.copyOf(plan.array, plan.array.length);
        int[] buffer = new int[copy.length];
        MergeSort.mergeSort(copy, buffer, 0, copy.length, 0);
    }

    @Benchmark
    public void benchQuickSort(ExecutionPlan plan) {
        int[] copy = Arrays.copyOf(plan.array, plan.array.length);
        QuickSort.quickSort(copy, 0, copy.length - 1, 0);
    }

    @Benchmark
    public void benchDeterministicSelect(ExecutionPlan plan) {
        Random random = new Random();
        int[] copy = Arrays.copyOf(plan.array, plan.array.length);
        DeterministicSelect.select(copy, random.nextInt(1, plan.array.length), 0);
    }
}
