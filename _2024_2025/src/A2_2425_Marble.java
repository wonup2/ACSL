import java.util.*;

public class A2_2425_Marble {

	static Scanner in;
	static int n, from, to, move;
	static ArrayList<Character>[] a;
	static Queue<Integer> q;
	static String ans;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		int t = 1;
		while(t-->0) {
			init();
			solve();
		}
	}

	static void init() {
		
		n = in.nextInt(); in.nextLine();
		a = new ArrayList[n+3];
		for(int i=0; i<n+3; i++) a[i] = new ArrayList<Character>();
		
		for(int i=1; i<=n; i++) {
			String temp = in.next();
		
			for(int j=0; j<n; j++) {
				a[i].add(temp.charAt(j));
			}
		}
		in.nextLine();
		//System.out.println(Arrays.toString(a));
		
		String temp[] = in.nextLine().split(" ");
		
		q = new LinkedList<Integer>();
		for(int i=0; i<temp.length; i++) {
			int f = temp[i].charAt(0)-'0';
			int s = temp[i].charAt(1)-'0';
			q.add(f); q.add(s);
		}
		
		//System.out.println(q);
	}
	
	static void solve() {
		boolean won = true;
		
		while(!q.isEmpty()) {
			from = q.poll();
			to = q.poll();
			
			if(!isValid()) {
				//System.out.println(from+"->"+to+" "+ Arrays.toString(a));

				won = false;
				break;
			}
			
			for(int i=0; i<move; i++)
				a[to].add(0, a[from].remove(0));
			
			//System.out.println(move+" "+from+"->"+to+" "+ Arrays.toString(a));

		}		

		if(finalCheck()) won=true;
		else won = false;
		
		if(won) wonResult();
		else loseResult();
	}	
	
	static boolean finalCheck() {
		
		int isEmpty=0;
		int cnt = 0;

		for(int i=1; i<a.length; i++) {
			if(a[i].isEmpty()) {
				isEmpty++;
				continue;
			}
			
			cnt=0;
			char cur = a[i].get(0);
			for(int j=0; j<a[i].size(); j++)
				if(cur==a[i].get(j)) cnt++;
		}

		return isEmpty==2&&cnt==n;

		
	}
	static boolean isValid() {		
		
		if(a[from].isEmpty()) return false; 		
		//System.out.println(1);
		
		// If the destination tube is not empty, the marble(s) moved must match the color of the top marble at
		// the destination.
		if(!a[to].isEmpty() && a[from].get(0)!=a[to].get(0)) return false;   
		//System.out.println(2);

				
		//Move all of the marbles of the top color in the source tube that match the top color in the destination
		//tube, only if there is enough empty space for all of them
		move = 1;			
		char marble = a[from].get(0);  //System.out.println(marble);
		for(int i=1; i<a[from].size(); i++) {
			if(marble==a[from].get(i)) move++;
			else break; 
		}
		//System.out.println(3 +" "+move);

		
		//The destination tube may contain at most N marbles
		if(move+a[to].size()>n) return false;   
		//System.out.println(4);

		//Once a tube is full of N marbles of the same color, those marbles are not moved.
		if(a[from].size()==n) {			
			HashSet<Character> set = new HashSet<Character>();
			set.addAll(a[from]);
			if(set.size()==1) return false; 
		}
		//System.out.println(5);

		if(a[to].size()==n) {			
			HashSet<Character> set = new HashSet<Character>();
			set.addAll(a[to]);
			if(set.size()==1) return false; 
		}
			
		//System.out.println(6);

		return true;
	}
	
	static void wonResult() {
		
		ans = "";
		for(int i=1; i<n+3; i++) {
			if(a[i].size()==0) ans+="E";
			else ans+=a[i].get(0);
		}
		
		System.out.println("won " +ans);
		
	}
	
	static void loseResult() {
		
		 int count = 0;
	        
		 ans="";
		 for(int i = 1; i<n+3; i++) {
	        if(a[i].size()==0) continue;

	        if(a[i].size()<n) {
	        	ans+=i;
	        	continue;
	        }
	        
	        char temp = a[i].get(0);
	        
	        count=0;
	        for(char c:a[i]) if(c==temp) count += 1;	        
	        
	        if(count!=n) ans+=i; 
	        
		 }
		 
		 System.out.println("lose "+ans);
	}
}
