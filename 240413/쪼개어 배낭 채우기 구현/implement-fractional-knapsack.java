import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Jewel implements Comparable<Jewel> {
    int weight, value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    // 가치 / 무게 기준 내림차순으로 정렬
    @Override
    public int compareTo(Jewel j) {
        double x = (double)j.value / j.weight - (double) this.value / this.weight;
        if(x < 0)
            return -1;
        else if(x == 0)
            return 0;
        else
            return 1;
    }
}

public class Main {    
    public static final int MAX_N = 100000;

    // 변수 선언
    public static int n, m;
    public static ArrayList<Jewel> jewels = new ArrayList<>();
    public static double ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            jewels.add(new Jewel(w, v));
        }

        // 가치 / 무게가 내림차순이 되도록 정렬합니다.
        Collections.sort(jewels);

        for(int i = 0; i < n; i++) {
            int w = jewels.get(i).weight;
            int v = jewels.get(i).value;
            // 현재 보석을 온전히 다 담을 수 있다면 그대로 담아줍니다.
            if(m >= w) {
                m -= w;
                ans += v;
            }
            // 만약 부분만 담을 수 있다면
            // 비율에 맞춰 담아준 뒤 종료합니다.
            else {
                ans += (double)m / w * v;
                break;
            }
        }
        System.out.printf("%.3f", ans);
    }
}