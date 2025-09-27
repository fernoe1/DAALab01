package algorithms;

import org.example.algorithms.impl.ClosestPair;
import org.example.models.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClosestPairTest {
    double closestPair(Point[] points) {
        return ClosestPair.closestPair(points);
    }

    @Test
    void testSmallPoints() {
        Point[] points = {
                new Point(0, 0),
                new Point(3, 4),
                new Point(7, 7),
                new Point(1, 1)
        };


        double result = closestPair(points);

        assertEquals(Math.sqrt(2), result);
    }

    @Test
    void testLargePoints() {
        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        double result = closestPair(points);

        assertEquals(Math.sqrt(2), result);
    }
}
