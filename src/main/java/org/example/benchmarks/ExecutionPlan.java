package org.example.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.Random;

@State(Scope.Thread)
public class ExecutionPlan {
    @Param({ "1000", "10000", "100000" })
    public int size;

    public int[] array;
    private Random random;

    @Setup(Level.Invocation)
    public void setUp() {
        random = new Random(1987); // Fun fact, this seed is Kendrick Lamar's birthdate
        array = random.ints(size, 1, size).toArray();
    }
}
