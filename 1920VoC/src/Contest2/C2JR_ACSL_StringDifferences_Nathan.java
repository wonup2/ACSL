package Contest2;
/*
 * Nathan Kang 8
 * Voice of Calling
 * Junior
 */



import java.util.*;
import java.io.*;
public class C2JR_ACSL_StringDifferences_Nathan {
    static BufferedReader br;
    static ArrayList<Character> word1, word2;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(new File("1920C2Jr.in")));
        for(int i = 0; i < 5; i++) {
        	try {
        		word1 = new ArrayList<Character>();
                word2 = new ArrayList<Character>();
        		init();
        		solve();
        	}
        	catch(Exception e) {
        		e.printStackTrace(); //use while coding, comment out when submitting
        		//System.out.println("error"); //use when submitted, comment out when coding
        	}
        }
        br.close();
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String s1 = st.nextToken();
    	for(int i = 0; i < s1.length(); i++)
    		word1.add(s1.charAt(i));
    	String s2 = st.nextToken();
    	for(int i = 0; i < s2.length(); i++)
    		word2.add(s2.charAt(i));
    }
    private static void solve() {
        for(int i = word1.size() - 1; i > 0; i--) {
        	if(word1.get(i) == word1.get(i - 1))
        		word1.remove(i);
        	else if(word1.get(i) == 'A' || word1.get(i) == 'E' || word1.get(i) == 'I' || word1.get(i) == 'O' ||
        			word1.get(i) == 'U') {
        		word1.remove(i);
        	}
        }
        for(int i = word2.size() - 1; i > 0; i--) {
        	if(word2.get(i) == word2.get(i - 1))
        		word2.remove(i);
        	else if(word2.get(i) == 'A' || word2.get(i) == 'E' || word2.get(i) == 'I' || word2.get(i) == 'O' ||
        			word2.get(i) == 'U') {
        		word2.remove(i);
        	}
        }
        for(int i = 0; i < Math.min(word1.size(), word2.size()); i++) {
        	if(word1.get(i) == word2.get(i)) {
        		word1.remove(i);
        		word2.remove(i);
        		--i;
        	}
        }
        if(word1.size() > word2.size())
        	for(int i = Math.abs(word1.size() - word2.size()); i > 0; i--)
        		word2.add(0, ' ');
        else if(word1.size() < word2.size())
        	for(int i = Math.abs(word1.size() - word2.size()); i > 0; i--)
        		word1.add(0, ' ');
        for(int i = word1.size() - 1; i >= 0; i--) {
        	if(word1.get(i) == word2.get(i)) {
        		word1.remove(i);
        		word2.remove(i);
        	}
        }
        for(int i = word1.size() - 1; i >= 0; i--)
        	if(word1.get(i) == ' ')
        		word1.remove(i);
        for(int i = word2.size() - 1; i >= 0; i--)
        	if(word2.get(i) == ' ')
        		word2.remove(i);
        String res = "";
        if(word1.size() < word2.size())
        	for(int i = 0; i < word1.size(); i++)
        		res += word1.get(i) + "";
        else if(word2.size() < word1.size())
        	for(int i = 0; i < word2.size(); i++)
        		res += word2.get(i) + "";
        else {
        	boolean oneIsFirst = true;
        	for(int i = 0; i < word1.size(); i++) {
        		if(word1.get(i) > word2.get(i)) {
        			oneIsFirst = false;
        			break;
        		}
        	}
        	if(oneIsFirst)
        		for(int i = 0; i < word1.size(); i++)
        			res += word1.get(i) + "";
        	else
        		for(int i = 0; i < word2.size(); i++)
        			res += word2.get(i) + "";
        }
        System.out.println(res);
    }
}