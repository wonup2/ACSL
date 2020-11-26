import java.util.*;
import java.io.*;

public class A1_Patience {

	static Scanner in;
	static String input[], pile[];
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("A1_Patience.in"));
		
		for(int i=0; i<10; i++) {
			try {
				init();
				solve();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
		}
	}
	static void init() {
		input = in.nextLine().split(" ");
		pile = new String[input.length];
		for(int i = 0; i<input.length; i++) {
			pile[i]="";
		}		
	}

	static void solve() {
		String newCard, inPile;
		for(int i=0; i<input.length; i++) {
			newCard = input[i]; 
			for(int j=0; j<pile.length; j++) {
				if(pile[j].equals("")) {
					pile[j] = newCard; break;
				}
				inPile = pile[j].substring(pile[j].length()-2);
				if(compare(newCard, inPile)) {
					pile[j] += newCard; break;
				}
			}
		}
		
		int max = pile[0].length();
		for(int i=1; i<pile.length; i++) {
			max = Math.max(max, pile[i].length());		
		}
		
		int minSum = 1000;		
		for(String s:pile) {
			if(s.length()!=max) continue;
			int sum = 0;
			for(int i=0; i<s.length(); i+=2) {
				sum += conv(s.charAt(i));
			}
			minSum = Math.min(minSum, sum); 
		}		
		
		System.out.println(minSum);
	}
	
	static boolean compare(String newCard, String inPile) {
		return (newCard.charAt(0)=='K' && inPile.charAt(0)=='A' 
				|| conv(newCard.charAt(0)) < conv(inPile.charAt(0)))
				&& newCard.charAt(1) != inPile.charAt(1) ;
	}
	
	static int conv(char c) {
		if(c=='A') return 1;
		else if(c=='T') return 10;		
    	else if(c=='J') return 11;
    	else if(c=='Q') return 12;
    	else if(c=='K') return 13;
    	else return c-'0';
	}
}
