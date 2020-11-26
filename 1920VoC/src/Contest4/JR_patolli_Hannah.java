package Contest4;
/*
Hannah Moon
Grade 9
Voice of Calling Junior 5
*/

import java.io.*;
import java.util.*;

public class JR_patolli_Hannah {

	
	static Scanner in;
	static int op1;
	static int op2;
	static int op3;
	static int player;
	static int rolls;

	public static void main(String[] args) throws FileNotFoundException {

		in = new Scanner (new File ("1920c4jr.in"));
		for (int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		in.close();

	}
	
	static void init () throws IOException {
		
		op1 = in.nextInt();
		op2 = in.nextInt();
		op3 = in.nextInt();
		player = in.nextInt();
		rolls = in.nextInt();
	}
	
	static void solve () {
		
		for(int i = 0; i < rolls; i++){
			int temp = in.nextInt();
			if(player + temp <= 52){
				if(player + temp != op1 && player + temp != op2 && player + temp != op3) {
					player += temp;
					if(isPrime(player)){
						int temp1 = op1 - player;
						int temp2 = op2 - player;
						int temp3 = op3 - player;
						ArrayList<Integer> list = new ArrayList<Integer>();
						if(temp1 > 0) {
							list.add(temp1);
						}
						if(temp2 > 0) {
							list.add(temp2);
						}	
						if(temp3 > 0) {
							list.add(temp3);
						}
						int min = 999999999;
						for(int j = 0; j < list.size(); j++){
							min = Math.min(min, list.get(j));
						}
						if(min > 6) {
							player += 6;
						}
						else {
							player += (min - 1);
						}
				}
				else if(player > 4 && isSquare(player)){
					int temp1 = player - op1;
					int temp2 = player - op2;
					int temp3 = player - op3;
					ArrayList<Integer> list = new ArrayList<Integer>();
					if(temp1 > 0) {
						list.add(temp1);
					}
					if(temp2 > 0) {
						list.add(temp2);
					}	
					if(temp3 > 0) {
						list.add(temp3);
					}
					int min = 999999999;
					for(int j = 0; j < list.size(); j++){
						min = Math.min(min, list.get(j));
					}
					if(min > 6)
						player -= 6;
					else {
						player -= (min-1);
					}
						
				}
				
				else {
					int check = player ;
					if(player - temp < 7 && player > 7 || player - temp < 12 && player > 12 || player - temp < 17 && player > 17 || player - temp < 22 && player > 22 || player - temp < 27 && player > 27 || player - temp < 35 && player > 35 || player - temp < 40 && player > 40 || player - temp < 45 && player > 45 || player - temp < 50 && player > 50){
						player -= temp;
						for(int j = player + 1; j <= player + temp; j++){
							if(j%temp == 0 && j != op1 && j != op2 && j != op3){
								player = j;
								break;
							}
							
						}
					}
					
				}		
				}
				
			}
			else continue;
		}
		if(player == 52) {
			System.out.println("GAME OVER");
		}
		else {
			System.out.println(player);
		}
	}
		
	public static boolean isPrime(int num){
		
		for(int i = 2; i <= num/2; i++) {
	       double temp = num % i;
		   if(temp == 0){
		      return false;
		   }
		}
		return true;
		
	}
	
	public static boolean isSquare(double x){ 
		double sq = Math.sqrt(x); 
		return ((sq - Math.floor(sq)) == 0); 
    } 

}
