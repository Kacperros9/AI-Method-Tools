import java.util.Random;

public class RastriginEncodingDecoding {
    public static void main(String[] args) {

        // a) Calculate the number of bits required to encode a single variable
        double min = -5.21;
        double max = 5.21;
        double precision = 0.001;
        double range = max - min;
        int numberOfValues = (int) Math.round(range / precision);

        int bitsPerVariable = 0;
        while (Math.pow(2, bitsPerVariable) < numberOfValues) {
            bitsPerVariable++;
        }

        // b) Calculate the total number of bits for both variables (i.e., chromosome length)
        int totalBits = bitsPerVariable * 2;

        System.out.println("Number of bits required to encode one variable: " + bitsPerVariable);
        System.out.println("Chromosome length (for two variables): " + totalBits + " bits");

        // c) Generate a random binary chromosome
        Random random = new Random();
        int[] chromosome = new int[totalBits];
        for (int i = 0; i < totalBits; i++) {
            chromosome[i] = random.nextInt(2); // 0 lub 1
        }

        // Printing the binary chromosome
        System.out.print("Chromosome: ");
        for (int bit : chromosome) {
            System.out.print(bit);
        }
        System.out.println();

        // d) Decode the binary chromosome into x1 and x2 values
        double x1 = decode(chromosome, 0, bitsPerVariable, min, max);
        double x2 = decode(chromosome, bitsPerVariable, bitsPerVariable, min, max);

        System.out.println("x1 = " + x1 + ", x2 = " + x2);

        // Check if the decoded values are within the valid range
        if (x1 >= min && x1 <= max && x2 >= min && x2 <= max) {
            System.out.println("x1 and x2 are within valid range.");
        } else {
            System.out.println("x1 or x2 are out of range!");
        }

        // e) Evaluate the Rastrigin function value
        double f = rastrigin(x1, x2);
        System.out.println("f(x1, x2) = " + f);
    }

    // Decodes a section of the binary chromosome to a real-valued variable
    static double decode(int[] chromosome, int offset, int bits, double min, double max) {
        int value = 0;
        for (int i = 0; i < bits; i++) {
            value = (value << 1) | chromosome[offset + i];
        }

        int maxVal = (1 << bits) - 1;
        return min + (value / (double) maxVal) * (max - min);
    }

    // Rastrigin function evaluation for two variables
    static double rastrigin(double x1, double x2) {
        int A = 10;
        return 2 * A + (x1 * x1 - A * Math.cos(2 * Math.PI * x1)) +
                (x2 * x2 - A * Math.cos(2 * Math.PI * x2));
    }
}