package AdityaVerma;

import java.util.Scanner;

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
//		String s2 = sc.next();
		System.out.println(longestPalindromeSubseq(s1));
	}
	public static int longestPalindromeSubseq(String S) {
		StringBuilder sb = new StringBuilder(S);
		String b = sb.reverse().toString();
		int[][] t = new int[S.length() + 1][b.length() + 1];
		for (int i = 0; i <= S.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (S.charAt(i - 1) == b.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		return t[S.length()][b.length()];
	}

}
