
public class Loop1 {

	public static void main(String[] args) {

		int ans = sum(5);
		
		System.out.println(ans);
	}

	public static int sum(int n) {
		
		int s = 0;
		
		for(int i=n; i>0; i--) {
			s = s + i;  
		}
		
		return s;
	}
}
