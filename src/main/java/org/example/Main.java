package org.example;
import org.example.cli.CLI;

import java.io.IOException;

public class Main{

    public static void main(String args[]) {
        try {
            CLI.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}