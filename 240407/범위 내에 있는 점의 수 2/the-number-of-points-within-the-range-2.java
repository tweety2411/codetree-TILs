import java.util.HashMap;
import java.util.Scanner;


public class Main {

    static int n, m, ans;
    static int[] arr;
    static int[] prefixSum;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int q = sc.nextInt();

        map = new HashMap<>();
        arr = new int[1000001];
        prefixSum = new int[100001];

        int max = 0;
        for(int i = 1; i < n+1; i++) {
            int num = sc.nextInt();
            arr[num] = 1;
            max = Math.max(num, max);
        }

        for(int i = 1; i <=max; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            int result = prefixSum[e] - prefixSum[s] + arr[s];
            System.out.println(result);
        }

    }

}