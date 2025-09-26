package org.example.cli;

import org.example.algorithms.ClosestPair;
import org.example.algorithms.DeterministicSelect;
import org.example.algorithms.MergeSort;
import org.example.algorithms.QuickSort;
import org.example.utils.Metrics;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    public static void start() throws IOException {
        Scanner sc = new Scanner(System.in);

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
                    MergeSort.start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 1:
                    QuickSort.start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 2:
                    DeterministicSelect.start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 3:
                    ClosestPair.start();
                    System.out.println(Metrics.getInstance());
                    break;
                case 4:
                    MergeSort.start();
                    QuickSort.start();
                    DeterministicSelect.start();
                    ClosestPair.start();
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
