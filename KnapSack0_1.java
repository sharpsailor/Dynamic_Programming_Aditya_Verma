package AdityaVerma;

import java.util.Arrays;
import java.util.Scanner;

public class KnapSack0_1 {
	static int[][]dp = new int[1002][1002];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cap = sc.nextInt();
		int[] wt = new int[n];
		for (int i = 0; i < wt.length; i++) {
			wt[i] = sc.nextInt();
		}
		int[] Val = new int[n];
		for (int i = 0; i < Val.length; i++) {
			Val[i] = sc.nextInt();
		}
		int[][]dp = new int[n+1][cap+1];
		for(int[]a: dp) {
			Arrays.fill(a, -1);
		}
	}
	static int KnapSack(int[]wt , int[] val ,int cap, int n) {
		if(n==0|| cap==0) {
			return 0;
		}
		if(dp[n][cap]!=-1) {
			return dp[n][cap];			
		}
		if(wt[n-1]<=cap) {
			 dp[n][cap]= Math.max((val[n-1]+KnapSack(wt, val, cap-wt[n-1], n-1)),KnapSack(wt, val, cap, n-1));
		}else if(wt[n-1]>cap) {
			 dp[n][cap]=KnapSack(wt, val, cap, n-1);
		}
		return dp[n][cap];
	}
	public static int BootomUp(int w, int wt[], int val[],int n) {
		int[][] dp = new int[n+1][w+1];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for(int i =1;i<n+1;i++){
        for(int j =1;j<w+1;j++){
            if(wt[i-1]<=j  ){
                dp[i][j]= Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
            }else
               dp[i][j]= dp[i-1][j];
            }
        }   
        return dp[n][w];
	}

}
