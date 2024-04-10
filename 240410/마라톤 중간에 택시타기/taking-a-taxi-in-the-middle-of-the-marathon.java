import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

    static int n, m, ans;
    static int[] arr;
    static TreeSet<Integer> sets;
    static HashMap<Integer, Integer> map;

    static Point[] points;
    static int[] xl_arrs;
    static int[] xr_arrs;
    static int[] yl_arrs;
    static int[] yr_arrs;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        points = new Point[n+1];

        points[0] = new Point(0,0);
        for(int i = 1; i <= n; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }

        xr_arrs = new int[n+1];
        xl_arrs = new int[n+1];
        yl_arrs = new int[n+1];
        yr_arrs = new int[n+1];

        for(int i = 1; i <= n; i++) {
            xl_arrs[i] = xl_arrs[i-1] + Math.abs(points[i].x - points[i-1].x);
            yl_arrs[i] = yl_arrs[i-1] + Math.abs(points[i].y - points[i-1].y);
        }

        for(int i = n-1; i > 0; i--) {
            xr_arrs[i] = xr_arrs[i+1] + Math.abs(points[i+1].x - points[i].x);
            yr_arrs[i] = yr_arrs[i+1] + Math.abs(points[i+1].y - points[i].y);
        }

        ans = Integer.MAX_VALUE;
        for(int i = 2; i < n; i++) {
            int x = xl_arrs[i-1] + xr_arrs[i+1] + Math.abs(points[i+1].x - points[i-1].x);
            int y = yl_arrs[i-1] + yr_arrs[i+1] + Math.abs(points[i+1].y - points[i-1].y);
            ans = Math.min(ans, x+y);
        }
        System.out.println(ans);
    }


}

class Point {
    int x;
    int y;

    public  Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}