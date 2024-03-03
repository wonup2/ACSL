import java.io.*;
import java.util.*;
import java.math.*;
import java.text.DecimalFormat;

public class prob18 {
	
	//static String file = "Prob18-8";    //local    
    //static PrintWriter out;        //local    
    static Scanner in;

	public static void main(String[] args) throws IOException{
		
		try{
		
			//in = new Scanner(new File(file+"-in.txt"));            //local
	        //out = new PrintWriter(new File("-out.txt"));        //local        
	        in = new Scanner(System.in);  
		
			ArrayList<String> inp = new ArrayList<String>();
			
			while(true) { //do ctrl z to end reading input if using standard scanner (System.in)
				String temp = in.nextLine();
			    if(temp.length()==0) break;
			    inp.add(temp);
			}
			String word = inp.get(0).toLowerCase();

			if(inp.size() == 2) {
				System.out.println(inp.get(1));
			}else if(inp.size() == 3) {
				System.out.println(inp.get(1) + " " + word + " " + inp.get(2));
			}else {
				for(int i = 1;i < inp.size()-1;i ++) {
					System.out.print(inp.get(i) + ", ");
				}
				System.out.print(word + " " + inp.get(inp.size()-1));
			}
			
	
			in.close();
			//out.close(); //local
		    //Check.check("-out.txt", file+"-out.txt");    //local 
		
		}catch(Exception e){ 
			System.out.println("error: "+e.getMessage()); 
		} 

	}

}