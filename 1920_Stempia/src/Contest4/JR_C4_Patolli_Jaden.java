package Contest4;
/*
Name: Jaden Chung
Grade: 9
Team: Stempia
Division: Junior5
Date: 4/5/2020
*/

import java.util.*;
import java.io.*;

public class JR_C4_Patolli_Jaden {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1920c4jr.in"));
		
		for(int q = 0; q < 5; q++) {
			
			int[] opps = new int[3];
			opps[0] = in.nextInt();
			opps[1] = in.nextInt();
			opps[2] = in.nextInt();
			
			int player = in.nextInt();
			
			int r = in.nextInt();
			int[] dice = new int[r];
			for(int i = 0; i < r; i++) {
				dice[i] = in.nextInt();
			}
			
			int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
			int[] perfectsq = {9, 16, 25, 36, 49};
			int[] htov = {7, 12, 17, 22, 27, 35, 40, 45, 50};
			
			String[] board = new String[100];
			for(int i = 0; i < 100; i++) {
				board[i] = "";
			}
			board[opps[0]] = "#";
			board[opps[1]] = "#";
			board[opps[2]] = "#";
			boolean gameover = false;
			int ans = 0;
			for(int i = 0; i < dice.length; i++) {
				int currroll = dice[i];
				
				int currland = player+currroll;
				//System.out.println("1 "+ currland);
				if(board[currland].equals("#")) continue;
				if(currland>=52) {
					gameover=true;
					break;
				}
				boolean primed = false;
				boolean containsPrime = false;
				for(int j = 0; j < primes.length; j++) {
					if(currland==primes[j]){
						primed=true;
						for(int k = currland; k <= Math.min(52, currland+6); k++) {
							if(board[k].equals("#")) {
								currland=k-1;
								containsPrime = true;
								break;
							}
						}
						
					}
					if(primed) break;
				}
				//System.out.println("2 "+ currland);
				if(primed == true && !containsPrime)
					currland=currland+6;
				
				boolean squared = false;
				boolean containsSquare = false;
				if(primed==false) {
					for(int j = 0; j < perfectsq.length; j++) {
						if(currland==perfectsq[j]) {
							squared=true;
							for(int k = currland-6; k <= currland; k++) {
								if(board[k].equals("#")) {
									currland=k+1;
									containsSquare = true;
									break;
								}
							}
							
						}
						if(squared) break;
					}
				}
				//System.out.println("3 "+ currland);
				if(squared==true && !containsSquare) {
					currland = currland-6;
				}
				boolean changed = false;
				if(!primed && !squared) {
					for(int j = 0; j < htov.length; j++) {
						if(player<htov[j]&&currland>htov[j]) {
							int[] multiples = new int[53];
							int c = 0;
							for(int k = currroll; k<=52; k+=currroll) {
								multiples[c] = k;
								c++;
							}
							for(int k = 0; k < multiples.length; k++) {
								if(multiples[k]<=player||multiples[k]>currland) continue;
								if(board[multiples[k]].equals("#")) continue;
								currland = multiples[k];
								changed = true;
								break;
							}
							if(changed==false) {
								currland=player;
							}
						}
					}
					
				}
				//System.out.println("4 "+ currland);
				player=currland; 
			}
			
			if(gameover) {
				System.out.println("GAME OVER");
			}
			else
				System.out.println(player);
			//System.out.println("------------");
		}
		
	}

}
/*
4 6 8 1 5 6 3 5 1 1
10 24 32 8 4 4 4 3 5
10 22 32 8 7 4 4 3 5 5 5 6
17 20 27 16 7 3 5 4 6 5 1 4
43 46 50 40 5 3 1 2 4 4
*/


