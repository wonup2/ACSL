package Contest3;
//Sean Kim
//8th Grade
//ABCobot
//Junior
//Contest 3

import java.util.Scanner;
import java.util.*;
import java.io.*;
public class JR_veitchC3_Sean {
	static Scanner in;
	static char[][] board;
	static ArrayList<String> ans;
	static String real;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c3jr.in"));
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		in.close();
	}
	public static void init() {
		board = new char [2][4];
		ans = new ArrayList<String>();
		String[] temp = in.nextLine().split("");
		for(int j = 0; j < 2; j++) {
			int num = Integer.parseInt(temp[j], 16);
			String bin = Integer.toBinaryString(num);
			bin = String.format("%4s", bin).replace(" ","0");
			board[j] = bin.toCharArray();
		}
		real = "";
	}
	public static void solve() {
		if(board[0][0] == '1' && board[0][1] == '1' && board[1][0] == '1' && board[1][1] == '1') {
			ans.add("A");
			board[0][0] = 0;
			board[0][1] = 0;
			board[1][0] = 0;
			board[1][1] = 0;
		}
		if(board[0][1] == '1' && board[0][2] == '1' && board[1][1] == '1' && board[1][2] == '1') {
			ans.add("C");
			board[0][1] = 0;
			board[0][2] = 0;
			board[1][1] = 0;
			board[1][2] = 0;
		}
		if(board[0][2] == '1' && board[0][3] == '1' && board[1][2] == '1' && board[1][3] == '1') {
			ans.add("~A");
			board[0][2] = 0;
			board[0][3] = 0;
			board[1][2] = 0;
			board[1][3] = 0;
		}
		if(board[0][0] == '1' && board[0][1] == '1' && board[0][2] == '1' && board[0][3] == '1') {
			ans.add("B");
			board[0][0] = 0;
			board[0][1] = 0;
			board[0][2] = 0;
			board[0][3] = 0;
		}
		if(board[1][0] == '1' && board[1][1] == '1' && board[1][2] == '1' && board[1][3] == '1') {
			ans.add("~B");
			board[1][0] = 0;
			board[1][1] = 0;
			board[1][2] = 0;
			board[1][3] = 0;
		}
		if(board[0][0] == '1' && board[1][0] == '1' && board[0][3] == '1' && board[1][3] == '1') {
			ans.add("~C");
			board[0][0] = 0;
			board[1][0] = 0;
			board[0][3] = 0;
			board[1][3] = 0;
		}
		if(board[0][0] == '1' && board[0][1] == '1') {
			ans.add("A B");
			board[0][0] = 0;
			board[0][1] = 0;
		}
		if(board[0][1] == '1' && board[0][2] == '1') {
			ans.add("B C");
			board[0][1] = 0;
			board[0][2] = 0;
		}
		if(board[0][2] == '1' && board[0][3] == '1') {
			ans.add("~A B");
			board[0][2] = 0;
			board[0][3] = 0;
		}
		if(board[1][0] == '1' && board[1][1] == '1') {
			ans.add("A ~B");
			board[1][0] = 0;
			board[1][1] = 0;
		}
		if(board[1][1] == '1' && board[1][2] == '1') {
			ans.add("~B C");
			board[1][1] = 0;
			board[1][2] = 0;
		}
		if(board[1][2] == '1' && board[1][3] == '1') {
			ans.add("~A ~B");
			board[1][2] = 0;
			board[1][3] = 0;
		}
		if(board[0][0] == '1' && board[1][0] == '1') {
			ans.add("A ~C");
			board[0][0] = 0;
			board[1][0] = 0;
		}
		if(board[0][1] == '1' && board[1][1] == '1') {
			ans.add("A C");
			board[0][1] = 0;
			board[1][1] = 0;
		}
		if(board[0][2] == '1' && board[1][2] == '1') {
			ans.add("~A C");
			board[0][2] = 0;
			board[1][2] = 0;
		}
		if(board[0][3] == '1' && board[1][3] == '1') {
			ans.add("~A ~C");
			board[0][3] = 0;
			board[1][3] = 0;
		}
		if(board[0][0] == '1' && board[0][3] == '1') {
			ans.add("B ~C");
			board[0][0] = 0;
			board[0][3] = 0;
		}
		if(board[1][0] == '1' && board[1][3] == '1') {
			ans.add("~B ~C");
			board[1][0] = 0;
			board[1][3] = 0;
		}
		if(board[0][0] == '1') {
			ans.add("A B ~C");
			board[0][0] = 0;
		}
		if(board[0][1] == '1') {
			ans.add("A B C");
			board[0][1] = 0;
		}
		if(board[0][2] == '1') {
			ans.add("~A B C");
			board[0][2] = 0;
		}
		if(board[0][3] == '1') {
			ans.add("~A B ~C");
			board[0][3] = 0;
		}
		if(board[1][0] == '1') {
			ans.add("A ~B ~C");
			board[1][0] = 0;
		}
		if(board[1][1] == '1') {
			ans.add("A ~B C");
			board[1][1] = 0;
		}
		if(board[1][2] == '1') {
			ans.add("~A ~B C");
			board[1][2] = 0;
		}
		if(board[1][3] == '1') {
			ans.add("~A ~B ~C");
			board[1][3] = 0;
		}

		for(int j = 0; j < ans.size(); j++) {
			if(j == ans.size()-1) {
				String t = ans.get(j).replace(" ", "");
				real += t;
			}else {
				String t = ans.get(j).replace(" ", "");
				real += t +  " + ";	
			}
		}
		System.out.println(real);
	}
}
