import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomWalkOptimization {
    public static void main(String[] args) {
        Random random = new Random();

        int M = 1000; // number of iterations

        // Generate the initial random point X0 = (x1, x2) within the range [-2, 2]
        double x1 = random.nextDouble(-2, 2);
        double x2 = random.nextDouble(-2, 2);

        double fmax = f(x1, x2);
        double x1max = x1,
                x2max = x2;

        try {
            FileWriter bestStepWriter = new FileWriter("best_step.txt");
            FileWriter currentWriter = new FileWriter("current.txt");

            // Random walk algorithm
            for (int k = 1; k <= M; k++) {
                x1 = random.nextDouble(-2, 2);
                x2 = random.nextDouble(-2, 2);

                double fValue = f(x1, x2);

                currentWriter.write(k + "\t" + fValue + "\n");

                if (fValue > fmax) {
                    fmax = fValue;
                    x1max = x1;
                    x2max = x2;
                }

                bestStepWriter.write(k + "\t" + fmax + "\n");
            }
            bestStepWriter.close();
            currentWriter.close();

            System.out.println("Fmax: " + fmax + " Xmax: (" + x1max + " ; " + x2max + ")");

        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
        }
    }
    public static double f(double x1, double x2) {
        return -x1 * x1 - x2 * x2 + 2;
    }
}