package AdityaVerma;

public class MCM_Recursive {
	public static void main(String[] args) {
		int[] arr = {40,20,30,10,30};
		System.out.println(Solve(arr,1,arr.length-1));
	}
	public static  int Solve(int[]arr, int i , int j) {
		if(i>=j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int k = i;k<=j-1;k++) {
			int tempAns = Solve(arr, i, k)+Solve(arr, k+1, j)+(arr[i]*arr[k]*arr[j]);
			if(min>tempAns) {
				min = tempAns;
			}
		}
		return min;
	}
}
  