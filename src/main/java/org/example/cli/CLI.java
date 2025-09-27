package org.example.cli;

import org.example.algorithms.IAlgorithm;
import org.example.algorithms.impl.ClosestPair;
import org.example.algorithms.impl.DeterministicSelect;
import org.example.algorithms.sorting.impl.MergeSort;
import org.example.algorithms.sorting.impl.QuickSort;
import org.example.utils.Metrics;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CLI {
    public static void start() throws IOException {
        Scanner sc = new Scanner(System.in);

        Map<String, IAlgorithm> algorithms = Map.of(
                "Merge Sort", new MergeSort(),
                "Quick Sort", new QuickSort(),
                "Deterministic Select", new DeterministicSelect(),
                "Closest Pair", new ClosestPair()
        );

        System.out.println("All algorithms are run on input size of 1000, with each input being 0 <= input <= 999");
        while (true) {
            System.out.println("[0] Run merge sort \n" +
                    "[1] Run quick sort \n" +
                    "[2] Run deterministic select \n" +
                    "[3] Run closest pair \n" +
                    "[4] Run all tests \n" +
                    "[5] Exit");
            int input = sc.nextInt();
            switch (input) {
                case 0:
                    algorithms.get("Merge Sort").start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 1:
                    algorithms.get("Quick Sort").start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 2:
                    algorithms.get("Deterministic Select").start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 3:
                    algorithms.get("Closest Pair").start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 4:
                    for (IAlgorithm algo : algorithms.values()) {
                        algo.start();
                    }
                    System.out.println("Check metrics.csv for results");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }
}
