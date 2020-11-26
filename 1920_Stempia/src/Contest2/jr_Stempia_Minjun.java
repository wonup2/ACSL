package Contest2;
/*
Name: Minjun Kim
Grade: 9
Team: Stempia
Division: Junior5 
Contest2
*/
import java.util.*;
import java.io.*;

public class jr_Stempia_Minjun {
	
	static Scanner in;
	static ArrayList<String> str1, str2, st1, st2;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("1920C2JR.in"));
			
			for(int i = 0; i < 5; i++) {
				init();
				solve();
			}
			
			in.close();
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
	private static void init() {
		String temp = in.next();
		str1 = new ArrayList<String>();
		
		for(int i = 0; i < temp.length(); i++) {
			str1.add(Character.toString(temp.charAt(i)));
		}
		
		temp = in.next();
		str2 = new ArrayList<String>();
		
		for(int i = 0; i < temp.length(); i++) {
			str2.add(Character.toString(temp.charAt(i)));
		}
		
		
		
	}
	
	private static String solve() {
	//1	
		doubleConsonants();
	//2	
		vowels();
	//3	
		LtoR();
	//4
		RtoL();
		
		String temp1 = "";
		for(int i = 0; i < str1.size(); i++) {
			temp1 += str1.get(i);
		}
		String temp2 = "";
		for(int i = 0; i < str2.size(); i++) {
			temp2 += str2.get(i);
		}
		
		if(str1.size() == str2.size()) {
			
			String ans[] = new String[2];
			
			ans[0] = temp1;
			ans[1] = temp2;
			
			Arrays.sort(ans);
			String temp = ans[0];
			System.out.println(temp);
			
		}
		else if(str1.size() > str2.size()) {
			
			System.out.println(temp2);
		}
		else {
			System.out.println(temp1);
		}
		
		return "";
	}
	private static void RtoL() {
		st1 = new ArrayList<String>();
		st2 = new ArrayList<String>();
		
		for(int i = str1.size()-1; i >= 0; i--) {
			st1.add(str1.get(i));
		}
		
		for(int i = str2.size()-1; i >= 0; i--) {
			st2.add(str2.get(i));
		}
		
		
		for(int i = 0; i < Math.min(st1.size(), st2.size()); i++) {
			if(st1.get(i).equals(st2.get(i))) {
				st1.remove(i);
				st2.remove(i);
				i--;
			}
		}
		
		str1.clear();
		str2.clear();
		
		for(int i = st1.size()-1; i >= 0; i--) {
			str1.add(st1.get(i));
		}
		
		for(int i = st2.size()-1; i >= 0; i--) {
			str2.add(st2.get(i));
		}
		
	}
	
	private static void LtoR() {
		for(int i = 0; i < Math.min(str1.size(), str2.size()); i++) {
			if(str1.get(i).equals(str2.get(i))) {
				str1.remove(i);
				str2.remove(i);
				i--;
			}
		}
	}
	
	private static void doubleConsonants() {
		for(int i = 0; i < str1.size()-1; i++) {
			String temp = str1.get(i);
			if(temp.equals(str1.get(i+1)) && vowelCheck(temp) == false) {
				str1.remove(i);
			}
		}
		for(int i = 0; i < str2.size()-1; i++) {
			String temp = str2.get(i);
			if(temp.equals(str2.get(i+1)) && vowelCheck(temp) == false) {
				str2.remove(i);
			}
		}
	}
	
	private static void vowels() {
		for(int i = 0; i < str1.size(); i++) {
			if(str1.get(i).contentEquals("A") || str1.get(i).contentEquals("E") || str1.get(i).contentEquals("I") || str1.get(i).contentEquals("O") || str1.get(i).contentEquals("U")) {
				if(i != 0) {
					str1.remove(i);
					i--;
				}
			}
		}
		for(int i = 0; i < str2.size(); i++) {
			if(str2.get(i).contentEquals("A") || str2.get(i).contentEquals("E") || str2.get(i).contentEquals("I") || str2.get(i).contentEquals("O") || str2.get(i).contentEquals("U")) {
				if(i != 0) {
					str2.remove(i);
					i--;
				}
			}
		}
	}
	
	private static boolean vowelCheck(String temp) {
		if(temp.contentEquals("A") || temp.contentEquals("E") || temp.contentEquals("I") || temp.contentEquals("O") || temp.contentEquals("U")) {
			return true;
		}
		else return false;
	}
}
