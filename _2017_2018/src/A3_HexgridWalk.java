
import java.util.*;
import java.io.*;

public class A3_HexgridWalk {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1718A3.in"));	
		
		for(int x = 0; x < 10; x++) {			
			
			String input = in.next();
			
			char letter = input.charAt(0);
			int number = Integer.parseInt(input.substring(1));
			
			int[][] p1 = {{0,1},{1,1},{1,0},{0,-1},{-1,0},{-1,1}};    //odd letter: A C E G ...
			int[][] p2 = {{0,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};  //even letter: B D F H ...		
			
			char[] move = in.next().toCharArray();			
			
			for(int i = 0; i < move.length; i++) {		
				int num = move[i]-'0'-1;
				int cm=0;
				int nm=0;
				
				if(letter%2==1) {
					cm=p1[num][0];
					nm=p1[num][1];
				}					
				else {
					cm= p2[num][0];
					nm= p2[num][1];
				}		
				
				letter += cm;
				number += nm;
				
				if(letter < 'A' || letter > 'Z' || number <= 0) {					
					letter -= cm;
					number -= nm;
				}								
			}
			
			System.out.println(letter + "" + number);			
		}
	}
}