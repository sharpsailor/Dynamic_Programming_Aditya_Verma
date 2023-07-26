package AdityaVerma;
import java.io.*;
import java.util.*;
public class RodCutting {
	//{ Driver Code Start

	    public static void main(String args[])throws IOException {
	        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t = Integer.parseInt(in.readLine().trim());
	        while (t-- > 0) {
	            int n = Integer.parseInt(in.readLine().trim());
	            String s[]=in.readLine().trim().split(" ");
	            int[] arr = new int[n];
	            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

	            Solution ob = new Solution();
	            out.println(ob.cutRod(arr, n));
	        }
	        out.close();
	    }
	    
	// } Driver Code Ends
}

	class Solution{
	    public int cutRod(int price[], int n) {
	        //code here
	        int[] cuts = new int[n];
	        for(int i =0;i<n;i++){
	            cuts[i]= i+1;
	        }
	        return minCost(n, cuts , price);
	    }
	    public int minCost(int n, int[] cuts,int[] prices) {
	        // Arrays.sort(cuts);
	        int[][] dp = new int[n+1][cuts.length+1];
	        for(int i =0;i<dp.length;i++){
	            for(int j =0;j<dp[0].length;j++){
	                if(i==0||j==0){
	                    dp[i][j]=0;
	                }
	            }
	        }
	        for(int i =1;i<dp.length;i++){
	            for(int j =1;j<dp[0].length;j++){
	                if(cuts[i-1]<=j){
	                    dp[i][j]= Math.max(dp[i-1][j],prices[i-1]+dp[i][j-cuts[i-1]]);
	                }else{
	                    dp[i][j]=dp[i-1][j];
	                }
	            }
	        }
	        return dp[n][cuts.length];
	    }
	}

