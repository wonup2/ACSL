
public class Recursive1 {

	public static void main(String[] args) {

		int ans = sum(5);
		
		System.out.println(ans);
	}

	public static int sum(int n) {
		
		if(n==1) return 1;
		else return n + sum(n-1);
	}
}
