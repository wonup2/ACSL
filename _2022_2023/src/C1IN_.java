import java.util.*;

public class C1IN_ {

	static Scanner in;
	static String s;
	static int ans;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}

	static void init() {
		
		s = in.nextLine(); 
	}
	
	static void solve() {
		
		String bin = "";
		for(int i=0; i<s.length(); i++) {
			String temp = Integer.toBinaryString(s.charAt(i));
			
			while(temp.length()<8) temp = "0"+temp;
			bin+=temp;
		}

		int n = 0;
		String conv = "";
		
		while(true) {
			
			conv = Integer.toBinaryString(n); 
			
			int front = bin.indexOf(conv); 
			int back = bin.lastIndexOf(conv);
			
			if(front == -1 || back == -1) break;
			
			bin = bin.substring(0, front) + bin.substring(front+conv.length());
			back = bin.lastIndexOf(conv);
			if(back!=-1) 
				bin = bin.substring(0, back) + bin.substring(back+conv.length());
			
			
			System.out.println(bin);
			n++;
		}
		
		System.out.println(n-1);
	}
}

/*
0: 
101001001101111011100110110011
1: 
0100100110111101110011011001
10: 
001001101111011100110101

11:
00100011110111000101

100:
00011110110101

101:
00011110

110:
00011

01010010011011110111001101100101



1. Roses are red.
2. A is Alpha; B is Bravo; C is Charlie.
3. A stitch in time saves nine.
4. 1, 2: Buckle my shoe! 3, 4: Shut the door!
5. Is HackerRank the platform used by ACSL?

SAMPLE OUTPUT:
1. 12
2. 20
3. 14
4. 22
5. 27

*/