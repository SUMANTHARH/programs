package q30652;
import java.util.Scanner;
public class Knapsack {

    // write your code here 
    public static int knapsack(int[] w, int[] p, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (w[i - 1] <= j)
                    dp[i][j] = Math.max(p[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][W];
	}
    
    
    
    
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] w = new int[n];
        int[] p = new int[n];

        System.out.println("Enter the weight and price of all items:");
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of knapsack: ");
        int W = scanner.nextInt();

        int max = knapsack(w, p, n, W);
        System.out.println("The maximum value of items that can be put into the knapsack is: " + max);

        scanner.close();
    }
}
