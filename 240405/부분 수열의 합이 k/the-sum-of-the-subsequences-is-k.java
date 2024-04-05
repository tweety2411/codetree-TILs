import java.util.Scanner;


public class Main {

    static int n, m, ans;
    static int[] arr;
    static int[] prefixSum;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n+1];
        prefixSum = new int[n+1];
        
        for(int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt();
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        ans = 0;
        for(int i = 1; i < n ; i++) {
            for(int j = i+1; j <= n; j++) {
                int result = prefixSum[j] - prefixSum[i] + arr[i];
                if(result == k) ans++;
            }
        }

        System.out.println(ans);
    }

}