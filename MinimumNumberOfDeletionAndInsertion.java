package AdityaVerma;

import java.util.Scanner;

public class MinimumNumberOfDeletionAndInsertion {
//	Leetcode :https://leetcode.com/problems/delete-operation-for-two-strings/
// gfg:https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(minOperations(s1,s2));
	}
	public static int minOperations(String s1, String s2) 
	{ 
	    // Your code goes here
		int x = s1.length(),y=s2.length();
		int[][] t = new int[x+1][y+1];
		for(int i =0;i<=x;i++) {
			for(int j =0;j<=y;j++) {
				if(i==0||j==0) {
					t[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					t[i][j]= 1+t[i-1][j-1];
				}else {
					t[i][j]= Math.max(t[i-1][j],t[i][j-1]);
				}
			}
		}
		int deletion = s1.length()-t[x][y];
		int insertion = s2.length()-t[x][y];
		return deletion+insertion;
	} 
}
