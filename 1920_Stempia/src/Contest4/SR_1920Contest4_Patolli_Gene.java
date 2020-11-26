package Contest4;
/*
Gene Lee
12th Grade
Stempia
Senior 3 Contest 4
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class SR_1920Contest4_Patolli_Gene {
	
	static final int MAX=53;
	static TreeSet<Integer>opponent,player;
	static final String moves=" ddlllldrrrrdlllldrrrrddddruuuurrrrullllurrrrulllluu";//up,down,left,right
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new File("1920c4sr.in"));
		opponent=new TreeSet<Integer>();
		player=new TreeSet<Integer>();
		
		for(int test=0;test<5;test++) {
			//reset
			opponent.clear();
			player.clear();
			
			//input
			for(int i=0;i<3;i++)
				opponent.add(sc.nextInt());
			for(int i=0;i<3;i++)
				player.add(sc.nextInt());
			
			int rolls=sc.nextInt();
			boolean playerTurn=true;
			
			while(rolls-->0) {//logic
				playerTurn=!playerTurn;
				int roll=sc.nextInt();
				int start;
				int end;
				
				if(!playerTurn) {//opponent's turn
					start=opponent.first();
				}
				else {
					start=player.first();
				}
				end=roll+start;							
				
				//4
				if(occupied(end))
					continue;
				
				//6
				if(end>52) {
					save(end,playerTurn);
					continue;
				}
				
				//7
				if(isPrime(end)) {	
					for(int i=0;i<6;i++) {
						if(occupied(end+1))
							break;
						end++;
					}										
					save(end,playerTurn);
				}
				//8
				else if(isSquare(end)&&end>4) {
					for(int i=0;i<6;i++) {
						if(occupied(end-1)&&(end-1)!=start)
							break;
						end--;
					}										
					save(end,playerTurn);
				}
				//9
				else {
					if(h1v1(start,end)) {
						int result=-1;
						for(int i=end;i>=start;i--)
							if(i%roll==0&&!occupied(i)) {
								result=i;
								break;
							}								
						save(result,playerTurn);
					}										
					else save(end,playerTurn); 			
				}
			}
			
			//output
			int oppSum=0;
			for(int i:opponent)
				oppSum+=i;
			
			int plaSum=0;
			for(int i:player)
				plaSum+=i;
			
			System.out.println(oppSum+" "+plaSum);
		}
		
		//close
		sc.close();
	}
	
	static boolean h1v1(int start,int end) {
		boolean prevHorizontal=false;
		for(int i=start;i<end;i++) {//at least one vertical move after
			char move=moves.charAt(i);
			
			if(prevHorizontal&&(move=='u'||move=='d'))
				return true;
			
			prevHorizontal=move=='l'||move=='r';
		}
		
		return false;//if no vertical moves
	}
	
	static void save(int newVal,boolean playerTurn) {
		if(newVal<1||newVal>52)
			return;
		if(playerTurn) {
			player.pollFirst();
			if(newVal<52)
				player.add(newVal);
		}
		else {
			opponent.pollFirst();
			if(newVal<52)
				opponent.add(newVal);
		}
	}
	
	static boolean isSquare(int num) {
		for(int i=0;i<10;i++)
			if(i*i==num)
				return true;
		return false;
	}
	
	static boolean occupied(int location) {
		return player.contains(location)||opponent.contains(location);
	}
	
	static boolean isPrime(int n) {
		if(!notPrime[0])runSieve();
		return !notPrime[n];
	}
	
	static boolean[] notPrime=new boolean[MAX];
	public static void runSieve() {
		notPrime[0]=true;
		notPrime[1]=true;
		for(int i=2;i<=MAX/2;i++)
			if(!notPrime[i])
				for(int j=i*i;j<MAX;j+=i)
					notPrime[j]=true;
	}

}
