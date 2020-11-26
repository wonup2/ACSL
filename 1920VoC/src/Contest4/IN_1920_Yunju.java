package Contest4;
import java.util.*;
import java.io.*;
/*
Yunju Song
10th grade
Voice Of Calling
intermediate
*/
public class IN_1920_Yunju  {
	static Scanner in;
	static ArrayList<Integer> o;
	static ArrayList<Integer> p;
	static ArrayList<Integer> d;
	static int n;
	static int[] rule9 = {7,12,17,22,27,35,40,50};
	static int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C4IN.in"));
		
		
		 for(int i=0; i<5; i++){
				try{			
					System.out.print(i+1+". ");
					init();
					solve();			
				}
				catch(Exception e){
					System.out.println("Error");
	                e.printStackTrace();
				}
	        }
		 
		 in.close();

	}
	static void init(){
		o = new ArrayList<Integer>();    
	    p = new ArrayList<Integer>();     
	    d = new ArrayList<Integer>();     
		    
	   for(int i=0; i<3; i++) o.add(in.nextInt());
	   for(int i=0; i<3; i++) p.add(in.nextInt());
	   n = in.nextInt();
	   for(int i=0; i<n; i++) d.add(in.nextInt());
		        
	   Collections.sort(o);
	   Collections.sort(p);      
	}
	static void solve(){
		boolean check = false;
		 for(int die:d) {
		      Collections.sort(p);                        
		      int move = p.get(0)+die;    
		      //System.out.println("rolled: " + die);
		      //System.out.println(p);
		      
		      if(move==52) { p.remove(0); continue; }
		      if(move>52 || isOccupied(move)) continue;
		      if(p.size()==0){check = true; break;}
		      
		      if(isPrime(move)) { 
		    	  //System.out.print(" isPrime : ");
		    	  p.set(0, movePrime(move, move+6));
		      }         
		      else if(isSquare(move)) {
		    	  //System.out.print(" isSquare: ");
		    	  p.set(0, moveSquare(move, move-6));
		      }
		      else if(isRule9(p.get(0), move)) {
		    	  //System.out.print(" isRule9: ");
		    	  p.set(0, moveRule9(p.get(0), move, die)); 
		      }
		      else {
		    	  //System.out.print(" noChange: ");
		    	  p.set(0, move); 
		      }
		      //System.out.print(p.get(0) + " || " + p);
		      //System.out.println("");
		    }
		    if(check) System.out.println("GAME OVER");
		    else{
		    	Collections.sort(p);
			    for(int i = 0; i < p.size()-1; i++){
			    	System.out.print(p.get(i) + " ");
			    }
			    System.out.print(p.get(p.size()-1));
			    System.out.println("");
		    }
		    
	}
	static boolean isOccupied(int m){
		for(int i = 0; i < 3; i++){
			if(o.get(i) == m){
				return  true;
			}
		}
		for(int i = 1; i < p.size(); i++){
			if(p.get(i) == m){
				return  true;
			}
		}
		return false;
		
	}
	static boolean isPrime(int m){
		boolean ans = true;
		
		for(int i = 0; i < prime.length; i++){
			if(prime[i] == m){
				ans = true;
				break;
			}
			else ans = false;
		}
		return ans;
	}
	static boolean isSquare(int m){
		boolean result = false;
		int[] perfect = {9, 16, 25, 36, 49};
		for(int i = 0; i < perfect.length; i++){
			if(m == perfect[i]){
				result = true;
				break;
			}
		}
		return result;
	}
	static boolean isRule9(int a, int b){
		for(int i = 0; i < rule9.length; i++){
			if(a < rule9[i] && b > rule9[i]){
				return true;
			}
		}
		return false;
	}
	static int movePrime(int a, int b){
		if(b > 52) return a;
		int s = 0;
		int min = 100;
		for(int i = 0; i < 3; i++){
			if(o.get(i) > a && o.get(i) <= b){
				s = o.get(i);
				if(s < min) min = s;
			}
		}
		for(int i = 1; i < p.size(); i++){
			if(p.get(i) > a && p.get(i) <= b){
				s = p.get(i);
				if(s < min) min = s;
			}
		}
		if(min != 100 && (min-1) <= 52) return min-1;
		
		else return b;
	}
	static int moveSquare(int a, int b){
		if(b>52) return a;
		int s = 0;
		int max = 0;
		
		for(int i = 0; i < 3; i++){
			if(o.get(i) < a && o.get(i) > b){
				s = o.get(i);
				if(s > max) max = s;
			}
		}
		for(int i = 1; i < p.size(); i++){
			if(p.get(i) < a && p.get(i) > b){
				s = p.get(i);
				if(s>max) max = s;
			}
		}
		if(max!=0 && (max+1) <= 52) return max+1;
		else return b;
	}
	static  int moveRule9(int a, int b, int c){
		for(int j = b; j >= a; j--){
			if(j%c == 0){//check
				//System.out.println(player+" "+oPlayer);
				if(!isOccupied(j)){
					b = j; //System.out.println("..."+newSpace); break;
					return b;
				}
			}
		}
		return a;
	}

}
