import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	static int n, m, ans;
	static int[] arr;
	static List<Meeting> meetings;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		meetings = new ArrayList<Meeting>();
		
		for(int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			meetings.add(new Meeting(start, end));
		}
		
		Collections.sort(meetings);
		
		ans = 0;
		int end = 0;
		for(int i = 0; i < n; i++) {
			Meeting meeting = meetings.get(i);
			if(meeting.start >= end) {
				ans++;
				end = meeting.end;
			}
		}
		
		System.out.println(ans);
		
	}

}

class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting o) {
		return this.end - o.end;
	}
	
	
}