package Contest3;
import java.io.File;
import java.io.IOException;
import java.util.*;
/*
 Mincheol Song
 Grade 9
 Team Voice of Calling Junior 5
 */
public class JR_Mincheol {
	static Scanner in;
	static String a, ans;
	static char b[][];

	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C3jr.in"));
		for(int i=0; i<5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		in.close();		

	}
	static void init() {
		a = in.next();
		b = new char[2][];
		b[0] = conv(a.charAt(0)).toCharArray();
		b[1] = conv(a.charAt(1)).toCharArray();
		//System.out.println(Arrays.deepToString(b));
		ans="";
	}
	private static String conv(char c) {
		if(c=='0') return "0000";
		else if(c=='1') return "0001";
		else if(c=='2') return "0010";
		else if(c=='3') return "0011";
		else if(c=='4') return "0100";
		else if(c=='5') return "0101";
		else if(c=='6') return "0110";
		else if(c=='7') return "0111";
		else if(c=='8') return "1000";
		else if(c=='9') return "1001";
		else if(c=='A') return "1010";
		else if(c=='B') return "1011";
		else if(c=='C') return "1100";
		else if(c=='D') return "1101";
		else if(c=='E') return "1110";
		else return "1111";		
	}		
	
	static void solve() {
		while(four()); 
		while(two()); 
		while(one()); 
	
		System.out.println(ans.substring(0, ans.length()-3));
	}
	private static boolean four() {
		boolean check = false;
		if(b[0][0]=='1'&&b[0][1]=='1'&&b[0][2]=='1'&&b[0][3]=='1') {
			ans+= "B";
			b[0][0] = '0'; b[0][1]= '0'; b[0][2] = '0'; b[0][3] = '0';
			check = true;
		}
		else if(b[1][0]=='1'&&b[1][1]=='1'&&b[1][2]=='1'&&b[1][3]=='1') {
			ans+="~B";
			b[1][0] = '0'; b[1][1] = '0'; b[1][2] = '0'; b[1][3] = '0';
			check = true; 
		}
		else if(b[0][0]=='1'&&b[0][1]=='1'&&b[1][0]=='1'&&b[1][1]=='1') {
			ans+="A";
			b[0][0]='0'; b[0][1] = '0'; b[1][0] = '0'; b[1][1] ='0';
			check = true;
		}
		else if(b[0][1]=='1'&&b[0][2]=='1'&&b[1][1]=='1'&&b[1][2]=='1') {
			ans +="C";
			b[0][1]='0'; b[0][2]='0'; b[1][1]='0'; b[1][2]='0';
			check = true;
		}
		else if(b[0][2]=='1'&&b[0][3]=='1'&&b[1][2]=='1'&&b[1][3]=='1') {
			ans+="~A";
			b[0][2]='0'; b[0][3]='0'; b[1][2]='0'; b[1][3]='0';
			 check = true;
		}
		else if(b[0][0]=='1'&&b[0][3]=='1'&&b[1][0]=='1'&&b[1][3]=='1') {
			ans+="~C";
			b[0][0]='0'; b[0][3]='0'; b[1][2]='0'; b[1][3]='0';
			check = true;
		}
		if(check) ans += " + ";
		return check;
	}
	private static boolean two() {
		boolean check = false;
		if(b[0][0]=='1'&&b[0][1]=='1') {
			ans+="AB";
			b[0][0]='0'; b[0][1]='0';
			check = true;
		}
		else if(b[0][1]=='1'&&b[0][2]=='1') {
			ans+="BC";
			b[0][1]='0'; b[0][2]='0';
			check = true;
		}
		else if(b[0][2]=='1'&&b[0][3]=='1') {
			ans+="~AB";
			b[0][2]='0'; b[0][3]='0';
			check = true;
		}
		else if(b[1][0]=='1'&&b[1][1]=='1') {
			ans+="A~B";
			b[1][0]='0'; b[1][1]='0';
			check = true;
		}
		else if(b[1][1]=='1'&&b[1][2]=='1') {
			ans+="~BC";
			b[1][1]='0'; b[1][2]='0';
			check = true;
		}
		else if(b[1][2]=='1'&&b[1][3]=='1') {
			ans+="~A~B";
			b[1][2]='0'; b[1][3]='0';
			check = true;
		}
		else if(b[0][0]=='1'&&b[1][0]=='1') {
			ans+="A~C";
		 	b[0][0]='0'; b[1][0]='0';
			check = true;
		}
		else if(b[0][1]=='1'&&b[1][1]=='1') {
			ans+="AC";
			b[0][1]='0'; b[1][1]='0';
			check = true;
		}
		else if(b[0][2]=='1'&&b[1][2]=='1') {
			ans+="~AC";
			b[0][2]='0'; b[1][2]='0';
			check = true;
		}
		else if(b[0][3]=='1'&&b[1][3]=='1') {
			ans+="~A~C";
			b[0][3]='0'; b[1][3]='0';
			check = true;
		}
		else if(b[0][0]=='1'&&b[0][3]=='1') {
			ans+="B~C";
			b[0][0]='0'; b[0][3]='0';
			check = true;
		}
		else if(b[1][0]=='1'&&b[1][3]=='1') {
			ans+="~B~C";
			b[1][0]='0'; b[1][3]='0';
			check = true;
		}
		if(check) ans += " + ";

		return check;
		
	}
	private static boolean one() {
		boolean check = false;
		if(b[0][0]=='1') {
			ans+="AB~C";
			b[0][0]='0';
			check = true;
		}
		else if(b[0][1]=='1') {
			ans+="ABC";
			b[0][1]='0';
			check = true;
		}
		else if(b[0][2]=='1') {
			ans+="~ABC";
			b[0][2]='0';
			check = true;
		}
		else if(b[0][3]=='1') {
			ans+="~AB~C";
			b[0][3]='0';
			check = true;
		}
		else if(b[1][0]=='1') {
			ans+="A~B~C";
			b[1][0]='0';
			check = true;
		}
		else if(b[1][1]=='1') {
			ans+="A~BC";
			b[1][1]='0';
			check = true;
		}
		else if(b[1][2]=='1') {
			ans+="~A~BC";
			b[1][2]='0';
			check = true;
		}
		else if(b[1][3]=='1') {
			ans+="~A~B~C";
			b[1][3]='0';
			check = true;
		}
		if(check) ans += " + ";

		return check;		
	}	
} 
