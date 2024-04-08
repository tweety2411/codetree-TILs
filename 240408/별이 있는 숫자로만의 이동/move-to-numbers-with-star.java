import java.util.Scanner;


public class Main {

	static int n, m, ans;
	static int[][] arr;
	static int[][] arr2;
	static int[][] prefixSum;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int k = sc.nextInt();
		
		arr = new int[n+1][n+1];
		arr2 = new int[n*2+1][n*2+1];
		prefixSum = new int[n*2+1][n*2+1];

		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= n ; j++ ) {
				// 새로운 행의 위치 : i+j-1
				// 새로운 열의 위치 : n-i+j
				arr2[i+j-1][n-i+j] = arr[i][j];
			}
		}
		
		for(int i = 1; i <= 2*n; i++) {
			for(int j = 1; j <=2*n; j++) {
				prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr2[i][j];
			}
		}
		
		ans = Integer.MIN_VALUE;
		// 2*k+1은 한변의 길이가 k인 다이아몬드 영역이 45도 회전한 후 정사각형 영역의 한 변 의 길이 (+1은 중앙셀을 포함하기 위함)
		// 2*n은 회전된 격자판의 최대크기로 45도 회전 후 한 변의 최대길이가 2*n을 초과할 수 없으므로 2*k+1이 2*n을 초과할 경우 2*n으로 설정 
		int k2 = Math.min(2*n, 2*k+1);
		
		for(int i = k2; i <= 2*n; i++) {
			for(int j = k2; j <=2*n; j++) {
				// 특정 크기의 정사각형 영역의 합은 특정크기(k2)를 빼주어야함 
				ans = Math.max(ans, prefixSum[i][j] - prefixSum[i-k2][j] - prefixSum[i][j-k2] + prefixSum[i-k2][j-k2]);
			}
		}
		
		
		System.out.println(ans);
	}
	




}