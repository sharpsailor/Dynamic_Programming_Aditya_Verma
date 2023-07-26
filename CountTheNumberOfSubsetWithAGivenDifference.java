package AdityaVerma;

public class CountTheNumberOfSubsetWithAGivenDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,3};
		int diff = 1;
		int n = arr.length;
		int sum= 0;
		for(int x: arr) {
			sum+=x;
		}
		int[][] dp = new int[n+1][sum+1];
		int requiredSum = (diff+sum)/2;
		System.out.println(subSetSum(arr,n , requiredSum, dp));
		
	}
	public static int subSetSum(int[]arr, int n , int sum , int[][] dp) {
		for(int i =0;i<dp.length;i++) {
			for(int j = 0;j<dp[0].length;j++) {
				if(i==0) {
					dp[i][j]= 0;
				}
				if(j==0) {
					dp[i][j]= 1;
				}
			}
		}
		for(int i =1;i<=n;i++) {
			for(int j = 1;j<=sum;j++) {
				if(arr[i-1]<=j) {
					dp[i][j] = dp[i-1][j]+dp[i-1][j-arr[i-1]];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}

}
