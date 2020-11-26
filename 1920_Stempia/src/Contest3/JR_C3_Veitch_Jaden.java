package Contest3;
/*
Name: Jaden Chung
Grade: 9
Team: Stempia
Division: Junior5
Date: 3/1/2020
*/



import java.util.*;
import java.io.*;

public class JR_C3_Veitch_Jaden {
	static String ans, temp;
	static String[][]rules = {{"AB~C","ABC","~ABC","~AB~C"},{"A~B~C","A~BC","~A~BC","~A~B~C"}};;
	static char[][]board;
	static boolean[][]v;
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(new File("1920c3jr.in"));
		
		for(int q = 0; q < 10; q++) {
			String n = in.next();
			String n1 = Integer.toBinaryString(Integer.parseInt((n.charAt(0)+""), 16));
			String n2 = Integer.toBinaryString(Integer.parseInt((n.charAt(1)+""), 16));
			
			int n1len = n1.length();
			int n2len = n2.length();
			
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

			int counter = 1;
			
			//4 Adjacent X's
			if(board[0][0]=='#'&&board[0][1]=='#'&&board[0][2]=='#'&&board[0][3]=='#') {
				Arrays.fill(board[0], (counter+"").charAt(0));
				counter++;
			}
			if(board[1][0]=='#'&&board[1][1]=='#'&&board[1][2]=='#'&&board[1][3]=='#') {
				Arrays.fill(board[1], (counter+"").charAt(0));
				counter++;
			}
			for(int i = 0; i < 3; i++) {
				if(board[0][i]=='#'&&board[0][i+1]=='#'&&board[1][i]=='#'&&board[1][i+1]=='#') {
					board[0][i]=(counter+"").charAt(0);
					board[0][i+1]=(counter+"").charAt(0);
					board[1][i]=(counter+"").charAt(0);
					board[1][i+1]=(counter+"").charAt(0);
					counter++;
				}
			}
			
			//4 End Column X's
			if(board[0][0]=='#'&&board[1][0]=='#'&&board[0][3]=='#'&&board[1][3]=='#') {
				board[0][0]=(counter+"").charAt(0);
				board[1][0]=(counter+"").charAt(0);
				board[0][3]=(counter+"").charAt(0);
				board[1][3]=(counter+"").charAt(0);
				counter++;
			}
			
			//2 Adjacent X's
			for(int i = 0; i < 3; i++){
				if(board[0][i]=='#'&&board[0][i+1]=='#') {
					board[0][i]=(counter+"").charAt(0);
					board[0][i+1]=(counter+"").charAt(0);
					counter++;
				}
			}
			for(int i = 0; i < 3; i++) {
				if(board[1][i]=='#'&&board[1][i+1]=='#') {
					board[1][i]=(counter+"").charAt(0);
					board[1][i+1]=(counter+"").charAt(0);
					counter++;
				}
			}
			if(board[0][0]=='#'&&board[1][0]=='#') {
				board[0][0]=(counter+"").charAt(0);
				board[1][0]=(counter+"").charAt(0);
				counter++;
			}
			if(board[0][1]=='#'&&board[1][1]=='#') {
				board[0][1]=(counter+"").charAt(0);
				board[1][1]=(counter+"").charAt(0);
				counter++;
			}
			if(board[0][2]=='#'&&board[1][2]=='#') {
				board[0][2]=(counter+"").charAt(0);
				board[1][2]=(counter+"").charAt(0);
				counter++;
			}
			if(board[0][3]=='#'&&board[1][3]=='#') {
				board[0][3]=(counter+"").charAt(0);
				board[1][3]=(counter+"").charAt(0);
				counter++;
			}
			
			//2 End Column X's
			if(board[0][0]=='#'&&board[0][3]=='#') {
				board[0][0]=(counter+"").charAt(0);
				board[0][3]=(counter+"").charAt(0);
				counter++;
			}
			if(board[1][0]=='#'&&board[1][3]=='#') {
				board[1][0]=(counter+"").charAt(0);
				board[1][3]=(counter+"").charAt(0);
				counter++;
			}
			
			//Single X's
			for(int r = 0; r < 2; r++) {
				for(int c = 0; c < 4; c++) {
					if(board[r][c]=='#') {
						board[r][c]=(counter+"").charAt(0);
						counter++;
					}
				}
			}
			ans="";
			//Find Sum of Groups and Add into ans
			for(int p = 1; p < counter; p++) {
				temp = "";
				for(int r = 0; r < 2; r++) {
					for(int c = 0; c < 4; c++) {
						if(board[r][c]==(p+"").charAt(0)) {
							temp+=rules[r][c];
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
			
			//Print Answer
			ans=ans.substring(0, ans.length()-3);
			System.out.println(ans);
		}
		
	}
	
}
