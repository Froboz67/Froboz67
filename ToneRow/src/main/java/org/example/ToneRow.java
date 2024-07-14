package org.example;

public class ToneRow {

    public void createRandomToneRow() {

        boolean repeatedNumber = false;
        int[] tones = new int[12];
        int generatedTone;
        int toneRowLength = 0;
        System.out.println();
        System.out.println("You're Random Tone Row Values Are:");
        System.out.println();
        System.out.print("| ");

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
                assignes each index to the value of zero. Therefore this conditional is used to ensure that
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
            while loop will stay at its current postion and the entire loop will start over with a new random number.
             */
            }
            if (!repeatedNumber) {
                tones[toneRowLength] = generatedTone;
                toneRowLength++;
            }
        }

        for (int i = 0; i < tones.length;i ++) {
            System.out.print(tones[i] + " | ");

        }

    }
}
