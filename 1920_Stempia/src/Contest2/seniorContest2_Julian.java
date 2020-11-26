package Contest2;
/*
Julian Ha
11th Grade
Stempia
Senior 3 Contest 2
 */

import java.util.*;
import java.io.*;


public class seniorContest2_Julian{

	static Scanner in;
	static PrintWriter out;
	static String s1, s2, s1t, s2t;
	static String[] split1, split2;
	static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(new File("1920c2sr.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("seniorContest2.out")));
		for (int rep = 0; rep < 5; rep++) {
			init();
			solve();
		}
	}
	
	public static void init() {
		s1t = in.nextLine();
		s2t = in.nextLine();
		s1t = s1t.toUpperCase();
		s2t = s2t.toUpperCase();
		split1 = s1t.split(" ");
		split2 = s2t.split(" ");
		s1t = "";
		s2t = "";
		s1 = "";
		s2 = "";
		for (int i = 0; i < split1.length; i++) {
			s1t += split1[i];
		}
		for (int i = 0; i < split2.length; i++) {
			s2t += split2[i];
		}
		for (int i = 0; i < s1t.length(); i++) {
			if (s1t.charAt(i) == '0' || s1t.charAt(i) == '1' || s1t.charAt(i) == '2' || s1t.charAt(i) == '3' || s1t.charAt(i) == '4' || s1t.charAt(i) == '5' || s1t.charAt(i) == '6' ||s1t.charAt(i) == '7' || s1t.charAt(i) == '8' || s1t.charAt(i) == '9' || s1t.charAt(i) == '.')
				continue;
			else
				s1 += s1t.charAt(i);
		}
		for (int i = 0; i < s2t.length(); i++) {
			if (s2t.charAt(i) == '0' || s2t.charAt(i) == '1' || s2t.charAt(i) == '2' || s2t.charAt(i) == '3' || s2t.charAt(i) == '4' || s2t.charAt(i) == '5' || s2t.charAt(i) == '6' ||s2t.charAt(i) == '7' || s2t.charAt(i) == '8' || s2t.charAt(i) == '9' || s2t.charAt(i) == '.')
				continue;
			else
				s2 += s2t.charAt(i);
		}
		list = new ArrayList<String>();
		//System.out.println(s1);
		//System.out.println(s2);
	}
	
	public static void solve() {
		System.out.println(split(s1, s2));
	}
	
	public static int split(String x, String y) {
		int temp = 0;
		//System.out.println("x = " + x);
		//System.out.println("y = " + y);
		if (x.equals(" ") || y.equals(" ") || x.equals("") || y.equals("") || x.length() == 0 || y.length() == 0)
			return 0;
		else {
			for (int i = x.length(); i >= 0; i--) {
				if (i > y.length())
					continue;
				for (int j = 0; j <= x.length() - i; j++) {
					String sub = x.substring(j, j + i);
					//System.out.println("sub = " + sub);
					if (y.contains(sub))
						list.add(sub);
				}
				if (!list.isEmpty())
					break;
			} //IM PRETTY SURE ALL OF THIS PART IS CORRECT
			if (list.isEmpty())
				return 0;
			Collections.sort(list);
			String word = list.get(0);
			temp += word.length(); //ADD THE LENGTH OF THE WORD TO TEMP
			//System.out.println("word = " + word);
			if (word.equals(" ") || word.equals("") || word.length() == 0)
				return 0;
			String s3;
			String s4;
			String s5;
			String s6;
			s3 = x.substring(0, x.indexOf(word));
			//System.out.println("s3 = " + s3);
			if (x.indexOf(word) + word.length() >= x.length())
				s4 =  "";
			s4 = x.substring(x.indexOf(word) + word.length());
			//System.out.println("s4 = " + s4);
			s5 = y.substring(0, y.indexOf(word));
			//System.out.println("s5 = " + s5);
			if (y.indexOf(word) + word.length() >= word.length())
				s6 = "";
			s6 = y.substring(y.indexOf(word) + word.length());
			//System.out.println("s6 = " + s6);
			list.clear();
			//System.out.println("temp = " + temp);
			temp += split (s3, s5);
			//System.out.println("temp = " + temp);
			list.clear();
			temp += split (s4, s6);
			//System.out.println("temp = " + temp);
		}
		return temp;
	}
}