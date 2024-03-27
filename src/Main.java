import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wektor 1:");
        Vector vector1 = Vector.createFromInput(scanner);

        System.out.println("Wektor 2:");
        Vector vector2 = Vector.createFromInput(scanner);

        try {
            int[] result = Vector.addVectors(vector1, vector2);
            Vector.saveVectorToFile(result, "wynik.txt");
            System.out.println("Wynik dodawania wektorów:");
            Vector.displayVector(result);
        } catch (WektoryRoznejDlugosciException e) {
            System.out.println("Wystąpił wyjątek: WektoryRoznejDlugosciException");
            System.out.println("Długość pierwszego wektora to " + e.getDlugoscPierwszego() +
                    " a drugiego to " + e.getDlugoscDrugiego());
        }
    }
}
