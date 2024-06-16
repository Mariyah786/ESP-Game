/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description:  The ESPGame class is a console-based game that tests the user's Extra Sensory Perception (ESP) skills.
 * It reads a list of colors from a file, prompts the user to guess the color randomly chosen by the program,
 * and records the number of correct guesses over multiple rounds. Additionally, it collects the user's name
 * and a description for display at the end of the game.
 * Due: 06/16/24
 * Platform/compiler:This program is intended to run on any platform that supports Java SE (Standard Edition).
 * It was compiled using the Java Development Kit (JDK) with the Eclipse IDE (Integrated Development Environment).
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Mariyah Shahmalak
*/

package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {
    
    // Constants for file path and number of rounds
    private static final String FILE_PATH = "/Users/mars/Desktop/colors.txt";
    private static final int NUM_ROUNDS = 3;
    
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("CMSC203 Assignment1: Test your ESP skills!\nThere are sixteen colors from a file:");

        // Read colors from file
        File file = new File(FILE_PATH);
        Scanner inputFile = new Scanner(file);

        int correctGuesses = 0;
        String correctColor = "";

        // Initialize variables
        String[] colorsArray = new String[16];
        int index = 0;

        while (inputFile.hasNextLine() && index < 16) {
            String line = inputFile.nextLine();
            String[] parts = line.split(" ");
            String colorName = parts[1];
            colorsArray[index] = colorName;
            System.out.println(colorName);
            index++;
        }

        inputFile.close();

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("Round " + round);

            // Generate random number from 0 to 15
            int randomNumber = random.nextInt(16);

            correctColor = colorsArray[randomNumber];

            // Prompt user to guess the color
            System.out.println("Enter your guess for the color:");
            String userGuess = scanner.nextLine();

            // Check if user's guess matches the correct color
            if (userGuess.equalsIgnoreCase(correctColor)) {
                correctGuesses++;
            }

            System.out.println("The correct color was: " + correctColor);
        }

        // Display number of correct guesses
        System.out.println("Number of correct guesses: " + correctGuesses);

        // Prompt the student to enter their name and description
        System.out.println("Please enter your name:");
        String studentName = scanner.nextLine();

        System.out.println("Please enter a sentence that describes yourself and the due date (MM/DD/YY):");
        String description = scanner.nextLine();

        // Display student's name and description
        System.out.println("Student Name: " + studentName);
        System.out.println("Description: " + description);

        scanner.close();
    }
}
