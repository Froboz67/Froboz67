package org.example;

import java.util.List;

public class Output {

    // make this the class that controls the console screen

    public static void welcomeMessage() {
        System.out.println();
        System.out.println("You're Random Tone Row Values Are:");

    }

    public static void printRandomToneRow(int[] tones) {
        for (int tone : tones) {

            System.out.printf("| %-3d", tone);
        }
        System.out.println("|");
    }

    public static void printPrimeZeroByPitchClass(String[] toneRowPitches) {
        System.out.println();
        System.out.println("This is the Prime Zero Row by Pitch Class");
        for (String tone : toneRowPitches) {

            System.out.printf("| %-3s", tone);
        }
        System.out.println("|");
    }

    public static void printToneRowMatrix(int[] primeZero, List primeRowVariants) {
        System.out.println();
        System.out.println("This is the Complete Tone Row Matrix:");
        for (int prime : primeZero) {

            System.out.printf("| %-3d", prime);
        }
        System.out.println("|");

        int rowValueCounter = 0;

        for (Object prime : primeRowVariants) {

            System.out.printf("| %-3d", prime);
            rowValueCounter++;
            if (rowValueCounter % 12 == 0) {
                System.out.println("|");
            }
        }
    }
}
