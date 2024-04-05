import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static int n, m;
    static Node[] nodes;
    static Circle[] circles;
    static HashMap<Integer, Integer> lineNums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int q = sc.nextInt();
        nodes = new Node[100_002];
        circles = new Circle[11];
        lineNums = new HashMap<>();

        for (int i = 1; i < m + 1; i++) {
            int num = sc.nextInt();
            TreeSet<Integer> sets = new TreeSet<>();
            Node prev = null;
            Node head = null;
            for (int j = 1; j < num + 1; j++) {
                int data = sc.nextInt();
                Node node = new Node(data);
                nodes[data] = node;
                lineNums.put(data, i);
                if (j == 1) {
                    head = node;
                } else {
                    connect(prev, node);
                    if (j == num)
                        connect(node, head);
                }
                prev = node;
                sets.add(data);
            }
            Circle circle = new Circle(i, sets);
            circles[i] = circle;
        }

        while (q-- > 0) {
            int opt = sc.nextInt();
            if (opt == 1) { // a랑 b를 합치기
                int a = sc.nextInt();
                int b = sc.nextInt();

                connectCircle(a, b);
                int a_line = lineNums.get(a);
                int b_line = lineNums.get(b);
                Circle circle = circles[b_line];
                for (Integer x : circle.sets) {
                    lineNums.put(x, a_line);
                }

                circles[a_line].sets.addAll(circle.sets);
                circles[b_line] = null;
            } else if (opt == 2) { // 분리하기
                int a = sc.nextInt();
                int b = sc.nextInt();

                seperateCircle(a, b);
            } else if (opt == 3) {
                int a = sc.nextInt();

                for (int i = 1; i < m + 1; i++) {
                    if (circles[i].sets.contains(a)) {
                        int first = circles[i].sets.first();
                        Node cur = nodes[first];
                        System.out.print(cur.data + " ");
                        cur = cur.prev;
                        while (cur != nodes[first]) {
                            System.out.print(cur.data + " ");
                            cur = cur.prev;
                        }
                    }
                }
            }
        }

    }

    private static void seperateCircle(int a, int b) {
        Node cur = nodes[a];
        TreeSet<Integer> sets = new TreeSet<>();
        Circle orgCircle = circles[lineNums.get(b)];
        TreeSet<Integer> orgSets = orgCircle.sets;
        int lineNum = 1;
        while (circles[lineNum] != null && lineNum < m + 1) {
            lineNum++;
        }
        while (cur.data != b) {
            sets.add(cur.data);
            lineNums.put(cur.data, lineNum);
            orgSets.remove(cur.data);
            cur = cur.next;

        }
        Node last = cur.prev;
        int x = last.data;

        orgCircle.sets = orgSets;
        circles[lineNums.get(b)] = orgCircle;
        circles[lineNum] = new Circle(lineNum, sets);

        connect(nodes[a].prev, nodes[x].next);
        connect(nodes[x], nodes[a]);

    }

    private static void connectCircle(int a, int b) {
        connect(nodes[b].prev, nodes[a].next);
        connect(nodes[a], nodes[b]);

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

class Circle {
    int idx;
    TreeSet<Integer> sets;

    public Circle(int idx, TreeSet<Integer> sets) {
        this.idx = idx;
        this.sets = sets;
    }
}