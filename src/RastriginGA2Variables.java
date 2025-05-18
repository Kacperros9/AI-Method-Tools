import java.util.Random;

public class RastriginGA2Variables {
    static final int BITS_PER_VARIABLE = 14;
    static final int TOTAL_BITS = 28;
    static final double MIN = -5.21;
    static final double MAX = 5.21;
    static final Random random = new Random();

    public static void main(String[] args) {

        // Generate two random valid parent chromosomes
        int[] parent1 = generateValidChromosome();
        int[] parent2 = generateValidChromosome();

        printChromosome("Parent 1", parent1);
        printChromosome("Parent 2", parent2);

        double f1 = rastrigin(decode(parent1, 0), decode(parent1, BITS_PER_VARIABLE));
        double f2 = rastrigin(decode(parent2, 0), decode(parent2, BITS_PER_VARIABLE));

        System.out.println("f(Parent1) = " + f1);
        System.out.println("f(Parent2) = " + f2);

        // a) Single-point crossover
        int[] child1 = new int[TOTAL_BITS];
        int[] child2 = new int[TOTAL_BITS];
        int crossoverPoint = random.nextInt(TOTAL_BITS - 1) + 1;

        for (int i = 0; i < crossoverPoint; i++) {
            child1[i] = parent1[i];
            child2[i] = parent2[i];
        }
        for (int i = crossoverPoint; i < TOTAL_BITS; i++) {
            child1[i] = parent2[i];
            child2[i] = parent1[i];
        }

        fixChromosome(child1);
        fixChromosome(child2);

        System.out.println("\n--- Single-point crossover ---");
        printChromosome("Child 1", child1);
        printChromosome("Child 2", child2);
        System.out.println("f(Child1) = " + rastrigin(decode(child1, 0), decode(child1, BITS_PER_VARIABLE)));
        System.out.println("f(Child2) = " + rastrigin(decode(child2, 0), decode(child2, BITS_PER_VARIABLE)));

        // b) Two-point crossover
        int p1 = random.nextInt(TOTAL_BITS - 2);
        int p2 = random.nextInt(TOTAL_BITS - p1 - 1) + p1 + 1;

        int[] child3 = parent1.clone();
        int[] child4 = parent2.clone();
        for (int i = p1; i < p2; i++) {
            child3[i] = parent2[i];
            child4[i] = parent1[i];
        }

        fixChromosome(child3);
        fixChromosome(child4);

        System.out.println("\n--- Two-point crossover ---");
        printChromosome("Child 3", child3);
        printChromosome("Child 4", child4);
        System.out.println("f(Child3) = " + rastrigin(decode(child3, 0), decode(child3, BITS_PER_VARIABLE)));
        System.out.println("f(Child4) = " + rastrigin(decode(child4, 0), decode(child4, BITS_PER_VARIABLE)));
    }

    static int[] generateValidChromosome() {
        int[] chrom;
        do {
            chrom = new int[TOTAL_BITS];
            for (int i = 0; i < TOTAL_BITS; i++) {
                chrom[i] = random.nextInt(2);
            }
        } while (!isValid(chrom));
        return chrom;
    }

    static boolean isValid(int[] chromosome) {
        double x1 = decode(chromosome, 0);
        double x2 = decode(chromosome, BITS_PER_VARIABLE);
        return (x1 >= MIN && x1 <= MAX) && (x2 >= MIN && x2 <= MAX);
    }

    static void fixChromosome(int[] chrom) {
        // If invalid, replace with a new random valid chromosome
        if (!isValid(chrom)) {
            int[] fixed = generateValidChromosome();
            System.arraycopy(fixed, 0, chrom, 0, TOTAL_BITS);
        }
    }

    static void printChromosome(String label, int[] chrom) {
        System.out.print(label + ": ");
        for (int bit : chrom) System.out.print(bit);
        System.out.println();

        double x1 = decode(chrom, 0);
        double x2 = decode(chrom, BITS_PER_VARIABLE);
        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }

    static double decode(int[] chromosome, int offset) {
        int value = 0;
        for (int i = 0; i < BITS_PER_VARIABLE; i++) {
            value = (value << 1) | chromosome[offset + i];
        }
        int maxVal = (1 << BITS_PER_VARIABLE) - 1;
        return MIN + (value / (double) maxVal) * (MAX - MIN);
    }

    static double rastrigin(double x1, double x2) {
        int A = 10;
        return 2 * A + (x1 * x1 - A * Math.cos(2 * Math.PI * x1)) +
                (x2 * x2 - A * Math.cos(2 * Math.PI * x2));
    }
}
