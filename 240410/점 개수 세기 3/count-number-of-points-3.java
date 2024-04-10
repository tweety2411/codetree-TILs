import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

    static int n, m, ans;
    static int[] arr;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int q = sc.nextInt();

        arr = new int[n];
        TreeSet<Integer> sets = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sets.add(arr[i]);
        }

        map = new HashMap<>();
        int cnt = 1;
        for(Integer num : sets) {
            map.put(num, cnt);
            cnt++;
        }

        for(int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int newA = map.get(a);
            int newB = map.get(b);

            System.out.println(newB - newA + 1);
        }
    }


}