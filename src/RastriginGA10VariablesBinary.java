import java.util.*;

public class RastriginGA10VariablesBinary {
    static final int NUM_VARIABLES = 10;
    static final double A = 10;
    static final double LOWER_BOUND = -5.21;
    static final double UPPER_BOUND = 5.21;
    static final double PRECISION = 0.001;
    static final int BITS_PER_VARIABLE = (int) Math.ceil(Math.log((UPPER_BOUND - LOWER_BOUND) / PRECISION + 1) / Math.log(2));
    static final int CHROMOSOME_LENGTH = NUM_VARIABLES * BITS_PER_VARIABLE;
    static final double MUTATION_PROBABILITY = 0.01;

    public static void main(String[] args) {
        // Generate random solution
        boolean[] chromosome = generateRandomChromosome();
        double[] decoded = decodeChromosome(chromosome);
        double fitnessBefore = rastriginFunction(decoded);

        System.out.println("Original chromosome:");
        System.out.println(Arrays.toString(decoded));
        System.out.printf("Function value: %.6f\n", fitnessBefore);

        // Apply mutation
        boolean[] mutatedChromosome = mutateChromosome(chromosome, MUTATION_PROBABILITY);
        double[] mutatedDecoded = decodeChromosome(mutatedChromosome);
        double fitnessAfter = rastriginFunction(mutatedDecoded);

        System.out.println("\nAfter mutation:");
        System.out.println(Arrays.toString(mutatedDecoded));
        System.out.printf("Function value: %.6f\n", fitnessAfter);
    }

    static boolean[] generateRandomChromosome() {
        Random rand = new Random();
        boolean[] chromosome = new boolean[CHROMOSOME_LENGTH];
        for (int i = 0; i < CHROMOSOME_LENGTH; i++) {
            chromosome[i] = rand.nextBoolean();
        }
        return chromosome;
    }

    static double[] decodeChromosome(boolean[] chromosome) {
        double[] decoded = new double[NUM_VARIABLES];
        for (int i = 0; i < NUM_VARIABLES; i++) {
            int start = i * BITS_PER_VARIABLE;
            int end = start + BITS_PER_VARIABLE;
            int value = 0;
            for (int j = start; j < end; j++) {
                value = (value << 1) | (chromosome[j] ? 1 : 0);
            }
            double x = LOWER_BOUND + value * (UPPER_BOUND - LOWER_BOUND) / (Math.pow(2, BITS_PER_VARIABLE) - 1);
            decoded[i] = Math.round(x * 1000.0) / 1000.0;
        }
        return decoded;
    }

    static double rastriginFunction(double[] x) {
        double sum = A * x.length;
        for (double xi : x) {
            sum += xi * xi - A * Math.cos(2 * Math.PI * xi);
        }
        return sum;
    }

    static boolean[] mutateChromosome(boolean[] chromosome, double pm) {
        Random rand = new Random();
        boolean[] mutated = chromosome.clone();
        for (int i = 0; i < mutated.length; i++) {
            if (rand.nextDouble() < pm) {
                mutated[i] = !mutated[i];
            }
        }
        return mutated;
    }
}