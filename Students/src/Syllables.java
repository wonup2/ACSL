import java.io.*;
import java.util.*;
public class Syllables {
	static Scanner in;
	static String[] prefix = {"co", "de", "dis", "pre", "re", "un"};
	static String[] suffix = {"age", "ful", "ing", "less", "ment"};
	static String[] consonant = {"ch", "ck", "ph", "sh", "th", "wh", "wr"};
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("syllables.txt"));
		for(int i =0; i<3; i++) {
			int ans = 0;
			String word = in.nextLine();
			String pre = "";
			String suf = "";
			//step1
			pre = findPre(word);
			if(pre!="") {
				word = removePre(word, pre);
			}
			//step2
			suf = findSuf(word);
			if(suf!="") {
				word = removeSuf(word, suf);
			}
		//	System.out.println(pre+word+suf);		
			//step3
			ArrayList<Integer>vowel = new ArrayList<Integer>();
			vowel = findVowel(word);
		//	System.out.println(vowel);
			if(vowel.size()>1) {
				String before = word.substring(0,vowel.get(0));
				int tmp = vowel.size()-vowel.get(vowel.size()-1);
				String after = word.substring(vowel.size()-tmp+1);
			//	System.out.println(before + " " + after);
				String center = "";
				center = vowelSyllable(vowel, word);
			}
			
			if(vowel.size()<=1){
				
				
			}
			
		}
	}
	public static int countConst(String s) {
		int cnt = 0;
		for(int i =0; i<s.length(); i++) {
			if(s.charAt(i)!='a'&&s.charAt(i)!='e'&&s.charAt(i)!='i'&&s.charAt(i)!='o'&&s.charAt(i)!='u') {
				cnt++;
			}
		}
		
		return cnt;
	}
	public static String vowelSyllable(ArrayList<Integer> v, String w) {
		String c = "";
		for(int i =0; i<v.size()-1; i++) {
			String con = w.substring(v.get(i),v.get(i+1)+1);
			System.out.println(con + " con");
			int count = countConst(con);
			boolean combo = false;
			combo = checkCombo(con);
			if(combo) {
				count--;
			}
			if(count==0) {
				c += con.substring(0,1);
			}
			else if(count==1) {
				boolean starts = false;
				starts = startswithCombo(con);
				if(combo&&starts) {
					c+= con.substring(0,1)+"|"+con.substring(1);
				}
				else{
					c += con.substring(0,1)+"|"+con.substring(1);
				}
			}
			else if(count==2) {
				boolean starts = false;
				starts = startswithCombo(con);
				if(combo&&starts) {
					c+= con.substring(0,3)+"|"+con.substring(3);
					
				}
				else {
					c+= con.substring(0,2)+"|"+con.substring(2);
				}
			}
			else if(count==3) {
				boolean starts = false;
				starts = startswithCombo(con);
				if(combo&&starts) {
					c+=con.substring(0,4)+"|"+con.substring(4);
				}
				else {
					c+=con.substring(0,3)+"|"+con.substring(3);
				}
			}
			else if(count==4) {
				boolean starts = false;
				starts = startswithCombo(con);
				if(combo&&starts) {
					c+=con.substring(0,5)+"|"+con.substring(5);
				}
				else {
					c+=con.substring(0,4)+"|"+con.substring(4);
				}
			}
		}
		System.out.println(c);
		return c;
	}
	public static boolean startswithCombo(String con) {
		String s = con.substring(1,con.length()-1);
		boolean ch = false;
		for(String a:consonant) {
			if(s.startsWith(a)) {
				ch = true;
			}
		}
		return ch;
	}
	public static boolean checkCombo(String s) {
		boolean ch = false;
		for(String a:consonant) {
			if(s.startsWith(a)||s.endsWith(a)) {
				ch = true;
			}
		}
		
		return ch;
	}
	public static ArrayList<Integer> findVowel(String word){
		ArrayList<Integer> ch = new ArrayList<Integer>();
		for(int i =0; i<word.length(); i++) {
			if(word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u') {
				ch.add(i);
			}
		}
		return ch;
	}
	public static String findPre(String word) {
		String a = "";
		for(String s:prefix) {
			if(word.startsWith(s)) {
				a = s+="|";
				break;
			}
		}
		
		return a;
	}
	public static String removePre(String w, String p) {
		int tmp = p.length()-1;
		return w.substring(tmp);
	}
	public static String findSuf(String word) {
		String a = "";
		for(String s: suffix) {
			if(word.endsWith(s)) {
				a = "|" + s;
				break;
			}
		}
		return a;
	}
	public static String removeSuf(String w, String s) {
		int tmp = s.length()-1;
		return w.substring(0, w.length()-tmp);
	}
}
