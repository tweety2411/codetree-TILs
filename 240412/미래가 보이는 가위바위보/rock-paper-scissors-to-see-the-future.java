import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    static int n, m, ans;
    static String[] arr;
    static TreeSet<Integer> sets;
    static HashMap<Integer, Integer> map;

    static int[] L_arrs;
    static int[] R_arrs;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new String[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        L_arrs = new int[n + 1];
        R_arrs = new int[n + 1];

        String[] shapes = new String[] { "P", "H", "S" };
        // 문자열이 같은 횟수를 저장하는 이유는
        // 같은 문자가 많을 경우 이길 수 있는 횟수가 올라가기 때문
        // P가 3개면 S를 3개 내면 되므로 같은 문자횟수를 체크
        // 왼쪽에서 이길 수 있는 횟수 체크
        for (int i = 0; i < 3; i++) {
            int sameCnt = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j].equals(shapes[i])) {
                    sameCnt++;
                }
                L_arrs[j] = Math.max(L_arrs[j], sameCnt);
            }
        }

        // i번부터 n-1번까지 동일한 모양을 냈을 때 최대로 이길 수 있는 횟수
        for (int i = 0; i < 3; i++) {
            int sameCnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j].equals(shapes[i])) {
                    sameCnt++;
                }
                R_arrs[j] = Math.max(R_arrs[j], sameCnt);
            }
        }

        ans = 0;
        for (int i = 0; i < n - 1; i++) {
            // 첫번째부터 i번까지 L_arrs에서 내고 그 다음은 R_arrs에서 냈을 때 최대로 이기는 경우
            ans = Math.max(ans, L_arrs[i] + R_arrs[i + 1]);
        }

        System.out.println(ans);
    }
}