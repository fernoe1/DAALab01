package org.example.utils;

public class Metrics {
    private String algorithm;
    private int n;
    private int comparisons = 0;
    private int assignments = 0;
    private int maxDepth = 0;

    private double startTime;

    public Metrics(String algorithm, int n) {
        this.algorithm = algorithm;
        this.n = n;
        startTime = System.nanoTime();
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

    public String getAlgorithm() {
        return algorithm;
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
}
