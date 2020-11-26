import java.util.*;
import java.io.*;
public class C3_Senior {
	static Scanner in;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("c3sr.in"));
		for(int i=0; i<24; i++) {
		    grid=toBin(in.nextLine()).toCharArray(); //FF33  --> 1111111100110011
			solve();
		}
	}

	static void solve(){
		String ans = "";
		for(int i=0; i<one.length; i++) {			
			boolean check = true; 
			for(int j=0; j<one[i].length; j++) 
				if(grid[one[i][j]]!='1')	check=false;
			
			if(check) {				
				ans+=alg1(one[i])+" + ";  //one[i] = {0,1,2,3,4,5,6,7}  B + 
				for(int j=0; j<one[i].length; j++) grid[one[i][j]]='0';		
			}
		}		
		System.out.println(ans.substring(0,ans.length()-2));
	}

	static String alg1(int[] t) {		
		String ans = "";
		for(int i=1; i<=8; i++) {
			boolean check = true;			
			for(int j=0; j<t.length; j++) 
				if(!cell[t[j]].contains(i+"")) check = false;				
			
			if(check) ans+=(i+"");
		}
		return alg2(ans);
	}
		
	static String alg2(String s) {
		String ret = "";
		for(int i=0; i<s.length(); i++)	ret+=letter[s.charAt(i)-'0'];
		return ret;
	}
	
	static String toBin(String s) {  
		String ret="";
		for(int i=0; i<4; i++) {
			int num = Integer.parseInt(s.charAt(i)+"", 16);
			String bin = Integer.toBinaryString(num);				
			bin = String.format("%4s", bin).replace(" ", "0");
			ret+=bin;			
		}
		return ret;
	}
	
	static char[] grid; 
	static int one[][] = {	
			{0,1,2,3,4,5,6,7}, {4,5,6,7,8,9,10,11}, {8,9,10,11,12,13,14,15}, {0,1,4,5,8,9,12,13}, 
			{1,2,5,6,9,10,13,14}, {2,3,6,7,10,11,14,15}, {0,1,2,3,12,13,14,15}, {0,3,4,7,8,11,12,15},
			{0,1,2,3}, {4,5,6,7}, {4,5,6,7}, {8,9,10,11}, {0,4,8,12}, {1,5,9,13}, {2,6,10,14}, {3,7,11,15},
			{0,1,4,5}, {1,2,5,6}, {2,3,6,7}, {4,5,8,9}, {5,6,9,10}, {6,7,10,11}, {8,9,12,13}, {9,10,13,14},
			{10,11,14,15}, {0,4,3,7}, {4,8,7,11}, {8,12,11,15}, {0,1,12,13}, {1,2,13,14}, {2,3,14,15}, {0,3,12,15},
			{0,1}, {1,2}, {2,3}, {4,5}, {5,6}, {6,7}, {8,9}, {9,10}, {10,11}, {12,13}, {13,14}, {14,15}, {0,4}, 
			{1,5}, {2,6}, {3,7}, {4,8}, {5,9}, {6,10}, {7,11}, {8,12}, {9,13}, {10,14}, {11,15}, {0,3}, {4,7}, 
			{8,11}, {12,15}, {0,12}, {1,13}, {2,14}, {3,15},{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11},{12},{13},{14},{15}
			};
       
	static String[] cell = {"1368","1358","2358","2368","1367","1357","2357","2367","1467","1457","2457","2467","1468","1458","2458","2468"};

	static String[] letter = { "0", "A", "~A", "B", "~B", "C", "~C", "D", "~D"};
}
