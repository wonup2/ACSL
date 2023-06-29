import java.util.*;

public class Contest3_Junior {

	static boolean[][] a;
	static Scanner in;
	static String ans;
	
	

	static int mutipleArrays(String a, String b, String c) {
		
		int x[] = new int[100];
		int y[] = new int[100];
		int z[] = new int[100];
		
		String temp[] = a.split(" ");
		for(int i=0; i<temp.length; i++) 
			x[i] = Integer.parseInt(temp[i]);
		
		temp = b.split(" ");
		for(int i=0; i<temp.length; i++) 
			y[i] = Integer.parseInt(temp[i]);
		
		temp = c.split(" ");
		for(int i=0; i<temp.length; i++) 
			z[i] = Integer.parseInt(temp[i]);
		
		
		int ans = 0;
		
		for(int i=0; i<100; i++) {
			int max = 0;
			
			if(x[i]==0 && y[i]==0) max = z[i];
			else if(x[i]==0 && z[i]==0) max = y[i];
			else if(y[i]==0 && z[i]==0) max = x[i];
			
			else if(x[i]==0) max = Math.max(y[i], z[i]);
			else if(y[i]==0) max = Math.max(x[i], z[i]);
			else if(z[i]==0) max = Math.max(x[i], y[i]);
			
			else max = Math.max(Math.max(x[i], y[i]), z[i]);
			
			ans += max;			
		}

				
		return ans;
	}

	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			String a = in.nextLine();
			String b = in.nextLine();
			String c = in.nextLine();
		
			int result = mutipleArrays(a, b, c);
		
			System.out.println(result);
		}
	}
}

/*

6 8 1 5 2 3 5 3 7 9
7 6 2 9
9 3 4 6 1 8 6 4 2 8 4


70

1 3 5 7 9 2 4 6 8 10
5 2 6 4 8 7 9 11 14 12
4 2 6 4 7 1 9 22 21 9

101
*/
