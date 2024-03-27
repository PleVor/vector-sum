import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vector {
    private int[] values;

    public Vector(int[] values) {
        this.values = values;
    }

    public static Vector createFromInput(Scanner scanner) {
        System.out.println("Podaj wektor, zakończ enterem:");
        String input = scanner.nextLine();
        String[] split = input.trim().split("\\s+");

        int[] vectorValues = new int[split.length];
        boolean isValid = true; // Flaga sprawdzająca poprawność całego wektora
        for (int i = 0; i < split.length; i++) {
            try {
                vectorValues[i] = Integer.parseInt(split[i]);
            } catch (NumberFormatException ignored) {
                isValid = false;
                System.out.println("Błąd: Wprowadzono niepoprawną liczbę. Proszę podać wektor ponownie.");
                break; // Przerwij pętlę w przypadku błędnej liczby
            }
        }

        if (!isValid) {
            return createFromInput(scanner); // Rekurencyjnie próbujemy ponownie
        }

        return new Vector(vectorValues);
    }

    public int[] getValues() {
        return values;
    }

    public static int[] addVectors(Vector v1, Vector v2) throws WektoryRoznejDlugosciException {
        int[] vec1 = v1.getValues();
        int[] vec2 = v2.getValues();

        if (vec1.length != vec2.length) {
            throw new WektoryRoznejDlugosciException(vec1.length, vec2.length);
        }

        int[] result = new int[vec1.length];
        for (int i = 0; i < vec1.length; i++) {
            result[i] = vec1[i] + vec2[i];
        }
        return result;
    }

    public static void saveVectorToFile(int[] vector, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int value : vector) {
                writer.write(value + " ");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }
    }

    public static void displayVector(int[] vector) {
        for (int value : vector) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
