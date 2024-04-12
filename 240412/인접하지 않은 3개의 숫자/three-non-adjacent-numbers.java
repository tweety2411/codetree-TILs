import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static int n, m, ans;
    static int[] arr;
    static TreeSet<Integer> sets;
    static HashMap<Integer, Integer> map;

    static int[] L;
    static int[] R;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        L = new int[n + 1];
        R = new int[n + 1];

        // L 배열을 채워줍니다.
        // L[i] = 0번부터 i번 원소 중 최댓값
        for (int i = 1; i < n + 1; i++) {
            L[i] = Math.max(L[i - 1], arr[i]);
        }

           // R 배열을 채워줍니다.
        // R[i] = i번부터 n - 1번 원소 중 최댓값
        for (int i = n - 1; i > 0; i--) {
            R[i] = Math.max(R[i + 1], arr[i]);
        }

        
        // i번째 숫자가 세 숫자 중 가운데 숫자라고 했을 때
        // 가능한 최대 합 중 최댓값을 갱신해줍니다.
        for (int i = 2; i < n - 1; i++) {
            ans = Math.max(ans, L[i - 2] + arr[i] + R[i + 2]);
        }

        System.out.println(ans);
    }
}