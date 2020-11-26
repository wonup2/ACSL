package Contest3;
// Minjun Kim 9th
// Stempia Junior
// Contest 3

import java.util.*;
import java.io.*;

public class JR_Veitch_MINJUN {
	
	static Scanner in;
	static String ans, temp, n, n1, n2;
	static int n1len, n2len;
	static String[][]yes = {{"AB~C","ABC","~ABC","~AB~C"},{"A~B~C","A~BC","~A~BC","~A~B~C"}};;
	static char[][]board;
	static boolean[][]v;
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new File("1920C3Jr.in"));
		
		for(int q = 0; q < 5; q++) {
			
			init();
			solve();
			
			ans = ans.substring(0, ans.length()-3);
			System.out.println(ans);
			
		}
		

		in.close();
		
	}
	
	private static void init() {
		n = in.next();
		n1 = Integer.toBinaryString(Integer.parseInt((n.charAt(0)+""), 16));
		n2 = Integer.toBinaryString(Integer.parseInt((n.charAt(1)+""), 16));
		
		n1len = n1.length();
		n2len = n2.length();
		
		while(n1len!=4) {
			n1 = "0"+n1;
			n1len++;
		}
		while(n2len!=4) {
			n2 = "0"+n2;
			n2len++;
		}
		
		board = new char[2][4];
		
		for(int i = 0; i < 4; i++) {
			if(n1.charAt(i)=='1') {
				board[0][i]='#';
			}
			else {
				board[0][i]='0';
			}
			if(n2.charAt(i)=='1') {
				board[1][i]='#';
			}
			else {
				board[1][i]='0';
			}
		}
	}
	
	private static void solve() {
		int cnt = 1;
		
		if(board[0][0]=='#'&&board[0][1]=='#'&&board[0][2]=='#'&&board[0][3]=='#') {
			Arrays.fill(board[0], (cnt+"").charAt(0));
			cnt++;
		}
		if(board[1][0]=='#'&&board[1][1]=='#'&&board[1][2]=='#'&&board[1][3]=='#') {
			Arrays.fill(board[1], (cnt+"").charAt(0));
			cnt++;
		}
		for(int i = 0; i < 3; i++) {
			if(board[0][i]=='#'&&board[0][i+1]=='#'&&board[1][i]=='#'&&board[1][i+1]=='#') {
				board[0][i]=(cnt+"").charAt(0);
				board[0][i+1]=(cnt+"").charAt(0);
				board[1][i]=(cnt+"").charAt(0);
				board[1][i+1]=(cnt+"").charAt(0);
				cnt++;
			}
		}
		
		if(board[0][0]=='#'&&board[1][0]=='#'&&board[0][3]=='#'&&board[1][3]=='#') {
			board[0][0]=(cnt+"").charAt(0);
			board[1][0]=(cnt+"").charAt(0);
			board[0][3]=(cnt+"").charAt(0);
			board[1][3]=(cnt+"").charAt(0);
			cnt++;
		}
		
		for(int i = 0; i < 3; i++){
			if(board[0][i]=='#'&&board[0][i+1]=='#') {
				board[0][i]=(cnt+"").charAt(0);
				board[0][i+1]=(cnt+"").charAt(0);
				cnt++;
			}
		}
		for(int i = 0; i < 3; i++) {
			if(board[1][i]=='#'&&board[1][i+1]=='#') {
				board[1][i]=(cnt+"").charAt(0);
				board[1][i+1]=(cnt+"").charAt(0);
				cnt++;
			}
		}
		if(board[0][0]=='#'&&board[1][0]=='#') {
			board[0][0]=(cnt+"").charAt(0);
			board[1][0]=(cnt+"").charAt(0);
			cnt++;
		}
		if(board[0][1]=='#'&&board[1][1]=='#') {
			board[0][1]=(cnt+"").charAt(0);
			board[1][1]=(cnt+"").charAt(0);
			cnt++;
		}
		if(board[0][2]=='#'&&board[1][2]=='#') {
			board[0][2]=(cnt+"").charAt(0);
			board[1][2]=(cnt+"").charAt(0);
			cnt++;
		}
		if(board[0][3]=='#'&&board[1][3]=='#') {
			board[0][3]=(cnt+"").charAt(0);
			board[1][3]=(cnt+"").charAt(0);
			cnt++;
		}
		
		if(board[0][0]=='#'&&board[0][3]=='#') {
			board[0][0]=(cnt+"").charAt(0);
			board[0][3]=(cnt+"").charAt(0);
			cnt++;
		}
		if(board[1][0]=='#'&&board[1][3]=='#') {
			board[1][0]=(cnt+"").charAt(0);
			board[1][3]=(cnt+"").charAt(0);
			cnt++;
		}
		
		for(int r = 0; r < 2; r++) {
			for(int c = 0; c < 4; c++) {
				if(board[r][c]=='#') {
					board[r][c]=(cnt+"").charAt(0);
					cnt++;
				}
			}
		}
		ans="";
		
		for(int p = 1; p < cnt; p++) {
			temp = "";
			for(int r = 0; r < 2; r++) {
				for(int c = 0; c < 4; c++) {
					if(board[r][c]==(p+"").charAt(0)) {
						temp+=yes[r][c];
					}
				}
			}
			
			temp=temp.replace("~A", "$").replace("A", "!").replace("~B", "&").replace("B", "%").replace("~C", ")").replace("C", "(");
			TreeSet<String> set = new TreeSet<String>();
			
			for(int i = 0; i < temp.length(); i++) {
				set.add((temp.charAt(i)+""));
			}
			
			if(set.contains("$")&&set.contains("!")) {
				set.remove("$");
				set.remove("!");
			}
			
			if(set.contains("&")&&set.contains("%")) {
				set.remove("&");
				set.remove("%");
			}
			
			if(set.contains("(")&&set.contains(")")) {
				set.remove("(");
				set.remove(")");
			}
			
			temp=String.join("", set);
			
			temp=temp.replace("$", "~A").replace("!", "A").replace("&", "~B").replace("%", "B").replace(")", "~C").replace("(", "C");
			
			ans+=temp+" + ";
			
		}
		
	}
}
