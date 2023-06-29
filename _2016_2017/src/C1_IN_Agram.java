import java.util.*;

public class C1_IN_Agram {

	static Scanner in;
	static pair cards[];	
	static int num;
	static char suit;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			init();
			solve();
		}
	}

	static void init() {
		
		String temp = in.next();
		
		num = conv(temp.charAt(0));
		suit = temp.charAt(1);
		
		//System.out.println(num+" "+suit);
		
		cards = new pair[5];
		for(int i=0; i<5; i++) {
			temp = in.next();
			int x = conv(temp.charAt(0));
			char y = temp.charAt(1);
			cards[i] = new pair(x, y);
		}
		
		Arrays.sort(cards);
		
		//System.out.println(Arrays.toString(cards));

	}
	
	static void solve() {
		
		ArrayList<pair> s = new ArrayList<pair>();
		
		for(pair p: cards) {
			
			if(p.suit==suit) s.add(p);
		}

		//System.out.println(s);
		
		
		pair ans=null;
		
		if(s.size()==0) ans = cards[0];
		
		else {
		
			for(pair p:s) {
				if(p.num>=num) {
					ans = p;
					break;
				}
			}
			
			if(ans==null) ans = s.get(0);
			
		}
		
		System.out.println(conv2(ans.num) + "" + ans.suit);
		
	}
	
	static int conv(char c) {
		
		if(c=='A') return 1;
		else if(c=='T') return 10;
		else if(c=='J') return 11;
		else if(c=='Q') return 12;
		else if(c=='K') return 13;
		else return c-'0';
	}
	
	static char conv2(int c) {
		
		if(c==1) return 'A';
		else if(c==10) return 'T';
		else if(c==11) return 'J';
		else if(c==12) return 'Q';
		else if(c==13) return 'K';
		else return (char)(c+'0');
	}
	
	static class pair implements Comparable<pair>{
		
		int num;
		char suit;
		
		pair(int n, char c){
			num = n;
			suit = c;
		}
		
		public String toString() {
			return num +" "+suit;
		}

		@Override
		public int compareTo(C1_IN_Agram.pair o) {

			if(this.num < o.num) return -1;
			return 1;
		}		
	}
}

/*
TC AC KC QH JS TD
5D 2D 6H 9D TD 6H
3D 4H 5C 6S 2D 7H
KS TH QC 7H 9H 3H
AC AD KH JS KS QS

*/
