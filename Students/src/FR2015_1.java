import java.util.Arrays;

public class FR2015_1 {
	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4};
		int[][] b = { 	{1, 1, 1, 1},  
						{2, 2, 2, 2},
						{3, 3, 3, 3},
						{4, 4, 4, 4},
						{5, 5, 5, 5},
					};  //4, 8, 12, 16, 20
	
		int[] row = new int[b.length]; 
		
		int ans = arraySum(a);
		
		row = rowSum(b);
		System.out.println(ans);
		System.out.println(Arrays.toString(row));
	}
	
	public static int arraySum(int[] a) {
		int sum = 0;			//{1, 2, 3, 4}
		for(int n: a) {
			sum += n;
		}
		return sum;
	}
	
	public static int[] rowSum(int[][] a) {
		int[] ans = new int[a.length];
		
		int i = 0;
		for(int[] n: a) {
			ans[i]=arraySum(n);
			i++;
		}
		return ans;
	}
}
