import java.util.Scanner;

public class Main {
    public static int n, ans;
    static int[][] arr;
    static int[][] prefixSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n + 1][n + 1];
        prefixSum = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = sc.nextInt();
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        ans = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                ans = Math.max(ans, getMaxArea(i, j));
            }
        }

        System.out.println(ans);
    }

    private static int getMaxArea(int x1, int x2) {

        int max = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];
        for (int y = 1; y < n + 1; y++) {
            int result = getSum(x1, y, x2, y);

            dp[y] = Math.max(result, dp[y - 1] + result);
        }

        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int getSum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }

}