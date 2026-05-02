import java.io.*;
import java.util.*;

public class A2_2425_MarblesSortChecker {
	
	static Scanner in;
	static int n, from, to, move;
	static LinkedList<Character>[] a;
	static String ans;
	static Queue<Integer> q;
	
	static void init() {
		n = in.nextInt();
		a = new LinkedList[n+3];
		for(int i=1; i<n+3; i++) a[i] = new LinkedList<Character>();
		
		for(int i=1; i<=n; i++) {
			String temp = in.next();			
			for(int j=0; j<n; j++) a[i].add(temp.charAt(j));
		}
		
		in.nextLine();
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		q = new LinkedList<Integer>();
			
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			int f = temp.charAt(0)-'0';
			int s = temp.charAt(1)-'0';
			q.add(f);
			q.add(s);
		}		
	}
	
	static void solve() {
		
		boolean won = true;
		
		while(!q.isEmpty()) {
			
			from = q.poll();
			to = q.poll();
			
			if(!isValid()) break;
			
			for(int i=0; i<move; i++) 
				a[to].add(0, a[from].remove(0));
		}
		
		won = isWon();  //final check
		if(won) wonResult();
		else lossResult();
	}
	
	static boolean isWon() {
		
		HashSet<Character> s = new HashSet<Character>();
		
		for(int i=1; i<=n+2; i++) {
			if(a[i].isEmpty()) continue;
			numTopColor(a[i]);
			if(a[i].size()!=n || move!=n) return false;
		}
		return true;
	}
	
	static boolean isValid() {
						
		//if the source tube is empty
		if(a[from].isEmpty()) return false; 
		
		//If the destination tube is not empty, 
		//the marble(s) moved must match the color of the top marble at the destination.
		if(!a[to].isEmpty() && a[from].get(0)!=a[to].get(0)) return false; 
		
		//The destination tube may contain at most N marbles.
		if(a[to].size()==n) return false; 
		
		//Move all of the marbles of the top color in the source tube that match the top color in the 
		//destination tube, only if there is enough empty space for all of them.
		//Once a tube is full of N marbles of the same color, those marbles are not moved.
		numTopColor(a[from]);
		if(move + a[to].size() > n || move == n) return false; 
		return true;
	}
	
	static void numTopColor(LinkedList<Character> tube) {
		move = 0;
		char key = tube.get(0);
		for(char m:tube) {
			if(m!=key) break;
			move++;		
		}
	}
	
	static void wonResult() {
		for(int i = 1; i<=n+2; i++) {
			if(a[i].isEmpty()) System.out.print("E");
			else System.out.print(a[i].get(0));
		}
		System.out.println();
	}
	
	static void lossResult() {
		for(int i = 1; i<=n+2; i++) {
			if(a[i].isEmpty()) continue;
			
			numTopColor(a[i]);
			if(move==n) continue;
			
			System.out.print(i);
		}
		
		System.out.println();			
	}
	
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		int t = 10;
		while(t-->0) {
	        init();
	        solve();
		}
        in.close();
	}
}

/*

4 
PPOP BBGP GBBG OGOO 
25 26 36 35 36 13 23 12 42 13 46 42
6 
GOPOGT GOGPRR GTRBRG PRPOTB OBBTTB TBOPPR 
17 27 37 18 28 58 27 21 41 42 63 65 68 64 62 16 46 18 17 48 34 32 53 41 51 34 54 32 37
6 
GTBOGG OBRGOG TPBROT RPTRPP BGTPRR OTBPBO 
27 67 28 58 15 16 18 17 42 51 35 34 38 32 37 35 53 63 68 65 68 67 46 56 43 45 46 24 54 15 25 21 71 27 57
5 
RRPOG OPBOG OPROP RPGRB GBGBB 
26 36 27 37 43 47 54 52 54 25 26 42 43 45 14 34 17 16 12 51 36 37
5 
OPPPO RPOGO OBBBR GPBGB RGRRG 
16 36 27 57 21 26 25 26 42 52 57 52 15 45 16 31 41 37 23 43 12 42 35 21 74 62
5 
OBORP OOORR BPRGP BPRGB GBGGP
36 46 17 27 16 17 12 13 31 41 34 42 43 46 34 54 31 53 63 46 56 14 54
7 
OOGRRYY GGGOGGP GBBOORR YYBBTTT OPYRTTT PPRTOYB PPRYPBB
28 38 19 29 28 62 18 61 59 52 72 71 75 72 37 39 13 41 51 53 65 69 61 46 76 45 54 67
5 
PBROO BBORO BGRPG PRGBG RGOPP
26 36 17 47 16 14 21 52 53 51 57 25 45 21 32 42 35 37 32
5 
OOBOB GPBBP PPGBO GORPR RGGRR
26 46 17 47 54 56 45 42 45 24 34 12 17 12 31 61 26 36 24
6 
TROORG OGOBBR PBPPTP TPOORR BBBGGG TGTRPT
17 47 67 38 48 24 26 24 32 38 37 38 23 53 12 65 67 62 68

*/