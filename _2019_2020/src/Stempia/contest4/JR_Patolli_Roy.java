package Stempia.contest4;
import java.util.*;
import java.io.*;
public class JR_Patolli_Roy {
	static Scanner in;
	static ArrayList<Integer> opp, dice;
	static int mark, num;
  
	public static void main(String[] args)throws IOException {
		in = new Scanner(new File("1920c4jr.in"));
		try {
			for(int i = 0;i<5;i++) {
				init();
				solve();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
  
	public static void init() {
		opp = new ArrayList<Integer>();
		for(int i = 0;i<3;i++) {
			opp.add(in.nextInt());
		}
      
		Collections.sort(opp);
		mark = in.nextInt();
		num = in.nextInt();
		dice = new ArrayList<Integer>();
      
		for(int i = 0;i<num;i++) {
			dice.add(in.nextInt());
		}		
	}
  
	public static void solve() {
		int after = 0;
      
		for(int i = 0;i<dice.size();i++) {
          
			after = mark + dice.get(i);   			
                             
			if(after==52) {
				mark = -1;
				break;
			}
          
			if(after>52||opp.contains(after)) continue;
          
			if(isPrime(after)) {
				after = movePrime(after);					
			}
			else if(isSquare(after)) {
				after = moveSquare(after);					
			}
			else if(isRule9(mark, after)) {
				after = moveRule9(mark, after, dice.get(i)); 
			}
			
			mark = after;
		}
		
		if(mark==-1) System.out.println("GAME OVER");
		else System.out.println(mark);
	}
  
  
	public static boolean isPrime(int m) {
		for(int i = 2; i <= m/2; i++) {
			if(m%i==0) return false;
		}
		return true;
	}
  
  
	public static int movePrime(int m) {
      
      for(int i=0; i<6; i++){
        if(opp.contains(m+1)) return m;
        m++;
      }
	   return m;
	}
  
    
	public static boolean isSquare(int m) {
		
      if(m==4) return false;
      
      return Math.sqrt(m) == (int)Math.sqrt(m);
      
	}
  
  
	public static int moveSquare(int m) {
		for(int i = 0;i<6;i++) {
			if(opp.contains(m-1)) return m;
			m--;
		}
		return m;
	}
  
	public static boolean isRule9(int mark, int after) {
		int[] r = {7, 12, 17, 22, 27, 5, 40, 45, 50};
		for(int i = 0;i<r.length;i++) {
			if(mark<r[i]&&after>r[i]) {
				return true;
			}
		}
		return false;
	}
  
	public static int moveRule9(int mark, int after, int d) {
		for(int j = after; after>=mark;j--) {
			if(j%d==0) {
				if(!opp.contains(j)) {
					return j;
				}
				else return mark;
			}
		}
		return mark;
	} 
}
