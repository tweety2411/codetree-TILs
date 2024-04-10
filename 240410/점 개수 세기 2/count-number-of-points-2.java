import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

    static int n, m, ans;
    static Point[] arr;
    static int[][] prefixSum;
    static TreeSet<Integer> sets;
    static Tuple[] tuples;

    static HashMap<Integer, Integer> map;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int q = sc.nextInt();

        arr = new Point[n];
        sets = new TreeSet<>();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Point(x,y);
            sets.add(x);
            sets.add(y);
        }

        map = new HashMap<>();
        int cnt = 1;
        for(Integer num : sets) {
            map.put(num, cnt);
            cnt++;
        }

        prefixSum = new int[2000][2000];
        for(int i = 0; i < n; i++) {
            int x = map.get(arr[i].x);
            int y = map.get(arr[i].y);

            prefixSum[x][y]++;
        }

        tuples = new Tuple[q];
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            tuples[i] = new Tuple(x1, y1, x2, y2);
        }

        for(int i = 1; i <= cnt; i++ ) {
            for(int j = 1; j <= cnt; j++) {
                prefixSum[i][j] += prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }
        
        for(int i = 0; i < q; i++) {

            int newX1 = getUpperBoundry(tuples[i].x1);
            int newY1 = getUpperBoundry(tuples[i].y1);
            int newX2 = getLowerBoundry(tuples[i].x2);
            int newY2 = getLowerBoundry(tuples[i].y2);

            ans = getSum(newX1, newY1, newX2, newY2);
            System.out.println(ans);
        }
    }

    private static int getSum(int newX1, int newY1, int newX2, int newY2) {
        return prefixSum[newX2][newY2] - prefixSum[newX1-1][newY2] - prefixSum[newX2][newY1-1]
                + prefixSum[newX1-1][newY1-1];
    }

    private static int getLowerBoundry(int y1) {
        if(null != sets.floor(y1)) return map.get(sets.floor(y1));
        return 0;
    }

    // x1보다 크거나 같은 좌표를 구해 리턴
    private static int getUpperBoundry(int x1) {
       if(sets.ceiling(x1) != null) return map.get(sets.ceiling(x1));
       return sets.size() + 1;
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

class Tuple {
    int x1;
    int y1;
    int x2;
    int y2;

    public Tuple(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}