package AdityaVerma;

import java.util.Scanner;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(longestCommonSubstr(s1,s2,s1.length(),s2.length()));
	}
	private static int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
//     Base case initalisation
		int[][]t = new int[n+1][m+1];
        for(int i =0;i<=n;i++){
        for(int j =0;j<=m;j++)
            {
                if(i==0||j==0){
                    t[i][j]=0;
                }
//                 Choice Diagram
                else if (s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=0;
                }
            }
        }
//      checking for max value
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
         for(int j =0;j<=m;j++){
             max= Math.max(max,t[i][j]);
         }   
        }
        return max;
    }
}
