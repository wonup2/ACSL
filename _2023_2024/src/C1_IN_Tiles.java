import java.util.*;

public class C1_IN_Tiles {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = 5;
		while(n-->0) {
		int s = in.nextInt(); in.nextLine();
		String a = in.nextLine();
		
		int result = solve(s, a);
		System.out.println(result);		
		}
	}
	
	static int solve(int originalRows, String tiles) {
		
		char r[] = (originalRows+"").toCharArray();
		String t[] = tiles.split(" ");
		String discard = "";
		
		boolean twins = false;
		int idx = 0;
		boolean placed = false;

		for(String cur:t) {
			
			placed = false;
			char f = cur.charAt(0);
			char s = cur.charAt(1);
			
			if(twins) {
				
				if(r[idx]==f)r[idx]=s;				
				else if(r[idx]==s) r[idx]=f;
				else discard+=cur;

				if (f!=s) twins=false;
				continue;
			}
			
			
			for(int i=0; i<4; i++) {
				
				if(idx == 4) idx=0;

				if(r[idx]==f) {
					r[idx]=s;
					placed = true;
				}
				else if(r[idx]==s) {
					r[idx]=f;
					placed = true;
				}
				
				if(placed) {
					if(f==s) twins = true;
					else { 
						twins = false;
						idx++;
					}
					break;
				}				

				idx++;
			}
			
			if(!placed) discard += cur;
			
			System.out.println(discard);
		}

		
		int ans=0;
		for(int i=0; i<discard.length(); i++) ans += discard.charAt(i)-'0';

		return ans;
	}
}

/*
5923
56 27 73 34 99 45 32 19 64 57 18
4687
81 72 15 89 36 21 13 67 42 93 48 83 45 47 52 94 62
1932
94 81 13 43 21 31 89 69 18 28 86 88 29 89 92
1957
32 69 87 73 31 88 62
1542
24 44 39 32 92 63 47 76 37 78 38

1. 21
2. 86
3. 11
4. 23
5. 46



*/