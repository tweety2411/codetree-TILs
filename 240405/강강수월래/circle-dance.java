import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static class Node {
        int id;
        Node prev, next;

        Node(int id) {
            this.id = id;
            this.prev = null;
            this.next = null;
        }
    }

    private static final int MAX_N = 100000;

    // 학생들을 관리해 줄 배열입니다.
    private static Node[] nodes = new Node[MAX_N + 2];

    // 학생들의 번호의 범위가 1 ~ 10억이기 때문에, map으로 학생들의 번호들을 관리해줍니다.
    private static HashMap<Integer, Integer> studentId = new HashMap<>();

    // 두 사람을 연결합니다.
    private static void connect(Node s, Node e) {
        if (s != null) s.next = e;
        if (e != null) e.prev = s;
    }

    // 두 원을 연결합니다.
    private static void connectCircle(Node u, Node v) {
        Node vPrev = v.prev;
        Node uNext = u.next;

        connect(u, v);
        connect(vPrev, uNext);
    }

    // 두 원을 쪼갭니다.
    private static void splitCircle(Node u, Node v) {
        Node uPrev = u.prev;
        Node vPrev = v.prev;

        connect(uPrev, v);
        connect(vPrev, u);
    }

    // 원을 출력합니다.
    private static void printLine(Node target) {
        // 원에서 학생 번호가 가장 작은 학생을 찾습니다.
        int mn = target.id;
        Node cur = target;
        while (true) {
            cur = cur.next;
            if (cur != null) mn = Math.min(mn, cur.id);
            if (cur == target) break;
        }

        // 가장 작은 학생부터 출력합니다.
        Node init = nodes[studentId.get(mn)];
        cur = nodes[studentId.get(mn)];
        do {
            System.out.print(cur.id + " ");
            // 반시계 방향으로 돌면서 출력합니다.
            cur = cur.prev;
        } while (cur.id != init.id);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        // 각 학생의 번호를 저장합니다.
        int nodeCnt = 1;
        for (int i = 1; i <= m; i++) {
            int circleSize = sc.nextInt();
            Node start = null, tail = null;
            for (int j = 0; j < circleSize; j++) {
                int studentNum = sc.nextInt();
                studentId.put(studentNum, nodeCnt);
                nodes[nodeCnt] = new Node(studentNum);
                if (j == 0) {
                    start = nodes[nodeCnt];
                    tail = nodes[nodeCnt];
                } else {
                    connect(tail, nodes[nodeCnt]);
                    tail = nodes[nodeCnt];
                    if (j == circleSize - 1) {
                        // 원에서의 마지막 학생은 해당 원의 첫 학생과 연결합니다.
                        connect(tail, start);
                    }
                }
                nodeCnt++;
            }
        }

        // q개의 행동을 진행합니다.
        for (int i = 0; i < q; i++) {
            int option = sc.nextInt();
            if (option == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                connectCircle(nodes[studentId.get(a)], nodes[studentId.get(b)]);
            } else if (option == 2) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                splitCircle(nodes[studentId.get(a)], nodes[studentId.get(b)]);
            } else if (option == 3) {
                int a = sc.nextInt();
                printLine(nodes[studentId.get(a)]);
            }
        }
    }
}