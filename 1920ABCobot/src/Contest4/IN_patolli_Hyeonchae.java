package Contest4;
/*
name: Hyeonchae Kim
grade: 10th
team: ABCobot
division: Intermediate 3
Contest 2
*/

import java.util.*;
import java.io.*;

public class IN_patolli_Hyeonchae {
	
	static Scanner in;
	static ArrayList<Integer> opponent, player, die;
	static int N;
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new File("1920c4in.in"));
		
		for(int i = 0; i < 5; i++) {
			
			try {
				
				init();
				System.out.println(solve());
			
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static void init(){
		
		//opponent
	    opponent = new ArrayList<Integer>();
	    for(int i = 0; i < 3; i++)
	    	opponent.add(in.nextInt());
	    Collections.sort(opponent);
	    
	    //player
	    player = new ArrayList<Integer>();
	    for(int i = 0; i < 3; i++)
	    	player.add(in.nextInt());
	    Collections.sort(player);
	    
	    //dice
	    die = new ArrayList<Integer>();
	    N = in.nextInt();
	    for(int i = 0; i < N; i++)
	    	die.add(in.nextInt());
	                             
	}
	
	public static String solve() {
	    
		for(int die:die) {
			
			Collections.sort(player);                        
			int move = player.get(0) + die;                    
	      
			if(move == 52){ 
				player.remove(0);
				continue;
			}
			if(move > 52 || isOccupied(move))
				continue;
			
			if(isPrime(move))
				player.set(0, movePrime(move));         
			else if(isSquare(move))
				player.set(0, moveSquare(move));
			else if(isRule9(player.get(0), move))
				player.set(0, moveRule9(player.get(0), move, die));
			else 
				player.set(0, move); 
			
	    }
	        
	    Collections.sort(player);
	    if(player.size() > 0) {
	    	
	    	String ans = "";
	    	for(int i = 0; i < player.size(); i++)
	    		ans += player.get(i) + " ";
	    	return ans;
	    	
	    }else {
	    
	    	return "GAME OVER";
	    
	    }
	
	}
	
	//occupied
	public static boolean isOccupied(int move) {
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(0, player);
		temp.addAll(0, opponent);
		Collections.sort(temp);
		
		if(temp.contains(move))
			return true;
		else
			return false;
		
	}
	
	//prime
	public static boolean isPrime(int move) {
		
		for(int i = 2; i < move; i++) {
			
			if(move % i == 0)
				return false;
			
		}
		
		return true;
		
	}
	
	public static Integer movePrime(int move) {
			
		for(int i = 0; i < 6; i++) {
			
			if(isOccupied(move+1))
				break;
			move++;			
		
		}

		return move;		
	}
	
	//squares
	public static boolean isSquare(int move) {
		
		if(move==4) return false;
        
        if(Math.sqrt(move) == (int)(Math.sqrt(move)))
        	return true;
        else
        	return false;
        
	}
	
	public static  Integer moveSquare(int move) {
		
		for(int i = 6; i > 0; i--) {
			
			if(isOccupied(move-1))
				break;
			move--;
			
		}
		
		return move;
		
	}
	
	//rule 9
	public static boolean isRule9(int start, int end) {
		
		if(start < 7 && end > 7)
			return true;
		else if(start < 12 && end > 12)
			return true;
		else if(start < 17 && end > 17)
			return true;
		else if(start < 22 && end > 22)
			return true;
		else if(start < 27 && end > 27)
			return true;
		else if(start < 35 && end > 35)
			return true;
		else if(start < 40 && end > 40)
			return true;
		else if(start < 45 && end > 45)
			return true;
		else if(start < 50 && end > 50)
			return true;
		else
			return false;
		
	}
	
	public static Integer moveRule9(int start, int end, int die) {
		
		
		for(int i = end; i >= start; i--) {
			
			if(i % die == 0){
            
				if(isOccupied(i))
					return start;
				else
					return i;
            
			}
			
		}
		return start;
		
	}

}
