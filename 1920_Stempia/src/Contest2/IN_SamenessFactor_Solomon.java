package Contest2;
/*
Name:  Solomon Baik	
Grade:  10
Team:  Stempia
Division:  Intermediate
Contest 2
*/

import java.util.*;
import java.io.*;
public class IN_SamenessFactor_Solomon {
	
	static Scanner in;
	static String s1, s2;
	static ArrayList<Character> list1 = new ArrayList<Character>(), list2 = new ArrayList<Character>();
	static boolean deleteCounter, alignCounter;
	static int ans;
	
	public static void main(String[] args)throws IOException{
		in = new Scanner(new File("1920C2IN.in"));
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR");
				in.nextLine();
			}
		}
	}
	
	static void init() {
		list1.clear();
		list2.clear();
		s1 = in.next();
		s2 = in.next();
		for(char c: s1.toCharArray())
			list1.add(c);
		for(char c: s2.toCharArray())
			list2.add(c);
	}
	
	static void solve() {
		deleteCounter = true;
		alignCounter = true;
		while(deleteCounter == true && alignCounter == true) {
			delete();
			align();
			check();
		}
		calculate();
		System.out.println(ans);
	}
	
	static void delete() {
		int min = Math.min(list1.size(),list2.size());
		for(int i = 0; i < min; i++) {
			if(list1.get(i) == list2.get(i)) {
				list1.remove(i);
				list2.remove(i);
				i--;
				min--;
			}
		}
		deleteCounter = false;
	}
	
	static void align() {
		int min2 = Math.min(list1.size(), list2.size());
		for(int i = 0; i < min2 - 1; i++) {
			if(list1.get(i) == list2.get(i + 1)) {
				list2.remove(i);
				break;
			}else if(list1.get(i + 1) == list2.get(i)) {
				list1.remove(i);
				break;
			}
		}
		alignCounter = false;
	}
	
	static void check() {
		int min3 = Math.min(list1.size(), list2.size());
		for(int i = 0; i < min3; i++) {
			if(list1.get(i) == list2.get(i)) {
				deleteCounter = true;
				alignCounter = true;
			}
		}
	}
	
	static void calculate() {
		int min4 = Math.min(list1.size(), list2.size());
		ans = 0;
		for(int i = 0; i < min4; i++)
			ans += (list2.get(i) - list1.get(i)) * -1;
		if(list1.size() > min4) {
			ans += list1.size() - min4;
		}else if(list2.size() > min4) {
			ans += list2.size() - min4;
		}
	}

}
