package AdityaVerma;

import java.util.Scanner;

public class Print_LCS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(LCS(s1.length(), s2.length(), s1, s2));
	}

	private static String LCS(int m, int n, String s1, String s2) {
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}

			}
		}
		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int i =m, j = n;
		while(i>0 && j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}else {
				if(t[i][j-1]>t[i-1][j]) {
					j--;
				}else {
					i--;
				}
			}
		}
		return sb.reverse().toString();
	}
}
