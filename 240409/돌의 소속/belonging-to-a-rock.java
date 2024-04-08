import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n, m, ans;
    static int[] arr;
    static int[] prefixSum_a;
    static int[] prefixSum_b;
    static int[] prefixSum_c;

    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");
        n = Integer.parseInt(lines[0]);
        int q = Integer.parseInt(lines[1]);

        arr = new int[n + 1];
        prefixSum_a = new int[n + 1];
        prefixSum_b = new int[n + 1];
        prefixSum_c = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            prefixSum_a[i] = prefixSum_a[i - 1];
            prefixSum_b[i] = prefixSum_b[i - 1];
            prefixSum_c[i] = prefixSum_c[i - 1];
            if (arr[i] == 1)
                prefixSum_a[i]++;
            else if (arr[i] == 2)
                prefixSum_b[i]++;
            else if (arr[i] == 3)
                prefixSum_c[i]++;
        }

        for (int i = 0; i < q; i++) {
            lines = br.readLine().split(" ");
            int start = Integer.parseInt(lines[0]);
            int end = Integer.parseInt(lines[1]);

            int a = getSumA(start, end);
            int b = getSumB(start, end);
            int c = getSumC(start, end);
            System.out.println(a + " " + b + " " + c);
        }

    }

    private static int getSumC(int start, int end) {
        return prefixSum_c[end] - prefixSum_c[start - 1];
    }

    private static int getSumB(int start, int end) {
        return prefixSum_b[end] - prefixSum_b[start - 1];
    }

    private static int getSumA(int start, int end) {
        return prefixSum_a[end] - prefixSum_a[start - 1];
    }

}