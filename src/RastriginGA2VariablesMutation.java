import java.util.Random;

public class RastriginGA2VariablesMutation {
    static final int N = 2;
    static final double MIN = -5.21;
    static final double MAX = 5.21;
    static final int PRECISION = 1000; // 3 decimal places
    static final int BITS_PER_VAR = (int) Math.ceil(Math.log((MAX - MIN) * PRECISION + 1) / Math.log(2));
    static final int TOTAL_BITS = BITS_PER_VAR * N;

    public static void main(String[] args) {
        Random random = new Random();
        double mutationProbability = 0.01; // Example value, can be adjusted

        // 1.1 – Generate valid binary chromosome
        int[] chromosome = generateValidChromosome(random);
        System.out.println("Original chromosome: " + toBinaryString(chromosome));

        // 1.2 – Decode and evaluate function
        double[] decoded = decode(chromosome);
        double originalValue = rastrigin(decoded);
        System.out.println("f(original): " + originalValue);

        // 1.3 – Apply mutation operator
        int[] mutatedChromosome = mutateChromosome(chromosome, mutationProbability, random);
        mutatedChromosome = repairIfInvalid(mutatedChromosome); // ensure feasibility
        System.out.println("Mutated chromosome: " + toBinaryString(mutatedChromosome));

        // 1.4 – Decode and evaluate mutated solution
        double[] mutatedDecoded = decode(mutatedChromosome);
        double mutatedValue = rastrigin(mutatedDecoded);
        System.out.println("f(mutated): " + mutatedValue);

        // Change check
        if (originalValue != mutatedValue) {
            System.out.println("The function value has changed after mutation.");
        } else {
            System.out.println("The function value did not change after mutation.");
        }
    }

    static int[] generateValidChromosome(Random random) {
        int[] chromosome;
        double[] decoded;
        do {
            chromosome = new int[TOTAL_BITS];
            for (int i = 0; i < TOTAL_BITS; i++) {
                chromosome[i] = random.nextInt(2);
            }
            decoded = decode(chromosome);
        } while (!isValid(decoded));
        return chromosome;
    }

    static double[] decode(int[] chromosome) {
        double[] result = new double[N];
        int maxVal = (1 << BITS_PER_VAR) - 1;
        for (int i = 0; i < N; i++) {
            int val = 0;
            for (int j = 0; j < BITS_PER_VAR; j++) {
                val = (val << 1) | chromosome[i * BITS_PER_VAR + j];
            }
            result[i] = MIN + (val / (double) maxVal) * (MAX - MIN);
        }
        return result;
    }

    static boolean isValid(double[] vars) {
        for (double x : vars) {
            if (x < MIN || x > MAX) return false;
        }
        return true;
    }

    static double rastrigin(double[] vars) {
        int A = 10;
        double sum = A * vars.length;
        for (double x : vars) {
            sum += x * x - A * Math.cos(2 * Math.PI * x);
        }
        return sum;
    }

    static int[] mutateChromosome(int[] chromosome, double mutationProbability, Random random) {
        int[] mutated = chromosome.clone();
        for (int i = 0; i < mutated.length; i++) {
            if (random.nextDouble() < mutationProbability) {
                mutated[i] = 1 - mutated[i]; // flip bit
            }
        }
        return mutated;
    }

    static int[] repairIfInvalid(int[] chromosome) {
        double[] vars = decode(chromosome);
        if (isValid(vars)) return chromosome;

        // If invalid, generate a new valid chromosome
        return generateValidChromosome(new Random());
    }

    static String toBinaryString(int[] chromosome) {
        StringBuilder sb = new StringBuilder();
        for (int bit : chromosome) {
            sb.append(bit);
        }
        return sb.toString();
    }
}
