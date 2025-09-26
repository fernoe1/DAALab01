package org.example.algorithms;

import org.example.models.Point;
import org.example.utils.CsvWriter;
import org.example.utils.Metrics;

import java.io.IOException;
import java.util.*;

/**
 * Divide and Conquer Select Closest Pair
 * O(n log n) time complexity, O(n log n) space complexity
 */
public class ClosestPair {
    private static final Metrics METRICS = new Metrics("Closest Pair", 1000);
    private static final CsvWriter CSV_WRITER = CsvWriter.getCsvWriter();

    public static void start() throws IOException {
        Random random = new Random();
        Point[] points = new Point[1000];
        for (int i = 0; i < 1000; i++) {
            points[i] = new Point(random.nextDouble(0, 1000),
                    random.nextDouble(0, 1000));
        }

        METRICS.reset();

        closestPair(points);

        CSV_WRITER.write(METRICS);
    }

    public static double closestPair(Point[] points) {
        Point[] X = points.clone();
        Arrays.sort(X, Comparator.comparingDouble(p -> p.x));

        Point[] Y = points.clone();
        Arrays.sort(Y, Comparator.comparingDouble(p -> p.y));

        return closestPair(X, Y, 0);
    }

    public static double closestPair(Point[] X, Point[] Y, int depth) {
        METRICS.setMaxDepth(depth);

        int n = X.length;
        METRICS.increaseAssignments();

        if (n == 2) {
            METRICS.increaseComparisons();
            return dist(X[0], X[1]);
        }
        METRICS.increaseComparisons();
        if (n == 3) {
            METRICS.increaseComparisons();
            return Math.min(dist(X[0], X[1]),
                    Math.min(dist(X[1], X[2]), dist(X[0], X[2])));
        }
        METRICS.increaseComparisons();

        int mid = n / 2;
        METRICS.increaseAssignments();
        Point midPoint = X[mid];
        METRICS.increaseAssignments();

        Point[] XL = Arrays.copyOfRange(X, 0, mid);
        METRICS.increaseAssignments();
        Point[] XR = Arrays.copyOfRange(X, mid, n);
        METRICS.increaseAssignments();

        double dl = closestPair(XL, Y, depth + 1);
        METRICS.increaseAssignments();
        double dr = closestPair(XR, Y, depth + 1);
        METRICS.increaseAssignments();

        double d = Math.min(dl, dr);
        METRICS.increaseAssignments();

        List<Point> strip = new ArrayList<>();
        METRICS.increaseAssignments();
        for (Point p : Y) {
            METRICS.increaseComparisons();
            if (Math.abs(p.x - midPoint.x) < d) {
                strip.add(p);
                METRICS.increaseAssignments();
            }
        }

        for (int i = 0; i < strip.size(); i++) {
            METRICS.increaseComparisons();
            METRICS.increaseAssignments();
            for (int j = 1; j <= 7 && i + j < strip.size(); j++) {
                METRICS.increaseComparisons();
                METRICS.increaseAssignments();
                d = Math.min(d, dist(strip.get(i), strip.get(i + j)));
                METRICS.increaseAssignments();
            }
        }

        return d;
    }

    public static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y));
    }
}
