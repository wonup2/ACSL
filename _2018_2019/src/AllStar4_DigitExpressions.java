
import java.io.*;
public class AllStar4_DigitExpressions {
    static BufferedReader br;
    static String number;
    static int answer;  
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(new File("1819AllStar4.in")));
        for(int i = 0; i < 13; i++) {
        	try {
        		init();
        		solve();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        br.close();
    }
    private static void init() throws IOException {
    	number = br.readLine();
    	answer = 0;
    }
    private static void solve() {
       if(number.length() > 1) {
    	   for(int i = 0; i < number.length() - 1; i++) {
    		   String s1 = number.substring(0, i + 1);
    		   String s2 = number.substring(i + 1);
    		   if(s1.charAt(0) == '0' || s2.charAt(0) == '0')
    			   continue;
    		   answer += 2;
    		   if(Long.parseLong(s1) - Long.parseLong(s2) > 0)
    			   ++answer;
    	   }
       }
       if(number.length() > 2) {
    	   for(int i = number.length() - 1; i > 1; i--) {
    		   String s1 = number.substring(0, number.length() - i);
    		   if(s1.charAt(0) == '0')
    			   continue;
    		   for(int j = 0; j < i - 1; j++) {
    			   String s2 = number.substring(number.length() - i, number.length() - i + j + 1);
    			   String s3 = number.substring(number.length() - i + j + 1);
    			   if(s2.charAt(0) == '0' || s3.charAt(0) == '0')
    				   continue;
    			   answer += 2;
    			   if(Long.parseLong(s1) + Long.parseLong(s2) - Long.parseLong(s3) > 0)
    				   ++answer;
    			   if(Long.parseLong(s1) - Long.parseLong(s2) + Long.parseLong(s3) > 0)
    				   ++answer;
    			   if(Long.parseLong(s1) - Long.parseLong(s2) * Long.parseLong(s3) > 0)
    				   ++answer;
    			   if(Long.parseLong(s1) * Long.parseLong(s2) - Long.parseLong(s3) > 0)
    				   ++answer;
    		   }
    	   }
       }
       if(number.length() > 3) {
    	   for(int i = 0; i < number.length() - 3; i++) {
    		   String s1 = number.substring(0, i + 1);
    		   if(s1.charAt(0) == '0')
    			   continue;
    		   for(int j = i + 1; j < number.length() - 2; j++) {
    			   String s2 = number.substring(i + 1, j + 1);
    			   if(s2.charAt(0) == '0')
    				   continue;
    			   for(int k = j + 1; k < number.length() - 1; k++) {
    				   String s3 = number.substring(j + 1, k + 1);
    				   String s4 = number.substring(k + 1);
    				   if(s3.charAt(0) == '0' || s4.charAt(0) == '0')
    					   continue;
    				   if(Long.parseLong(s1) + Long.parseLong(s2) - Long.parseLong(s3) * Long.parseLong(s4) > 0)
    					   ++answer;
    				   if(Long.parseLong(s1) + Long.parseLong(s2) * Long.parseLong(s3) - Long.parseLong(s4) > 0)
    					   ++answer;
    				   if(Long.parseLong(s1) - Long.parseLong(s2) + Long.parseLong(s3) * Long.parseLong(s4) > 0)
    					   ++answer;
    				   if(Long.parseLong(s1) - Long.parseLong(s2) * Long.parseLong(s3) + Long.parseLong(s4) > 0)
    					   ++answer;
    				   if(Long.parseLong(s1) * Long.parseLong(s2) + Long.parseLong(s3) - Long.parseLong(s4) > 0)
    					   ++answer;
    				   if(Long.parseLong(s1) * Long.parseLong(s2) - Long.parseLong(s3) + Long.parseLong(s4) > 0)
    					   ++answer;
    			   }
    		   }
    	   }
       }
       System.out.println(answer);
    }
}