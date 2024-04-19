import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static int n, m, ans;
    static int[] arr;

    static TreeSet<Integer> sets;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sets = new TreeSet<>();
        for (int i = 0; i < n * 2; i++) {
            sets.add(i + 1);
        }

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sets.remove(arr[i]);
        }

        ans = 0;

        for (int i = 0; i < n; i++) {
            if (null != sets.higher(arr[i])) {
                int a = sets.higher(arr[i]);
                ans++;
                sets.remove(a);
            }
        }

        System.out.println(ans);
    }
}