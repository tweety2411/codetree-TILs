import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static int n, m, ans;
    static int[] arr;
    static TreeSet<Integer> sets;
    static HashMap<Integer, Integer> map;

    static Point[] points;
    static int[] L_arrs;
    static int[] R_arrs;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        points = new Point[n + 1];
        L_arrs = new int[n + 1];
        R_arrs = new int[n + 1];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        for (int i = 1; i < n; i++) {
            L_arrs[i] = L_arrs[i - 1] + Math.abs(points[i].x - points[i - 1].x)
                    + Math.abs(points[i].y - points[i - 1].y);
        }

        for (int i = n - 2; i >= 0; i--) {
            R_arrs[i] = R_arrs[i + 1] + Math.abs(points[i + 1].x - points[i].x)
                    + Math.abs(points[i + 1].y - points[i].y);
        }

        ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            ans = Math.min(ans, L_arrs[i - 1] + R_arrs[i + 1] + Math.abs(points[i + 1].x - points[i - 1].x)
                    + Math.abs(points[i + 1].y - points[i - 1].y));
        }

        System.out.println(ans);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}