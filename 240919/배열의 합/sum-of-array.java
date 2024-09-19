import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 4; 

        int[][] arr = new int[n][n];

        int []sum= new int[n];

        for(int i = 0; i < n; i++) {
            int result = 0;
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                result += arr[i][j];
            }
            sum[i] = result;
        }
       
        for (int i = 0; i < n; i++) {
            System.out.println(sum[i]);
        }
    }

}