package allStar;
import java.util.*;

public class hexFractions {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		
		for(int x = 0; x < 10; x++) {
			double decimal = Double.parseDouble(in.next());			
			String ans = ".";
			int cnt = 1;
			
			while(true) {
				decimal *= 16;
				String strDecimal = decimal+"";				
				int dot = strDecimal.indexOf(".");
				
				String front = strDecimal.substring(0,dot);  	//System.out.println("front: "+front);
				String back = "."+strDecimal.substring(dot+1);	//System.out.println("back: "+back);
				
				front = Integer.toHexString(Integer.parseInt(front)).toUpperCase();
				ans += front;
				decimal = Double.parseDouble(back);
				
				cnt++;
				if(cnt==16) break;
				if((int)decimal==decimal)break;
			}
			
			System.out.println(ans);
		}
	}
}

/*
.5
.75
.25
.1875
.6875
.013
.14
.144
.65
.88
.375
.875
.5625
.282
.556
.24
.28
.76
.1
.55
*/