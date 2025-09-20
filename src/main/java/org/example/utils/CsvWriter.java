package org.example.utils;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private static final CsvWriter CSV_WRITER = new CsvWriter();
    private static final String FILENAME = "metrics.csv";

    private CsvWriter() {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            writer.write("algorithm,n,comparisons,assignments,maxDepth,timeNs\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static CsvWriter getCsvWriter() {
        return CSV_WRITER;
    }

    public void write(Metrics metric) throws IOException {
        try (FileWriter writer = new FileWriter(FILENAME, true)) {
            writer.write(
                    metric.getAlgorithm() + "," +
                    metric.getN() + "," +
                    metric.getComparisons() + "," + metric.getAssignments() + "," +
                    metric.getMaxDepth() + "," +
                    metric.getTimeTaken() + "\n"
            );
        }
    }
}
