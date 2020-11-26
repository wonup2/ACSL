package Contest3;
/*
Name:  Solomon Baik	
Grade:  10
Team:  Stempia
Division:  Intermediate 5
Contest 3
*/
import java.util.*;
import java.io.*;
public class IN_Veitch_Solomon {
	
	static Scanner in;
	static boolean[][] grid, mastergrid;
	static int[][] ansgrid;
	static String input, ans;
	static ArrayList<String> list;
	static String[] test;
	
	public static void main(String[] args)throws IOException{
		in = new Scanner(new File("1920c3in.in"));
		
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
				in.nextLine();
			}
		}
	}
	
	static void init() {
		input = in.nextLine();
		list  = new ArrayList<String>();
		grid = new boolean[4][4];
		/* for(boolean[] array: grid) {
			for(boolean place: array)
				place = false;
		}
		*/
		test = input.split("\\+");
		for(int i = 0; i < test.length; i++) {
			list.add(test[i]);
		}
	}
	
	static void solve() {
		ans = "";
		mastergrid = new boolean[4][4];
		ansgrid = new int[4][4];
		for(String s: list) {
			if(s.contains("~A")) {//--- ~A
				s = s.substring(2);
				for(int i = 0; i < 4; i++) {
					for(int j = 2; j < 4; j++) {
						grid[i][j] = true;
					}
				}
				if(s.contains("~B")) {
					s = s.substring(2);
					for(int i = 0; i < 2; i++) {
						for(int j = 2; j < 4; j++) {
							grid[i][j] = false;
						}
					}
				}else if(s.contains("B")) {
					s = s.substring(1);
					for(int i = 2; i < 4; i++) {
						for(int j = 2; j < 4; j++) {
							grid[i][j] = false;
						}
					}
				}
				if(s.contains("~C")) {
					s = s.substring(2);
					for(int i = 0; i < 4; i++) {
						grid[i][2] = false;
					}
				}else if(s.contains("C")) {
					s = s.substring(1);
					for(int i = 0; i < 4; i++) {
						grid[i][3] = false;
					}
				}
				if(s.contains("~D")) {
					s = s.substring(2);
					for(int i = 1; i < 3; i++) {
						for(int j = 2; j < 4; j++) {
							grid[i][j] = false;
						}
					}
				}else if(s.contains("D")) {
					s = s.substring(1);
					for(int i = 0; i < 4; i += 3) {
						for(int j = 2; j < 4; j++) {
							grid[i][j] = false;
						}
					}
				}
			}else if(s.contains("A")) { //--- A
				s = s.substring(1);
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 2; j++) {
						grid[i][j] = true;
					}
				}
				if(s.contains("~B")) {
					s = s.substring(2);
					for(int i = 0; i < 2; i++) {
						for(int j = 0; j < 2; j++) {
							grid[i][j] = false;
						}
					}
				}else if(s.contains("B")) {
					s = s.substring(1);
					for(int i = 2; i < 4; i++) {
						for(int j = 0; j < 2; j++) {
							grid[i][j] = false;
						}
					}
				}
				if(s.contains("~C")) {
					s = s.substring(2);
					for(int i = 0; i < 4; i++) {
						grid[i][1] = false;
					}
				}else if(s.contains("C")) {
					s = s.substring(1);
					for(int i = 0; i < 4; i++) {
						grid[i][0] = false;
					}
				}
				if(s.contains("~D")) {
					s = s.substring(2);
					for(int i = 1; i < 3; i++) {
						for(int j = 0; j < 2; j++) {
							grid[i][j] = false;
						}
					}
				}else if(s.contains("D")) {
					s = s.substring(1);
					for(int j = 0; j < 2; j++) {
						grid[0][j] = false;
						grid[3][j] = false;
					}
				}
			}
			if(s.contains("~B")) { //--- ~B
				s = s.substring(2);
				for(int i = 2; i < 4; i++) {
					for(int j = 0; j < 4; j++) {
						grid[i][j] = true;
					}
				}
				if(s.contains("~C")) {
					s = s.substring(2);
					for(int i = 2; i < 4; i++) {
						for(int j = 1; j < 3; j++) {
							grid[i][j] = false;
						}
					}
				}else if(s.contains("C")) {
					s = s.substring(1);
					for(int i = 2; i < 4; i++) {
						for(int j = 0; j < 4; j += 3) {
							grid[i][j] = false;
						}
					}
				}
				if(s.contains("~D")) {
					s = s.substring(2);
					for(int j = 0; j < 4; j++) {
						grid[2][j] = false;
					}
				}else if(s.contains("D")) {
					s = s.substring(1);
					for(int j = 0; j < 4; j++) {
						grid[3][j] = false;
					}
				}
			}else if(s.contains("B")) {
				s = s.substring(1);
				for(int i = 0; i < 2; i++) {
					for(int j = 0; j < 4; j++) {
						grid[i][j] = true;
					}
				}
				if(s.contains("~C")) {
					s = s.substring(2);
					for(int i = 0; i < 2; i++){
						for(int j = 1; j < 3; j++){
							grid[i][j] = false;
						}
					}
				}else if(s.contains("C")) {
					s = s.substring(1);
					for(int j = 0; j < 4; j += 3) {
						grid[0][j] = false; grid[3][j] = false;
						grid[1][j] = false; grid[3][j] = false;
					}
				}
				if(s.contains("~D")) {
					s = s.substring(2);
					for(int j = 0; j < 4; j++) {
						grid[1][j] = false;
					}
				}else if(s.contains("D")) {
					s = s.substring(1);
					for(int j = 0; j < 4; j++) {
						grid[0][j] = false;
					}
				}
			}
			if(s.contains("~C")) {
				s = s.substring(2);
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < 4; j+= 3) {
						grid[i][j] = true;
					}
				}
				if(s.contains("~D")) {
					s = s.substring(2);
					for(int i = 1; i < 3; i++) {
						grid[i][0] = false;
						grid[i][3] = false;
					}
				}else if(s.contains("D")) {
					s = s.substring(1);
					grid[0][0] = false; grid[0][3] = false;
					grid[3][0] = false; grid[3][3] = false;
				}
			}else if(s.contains("C")) {
				s = s.substring(1);
				for(int i = 0; i < 4; i++) {
					for(int j = 1; j < 3; j++) {
						grid[i][j] = true;
					}
				}
				if(s.contains("~D")) {
					s = s.substring(2);
					for(int i = 1; i < 3; i++) {
						for(int j = 1; j < 3; j++) {
							grid[i][j] = false;
						}
					}
				}else if(s.contains("D")) {
					s = s.substring(1);
					for(int i = 0; i < 4; i += 3) {
						for(int j = 1; j < 3; j++) {
							grid[i][j] = false;
						}
					}
				}
			}
			if(s.contains("~D")) {
				s = s.substring(2);
				for(int j = 0; j < 4; j++) {
					grid[0][j] = true;
					grid[3][j] = true;
				}
			}else if(s.contains("D")) {
				s = s.substring(1);
				for(int i = 1; i < 3; i++) {
					for(int j = 0; j < 4; j++) {
						grid[i][j] = true;
					}
				}
			}
			for(int i = 0; i < 4; i++) { //transfers to mastergrid
				for(int j = 0; j < 4; j++) {
					if(grid[i][j] == true) {
						mastergrid[i][j] = true;
					}
				}
			}
		}
		 for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(mastergrid[i][j]) {
					ansgrid[i][j] = 1;
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			String binaryStr = "";
			for(int j = 0; j < 4; j++) {
				binaryStr += ansgrid[i][j];
			}
			int decimal = Integer.parseInt(binaryStr,2);
			String hexStr = Integer.toString(decimal,16);
			ans += hexStr;
		}
		
		
		System.out.println(ans.toUpperCase());
	}

}
