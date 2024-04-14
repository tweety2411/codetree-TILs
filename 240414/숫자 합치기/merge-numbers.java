import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

	static int n, m, ans;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];

		Queue<Integer> queue = new PriorityQueue();
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			queue.add(arr[i]);
		}
		
		
		ans = 0;
		ans = queue.poll() + queue.poll();
		queue.add(ans);
		
		int sum = 0;
		while(!queue.isEmpty()) {
			int a = queue.poll();
			if(sum != 0) {
				ans += a+sum;
				queue.add(a+sum);
				sum = 0;
				continue;
			} 
			if(a > ans ) {
				ans += a;
				sum = 0;
			} else {
				sum += a;
			}
		}
		
		System.out.println(ans);
		
	}

}