import java.io.*;
import java.util.*;

public class P3_Syllable {
	
	static Scanner in;
	static String str;
	static int count;
	static ArrayList<String> vowels, consonants, combo;
	static String[] pre, suf;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			try {
				init();
				solve();
			} catch (Exception e) {
				in.nextLine();
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		in.close();
	}
	
	public static void init() throws IOException {
		str = in.nextLine();
		pre = new String[] {"co", "de", "dis", "pre", "re", "un"};
		suf = new String[] {"age", "ful", "ing", "less", "ment"};
		count = 0;
		vowels = new ArrayList<String>();
		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");
		combo = new ArrayList<String>();
		combo.add("ch");
		combo.add("ck");
		combo.add("ph");
		combo.add("sh");
		combo.add("th");
		combo.add("wh");
		combo.add("wr");
	}
	
	public static void solve() {
		String prefix = "";
		if(hasPrefix(str).length() > 0) {
			prefix = hasPrefix(str) + "|";
			str = str.substring(prefix.length() - 1);
		}
		//System.out.println(prefix + str);
		String suffix = "";
		if(hasSuffix(str).length() > 0) {
			suffix = "|" + hasSuffix(str);
			str = str.substring(0, str.length() - suffix.length() + 1);
		}
		//System.out.println(str + suffix);
		ArrayList<Integer> vowelindex = new ArrayList<Integer>();
		for(int i = 0; i < str.length(); i++) {
			if(vowels.contains(str.substring(i, i + 1))) vowelindex.add(i);
		}
		//System.out.println(vowelindex);
		String result  = "";
		String center = "";
		
			center = str.substring(0,vowelindex.get(0));
			
			for(int i = 0; i < vowelindex.size() - 1; i++) {
				center += str.charAt(vowelindex.get(i));
				String t = str.substring(vowelindex.get(i)+1, vowelindex.get(i + 1));
				
				if(t.length() == 1) center+="|"+t;
								
				else if(t.length() == 2) {
					if(combo.contains(t)) center+="|"+t;	 				
					else center+=t.charAt(0) + "|" + t.substring(1);
				}
				else if(t.length() == 3) {
					String temp = t.substring(0,2);
					if(combo.contains(temp)) center += temp + "|" + t.charAt(2);
					else center += t.charAt(0) + "|" + temp;
				}
				else if(t.length() == 4)  {					
					center += t.substring(0,2) + "|" + t.substring(2);					
				}
			}
			
			center += str.substring(vowelindex.get(vowelindex.size()-1));			
			
			result = prefix +  center + suffix;
		
		int sum = 0;
		for(int i = 0; i < result.length(); i++) {
			if(result.charAt(i) == '|') sum+=i;
		}
		System.out.println(sum);
	}
	
	public static String hasPrefix(String s) {
		for(String t:pre) {
			if(s.startsWith(t)) return t;
		}
		return "";
	}
	
	public static String hasSuffix(String s) {
		for(String t:suf) {
			if(s.endsWith(t)) return t;
		}
		return "";
	}

}
