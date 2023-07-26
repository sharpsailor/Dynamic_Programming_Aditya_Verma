package AdityaVerma;
import java.util.*;
public class MinimumSubsetSumDifference {

	class Solution
	{

		public int minDifference(int arr[], int n) 
		{ 
		    // Your code goes here
		    return minimumDifference(arr);
		} 
		public int minimumDifference(int[] nums) {
	        int target =0;
	        for (int x : nums) {
	            target += x; // Use absolute value to ensure target is non-negative
	        }
	        boolean[][] dp = new boolean[nums.length+1][target+1];
	       return  isSubset(nums,target,dp);
	    }
	    public int isSubset(int[]arr, int sum,boolean[][]dp){
	        for(int i = 0;i<dp.length;i++){
	            for(int j = 0;j<dp[0].length;j++){
	                if(i==0){
	                dp[i][j]=false;
	                }
	                if(j==0){
	                dp[i][j]=true;
	                }
	            }
	        }
	        for(int i = 1;i<dp.length;i++){
	            for(int j = 1;j<dp[0].length;j++){
	                if(arr[i-1]<=j){
	                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
	                }else{
	                    dp[i][j]= dp[i-1][j];
	                }
	            }
	        }
	        int min = Integer.MAX_VALUE;
	        for(int i =0;i<=sum/2;i++){
	            if(dp[arr.length][i]){
	                min = Math.min(min, sum-(2*i));
	            }
	        }
	        return min;
	    }
	}

}
