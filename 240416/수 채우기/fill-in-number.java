import java.util.Scanner;


public class Main {

	static int n, m, ans;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();

			
		int last = n;
		ans = 0;
		if(last < 0) ans = -1;
		while( last > -1) {
			if(last >= 5) {
				if(last % 5 == 0) {
					ans += last / 5;
					break;
				}
				last = last - 2;
				ans++;
			} else {
				
				if(last % 2 == 0) {
					ans += last / 2;
					break;
				}
			}
		}
		
		
		
		System.out.println(ans);
		 
	}

}