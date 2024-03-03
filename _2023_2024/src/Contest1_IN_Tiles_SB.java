import java.util.*;

public class Contest1_IN_Tiles_SB {
	
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
		
		// data organize and create variables		
		String tile[] = tiles.split(" ");
		
		
		for(String cur:tile) {
			
			//double == true
			//	placed ---> double is still true? or false?
			//	no placed ---> cur goes to discard
			
			
			//double == false
			//	placed ---> restore cur --> double or not double? --> break
			//	no placed ---> cur goes to discard
			
		}

		
		// sum of discard
		int ans=0;
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