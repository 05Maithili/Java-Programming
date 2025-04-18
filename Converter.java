import java.util.*;

interface TemperatureConversion {
    final int y=5/9;
    double convertToCelsius(double x);
    double convertToFahrenheit(double x);
}

interface LengthConversion {
    double convertCToMeter(double x);
    double convertToCentimeter(double x);
    double convertToFeet(double x);
}

interface TimeConversion {
    double convertToSecond(double x);
    double convertToMinute(double x);
}

interface DisplayInfo {
    void displayMenu();
}

interface UnitOperations extends TemperatureConversion, LengthConversion, TimeConversion, DisplayInfo {}

class UnitConverter implements UnitOperations {
    @Override
    public double convertToCelsius(double x) {
        return (x - 32) * 5/9;
    }

    @Override
    public double convertToFahrenheit(double x) {
        return (x * 9/5) + 32;
    }

    @Override
    public double convertCToMeter(double x) {
        return x / 100;
    }

    @Override
    public double convertToCentimeter(double x) {
        return x * 100;
    }

    @Override
    public double convertToFeet(double x) {
        return x * 3.28084;
    }

    @Override
    public double convertToSecond(double x) {
        return x * 60;
    }

    @Override
    public double convertToMinute(double x) {
        return x / 60;
    }

    @Override
    public void displayMenu() {
        System.out.println("\nSource Units:");
        System.out.println("1. Fahrenheit");
        System.out.println("2. Celsius");
        System.out.println("3. Centimeter");
        System.out.println("4. Meter");
        System.out.println("5. Feet");
        System.out.println("6. Minutes");
        System.out.println("7. Seconds");
        System.out.print("Enter source unit: ");
    }
}

public class Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnitConverter converter = new UnitConverter();

        while (true) {
            System.out.print("\nEnter value: ");
            double value = scanner.nextDouble();

            converter.displayMenu();
            int sourceUnit = scanner.nextInt();

            System.out.println("\nTarget Units:");
            System.out.println("1. Celsius");
            System.out.println("2. Fahrenheit");
            System.out.println("3. Meter");
            System.out.println("4. Centimeter");
            System.out.println("5. Feet");
            System.out.println("6. Seconds");
            System.out.println("7. Minutes");
            System.out.print("Enter target unit: ");
            int targetUnit = scanner.nextInt();

            double result = convert(converter, value, sourceUnit, targetUnit);
            System.out.println("Converted value: " + result);

            System.out.print("\nDo you want to perform another conversion? (yes/no): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }

    public static double convert(UnitConverter converter, double value, int sourceUnit, int targetUnit) {
        double baseValue = 0;
        switch (sourceUnit) {
            case 1: baseValue = converter.convertToCelsius(value); break;
            case 2: baseValue = value; break;
            case 3: baseValue = converter.convertCToMeter(value); break;
            case 4: baseValue = value; break;
            case 5: baseValue = value / 3.28084; break;
            case 6: baseValue = converter.convertToSecond(value); break;
            case 7: baseValue = value; break;
        }

        switch (targetUnit) {
            case 1: return baseValue;
            case 2: return converter.convertToFahrenheit(baseValue);
            case 3: return baseValue;
            case 4: return converter.convertToCentimeter(baseValue);
            case 5: return converter.convertToFeet(baseValue);
            case 6: return baseValue;
            case 7: return converter.convertToMinute(baseValue);
        }
        return 0;
    }
}
