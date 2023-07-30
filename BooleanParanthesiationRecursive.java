package AdityaVerma;

class BooleanParanthesiationRecursive {
	public static void main(String[] args) {
		String expression = "T^F|F";
		int result = solve(expression, 0, expression.length() - 1, true);
		System.out.println("Number of ways to make the expression true: " + result);
	}

	private static int solve(String s, int i, int j, boolean isTrue) {
		if (i >= j) {
			if (isTrue)
				return s.charAt(i) == 'T' ? 1 : 0;
			else
				return s.charAt(i) == 'F' ? 1 : 0;
		}
		int ans = 0;
		for (int k = i + 1; k <= j; k += 2) {
			int lT = solve(s, i, k - 1, true);
			int lF = solve(s, i, k - 1, false);
			int rT = solve(s, k + 1, j, true);
			int rF = solve(s, k + 1, j, false);
			if (s.charAt(k) == '|') {
				if (isTrue) {
					ans += lT * rF + lT * rT + rT * lF;
				} else {
					ans += lF * rF;
				}
			} else if (s.charAt(k) == '&') {
				if (isTrue) {
					ans += lT * rT;
				} else {
					ans += lT * rF + lF * rT + lF * rF;
				}
			} else if (s.charAt(k) == '^') {
				if (isTrue) {
					ans += lT * rF + lF * rT;
				} else {
					ans += lT * rT + lF * rF;
				}
			}
		}
		return ans;
	}
}
