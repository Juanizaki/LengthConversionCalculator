/* Author: JUAN A RAMOS III
Created Date: 03/26/2023
Description: Length Conversion Calculator for units (Inch, Foot, Yard, Mile)
*/

import java.util.*;

public class LengthConversionCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Define conversion factors between units
        HashMap<String, Double> conversionFactors = new HashMap<>();
        conversionFactors.put("in", 1.0);
        conversionFactors.put("ft", 12.0);
        conversionFactors.put("yd", 36.0);
        conversionFactors.put("mi", 63360.0);

        // Main loop
        boolean done = false;
        while (!done) {

            // Display unit options and ask for user input
            System.out.println("Select the units you would like to convert: ");
            System.out.println("1. Inch");
            System.out.println("2. Foot");
            System.out.println("3. Yard");
            System.out.println("4. Mile");
            System.out.print("Enter the number corresponding to the unit you would like to convert FROM (1-4): ");
            int fromChoice;
            while (true) {
                try {
                    fromChoice = input.nextInt();
                    break;
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Invalid entry, try again.");
                }
            }
            String unitFrom = getUnitFromChoice(fromChoice);
            if (unitFrom == null) {
                System.out.println("Invalid entry, try again.");
                continue;
            }
            System.out.print("Enter the number corresponding to the unit you would like to convert TO (1-4): ");
            int toChoice;
            while (true) {
                try {
                    toChoice = input.nextInt();
                    break;
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Invalid entry, try again.");
                }
            }
            String unitTo = getUnitFromChoice(toChoice);
            if (unitTo == null) {
                System.out.println("Invalid entry, try again.");
                continue;
            }

            // Get the measurement from the user
            double measurement;
            while (true) {
                System.out.print("Enter the measurement to convert: ");
                try {
                    measurement = Double.parseDouble(input.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entry, try again.");
                }
            }
            // Convert the measurement to the desired unit
            double convertedMeasurement = measurement * conversionFactors.get(unitFrom) / conversionFactors.get(unitTo);

            // Display the converted measurement
            System.out.printf("%.2f %s = %.2f %s\n", measurement, unitFrom, convertedMeasurement, unitTo);

            // Ask if the user wants to perform another conversion
            String answer;
            do {
                System.out.print("Perform another conversion? (Y/N): ");
                answer = input.next();
                System.out.println("Invalid entry, try again.");
            } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
            if (answer.equalsIgnoreCase("N")) {
                done = true;
            }
        }
        // Exit message
        System.out.println("Thanks for using the Length Conversion Calculator!!!");
    }

    private static String getUnitFromChoice(int choice) {
        return switch (choice) {
            case 1 -> "in";
            case 2 -> "ft";
            case 3 -> "yd";
            case 4 -> "mi";
            default -> null;
        };
    }
}