package AdityaVerma;

public class TargetSum {
	class Solution {
	    public int findTargetSumWays(int[] nums, int target) {
	        int n = nums.length;
	        int sum = 0;
	        for(int x: nums){
	            sum+=x;
	        }
	        if((sum- target)%2!=0 || target>sum){
	            return 0;
	        }
	        sum = (sum- target)/2;
	        return subSetSum(nums, n , sum);
	    }
	    public int subSetSum(int[] arr, int n , int sum ){
	        int[][] t = new int[n+1][sum+1];
	        t[0][0]=1 ;
	        for(int i =1;i<=n;i++){
	            for(int j =0;j<=sum;j++){
	                if(arr[i-1]<=j){
	                    t[i][j]= t[i-1][j]+t[i-1][j-arr[i-1]];
	                }else{
	                    t[i][j]= t[i-1][j];
	                }
	            }
	        }
	        return t[n][sum];

	    }
	}
}
