package org.example;

import java.util.ArrayList;
import java.util.List;

public class ToneRow {

    public static final int WESTERN_TONAL = 12;

    public void createRandomToneRow() {

        boolean repeatedNumber;
        int[] tones = new int[12];
        int generatedTone;
        int toneRowLength = 0;

        Output.welcomeMessage();


        // while loop will ensure there are 12 tones 0-11 inside the array tones[]
        while (toneRowLength < 12) {

            /*
            boolean to indicate if there is a duplicate number in the array tones[]
            it resets itself each time the while loop repeats
             */
            repeatedNumber = false;

            // create a random number called generatedTone
            generatedTone = (int) ((Math.random() * 12));

            /*
            this for loop iterates through the array using a counter variable toneRowLength which increments each
            time a number is actually added to the tones[]
             */

            for (int i = 0; i <= toneRowLength; i++) {

                /*
                when you initialize an array object in Java and you don't set values for each index, Java
                assigns each index to the value of zero. Therefore this conditional is used to ensure that
                zero can be assigned to the first index of the tones[]. otherwise the repeated number would always
                be true for the first number in the tones[] and the program would assign it a different number.
                 */
                if (generatedTone == 0 && toneRowLength == 0) {
                    tones[0] = generatedTone;

                    /*
                    this conditional is making the comparison of the current index in tones[] and
                    trying to find a repeat value. if it tests true it will set the repeatedNumber
                    boolean to true for later use.
                     */
                } else  if (generatedTone == tones[i]) {

                    //generatedTone = (int) ((Math.random() * 12));
                    repeatedNumber = true;
                }
                /*
                if this condition is true it means the for loop has reached its final iteration and tones[i]
                is in fact assigned to the current generatedTone
                 */
                if (i == toneRowLength) {
                    tones[i] = generatedTone;
                }

            /*
            this final conditional is to confirm that the current number that has been added to the row is a
            valid value, in other words it hasn't been repeated already. so !repeatedNumber is saying yes! this is
            a good number to add to the array so do it! and also increase the toneRowLength counter. Otherwise the
            while loop will stay at its current position and the entire loop will start over with a new random number.
             */
            }
            if (!repeatedNumber) {
                tones[toneRowLength] = generatedTone;
                toneRowLength++;
            }
        }

        Output.printRandomToneRow(tones);

        assignToneRowToPitches(tones);

    }

    public static String[] assignToneRowToPitches(int[] tones) {

        // initialize String Array
        String[] toneRowPitches = new String[WESTERN_TONAL];
        // define pitch equivalents from array numbers to note names
        // convert randomToneRow[] values into a string Array
        for (int i = 0; i <= 11; i++) {
            if (tones[i] == 0) {
                toneRowPitches[i] = "C";
            } else if (tones[i] == 1) {
                toneRowPitches[i] = "C#";
            } else if (tones[i] == 2) {
                toneRowPitches[i] = "D";
            } else if (tones[i] == 3) {
                toneRowPitches[i] = "D#";
            } else if (tones[i] == 4) {
                toneRowPitches[i] = "E";
            } else if (tones[i] == 5) {
                toneRowPitches[i] = "F";
            } else if (tones[i] == 6) {
                toneRowPitches[i] = "F#";
            } else if (tones[i] == 7) {
                toneRowPitches[i] = "G";
            } else if (tones[i] == 8) {
                toneRowPitches[i] = "G#";
            } else if (tones[i] == 9) {
                toneRowPitches[i] = "A";
            } else if (tones[i] == 10) {
                toneRowPitches[i] = "A#";
            } else if (tones[i] == 11) {
                toneRowPitches[i] = "B";
            }
        }

        Output.printPrimeZeroByPitchClass(toneRowPitches);

        buildToneRowMatrix(tones);

        return toneRowPitches;
    }

    public static int[] buildToneRowMatrix(int[] tones) {
        /*
       populates the Prime Zero Row with proper note assigned to 0 index
        */

        //  the fist index and assign it to zero
        int[] primeZero = new int[WESTERN_TONAL];
        primeZero[0] = 0;
        for (int i = 1; i < WESTERN_TONAL; i++) {
            primeZero[i] = ((WESTERN_TONAL - tones[0]) + tones[i]);
            if (primeZero[i] > 11) {
                primeZero[i] -= WESTERN_TONAL;
            }
        }


        int[] primeRows = new int[WESTERN_TONAL];
        List<Integer> primeRowVariants = new ArrayList<>();

        // populates rows 1 - 11 of the matrix

        for (int eachRow = 1; eachRow < WESTERN_TONAL; eachRow++) {
            primeRows[0] = WESTERN_TONAL - primeZero[eachRow];
            for (int i = 1; i < WESTERN_TONAL; i++) {
                primeRows[i] = (primeZero[i] + primeRows[0]);
                if (primeRows[i] > 11) {
                    primeRows[i] -= WESTERN_TONAL;
                }
            }
            for (int prime : primeRows) {
                primeRowVariants.add(prime);
                // System.out.printf("| %-3d", prime);
            }

        }
        Output.printToneRowMatrix(primeZero, primeRowVariants);

        return null;
    }
}


