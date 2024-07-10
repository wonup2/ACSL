import java.util.*;
import java.io.*;

public class C1JR_Poker {
	
	public static void main(String[] args)  {
		
		Scanner in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			
			//input
			int cards[] = new int[5];
			for(int j = 0; j<5; j++) cards[j] = in.nextInt()%13;
									
			//processing
			int num[] = new int[14];
			for(int j = 0; j<5; j++) num[cards[j]]++;
			
			boolean two = false, three = false, four = false;
			for(int j = 0; j<14; j++) {
				if(num[j]==2) two = true;
				else if(num[j]==3) three = true;
				else if(num[j]==4) four = true;
			}
			
			//output	
			String ans = "NONE";
			if(two && three) ans = "FULL HOUSE";
			else if(two) ans = "PAIR";
			else if(three) ans = "THREE OF A KIND";
			else if(four) ans = "FOUR OF A KIND";

			System.out.println(ans);					
		}	
	}	
}

/*
2 18 33 49 41
9 22 29 45 48
1 17 34 50 25
4 17 20 33 46
11 24 37 34 50

PAIR
THREE OF A KIND
NONE
FULL HOUSE
FOUR OF A KIND

*/