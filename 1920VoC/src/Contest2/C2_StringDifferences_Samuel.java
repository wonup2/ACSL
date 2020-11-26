package Contest2;
/*
 * Samuel Nam 9
 * Voice of Calling
 * Junior
 */



import java.util.*;
import java.io.*;

public class C2_StringDifferences_Samuel {

    static Scanner in;
    static String a, b;
    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("1920c2jr.in"));
        for(int i=0; i<5; i++) {
            try {            
                init();
                solve();
            
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        in.close();            
    }

    static void init() {
        a = in.next();
        b = in.next();
    }
    
    static void solve() {
        //step 1
        a = removeDouble(a);
        b = removeDouble(b);
        
        //step 2
        a = removeVowel(a);
        b = removeVowel(b);

        //step 3
        removeSameLocationSameCharacter();
        
        //step 4
        a = reverse(a);
        b = reverse(b);
        removeSameLocationSameCharacter();
        a = reverse(a);
        b = reverse(b);
        
        if(a.length()<b.length())
        	System.out.println(a);
        else
        	System.out.println(b);
        
    }
    
    static String removeDouble(String s){
    	for(int i=0; i<s.length()-1;){
			if(s.charAt(i)==s.charAt(i+1)){
				s=s.substring(0,i)+s.substring(i+1);
			}
			else
				i++;
		}
    	return s;
    }
    static String removeVowel(String s){
    	char c = s.charAt(0);
		s = s.substring(1);
		s = s.replaceAll("A","").replaceAll("E", "").replaceAll("I", "").replaceAll("O", "").replaceAll("U", "");
		s = c+s;
		return s;
    }
    
    static void removeSameLocationSameCharacter(){
    	int l = Math.min(a.length(), b.length());
    	for(int i=0; i<l-1;){
			if(a.charAt(i)==b.charAt(i)){
				a=a.substring(0,i)+a.substring(i+1);
				b=b.substring(0,i)+b.substring(i+1);
				l--;
			}
			else
				i++;
		}
    	
    }
    
    static String reverse(String s){
    	String temp = "";
    	for(int i = s.length()-1; i>=0; i--){
    		temp = temp + s.charAt(i);
    	}
    	return temp;    	
    }
}