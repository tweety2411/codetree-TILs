import java.util.Scanner;


public class Main {

    static int n, m, ans;
    static int[] arr;
    static int[] prefixSum;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k = sc.nextInt();
        int b = sc.nextInt();

        arr = new int[n+1];
        prefixSum = new int[n+1];

        for(int i = 1; i < b+1; i++) {
            int num = sc.nextInt();
            arr[num] = 1;
        }

        for(int i = 1; i < n+1; i++)
            prefixSum[i] = prefixSum[i-1] + arr[i];

        ans = Integer.MAX_VALUE;
        for(int i = 1; i + k - 1 <= n; i++) {
            for(int j = i+k-1; j <= n; j++) {
                int result = prefixSum[j] - prefixSum[i] + arr[i];
                ans = Math.min(ans, result);
            }
        }

        System.out.println(ans);
    }

}