import java.util.*;

public class all_4_uuencode {

	static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		for(int i=0; i<10; i++) init();

	}

	static void init() {
		
		String s = in.nextLine();
		while(s.length()%3!=0)
			s+="0";
		
		ArrayList<Integer> ascii = new ArrayList<Integer>();
		
		for(int i=0; i<s.length(); i++) {
			int temp = s.charAt(i);
			ascii.add(temp);
		}
		
		
		String bin =  "";
		
		for(int n:ascii) {
			
			String t = Integer.toBinaryString(n);
			int len = t.length();
			
			for(int i=0; i<8-len; i++) {
				t = "0" + t;
			}
			bin += t;
		}
		
		String ans = "";
		while(bin.length()>0) {
			String t = bin.substring(0,6);
			bin = bin.substring(6);
			int dec = Integer.parseInt(t, 2);
			dec+=32;
			if(dec==32) ans+="~";
			else ans += (char)dec;
		}
		
		System.out.println(ans);
	}
	
}
