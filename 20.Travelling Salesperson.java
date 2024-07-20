package q30656;

public class TSPDynamicProgramming {

    // write your code here 
    private static int[][] dp;
    private static int[][] graph;
    private static int N;
    private static final int INF = Integer.MAX_VALUE / 2;  // A large value representing infinity

    // The tsp method implements the Held-Karp algorithm
    public static int tsp(int[][] graph, int N) {
        TSPDynamicProgramming.graph = graph;
        TSPDynamicProgramming.N = N;
        
        dp = new int[N][1 << N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start the tour from the first city (index 0) with the first city visited
        return tspHelper(0, 1);
    }


    private static int tspHelper(int pos, int visited) {
        if (visited == (1 << N) - 1) {
            return graph[pos][0];  // Return to the starting city
        }

        if (dp[pos][visited] != -1) {
            return dp[pos][visited];
        }

        int minCost = INF;

        for (int city = 0; city < N; city++) {
            if ((visited & (1 << city)) == 0) {  // If the city has not been visited
                int newCost = graph[pos][city] + tspHelper(city, visited | (1 << city));
                minCost = Math.min(minCost, newCost);
            }
        }

        dp[pos][visited] = minCost;
        return minCost;
	}    

	public static void main(String[] args) {
        	Scanner scanner = new Scanner(System.in);

        	System.out.print("Enter the number of cities: ");
        	int N = scanner.nextInt();

        	int[][] graph = new int[N][N];

        	System.out.println("Enter the weighted matrix of the graph:");
        	for (int i = 0; i < N; i++) {
            		for (int j = 0; j < N; j++) {
                		graph[i][j] = scanner.nextInt();
            		}
        	}

        	int minCost = tsp(graph, N);

        	System.out.println("Minimum cost to visit all cities: " + minCost);

        	scanner.close();
    	}
}
