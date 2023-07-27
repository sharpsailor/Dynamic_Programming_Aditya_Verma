package AdityaVerma;

import java.util.Scanner;

public class shortestCommonSupersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(shortestCommonSupersequence(s1,s2,s1.length(),s2.length()));
	}
	public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int LCS = LCS(m,n,X,Y);
        return m+n-LCS;
    }
    private static int LCS(int x , int y ,String s1 , String s2){
        int[][]t = new int[x+1][y+1];
         for(int i =0;i<=x;i++){
             for(int j =0;j<=y;j++){
                 if(i==0||j==0){
                     t[i][j] = 0;
                 }
                 else if(s1.charAt(i-1)==s2.charAt(j-1)){
                     t[i][j]=1+t[i-1][j-1];
                 }else{
                     t[i][j]= Math.max(t[i-1][j],t[i][j-1]);
                 }
             }
         }
         return t[x][y];
    }
}
