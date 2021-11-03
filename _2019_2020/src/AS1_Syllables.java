import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solve {
	
	public static String[] prefix = {"co","de","dis","pre","re","un"};
	public static String[] suffix = {"age","ful","ing","less","ment"};
	public static String[] twocons = {"ch","ck","ph","sh","th","wh","wr"};
	
    public static int syllables(String word) {
    	
    	String pre = "";
    	String suf = "";
    	for(String s:prefix) 	{
    		if(word.startsWith(s)) {	
    			pre=s+"|";
    			word = word.substring(s.length());    
    			break;
    		}
    	}    	
    	//System.out.println(pre +" "+word);  //prelanguage
    	
    	for(String s:suffix){
    		if(word.endsWith(s)) {
    			suf="|"+s;
    			word = word.substring(0,word.length()-s.length());
    			break;
    		}
    	}    	

    	//System.out.println(pre +" "+word +" "+suf);  //prelanguage
    	
    	ArrayList<Integer> v = new ArrayList<Integer>();
    	for(int i=0; i<word.length(); i++) {
    		if(isVowel(word.charAt(i))) v.add(i);
    	}
    	
    	//System.out.println(v);
    	
    	String center = word.substring(0, v.get(0));
    	
    	for(int i=0; i<v.size()-1; i++) {
    		int a = v.get(i);
    		int b = v.get(i+1);
    		String t = word.substring(a+1,b);
    		center += word.charAt(a);
    		
    		if(t.length()==1) center += "|" + t;
    		else if(t.length()==2) {
    			if(startCons(t)) center += "|" + t;
    			else center += t.charAt(0) + "|" + t.charAt(1);
    		}
    		else if(t.length()==3) {
    			if(startCons(t)) center += t.substring(0,2) + "|" + t.charAt(2);
    			if(endCons(t)) center += t.charAt(0) + "|" + t.substring(1,3);
    		}
    		else if(t.length()==4) {
    			center += t.substring(0,2) + "|" + t.substring(2,4);
    		}
    	}
    	
    	center += word.substring(v.get(v.size()-1));    	    	

		String s = pre+center+suf;
    	int ans = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='|') ans+=i;
		}
		return ans;    	
    }
    
    public static boolean startCons(String s) {
    	for(String t:twocons) {
    		if(s.startsWith(t)) return true;
    	}
    	return false;
    }
    
    public static boolean endCons(String s) {
    	for(String t:twocons) {
    		if(s.endsWith(t)) return true;
    	}
    	return false;
    } 
    
    public static boolean isVowel(char c) {
    	return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}

public class AS1_Syllables {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++) {
        	String word = bufferedReader.readLine();

        	int result = Solve.syllables(word);
        	System.out.println(result);     
        }
    }
}
