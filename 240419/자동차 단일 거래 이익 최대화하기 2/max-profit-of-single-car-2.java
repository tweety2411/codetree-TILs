import java.util.Scanner;

public class Main {

    static int n, m, ans;
    static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int price = arr[0];
        ans = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > price) {
                ans = Math.max(ans, arr[i] - price);
            } else if (arr[i] < price) {
                price = arr[i];
            }
        }

        System.out.println(ans);
    }
}