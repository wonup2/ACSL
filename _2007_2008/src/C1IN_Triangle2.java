import java.util.*;
import java.io.*;

public class C1IN_Triangle2 {
	
	static Scanner in;
	static String t1[];
	static HashMap<String, Character> t2;
	
    public static void main(String[] args) throws IOException{
        in = new Scanner(new File("C1IN.in"));
        
		for(int i=0; i<5; i++) {
			try {
				init();   //get data
				solve();  //processing and output
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		in.close();
    }
    
    static void init() {
    	
    	String t[] = in.nextLine().split(" ");
    	
    	t1 = new String[]{t[1], t[2], t[0]};
    	t2 = new HashMap<String,Character>();
    	    	
    	t2.put(t[3],'F');
        t2.put(t[4],'D');
        t2.put(t[5],'E');
    }
    
    static void solve() {
    	String output = "";
    	
        for(int j =0;j<3;j++) {
            if(t2.get(t1[j]) == null) {
                output = "NONE";
                break;
            }
            else output+=t2.get(t1[j]);
        }
        
        System.out.println(output);
    }       
}