import java.util.HashMap;
import java.util.Scanner;


public class Main {

	static int n, m, ans;
	static Node[] nodes;
	static Node[] headers;
	static Node[] tails;
	static HashMap<String, Integer> nodeIds;
	static HashMap<String, Integer> lineNums;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int q = sc.nextInt();
		int x = n / m;

		nodes = new Node[100_001];
		headers = new Node[11];
		tails = new Node[11];
		nodeIds = new HashMap<String, Integer>();
		lineNums = new HashMap<String, Integer>();
		
		Node tail = null;
		int prevLine = 0;
		int nodeCnt = 1;
		int line = 0;
		for(int i = 1 ; i < n + 1 ; i++) {
			line = (int) Math.ceil((double) i / x);
			String data = sc.next();
			Node node = new Node(data);
			nodes[nodeCnt] = node;
			nodeIds.put(data, nodeCnt);
			lineNums.put(data, line);
			
			if(line != prevLine) {
				tail = headers[line] = node;
				prevLine = line;
			} else {
				connect(tail, node);
				tail = tails[line] = node;
			}
			nodeCnt++;
		}
		
		for(int i = 0; i < q; i++) {
			int opt = sc.nextInt();
			
			if(opt == 1) { // a 가 b앞에
				String a = sc.next();
				String b = sc.next();
				insertPrev(nodes[nodeIds.get(a)], nodes[nodeIds.get(b)]);
				lineNums.put(a, lineNums.get(b));
				
			} else if(opt == 2) { // a는 집
				String a = sc.next();
				popA(nodes[nodeIds.get(a)]);
			} else if(opt == 3) {
				String a = sc.next();
				String b = sc.next();
				String c = sc.next();
				
				insertRange(nodes[nodeIds.get(a)], nodes[nodeIds.get(b)], nodes[nodeIds.get(c)]);
				
				Node cur = nodes[nodeIds.get(a)];
				while(true) {
					lineNums.put(cur.data, lineNums.get(c));
					cur = cur.next;
					if(cur.data == b) break;
				}
			}
			
			
		}

		for(int i = 1; i <= line; i++) {
			if(headers[i] == null) {
				System.out.println(-1);
			} else {
				Node cur = headers[i];
				while(cur.next != null) {
					System.out.print(cur.data+" ");
				}
				System.out.println();
			}
		}
		
		
	}
	



	private static void insertRange(Node a, Node b, Node c) {
		if(headers[lineNums.get(a.data)] == a) {
			headers[lineNums.get(a.data)] = a.next;
			if(a.next == null) 
				headers[lineNums.get(a.data)] = tails[lineNums.get(a.data)] = null;
		}
		if(tails[lineNums.get(b.data)] == b) {
			tails[lineNums.get(b.data)] = b.prev;
			if(b.prev == null)
				headers[lineNums.get(b.data)] = tails[lineNums.get(b.data)] = null;
		}
		connect(a.prev, b.next);
		connect(c.prev, a);
		connect(b, c);
		
		if(headers[lineNums.get(c.data)] == c) {
			headers[lineNums.get(c.data)] = a;
		}
	}




	private static void popA(Node u) {
		if(headers[lineNums.get(u.data)] == u) {
			headers[lineNums.get(u.data)] = u.next;
			if(u.next == null) 
				headers[lineNums.get(u.data)] = tails[lineNums.get(u.data)] = null;
		}
		if(tails[lineNums.get(u.data)] == u) {
			tails[lineNums.get(u.data)] = u.prev;
			if(u.prev == null)
				headers[lineNums.get(u.data)] = tails[lineNums.get(u.data)] = null;
		}
		connect(u.prev, u.next);
		
		u.prev  = null;
		u.next = null;
		lineNums.remove(u.data);
		nodeIds.remove(u.data);
	}




	private static void insertPrev(Node u, Node v) {
		if(headers[lineNums.get(u.data)] == u) {
			headers[lineNums.get(u.data)] = u.next;
			if(u.next == null) 
				headers[lineNums.get(u.data)] = tails[lineNums.get(u.data)] = null;
		}
		if(tails[lineNums.get(u.data)] == u) {
			tails[lineNums.get(u.data)] = u.prev;
			if(u.prev == null)
				headers[lineNums.get(u.data)] = tails[lineNums.get(u.data)] = null;
		}
		
		connect(u.prev, u.next);
		connect(u, v);
		
	}




	private static void connect(Node s, Node e) {
		if(s != null)
			s.next = e;
		if(e != null)
			e.prev = s;
	}
	
}


class Node {
	String data;
	Node prev;
	Node next;
	
	public Node(String data) {
		this.data = data;
		this.prev = null;
		this.next = null;
				
	}
}