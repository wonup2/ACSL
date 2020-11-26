import java.io.*;
import java.util.*;

public class A3_egypt {
    
    static Scanner in;
    static int a, b, sum;
    static String ans;

    public static void main(String[] args) throws FileNotFoundException {
        
        in = new Scanner(new File("egypt.in"));        
        
        for(int i =0; i < 10; i++) {
            try {
                init();
                solve();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void init() {
                
        int a1 = in.nextInt(); 				
        int b1 = in.nextInt();			 	
        
        a = Math.max(a1, b1);
        b = Math.min(a1, b1);

        ans = "";       
    }
    
    private static void solve() {
        int i = 32;
    	while(true) {
    		if(Math.pow(2, i) <= a) {
    			int n = (int)Math.pow(2, i); 
    			ans += n*b +" ";   
    			a-=n;     	
    		}
    		if(a==0) break;
    		i--;
    	}
    	System.out.println(ans);
    }
}