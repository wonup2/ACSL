package Contest3;
/*
Julia Jung
10th Grade
Voice of Calling
Intermediate 3
Contest 3
 */
import java.io.*;
import java.util.*;
public class IN_veitch_Julia {
	static Scanner in;
	static String[] board, input;
	static boolean[] x;
	public static void main(String[] args) throws FileNotFoundException{
		in = new Scanner(new File("1920c3in.in"));
		
		board = new String[16];
		board[0] = "`A`B~C~D";
		board[1] = "`A`B`C~D";
		board[2] = "~A`B`C~D";
		board[3] = "~A`B~C~D";
		board[4] = "`A`B~C`D";
		board[5] = "`A`B`C`D";
		board[6] = "~A`B`C`D";
		board[7] = "~A`B~C`D";
		board[8] = "`A~B~C`D";
		board[9] = "`A~B`C`D";
		board[10] = "~A~B`C`D";
		board[11] = "~A~B~C`D";
		board[12] = "`A~B~C~D";
		board[13] = "`A~B`C~D";
		board[14] = "~A~B`C~D";
		board[15] = "~A~B~C~D";
		
		for(int i =0; i < 5; i++) {
			try {
				init();
				solve();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		in.close();
	}
	
	private static void init() {
		x = new boolean[16];
		String temp = in.nextLine();
		temp = temp.replace("+", " ");
		input = temp.split(" ");
		
		for(int i =0; i < input.length; i++) {
			String t = input[i];
			String r = "";
			for(int j =0; j < input[i].length(); j++) {
				if(t.charAt(j) != '~') {
					r += "`" + t.charAt(j);
				}else {
					r += t.substring(j, j+2);
					j++;
				}
			}
			input[i] = r;
		}
		
	}
	
	private static void solve() {
		
		for(int i =0; i < input.length; i++) {
			String temp = input[i];
			ArrayList <String> sep = new ArrayList<String>();
			
			for(int k =0; k < temp.length(); k+=2) {
				sep.add(temp.substring(k, k+2));
			}
			
			for(int j =0; j < 16; j++) {
				boolean chk = true;
				for(int b = 0; b < sep.size(); b++) {
					if(!board[j].contains(sep.get(b))) {
						chk = false;
						
						break;
					}
				}
				if(chk)
					x[j] = true;
			}
		}
		
		String s = "";
		for(int i =0; i < 16; i++) {
			if(x[i]) {
				s+= "1";
			}else {
				s+= "0";
			}
		}
		
		int num = Integer.parseInt(s, 2);
		String res = Integer.toHexString(num).toUpperCase();
		
		if(res.length() < 1) 
			res = "0000";
		else if(res.length() <2) 
			res = "000" + res;
		else if(res.length() <3) 
			res = "00" + res;
		else if (res.length()< 4) 
			res = "0" + res;
		
		System.out.println(res);
	}

}
