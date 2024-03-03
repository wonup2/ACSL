//hackerrank template

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

class Result {

    /*
     * Complete the 'bigwords' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY lines as parameter.
     */

    public static String findTime(char c1, char c2, char c3, char c4, char c5) {
    	
    	String ans = "";
    	
    	return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = bufferedReader.readLine().split(" ");

        char c1 = temp[0].charAt(0);  	// "R" --> 'R'
        char c2 = temp[1].charAt(0); 	// "W" --> 'W'
        char c3 = temp[2].charAt(0); 	// "G" --> 'G'
        char c4 = temp[3].charAt(0); 	// "B" --> 'B'
        char c5 = temp[4].charAt(0); 	// "G" --> 'G'

        String result = Result.findTime(c1, c2, c3, c4, c5);
        
        System.out.println(result);
        
        bufferedReader.close();
    }
}
