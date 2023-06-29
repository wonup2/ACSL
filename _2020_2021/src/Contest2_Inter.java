import java.util.*;
public class Contest2_Inter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		String ans = rearrangeString(s, n);
		
		System.out.println(ans);
		
	}
	
	static int k;
	static char key;
	static ArrayList<pair> a;
	
	public static void makeString(String s) {
		k = 0;
		key = s.charAt(0);
		a = new ArrayList<pair>();
		
		for(int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if(key==cur) k++;
			else {
				a.add(new pair(k, key));
				key = cur;
				k = 1;
			}			
		}
		a.add(new pair(k, key));
		
	}
	
	public static String rearrangeString(String s, int n) {
		
		makeString(s); 			System.out.println(1+" "+a);
		Collections.sort(a);	System.out.println(2+" "+a);
		
		while(true) {
			boolean flag = true;			
			s = "";
			for(pair p:a) {
				int x = p.n > n? n:p.n;
				char y = p.c;				
				for(int i=0; i<x; i++)	s+=y;
			}
			System.out.println(s);
			makeString(s); System.out.println(3+" "+a);
			
			for(pair p:a) if(p.n>n) flag=false;			
						
			if(flag)break;
		}
				
		return s;
	}
	
	static class pair implements Comparable<pair>{
		int n;
		char c;
		
		pair(int a, char b){
			n = a;
			c = b;
		}
		
		public String toString() {
			return n+" "+c;
		}
		@Override
		public int compareTo(Contest2_Inter.pair o) {
			if(o.n==this.n) return this.c- o.c;
			return o.n-this.n;
		}
		
	}
}


//MBAMMDXXMMMGGMMZ 3
//MMMGGMMMXXABDMZ
//MMMGGMMMXXABDMZ
//MMMGGMMMXXABDMZ
//EENNSSEEHLNORSTTUV
//EENNSSEEHLNORSTTUV
//EENNSSEEHLNORSTTUV
//MHHHHJLDDHHDDD 3 
//HHHDDDHHJLM
//HHHDDDHHJLM

//EEEEOOORRBKP
//EEEEOOORRBKP

//THETENNESSEEVOLUNTEERS 2

