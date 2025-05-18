import java.util.Random;

public class RastriginGA10Variables {
    static final int N = 10; // number of variables
    static final double MIN = -5.21;
    static final double MAX = 5.21;
    static final int PRECISION = 1000; // for 0.001
    static final int BITS_PER_VAR = (int) Math.ceil(Math.log((MAX - MIN) * PRECISION + 1) / Math.log(2));
    static final int TOTAL_BITS = BITS_PER_VAR * N;

    public static void main(String[] args) {
        Random random = new Random();

        int[] parent1 = generateValidChromosome(random);
        int[] parent2 = generateValidChromosome(random);

        System.out.println("Parent 1: " + toBinaryString(parent1));
        System.out.println("Parent 2: " + toBinaryString(parent2));
        System.out.println("f(Parent 1): " + rastrigin(decode(parent1)));
        System.out.println("f(Parent 2): " + rastrigin(decode(parent2)));

        // a) Single-point crossover
        int point = random.nextInt(TOTAL_BITS - 1) + 1;
        int[] child1 = crossover(parent1, parent2, point, -1);
        int[] child2 = crossover(parent2, parent1, point, -1);
        child1 = repairIfInvalid(child1);
        child2 = repairIfInvalid(child2);

        System.out.println("\n--- Single-point crossover ---");
        System.out.println("f(Child 1): " + rastrigin(decode(child1)));
        System.out.println("f(Child 2): " + rastrigin(decode(child2)));

        // b) Two-point crossover
        int point1 = random.nextInt(TOTAL_BITS - 2);
        int point2 = point1 + 1 + random.nextInt(TOTAL_BITS - point1 - 1);
        int[] child3 = crossover(parent1, parent2, point1, point2);
        int[] child4 = crossover(parent2, parent1, point1, point2);
        child3 = repairIfInvalid(child3);
        child4 = repairIfInvalid(child4);

        System.out.println("\n--- Two-point crossover ---");
        System.out.println("f(Child 3): " + rastrigin(decode(child3)));
        System.out.println("f(Child 4): " + rastrigin(decode(child4)));
    }

    static int[] generateValidChromosome(Random random) {
        int[] chrom;
        double[] decoded;
        do {
            chrom = new int[TOTAL_BITS];
            for (int i = 0; i < TOTAL_BITS; i++) chrom[i] = random.nextInt(2);
            decoded = decode(chrom);
        } while (!isValid(decoded));
        return chrom;
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

    static int[] crossover(int[] p1, int[] p2, int point1, int point2) {
        int[] child = new int[TOTAL_BITS];
        if (point2 == -1) { // single-point
            for (int i = 0; i < TOTAL_BITS; i++) {
                child[i] = i < point1 ? p1[i] : p2[i];
            }
        } else { // two-point
            for (int i = 0; i < TOTAL_BITS; i++) {
                if (i < point1 || i >= point2)
                    child[i] = p1[i];
                else
                    child[i] = p2[i];
            }
        }
        return child;
    }

    static int[] repairIfInvalid(int[] chromosome) {
        double[] vars = decode(chromosome);
        if (isValid(vars)) return chromosome;

        // Repair: generate a new valid chromosome
        Random rand = new Random();
        return generateValidChromosome(rand);
    }

    static String toBinaryString(int[] chromosome) {
        StringBuilder sb = new StringBuilder();
        for (int bit : chromosome) {
            sb.append(bit);
        }
        return sb.toString();
    }
}
