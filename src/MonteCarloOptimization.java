import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MonteCarloOptimization {
    public static void main(String[] args) {
        int M = 1000;
        double T = 1.0;
        double gamma = 0.1;
        Random random = new Random();

        // Generate the initial random point X0 = (x1, x2) within the range [-2, 2]
        double x1 = -2 + 4 * random.nextDouble();
        double x2 = -2 + 4 * random.nextDouble();

        double fMax = f(x1, x2);
        double x1Max = x1;
        double x2Max = x2;

        try {
            FileWriter bestStepWriter = new FileWriter("best_step.txt");
            FileWriter currentWriter = new FileWriter("current.txt");

            for (int k = 1; k <= M; k++) {
                double x1New = x1;
                double x2New = x2;

                // Randomly select w ∈ {0, 1}
                int w = random.nextInt(2);
                double sigma1 = random.nextDouble(); // σ ∈ (0,1)
                double sigma2 = random.nextDouble();

                if (w == 1) {
                    x1New = x1 + gamma * sigma1;
                    x2New = x2 + gamma * sigma2;
                } else {
                    x1New = x1 - gamma * sigma1;
                    x2New = x2 - gamma * sigma2;
                }

                // Clamp to the interval [-2, 2]
                x1New = clamp(x1New, -2, 2);
                x2New = clamp(x2New, -2, 2);

                double fNew = f(x1New, x2New);
                currentWriter.write(k + "\t" + fNew + "\n");

                if (fNew > fMax) {
                    fMax = fNew;
                    x1Max = x1New;
                    x2Max = x2New;
                    x1 = x1New;
                    x2 = x2New;
                } else {
                    double Z = random.nextDouble();
                    double delta = (fNew - f(x1, x2)) / T;

                    if (Z < Math.exp(delta)) {
                        fMax = fNew;
                        x1Max = x1New;
                        x2Max = x2New;
                        x1 = x1New;
                        x2 = x2New;
                    }
                }

                bestStepWriter.write(k + "\t" + fMax + "\n");
            }

            bestStepWriter.close();
            currentWriter.close();

            System.out.println("fMax: " + fMax);
            System.out.println("Xmax: (" + x1Max + ", " + x2Max + ")");

        } catch (IOException e) {
            System.out.println("Error writing to file!");
            e.printStackTrace();
        }
    }

    public static double f(double x1, double x2) {
        return -x1 * x1 - x2 * x2 + 2;
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}