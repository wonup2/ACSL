
public class Recursive2 {

	public static void main(String[] args) {

		int ans = f(14);
		
		System.out.println(ans);
	}

	public static int f(int x) {
		
		if(x>=10) return f(x-2)-1;
		
		else if(x>6 && x<10) return f(x-1)+4;
		
		else return x-3;
	}
}
