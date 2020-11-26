package Contest3;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class IN_c3_jaemin {
	public static String[][] chart = {{"*A*B~C~D", "*A*B*C~D", "~A*B*C~D", "~A*B~C~D"},
								{"*A*B~C*D", "*A*B*C*D", "~A*B*C*D", "~A*B~C*D"},
								{"*A~B~C*D", "*A~B*C*D", "~A~B*C*D", "~A~B~C*D"},
								{"*A~B~C~D", "*A~B*C~D", "~A~B*C~D", "~A~B~C~D"}};
	public static int[][] ans;
	static Scanner in;
	static String a[];	
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("1920c3in.in"));
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
  
    static void init() {
    	ans = new int[4][4];
		a = in.nextLine().replace("+", " ").split(" ");
		for(int i = 0; i < a.length; i++) {
			a[i] = conv(a[i]);

		}
      
	}
	
  	static void solve() {
  		
  		for(int i = 0; i < 4; i++) {
  			for(int i1 = 0; i1 < 4; i1++) {
  			String c = chart[i][i1];
  				for(int j = 0; j < a.length; j++) {
  				String t1 = a[j];
  				boolean ok = true;
  					for(int k = 0; k < t1.length(); k +=2) {
  						String t2 = t1.substring(k , k+2);
  						
						if(!c.contains(t2)) ok = false;
  						
  					}
  					if(ok) {ans[i][i1] = 1; break;}
  				}
  			}
  		}
      
      
  		//System.out.println(Arrays.deepToString(ans));
      
        String output = "";
      	for(int i = 0; i < 4; i++) {
  			String c = ""+ans[i][0]+ans[i][1]+ans[i][2]+ans[i][3];
            output+=conversion(c);
        }
           System.out.println(output);     
	}
       
  static String conv(String s){

		String temp ="";
		for(int k = 0; k < s.length(); k++) {
			if(s.charAt(k) != '~') {
				temp += "*" + s.charAt(k);
			}
			else {
				temp += "~" + s.charAt(k+1);
				k++;
			}
		}
		return temp;
  }
		 
 
  
  
	public static String conversion (String binary) {
		if(binary.equals("0000")) return "0";
		else if (binary.equals("0001")) return "1";
		else if (binary.equals("0010")) return "2";
		else if (binary.equals("0011")) return "3";
		else if (binary.equals("0100")) return "4";
		else if (binary.equals("0101")) return "5";
		else if (binary.equals("0110")) return "6";
		else if (binary.equals("0111")) return "7";
		else if (binary.equals("1000")) return "8";
		else if (binary.equals("1001")) return "9";
		else if (binary.equals("1010")) return "A";
		else if (binary.equals("1011")) return "B";
		else if (binary.equals("1100")) return "C";
		else if (binary.equals("1101")) return "D";
		else if (binary.equals("1110")) return "E";
		else if (binary.equals("1111")) return "F";
		else return binary;
	}

}
