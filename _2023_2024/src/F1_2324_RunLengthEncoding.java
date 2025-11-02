import java.util.*;

public class F1_2324_RunLengthEncoding {

	static Scanner in;
	static String c, s, ans="";
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		
		c = in.next();
		s = in.next();
	}
	
	static void solve() {
		
		if(c.equals("E")) E();
		else if(c.equals("EV")) EV();
		else if(c.equals("D")) D();
		else if(c.equals("DV")) DV();
	}

	static void E() {
		
		int n = 0;
		char cur = '0';
		char key = s.charAt(0);
		String hex="";
		while(s.length()>0) {

			cur = s.charAt(0);	
			s = s.substring(1);

			if(key==cur) {
				n++;
			}
			else {
				
				int t = 0;
				if(n>15) t=n/16;
				while(t-->0) ans+=key+"F";
				n%=16;
				hex = Integer.toHexString(n-1).toUpperCase();
				ans+=key+hex;
				key = cur;
				n=1;
			}			
			
		}
		int t = 0;
		if(n>15) t=n/16;
		while(t-->0) ans+=key+"F";
		n%=16;
		hex = Integer.toHexString(n-1).toUpperCase();
		ans+=key+hex;
		System.out.println(ans);
	}
	
	static void EV() {}
	static void D() {}
	static void DV() {}
}


/*
E
zzzzzzzzzzzzzyyyyyyyxwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwvvvuuuuuuuuuuuuuuuuuuuuuu

*/