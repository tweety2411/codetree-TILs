import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main {

	static int n, m, ans;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		Integer[] arrs = new Integer[n];
		
		
		for(int i = 0; i < n ; i++) {
			arrs[i] = sc.nextInt();
		}
		
		 Arrays.sort(arrs, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = Integer.toString(o1) + Integer.toString(o2);
				String s2 = Integer.toString(o2) + Integer.toString(o1);
				return s2.compareTo(s1);
			}
		});
		
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0; i < n; i++) {
			 sb.append(String.valueOf(arrs[i]));
		 }
		 
		 System.out.println(sb.toString());
		 
	}

}