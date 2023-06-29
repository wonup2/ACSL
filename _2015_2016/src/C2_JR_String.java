//1516 contest 2
import java.util.*;

public class C2_JR_String {

	static Scanner in;
	static String line;
	static int start, length;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		line = in.nextLine();
		
		for(int i=0; i<8; i++)	
			solve();
	}
	
	static void solve() {
		start = in.nextInt();
		length = in.nextInt();
		
		if(start<0) start = line.length()+start;
		
		if(length<0) length = line.length()+length;
		else if(length==0) length = line.length();
		else length = start+length;
		
		System.out.println(line.substring(start, length));		
	}
}

/*

Hello world!
0 10
1 8
0 5
6 6
0 -1
-10 -2
0 -5
-4 0

*/

