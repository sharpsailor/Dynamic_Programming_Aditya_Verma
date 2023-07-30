package AdityaVerma;

import java.util.*;

public class BooleanParanthesizationMemoisation {
	static int m =1003; // Modulo function to handle the over flow we used a prime number
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next();

        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, -1);
            }
        }

        System.out.println(solve(X, 0, X.length() - 1, true));
    }
	
	/*	Matrix dimensions depend on changing variables in this case its 3 so it would be a 3D Matrix i.e. i, j , isTrue are the changing variable
*	i and j values depend on constraints in our case ->1000 so [1001] and for isTrue a size [2]
*   Also we can use Map since imaging 3d matrix is not imaginable
*/	
	static int[][][] dp = new int[2][1001][1001];
	private static int solve(String s, int i, int j, boolean isTrue) {
		if (i >= j) {
			if (isTrue)
				dp[1][i][j]= s.charAt(i) == 'T' ? 1 : 0;
			else
				dp[0][i][j]= s.charAt(i) == 'F' ? 1 : 0;
			return dp[isTrue?1:0][i][j];
		}
		if(dp[isTrue?1:0][i][j]!=-1) {
			return dp[isTrue?1:0][i][j];
		}
		int ans = 0;
		for (int k = i + 1; k <= j; k += 2) {
			int lT = solve(s, i, k - 1, true);
			int lF = solve(s, i, k - 1, false);
			int rT = solve(s, k + 1, j, true);
			int rF = solve(s, k + 1, j, false);
			if (s.charAt(k) == '|') {
				if (isTrue) {
					ans += (lT * rF + lT * rT + rT * lF)%m;
				} else {
					ans += lF * rF%m;
				}
			} else if (s.charAt(k) == '&') {
				if (isTrue) {
					ans += lT * rT%m;
				} else {
					ans += (lT * rF + lF * rT + lF * rF)%m;
				}
			} else if (s.charAt(k) == '^') {
				if (isTrue) {
					ans += (lT * rF + lF * rT)%m;
				} else {
					ans += (lT * rT + lF * rF)%m;
				}
			}
		}
		return dp[isTrue?1:0][i][j]=ans%m;
	}

}
