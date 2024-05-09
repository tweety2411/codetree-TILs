import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 동(E) 북(N) 서(W) 남(S)
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Map<String, Integer> dirMaps = new HashMap<>();
        dirMaps.put("E", 0);
        dirMaps.put("N", 1);
        dirMaps.put("W", 2);
        dirMaps.put("S", 3);

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String dir = sc.next();
            int distance = sc.nextInt();

            x = x + (dx[dirMaps.get(dir)] * distance);
            y = y + (dy[dirMaps.get(dir)] * distance);
        }

        System.out.println(x + " " + y);

    }
}