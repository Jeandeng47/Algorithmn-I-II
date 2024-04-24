import java.util.Random;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_35 {
    public static void main(String[] args) {
        // 1. Compute theoretical probability distribution of sum of two dice
        int SIDES = 6;
        double[] theorectialDist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                theorectialDist[i + j] += 1.0;
            }
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            theorectialDist[k] /= 36.0;
        }

        // 2. Simulation of rolling two dice for N time
        Random rand = new Random();
        int N = 100; // num of simulations
        boolean cloesEnough;
        do {
            cloesEnough = true;
            double[] empiricalDist = new double[2 * SIDES + 1];
            for (int i = 0; i < N; i++) {
                int rollD1 = rand.nextInt(SIDES) + 1;
                int rollD2 = rand.nextInt(SIDES) + 1;
                empiricalDist[rollD1 + rollD2] += 1.0;
            }
            StdOut.println("Number of simulations: " + N);

            // 3. Compare theorectical and empirical results
            for (int k = 2; k <= 2 * SIDES; k++) {
                double empiricalProb = empiricalDist[k] / N;
                StdOut.printf("Sum %d: Theoretical = %.3f, Emprical = %.3f\n",
                        k, theorectialDist[k], empiricalProb);
                if (Math.abs(empiricalProb - theorectialDist[k]) > 0.01) {
                    cloesEnough = false;
                }
            }

            // 4. Determine N
            if (!cloesEnough) {
                N *= 2;
            }

        } while (!cloesEnough);

    }
}
