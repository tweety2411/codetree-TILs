import java.util.Scanner;


public class Main {

    static int n, m, ans;
    static int[][] arr;
    static int[][] prefixSum;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n+1][n+1];
        prefixSum = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                arr[i][j] = sc.nextInt();
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] + arr[i][j] - prefixSum[i-1][j-1];
            }
        }

        ans = 0;
        for(int i = 1; i + k -1 < n + 1; i++) {
            for(int j = 1; j + k -1 < n + 1; j++) {
                int x1 = i;
                int y1 = j;
                int x2 = i + k - 1;
                int y2 = j + k - 1;

                int result = prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
                ans = Math.max(ans, result);
            }
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