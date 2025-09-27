package org.example.algorithms.sorting;

public interface ISorter {
    <T extends Comparable<T>> void sort(T[] arr);
}
