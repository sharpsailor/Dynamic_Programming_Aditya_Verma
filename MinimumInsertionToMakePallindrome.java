package AdityaVerma;

import java.util.Scanner;

public class MinimumInsertionToMakePallindrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
//		String s2 = sc.next();
		StringBuilder sb = new StringBuilder(s1);
		String s2 = sb.reverse().toString();
		int LCS= (LCS(s1,s2));
		System.out.println(s2.length()-LCS);
	}
	private static int LCS(String s1 , String s2 ) {
		int x = s1.length();
		int y = s2.length();
		int[][] t = new int[x+1][y+1];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				if(i==0||j==0) {
					t[i][j]= 0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					t[i][j]= 1+t[i-1][j-1];
				}
				else {
				t[i][j]=	Math.max(t[i-1][j],t[i][j-1]);
				}
			}
		}
		return t[x][y];
	}
}
