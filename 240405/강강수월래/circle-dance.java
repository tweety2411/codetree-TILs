import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int n, m;
    static Node[] nodes;
    static HashMap<Integer, Integer> studentIds;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();
        nodes = new Node[100_002];
        studentIds = new HashMap<>();

        int nodeCnt = 1;
        for (int i = 1; i <= m; i++) {
            int circleSize = sc.nextInt();
            Node start = null, tail = null;
            for (int j = 0; j < circleSize; j++) {
                int studentNum = sc.nextInt();
                studentIds.put(studentNum, nodeCnt);
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

        for (int i = 0; i < q; i++) {
            int opt = sc.nextInt();
            if (opt == 1) { // a랑 b를 합치기
                int a = sc.nextInt();
                int b = sc.nextInt();

                connectCircle(nodes[studentIds.get(a)], nodes[studentIds.get(b)]);

            } else if (opt == 2) { // 분리하기
                int a = sc.nextInt();
                int b = sc.nextInt();

                seperateCircle(a, b);
            } else if (opt == 3) {
                int a = sc.nextInt();
                Node target = nodes[studentIds.get(a)];
                int mn = target.data;
                Node cur = target;
                while (true) {
                    cur = cur.next;
                    if (cur != null)
                        mn = Math.min(mn, cur.data);
                    if (cur == target)
                        break;
                }

                Node init = nodes[studentIds.get(mn)];
                cur = nodes[studentIds.get(mn)];
                do {
                    System.out.print(cur.data + " ");
                    cur = cur.prev;
                } while (cur.data != init.data);
                System.out.println();
            }
        }
    }

    private static void seperateCircle(int a, int b) {

        connect(nodes[studentIds.get(a)].prev, nodes[studentIds.get(b)]);
        connect(nodes[studentIds.get(b)].prev, nodes[studentIds.get(a)]);

    }

    private static void connectCircle(Node u, Node v) {
        Node vPrev = v.prev;
        Node uNext = u.next;

        connect(u, v);
        connect(vPrev, uNext);

    }

    private static void connect(Node s, Node e) {
        if (null != s)
            s.next = e;
        if (null != e)
            e.prev = s;
    }

}

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}