import java.util.Scanner;


public class Main {

	static int n, m, ans;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		ans = Integer.MIN_VALUE;
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			
			if(sum < 0) {
				sum = arr[i];
			} else {
				sum += arr[i];
			}
			
			ans = Math.max(ans, sum);
			
		}
		
		
		
		System.out.println(ans);
	}

}