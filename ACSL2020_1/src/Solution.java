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
     * Complete the 'passort' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING line as parameter.
     */
    public static int find(char[] a, char c){
        for(int i=0; i<a.length; i++){
            if(a[i]==c) return i;
        }
        return -1;
    }
    
    
    public static int passort(String line) {
        
        //char[] _a = line.toCharArray();
        char[] a = line.toCharArray();
        char[] b = line.toCharArray();
        char[] _b = line.replaceAll("[^A-Z^a-z^0-9]", "").toCharArray();
        String temp = "";
        
        Arrays.sort(_b);
        for(int i=0; i<_b.length; i++) {
        	temp+=_b[i];
        }
        //System.out.println(Arrays.toString(a));

        for(int i=0; i<b.length; i++) {
        	if(a[i]==' ') continue;
        	b[i]=temp.charAt(0);
        	temp=temp.substring(1);
        }
        //System.out.println(Arrays.toString(_b));
        //Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        String line2 = "";
        for(int i=0; i<line.length(); i++){            
            line2+=b[i];        
        }
        
        System.out.println(line2);
        int cnt = 0;String line3="";
        while(true){                        	

            if(line3.equals(line2)) break; 
            line3="";
            for(int i=0; i<line.length(); i++){
                char c = b[i];   //System.out.println(c);
                if(!Character.isLetter(c)&&!Character.isDigit(c)) {
                	continue;
                }
                if(c!=a[i]){
                    int n = find(a, c); //System.out.println(n);
                    a[n]=a[i];
                    a[i]=c;
                    cnt++; ;
                }
            }
            for(int j=0; j<a.length; j++){                    
                    line3+=a[j];
            }if(cnt==10) break;
            System.out.println(line3);
            }
        
        return cnt;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        int result = Result.passort(line);
        System.out.println(result);
      //  bufferedWriter.write(String.valueOf(result));
      //  bufferedWriter.newLine();

        bufferedReader.close();
      //  bufferedWriter.close();
    }
}
