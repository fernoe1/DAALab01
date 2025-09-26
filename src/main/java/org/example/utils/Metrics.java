package org.example.utils;

public class Metrics {
    private static Metrics instance = null;

    private String algorithm;
    private int n;
    private int comparisons = 0;
    private int assignments = 0;
    private int maxDepth = 0;

    private double startTime;

    private Metrics() {}

    public static synchronized Metrics getInstance() {
        if (instance == null) {
            instance = new Metrics();
        }

        return instance;
    }

    public void reset() {
        comparisons = 0;
        assignments = 0;
        maxDepth = 0;
        startTime = 0;
    }

    public double getTimeTaken() {
        return ((System.nanoTime() - startTime) / 1000000);
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void increaseComparisons() {
        comparisons++;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void increaseAssignments() {
        assignments++;
    }

    public int getAssignments() {
        return assignments;
    }

    public void setMaxDepth(int depth) {
        if (depth > maxDepth) maxDepth = depth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    @Override
    public String toString() {
        return "\nAlgorithm: " + algorithm +
                "\nInput size (n): " + n +
                "\nComparisons: " + comparisons +
                "\nAssignments: " + assignments +
                "\nMax depth: " + maxDepth +
                "\nTime taken (ms): " + getTimeTaken() + "\n";
    }
}
