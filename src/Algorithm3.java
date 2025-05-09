import java.util.Random;

public class Algorithm3 {
    public static void main(String[] args) {

        // a) Obliczenie liczby bitów na jedną zmienną
        double min = -5.21;
        double max = 5.21;
        double precision = 0.001;
        double range = max - min;
        int numberOfValues = (int) Math.round(range / precision);

        int bitsPerVariable = 0;
        while (Math.pow(2, bitsPerVariable) < numberOfValues) {
            bitsPerVariable++;
        }

        // b)
        int totalBits = bitsPerVariable * 2;

        System.out.println("Liczba bitów potrzebna do zakodowania jednej zmiennej: " + bitsPerVariable);
        System.out.println("Długość chromosomu (dla dwóch zmiennych): " + totalBits + " bitów");

        // c) Generowanie losowego chromosomu
        Random random = new Random();
        int[] chromosome = new int[totalBits];
        for (int i = 0; i < totalBits; i++) {
            chromosome[i] = random.nextInt(2); // 0 lub 1
        }

        // Wyświetlenie ciągu binarnego
        System.out.print("Chromosome: ");
        for (int bit : chromosome) {
            System.out.print(bit);
        }
        System.out.println();

        // d) Dekodowanie do x1 i x2
        double x1 = decode(chromosome, 0, bitsPerVariable, min, max);
        double x2 = decode(chromosome, bitsPerVariable, bitsPerVariable, min, max);

        System.out.println("x1 = " + x1 + ", x2 = " + x2);

        // Sprawdzenie ograniczeń
        if (x1 >= min && x1 <= max && x2 >= min && x2 <= max) {
            System.out.println("x1 i x2 są dopuszczalne.");
        } else {
            System.out.println("x1 lub x2 poza zakresem!");
        }

        // e) Wartość funkcji Rastrigina
        double f = rastrigin(x1, x2);
        System.out.println("f(x1, x2) = " + f);
    }

    // Funkcja dekodująca bity na wartość zmiennej
    static double decode(int[] chromosome, int offset, int bits, double min, double max) {
        int value = 0;
        for (int i = 0; i < bits; i++) {
            value = (value << 1) | chromosome[offset + i];
        }

        int maxVal = (1 << bits) - 1;
        return min + (value / (double) maxVal) * (max - min);
    }

    // Funkcja Rastrigina
    static double rastrigin(double x1, double x2) {
        int A = 10;
        return 2 * A + (x1 * x1 - A * Math.cos(2 * Math.PI * x1)) +
                (x2 * x2 - A * Math.cos(2 * Math.PI * x2));
    }
}
