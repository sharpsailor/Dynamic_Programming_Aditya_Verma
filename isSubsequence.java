package AdityaVerma;

public class isSubsequence {
	class Solution {
		public boolean isSubsequence(String s1, String s2) {
			int[][] t = new int[s1.length()+1][s2.length()+1];
			for(int i =0;i<t.length;i++) {
				for(int j =0;j<t[0].length;j++) {
					if(i==0||j==0) {
						t[i][j]=0;
					}else if(s1.charAt(i-1)==s2.charAt(j-1)) {
						t[i][j]=1+t[i-1][j-1];
					}else {
						t[i][j]=Math.max(t[i][j-1], t[i-1][j]);
					}
				}
			}
			int lcs = t[s1.length()][s2.length()];
			return lcs==s1.length()?true:false;
		} 
	}
}
