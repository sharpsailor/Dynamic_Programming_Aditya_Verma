package AdityaVerma;

import java.util.Arrays;

public class MCM_Memoisation {
	public static void main(String[] args) {
		int[] arr = { 40, 20, 30, 10, 30 };
		int[][] dp = new int[1001][1001];
		for(int[]a:dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(Solve(arr, 1, arr.length - 1,dp));
	}

	public static int Solve(int[] arr, int i, int j,int[][]dp) {
		if (i >= j) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int tempAns = Solve(arr, i, k,dp) + Solve(arr, k + 1, j,dp) + (arr[i-1] * arr[k] * arr[j]);
			min = Math.min(min,tempAns);
		}
		return dp[i][j]=min;
	}
}
