import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Test {
	
	static Scanner in;
	static int d[] = {450,140,120,320,250,80};
	static int start, end;
	static double total, mpg, ppg, speed;
	public static void main(String[] args) throws FileNotFoundException
	{
		in = new Scanner(new File("a.txt"));
		
		mpg = in.nextDouble();
		ppg = in.nextDouble();
		speed = in.nextDouble();
		
		for(int i=0; i<5; i++) {
			init();
			solve();
		}
		in.close();
	}
		
	static void init() {
		String letter = "ABCDEFG";
		start = letter.indexOf(in.next());
		end = letter.indexOf(in.next());				
	}
	
	static void solve() {
		total = 0;
		for(int i=start; i<end; i++) {
			total+=d[i];
		}
		
		
	}
}
