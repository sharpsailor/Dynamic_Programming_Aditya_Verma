package AdityaVerma;

import java.util.Arrays;

public class LCS_Memoization {
	class Solution {
		public int longestCommonSubsequence(String text1, String text2) {
			int[][] t = new int[1001][1001];
			for(int[]a:t) {
				Arrays.fill(a, -1);
			}
			return lcs(text1.length(), text2.length(), text1, text2,t);
		}

		public static int lcs(int x, int y, String s1, String s2,int[][]t) {
			if (x == 0 || y == 0) {
				return 0;
			}
			if(t[x][y]!=-1) {
				return t[x][y];
			}
			if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
				t[x][y]= 1 + lcs(x - 1, y - 1, s1, s2,t);
			} else {
				t[x][y]= Math.max(lcs(x - 1, y, s1, s2,t), lcs(x, y - 1, s1, s2,t));
			}
			return t[x][y];
		}
	}
}
