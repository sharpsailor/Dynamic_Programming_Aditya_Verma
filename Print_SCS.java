package AdityaVerma;
import java.util.*;
public class Print_SCS {
   
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
	}
	private static String SCS(String s1 ,String s2) {
		int x = s1.length(),y = s2.length();
		int[][] t = new int[x+1][y+1];
		for(int i =0;i<=x;i++) {
			for(int j =0;j<=y;j++) {
				if(i==0||j==0) {
					t[i][j]=0;
				}
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					t[i][j]= 1+t[i-1][j-1];
				}else {
					t[i][j]=Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = x,j=y;
		while(i>0&&j>0) {
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}else if(t[i-1][j]>t[i][j-1]) {
				sb.append(s1.charAt(i-1));
				i--;
			}else if(t[i-1][j]<t[i][j-1]) {
				sb.append(s2.charAt(j-1));
				j--;
			}
		}
		while(i>0) {
			sb.append(s1.charAt(i-1));
			i--;
		}
		while(j>0) {
			sb.append(s2.charAt(j-1));
			j--;
		}
		return sb.reverse().toString();
	}
}
