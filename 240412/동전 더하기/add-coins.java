import java.util.Scanner;

public class Main {

    static int n, m, ans;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int last = k;
        int cnt = 0;
        while (last > 0) {
            if (last >= 1000) {
                cnt += last / arr[n - 1];
                last = last % arr[n - 1];
            } else if (last >= 500) {
                cnt += last / arr[n - 2];
                last = last % arr[n - 2];
            } else if (last >= 100) {
                cnt += last / arr[n - 3];
                last = last % arr[n - 3];
            } else if (last > 5) {
                cnt += last / arr[n - 4];
                last = last % arr[n - 4];
            } else {
                cnt += last;
                last = 0;
            }

        }
        System.out.println(cnt);

    }
}