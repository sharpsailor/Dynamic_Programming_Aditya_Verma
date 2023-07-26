package AdityaVerma;

public class subSetSumProblem {
	class Solution{


	    static Boolean isSubsetSum(int n, int arr[], int sum){
	        // code here
	        boolean[][]t = new boolean[n+1][sum+1];
	        for(int i =0;i<t.length;i++){
	            for(int j =0;j<t[0].length;j++){
	                if(i==0){
	                    t[i][j]=false;
	                }
	                if(j==0){
	                    t[i][j]=true;
	                }
	            }
	        }
	        for(int i =1;i<t.length;i++){
	            for(int j =1;j<t[0].length;j++){
	                if(arr[i-1]<=j){
	                    t[i][j]=t[i-1][j-arr[i-1]]||t[i-1][j];
	                }else{
	                    t[i][j]=t[i-1][j];
	                }
	            }
	        }
	        return t[n][sum];
	    }
	} 
}
