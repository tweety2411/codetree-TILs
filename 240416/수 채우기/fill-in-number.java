import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100000;
    
    // 변수 선언
    public static int n;
    public static int ans = MAX_NUM;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();

        // 사용할 5원 동전의 수를 전부 가정해보며
        // 그 중 가장 좋은 선택을 합니다.
        for(int i = 0; i <= MAX_NUM; i++) {
            int remainder = n - 5 * i;
            if(remainder >= 0 && remainder % 2 == 0)
                ans = Math.min(ans, i + (remainder / 2));
        }

        // 만약 그러한 동전을 만드는 것이 불가능하다면
        // -1을 넣어줍니다.
        if(ans == MAX_NUM)
            ans = -1;

        System.out.print(ans);
    }
}