import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	static int n, m, ans;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		String[] arrs = new String[n];
		
		for(int i = 0; i < n ; i++) {
			arrs[i] = String.valueOf(sc.nextInt());
		}
		
		 Arrays.sort(arrs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (int) (Long.valueOf(o2+o1) - Long.valueOf(o1+o2));
			}
		});
		
		 StringBuilder sb = new StringBuilder();
		 for(int i = 0; i < n; i++) {
			 sb.append(String.valueOf(arrs[i]));
		 }
		 
		 System.out.println(sb.toString());
		 
	}

}