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

        int nodeCount = 1;
        for (int i = 1; i < m + 1; i++) {
            int num = sc.nextInt();
            Node prev = null;
            Node head = null;
            for (int j = 1; j < num + 1; j++) {
                int data = sc.nextInt();
                Node node = new Node(data);
                nodes[nodeCount] = node;
                studentIds.put(data, nodeCount);
                if (j == 1) {
                    head = node;
                } else {
                    connect(prev, node);
                    if (j == num)
                        connect(node, head);
                }
                prev = node;
                nodeCount++;
            }
        }

        while (q-- > 0) {
            int opt = sc.nextInt();
            if (opt == 1) { // a랑 b를 합치기
                int a = sc.nextInt();
                int b = sc.nextInt();

                connectCircle(a, b);

            } else if (opt == 2) { // 분리하기
                int a = sc.nextInt();
                int b = sc.nextInt();

                seperateCircle(a, b);
            } else if (opt == 3) {
                int a = sc.nextInt();

                Node cur = nodes[studentIds.get(a)];
                int min = cur.data;
                Node target = cur;
                while (true) {
                    cur = cur.next;
                    if (cur != null)
                        min = Math.min(min, cur.data);
                    if (cur == target)
                        break;
                }

                Node minNode = nodes[studentIds.get(min)];
                cur = nodes[studentIds.get(min)];
                ;
                do {
                    System.out.print(cur.data + " ");
                    cur = cur.prev;
                } while (cur.data != minNode.data);

                System.out.println();
            }
        }
    }

    private static void seperateCircle(int a, int b) {

        connect(nodes[studentIds.get(a)].prev, nodes[studentIds.get(b)]);
        connect(nodes[studentIds.get(b)].prev, nodes[studentIds.get(a)]);

    }

    private static void connectCircle(int a, int b) {
        connect(nodes[studentIds.get(b)].prev, nodes[studentIds.get(a)].next);
        connect(nodes[studentIds.get(a)], nodes[studentIds.get(b)]);

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