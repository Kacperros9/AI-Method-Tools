import java.util.*;

public class PathInversionOperator {

    // Inverts a segment in a path-based individual
    public static List<Integer> inversion(List<Integer> individual) {
        Random random = new Random();
        int size = individual.size();

        int point1 = random.nextInt(size);
        int point2 = random.nextInt(size);

        while (point1 == point2) {
            point2 = random.nextInt(size);
        }

        int start = Math.min(point1, point2);
        int end = Math.max(point1, point2);

        List<Integer> inverted = new ArrayList<>(individual);
        while (start < end) {
            int temp = inverted.get(start);
            inverted.set(start, inverted.get(end));
            inverted.set(end, temp);
            start++;
            end--;
        }
        return inverted;
    }

    public static void main(String[] args) {
        // Parents from Task 2 (example permutations)
        List<Integer> parent1 = Arrays.asList(3, 5, 1, 9, 2, 8, 6, 10, 7, 4);
        List<Integer> parent2 = Arrays.asList(7, 2, 4, 10, 1, 3, 6, 9, 5, 8);

        System.out.println("Parent 1: " + parent1);
        List<Integer> mutated1 = inversion(parent1);
        System.out.println("Inverted Parent 1: " + mutated1);

        System.out.println("\nParent 2: " + parent2);
        List<Integer> mutated2 = inversion(parent2);
        System.out.println("Inverted Parent 2: " + mutated2);
    }
}