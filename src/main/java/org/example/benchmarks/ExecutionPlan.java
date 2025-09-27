package org.example.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.Random;

@State(Scope.Thread)
public class ExecutionPlan {
    @Param({ "1000", "10000", "100000" })
    public int size;

    public Integer[] array;
    private Random random;

    @Setup(Level.Invocation)
    public void setUp() {
        random = new Random(1987); // Fun fact, this seed is Kendrick Lamar's birthdate
        array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1, size);
        }
    }
}
