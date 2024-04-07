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
        arr = new int[100001];
        prefixSum = new int[1000001];

        for(int i = 1; i < n+1; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            prefixSum[arr[i]]++;
        }

        for(int i = 1; i <=1000000; i++) {
            prefixSum[i] += prefixSum[i-1];
        }

        for(int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if(s == 0) {
                System.out.println( prefixSum[e]);
            } else {
                int result = prefixSum[e] - prefixSum[s-1] ;
                System.out.println(result);

            }
        }

    }

}