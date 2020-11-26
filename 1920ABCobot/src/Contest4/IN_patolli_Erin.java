package Contest4;

import java.util.*;
import java.io.*;

public class IN_patolli_Erin {
	static Scanner in;
	static int n, revert;
	static ArrayList <Integer> o, p, d;
	
	public static void main(String [] args) throws IOException{
		in = new Scanner(new File("1920c4in.in"));
		
		for(int x = 0; x < 5; x++) {
			try {
				init();
				solve();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void init() throws IOException{
	    o = new ArrayList<Integer>();
	    p = new ArrayList<Integer>();
	    d = new ArrayList<Integer>();
	    
	    for(int i = 0; i < 3; i++) {
	    	o.add(in.nextInt());
	    }
	    for(int i = 0; i < 3; i++) {
	    	p.add(in.nextInt());
	    }
	    n = in.nextInt();
	    for(int i = 0; i < n; i++) {
	    	d.add(in.nextInt());
	    }  
	    Collections.sort(o);
	    Collections.sort(p);
	}
	
	public static void solve() {
	    for(int die : d) {
	      Collections.sort(p);
	      int move = p.get(0) + die;
	      //System.out.print(p+" "+p.get(0) + " + " + die + " = "+move);

	      if(move == 52) {
	    	  p.remove(p.get(0));
	    	  continue;
	      }
	      	      
	      revert = p.get(0);
	      if(move > 52 || isOccupied(move)) {
	    	  p.set(0, p.get(0));
	    	  continue;
	      } 
	      
	      if(isPrime(move)) {
	    	  p.set(0, movePrime(move, move + 6));
	      } else if(isSquare(move)) {
	    	  p.set(0, moveSquare(move, move - 6));
	      } else if(isRule9(p.get(0), move)) {
	    	  p.set(0, moveRule9(p.get(0), die));
	      } else {
	    	  p.set(0, move);
	      }
	      
	      for(int i = 1; i < p.size(); i++) {
	    	  if(p.get(0) == p.get(i)) {
	    		  p.set(0, revert);
	    		  break;
	    	  }
	      }
	    }
	    Collections.sort(p);
	    if(p.isEmpty()) {
	    	System.out.println("GAME OVER");
	    } else {
	    	for(int i = 0; i < p.size(); i++) {
	    		System.out.print(p.get(i) + " ");
	    	}
	    }
	    System.out.println();
	}
	
	public static boolean isOccupied(int a) {
		boolean chk = false;
		for(int o : o) {
			if(a == o) {
				chk = true;
			}
		}
		for(int p : p) {
			if(a == p) {
				chk = true;
			}
		}
		return chk;
	}
	
	public static boolean isPrime(int a) {
		boolean chk = true;
		if(a <= 1) {
			chk = false;
		}
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				chk = false;
			}
		}
		return chk;
	}
	
	public static int movePrime(int original, int sixPlus) {
		int block = 0;
		int temp1 = 0;
		for(int o : o) {
			if(o > original && o <= sixPlus) {
				temp1 = o;
				break;
			}
		}
		int temp2 = 0;
		for(int p : p) {
			if(p > original && p <= sixPlus) {
				temp2 = p;
				break;
			}
		}
		
		if(temp1 != 0 && temp2 != 0) {
			block = Math.min(temp1, temp2);
			block--;
		} else if(temp1 != 0) {
			block = temp1;
			block--;
		} else if(temp2 != 0){
			block = temp2;
			block--;
		} else {
			block = sixPlus;
		}
		return block;
	}
	
	public static boolean isSquare(int a) {
		boolean chk = false;
		if(a == 9 || a == 16 || a == 25 || a == 36 || a == 49) {
			chk = true;
		}
		return chk;
	}
	
	public static int moveSquare(int original, int sixMinus) {
		int block = 0;
		int temp1 = 0;
		for(int o : o) {
			if(o < original && o >= sixMinus) {
				temp1 = o;
			}
		}
		int temp2 = 0;
		for(int p : p) {
			if(p < original && p >= sixMinus) {
				temp2 = p;
			}
		}
		block = Math.max(temp1, temp2);
		block++;
		return block;
	}
	
	public static boolean isRule9(int before, int after) {
		boolean chk = true;
		if(after <= 7) {
		} else if(before >= 7 && before <= 12 && after >= 7 && after <= 12) {
			chk = false;
		} else if(before >= 12 && before <= 17 && after >= 12 && after <= 17) {
			chk = false;
		} else if(before >= 17 && before <= 22 && after >= 17 && after <= 22) {
			chk = false;
		} else if(before >= 22 && before <= 27 && after >= 22 && after <= 27) {
			chk = false;
		} else if(before >= 27 && before <= 35 && after >= 27 && after <= 35) {
			chk = false;
		} else if(before >= 35 && before <= 40 && after >= 35 && after <= 40) {
			chk = false;
		} else if(before >= 40 && before <= 45 && after >= 40 && after <= 45) {
			chk = false;
		} else if(before >= 45 && before <= 50 && after >= 45 && after <= 50) {
			chk = false;
		} else if(before >= 50) {
			chk = false;
		}
		return chk;
	}
	
	public static int moveRule9(int original, int die) {
		int add = die;
		while(die <= original) {
			die += add;
		}
		return die;
	}
}