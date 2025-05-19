import java.util.*;

public class PMXCrossoverOperator {

    public static void main(String[] args) {
        // Step 1: Generate two random parent permutations from [1,10]
        List<Integer> parent1 = generateRandomPermutation(10);
        List<Integer> parent2 = generateRandomPermutation(10);

        System.out.println("Parent 1: " + parent1);
        System.out.println("Parent 2: " + parent2);

        // Step 2: Apply PMX crossover
        List<List<Integer>> offspring = pmxCrossover(parent1, parent2);

        System.out.println("Offspring 1: " + offspring.get(0));
        System.out.println("Offspring 2: " + offspring.get(1));
    }

    private static List<Integer> generateRandomPermutation(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    private static List<List<Integer>> pmxCrossover(List<Integer> parent1, List<Integer> parent2) {
        int size = parent1.size();
        Random rand = new Random();
        int point1 = rand.nextInt(size);
        int point2 = rand.nextInt(size);

        // Ensure point1 < point2
        if (point1 > point2) {
            int temp = point1;
            point1 = point2;
            point2 = temp;
        }

        List<Integer> child1 = new ArrayList<>(Collections.nCopies(size, -1));
        List<Integer> child2 = new ArrayList<>(Collections.nCopies(size, -1));

        // Copy the crossover section
        for (int i = point1; i <= point2; i++) {
            child1.set(i, parent2.get(i));
            child2.set(i, parent1.get(i));
        }

        // Helper for resolving mapping conflicts
        pmxFill(child1, parent1, parent2, point1, point2);
        pmxFill(child2, parent2, parent1, point1, point2);

        return List.of(child1, child2);
    }

    private static void pmxFill(List<Integer> child, List<Integer> parentFrom, List<Integer> parentTo, int point1, int point2) {
        for (int i = 0; i < parentFrom.size(); i++) {
            if (i >= point1 && i <= point2) continue;
            int gene = parentFrom.get(i);
            while (child.contains(gene)) {
                int index = parentFrom.indexOf(gene);
                gene = parentTo.get(index);
            }
            child.set(i, gene);
        }
    }
}
