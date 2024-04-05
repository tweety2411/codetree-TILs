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

        arr[0] = prefixSum[0] = 0;

        for(int i = 1; i < n+1; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            prefixSum[i] = prefixSum[i-1] + num;
        }

        ans = 0;
        for(int i = 1; i + k -1 < n; i++) {
            int result = prefixSum[i+k-1] - prefixSum[i] + arr[i];
            ans = Math.max(ans, result);
        }

        System.out.println(ans);
    }

}


class Node {
    String data;
    Node prev;
    Node next;

    public Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;

    }
}