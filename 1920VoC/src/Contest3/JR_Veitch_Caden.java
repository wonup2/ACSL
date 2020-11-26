package Contest3;

import java.util.*;
import java.io.*;

public class JR_Veitch_Caden {
static int[][] board;
static ArrayList<String> ans;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920C3JR.in"));
		
		for (int i = 0; i < 5; i++) {
	    	board = new int[2][4];
	    	String s = Integer.toString(Integer.parseInt(in.nextLine(), 16), 2);
	    	s = String.format("%8s", s).replace(" ", "0");
	    	board[0][0] = Integer.parseInt(s.substring(0, 1));
	    	board[0][1] = Integer.parseInt(s.substring(1, 2));
	    	board[0][2] = Integer.parseInt(s.substring(2, 3));
	    	board[0][3] = Integer.parseInt(s.substring(3, 4));
	    	board[1][0] = Integer.parseInt(s.substring(4, 5));
	    	board[1][1] = Integer.parseInt(s.substring(5, 6));
	    	board[1][2] = Integer.parseInt(s.substring(6, 7));
	    	board[1][3] = Integer.parseInt(s.substring(7, 8));
	    	ans = new ArrayList<String>();
	    	//Priority 1
	    	p1();
	    	//Priority 2
	    	p2();
	    	//Priority 3
	    	p3();
	    	//Priority 4
	    	p4();
	    	//Priority 5
	    	p5();
	    	
	    	if (ans.size() == 1) {
	    		System.out.println(ans.get(0));
	    	}
	    	else {
	    		for (int j = 0; j < ans.size() - 1; j++) {
	    			System.out.print(ans.get(j) + " + ");
	    		}
	    		System.out.print(ans.get(ans.size() - 1));
	    		System.out.println();
	    	}
		}
	}
	
	public static void p1() {
    	if (board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1 && board[0][3] == 1) {
    		ans.add("B");
    		board[0][0] = 0;
    		board[0][1] = 0;
    		board[0][2] = 0;
    		board[0][3] = 0;
    	}
    	if (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1 && board[1][3] == 1) {
    		ans.add("~B");
    		board[1][0] = 0;
    		board[1][1] = 0;
    		board[1][2] = 0;
    		board[1][3] = 0;
    	}
    	if (board[0][0] == 1 && board[0][1] == 1 && board[1][0] == 1 && board[1][1] == 1) {
    		ans.add("A"); 
    		board[0][0] = 0; 
    		board[0][1] = 0; 
    		board[1][0] = 0; 
    		board[1][1] = 0;
    	}
    	if (board[0][1] == 1 && board[0][2] == 1 && board[1][1] == 1 && board[1][2] == 1) {
    		ans.add("C");
    		board[0][1] = 0;
    		board[0][2] = 0;
    		board[1][1] = 0;
    		board[1][2] = 0;
    	}
    	if (board[0][2] == 1 && board[0][3] == 1 && board[1][2] == 1 && board[1][3] == 1) {
    		ans.add("~A");
    		board[0][2] = 0;
    		board[0][3] = 0;
    		board[1][2] = 0;
    		board[1][3] = 0;
    	}
	}
	
	public static void p2() {
    	if (board[0][0] == 1 && board[1][0] == 1 && board[0][3] == 1 && board[1][3] == 1) {
    		ans.add("~C");
    		board[0][0] = 0;
    		board[1][0] = 0;
    		board[0][3] = 0;
    		board[1][3] = 0;
    	}
	}
	
	public static void p3() {
		if (board[0][0] == 1 && board[0][1] == 1) {
    		ans.add("AB");
    		board[0][0] = 0;
    		board[0][1] = 0;
    	}
    	if (board[0][1] == 1 && board[0][2] == 1) {
    		ans.add("BC");
    		board[0][1] = 0;
    		board[0][2] = 0;
    	}
    	if (board[0][2] == 1 && board[0][3] == 1) {
    		ans.add("~AB");
    		board[0][2] = 0;
    		board[0][3] = 0;
    	}
    	if (board[1][0] == 1 && board[1][1] == 1) {
    		ans.add("A~B");
    		board[1][0] = 0;
    		board[1][1] = 0;
    	}
    	if (board[1][1] == 1 && board[1][2] == 1) {
    		ans.add("~BC");
    		board[1][1] = 0;
    		board[1][2] = 0;
    	}
    	if (board[1][2] == 1 && board[1][3] == 1) {
    		ans.add("~A~B");
    		board[1][2] = 0;
    		board[1][3] = 0;
    	}
    	if (board[0][0] == 1 && board[1][0] == 1) {
    		ans.add("A~C");
    		board[0][0] = 0;
    		board[1][0] = 0;
    	}
    	if (board[0][1] == 1 && board[1][1] == 1) {
    		ans.add("AC");
    		board[0][1] = 0;
    		board[1][1] = 0;
    	}
    	if (board[0][2] == 1 && board[1][2] == 1) {
    		ans.add("~AC");
    		board[0][2] = 0;
    		board[1][2] = 0;
    	}
    	if (board[0][3] == 1 && board[1][3] == 1) {
    		ans.add("~A~C");
    		board[0][3] = 0;
    		board[1][3] = 0;
    	}
	}
	
	public static void p4() {
		if (board[0][0] == 1 && board[0][3] == 1) {
    		ans.add("B~C");
    		board[0][0] = 0;
    		board[0][3] = 0;
    	}
    	if (board[1][0] == 1 && board[1][3] == 1) {
    		ans.add("~B~C");
    		board[1][0] = 0;
    		board[1][3] = 0;
    	}
	}
	
	public static void p5() {
    	if (board[0][0] == 1) {
    		ans.add("AB~C");
    		board[0][0] = 0;
    	}
    	if (board[1][0] == 1) {
    		ans.add("A~B~C");
    		board[1][0] = 0;
    	}
    	if (board[0][1] == 1) {
    		ans.add("ABC");
    		board[0][1] = 0;
    	}
    	if (board[1][1] == 1) {
    		ans.add("A~BC");
    		board[1][1] = 0;
    	}
    	if (board[0][2] == 1) {
    		ans.add("~ABC");
    		board[0][2] = 0;
    	}
    	if (board[1][2] == 1) {
    		ans.add("~A~BC");
    		board[1][2] = 0;
    	}
    	if (board[0][3] == 1) {
    		ans.add("~AB~C");
    		board[0][3] = 0;
    	}
    	if (board[1][3] == 1) {
    		ans.add("~A~B~C");
    		board[1][3] = 0;
    	}
	}
}
