package Contest2;
/*
Catherine Cho 9
2019-2020 ACSL Contest 2 Junior Division
Stempia
*/

import java.util.*;
import java.io.*;
public class jr_stringDifferences_Catherine {
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(new File("1920c2jr.in"));
		for(int k=0; k<5; k++) {
			String word1 = in.next();
			String word2 = in.next();
			char previous = word1.charAt(word1.length()-1);
			for(int i = word1.length()-2; i >=0; i--) {
				if(word1.charAt(i) == previous ) {
					word1 = word1.substring(0,i) + word1.substring(i+1);
				}
				previous = word1.charAt(i);
			}
			
			previous = word2.charAt(word2.length()-1);
			for(int i = word2.length()-2; i >=0; i--) {
				if(word2.charAt(i) == previous ) {
					word2 = word2.substring(0,i) + word2.substring(i+1);
				}
				
				previous = word2.charAt(i);
			}
			
			word1 = word1.charAt(0) + word1.substring(1).replace("A", "");
			word1 = word1.charAt(0) + word1.substring(1).replace("E", "");
			word1 = word1.charAt(0) + word1.substring(1).replace("I", "");
			word1 = word1.charAt(0) + word1.substring(1).replace("O", "");
			word1 = word1.charAt(0) + word1.substring(1).replace("U", "");
			word2 =word2.charAt(0) + word2.substring(1).replace("A", "");
			word2 = word2.charAt(0) + word2.substring(1).replace("E", "");
			word2 = word2.charAt(0) + word2.substring(1).replace("I", "");
			word2 = word2.charAt(0) + word2.substring(1).replace("O", "");
			word2 =word2.charAt(0) + word2.substring(1).replace("U", "");
			
			int length = Math.min(word1.length()-1, word2.length()-1);
			for(int i = 0; i < length; i++) {
				if((word2.length() == 1 && i !=0)|| (word1.length() ==1 && i!= 0) || Math.min(word1.length(), word2.length()) == i){
					break;
				}
				
				if(word2.charAt(i) == word1.charAt(i)) {
					word2 = word2.substring(0,i) + word2.substring(i+1);
					word1 = word1.substring(0,i) + word1.substring(i+1);
					i--;
				}
			}
			
			
			length = word2.length()-1;
			int length2 = word1.length()-1;
			for(int i = length; i >= 0; i--) {
				if((word2.length() == 1 && i !=length)|| (word1.length() ==1 && i!= length) || length2 < 0){
					break;
				}
				char curr1 = word2.charAt(i);
				char curr2 = word1.charAt(length2);
				if(word2.charAt(i) == word1.charAt(length2)) {
					word2 = word2.substring(0,i) + word2.substring(i+1);
					word1 = word1.substring(0,length2) + word1.substring(length2 + 1);
	
				}
				length2--;
				
			}
			//System.out.println(word1);
			//System.out.println(word2);
			
			if(word1.length() > word2.length()) {
				System.out.println(word2);
			}else if(word1.length() < word2.length()) {
				System.out.println(word1);
			}else {
				char a = word1.charAt(0);
				char b = word2.charAt(0);
				if(a > b) {
					System.out.println(word2);
				}else {
					System.out.println(word1);
				}
			}
		}		
	}
}
