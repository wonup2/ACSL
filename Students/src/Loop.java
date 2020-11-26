
public class Loop {

	public static void main(String[] args) {

		int ans = factorial(5);
		
		System.out.println(ans);
	}

	public static int factorial(int n) {
		
		int f = 1;
		
		for(int i=n; i>0; i--) {
			f = f * i;
		}
		
		return f;
	}
}
