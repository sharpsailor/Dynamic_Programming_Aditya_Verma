package AdityaVerma;

public class LongestRepaetingSubsequence {
	public int LongestRepeatingSubsequence(String str) {
		String s1 = str;
		String s2 = str;
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i =0;i<dp.length;i++) {
			for(int j =0;j<dp[0].length;j++) {
				if(i==0||j==0) {
					dp[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)&& i!=j) {
					dp[i][j]=1+dp[i-1][j-1];
				}else {
					dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
