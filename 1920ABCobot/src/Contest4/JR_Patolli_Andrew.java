package Contest4;
import java.io.*;
import java.util.*;

public class JR_Patolli_Andrew {
	static Scanner in;
	static ArrayList<Integer> o, d;
	static int cpos, n, m;
	
	public static void main (String args[]) throws IOException {
		in = new Scanner(new File("1920c4jr.in"));
		for(int gLoop = 0; gLoop < 5; gLoop++) {
			init();
			solve();
		}
	}
	
	static void init() throws IOException{
	    o=new ArrayList<Integer>();  
	    d=new ArrayList<Integer>();  
	    for(int i=0; i<3; i++) o.add(in.nextInt());
	    m = in.nextInt(); 
	    n = in.nextInt();
	    for(int i=0; i<n; i++) d.add(in.nextInt());
	}
	
	static void solve() {
		  for(int die:d) {            
		     int move = m + die;                                           
		            
		     if(move==52) { 
               System.out.println("GAME OVER");  
		       return; 
             }
		     if(move>52 || o.contains(move)){               
               continue;
             }
		            
		     if(isPrime(move))         m = movePrime(move);            
		     else if(isSquare(move))   m = moveSquare(move);   
		     else if(isRule9(m, move)) m = moveRule9(m, move, die);     
		     else m = move;       
		   }
		   System.out.println(m);
		}
	
	static boolean isPrime(int n) {
      
		for(int i=2; i<=n/2; i++){
			if(n % i == 0) return false;
        }
        return true;
	}
  
  
  static int movePrime(int n){
    
    for(int i=0; i<6; i++){
      if(o.contains(n+1)){ 
        return n;
      }
      n++;
    }
    return n;
  }
  
  
	
  static boolean isSquare(int n) {
		
      if(n<=4) return false;
      if(Math.sqrt(n) == (int)(Math.sqrt(n))) return true;
      else return false;
	}
  
  static int moveSquare(int n){
	    
	    for(int i=0; i<6; i++){
	      if(o.contains(n-1)){ 
	        return n;
	      }
	      n--;
	    }
	    return n;
	  }

static boolean isRule9(int c, int n){
	int[] r = {7, 12, 17, 22, 27, 35, 40, 45, 50};
	for(int i=0; i<9; i++)
		if(c < r[i] && n > r[i]) return true;
	return false;				
}

static int moveRule9(int c, int n, int d){
  
    for(int i = n; i>=c; i--){
      if(i % d ==0) {
        if(o.contains(i)) return c;
        else return i;
      }
    }
  
  return -1;
}
}








