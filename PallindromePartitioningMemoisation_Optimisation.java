package AdityaVerma;

import java.util.Arrays;

public class PallindromePartitioningMemoisation_Optimisation {
static int[][]dp = new int[501][501];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababbbabbababa";
		for(int[]a:dp) {
			Arrays.fill(a, -1);
		}
		System.out.println(Solve(s, 0, s.length()-1));
	}
	public static int Solve(String s , int i , int j ) {
		if(i>=j) {
			return 0;
		}
		if(isPallindrome(s,i,j)) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int min = Integer.MAX_VALUE;
		for(int k = i;k<=j-1;k++) {
			int left=0,right=0;
			if(dp[i][k]!=-1) {
				left =dp[i][k];
			}else {
				left = Solve(s, i, k);
			}
			if(dp[k+1][j]!=-1) {
				right =dp[k+1][j];
			}else {
				right = Solve(s, k+1, j);
			}
			int tempAns= right+left+1;
			min = Math.min(tempAns, min);
		}
		return dp[i][j]=min;
	}
	private static boolean isPallindrome(String s, int i, int j) {
		// TODO Auto-generated method stub
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
