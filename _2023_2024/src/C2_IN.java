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



class Result1 {

    /*
     * Complete the 'decodeMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING text
     *  2. STRING message
     */

    public static String decodeMessage(String text, String message) {
    	
    	String words[] = text.split(" ");
    	String a[][] = new String[200][200];
		int s=0, w=0, c=0;
		String word = "";
		
		for(int i=0; i<words.length; i++) {
			word = words[i]; 	System.out.println(word);
			if(word=="") continue;
			char end = word.charAt(word.length()-1);			

			//Is that special character?
			if(word.length()==1) {
				String temp = word.replaceAll("[^a-zA-Z0-9]", "");
				if(temp.length()==0) continue;
			}
			
			//Did a special character split the word?
			word=word.replaceAll("[^a-zA-Z0-9]", " "); 
			StringTokenizer st = new StringTokenizer(word); 
			while(st.hasMoreTokens()) {
				a[s][w]= st.nextToken();
				w++;
			}
			//check end of sentences
			if(end=='.'||end=='?'||end=='!') { s++; w=0; }			
		}

		String ans="";
		String[] swc = message.split(" ");
		for(int i=0; i<swc.length; i++){
			word = swc[i]; 
			if(word==null) break;
			String t[] = word.split("\\.");
			s = Integer.parseInt(t[0])-1;
			w = Integer.parseInt(t[1])-1;
			c = Integer.parseInt(t[2])-1;
			
			if(a[s][w]==null || a[s][w].length()<=c) {
				ans+=" "; 
				continue;
			}

			ans+=a[s][w].charAt(c); 
		}
        return ans;
    }
}

public class C2_IN {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = bufferedReader.readLine();
        String message = bufferedReader.readLine();

        String result = Result1.decodeMessage(text, message);
        
        System.out.println(result);
    }
}
