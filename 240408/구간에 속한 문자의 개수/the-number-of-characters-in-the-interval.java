import java.util.Scanner;

public class Main {
    public static int n, m, ans;
    static String[][] arr;
    static int[][] prefixSum_a;
    static int[][] prefixSum_b;
    static int[][] prefixSum_c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        arr = new String[n + 1][m + 1];
        prefixSum_a = new int[n + 1][m + 1];
        prefixSum_b = new int[n + 1][m + 1];
        prefixSum_c = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            String[] strs = sc.next().split("");
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = strs[j - 1];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                String word = arr[i][j];
                prefixSum_a[i][j] = prefixSum_a[i - 1][j] + prefixSum_a[i][j - 1] - prefixSum_a[i - 1][j - 1];
                prefixSum_b[i][j] = prefixSum_b[i - 1][j] + prefixSum_b[i][j - 1] - prefixSum_b[i - 1][j - 1];
                prefixSum_c[i][j] = prefixSum_c[i - 1][j] + prefixSum_c[i][j - 1] - prefixSum_c[i - 1][j - 1];
                if (word.equals("a")) {
                    prefixSum_a[i][j]++;
                } else if (word.equals("b")) {
                    prefixSum_b[i][j]++;
                } else if (word.equals("c")) {
                    prefixSum_c[i][j]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int a = getSumA(x1, y1, x2, y2);
            int b = getSumB(x1, y1, x2, y2);
            int c = getSumC(x1, y1, x2, y2);
            System.out.println(a + " " + b + " " + c);
        }

    }

    private static int getSumC(int x1, int y1, int x2, int y2) {
        return prefixSum_c[x2][y2] - prefixSum_c[x1 - 1][y2] - prefixSum_c[x2][y1 - 1] + prefixSum_c[x1 - 1][y1 - 1];
    }

    private static int getSumB(int x1, int y1, int x2, int y2) {
        return prefixSum_b[x2][y2] - prefixSum_b[x1 - 1][y2] - prefixSum_b[x2][y1 - 1] + prefixSum_b[x1 - 1][y1 - 1];
    }

    private static int getSumA(int x1, int y1, int x2, int y2) {
        return prefixSum_a[x2][y2] - prefixSum_a[x1 - 1][y2] - prefixSum_a[x2][y1 - 1] + prefixSum_a[x1 - 1][y1 - 1];
    }

}