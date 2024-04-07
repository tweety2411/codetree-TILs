import java.util.HashMap;
import java.util.Scanner;


public class Main {

    static int n, m, ans;
    static int[][] arr;
    static int[][] prefixSum;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n+1][n+1];
        prefixSum = new int[n+1][n+1];

        ans = Integer.MIN_VALUE;
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=n; j++) {
                arr[i][j] = sc.nextInt();
                ans = Math.max(ans, arr[i][j]);
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i][j];
            }
        }

        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
               int result = getSumWidth(i, j);
               ans = Math.max(result, ans);
               result = getSumHeight(j, i);
                ans = Math.max(result, ans);
            }
        }

        System.out.println(ans);
    }

    private static int getSumHeight(int x, int y) {
        if (x + 1 == n) return prefixSum[x][y];
        int x2 = x + 1;
        int y2 = y;
        int max = Integer.MIN_VALUE;
        for(int i = x2; i <=n;i++) {
            int result =  prefixSum[i][y2] - prefixSum[x - 1][y2] - prefixSum[i][y-1] + prefixSum[x-1][y-1];
            max = Math.max(max, result);
        }
        return max;
    }

    private static int getSumWidth(int x, int y) {
        if(y+1 == n) return prefixSum[x][y];
        int x2 = x;
        int y2 = y+1;
        int max = Integer.MIN_VALUE;
        for(int i = y2 ; i <= n; i++) {
           int result = prefixSum[x2][i] - prefixSum[x - 1][i] - prefixSum[x2][y-1] + prefixSum[x-1][y-1];
           max = Math.max(max, result);
        }

        return max;
    }

}