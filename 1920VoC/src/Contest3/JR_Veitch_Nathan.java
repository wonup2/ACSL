package Contest3;
/*
Name: Nathan Kang
Grade: 8
2019-2020 ACSL Contest 3 Junior 5 Division
Team : Voice of Calling
*/

import java.util.*;
import java.io.*;
public class JR_Veitch_Nathan {
    static BufferedReader br;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(new File("1920C3Jr.in")));
        for(int i = 0; i < 5; i++) {
        	try {
        		init();
        		solve();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        br.close();
    }
    private static void init() throws IOException {
    	grid = new int[2][4];
    	String num = Integer.toString(Integer.parseInt(br.readLine(), 16), 2);
    	int index = num.length() - 1;
    	for(int i = 1; i >= 0; i--) {
    		for(int j = 3; j >= 0; j--) {
    			if(index < 0)
    				break;
    			grid[i][j] = Integer.parseInt(num.substring(index, index + 1));
    			--index;
    		}
    	}
    }
    private static void solve() {
    	ArrayList<String> terms = new ArrayList<String>();
    	if(grid[0][0] == 1 && grid[0][1] == 1 && grid[0][2] == 1 && grid[0][3] == 1) {
    		terms.add("B"); grid[0][0] = 0; grid[0][1] = 0; grid[0][2] = 0; grid[0][3] = 0;
    	}
    	if(grid[1][0] == 1 && grid[1][1] == 1 && grid[1][2] == 1 && grid[1][3] == 1) {
    		terms.add("~B"); grid[1][0] = 0; grid[1][1] = 0; grid[1][2] = 0; grid[1][3] = 0;
    	}
    	if(grid[0][0] == 1 && grid[0][1] == 1 && grid[1][0] == 1 && grid[1][1] == 1) {
    		terms.add("A"); grid[0][0] = 0; grid[0][1] = 0; grid[1][0] = 0; grid[1][1] = 0;
    	}
    	if(grid[0][1] == 1 && grid[0][2] == 1 && grid[1][1] == 1 && grid[1][2] == 1) {
    		terms.add("C"); grid[0][1] = 0; grid[0][2] = 0; grid[1][1] = 0; grid[1][2] = 0;
    	}
    	if(grid[0][2] == 1 && grid[0][3] == 1 && grid[1][2] == 1 && grid[1][3] == 1) {
    		terms.add("~A"); grid[0][2] = 0; grid[0][3] = 0; grid[1][2] = 0; grid[1][3] = 0;
    	}
    	if(grid[0][0] == 1 && grid[1][0] == 1 && grid[0][3] == 1 && grid[1][3] == 1) {
    		terms.add("~C"); grid[0][0] = 0; grid[1][0] = 0; grid[0][3] = 0; grid[1][3] = 0;
    	}
    	if(grid[0][0] == 1 && grid[0][1] == 1) {
    		terms.add("AB"); grid[0][0] = 0; grid[0][1] = 0;
    	}
    	if(grid[0][1] == 1 && grid[0][2] == 1) {
    		terms.add("BC"); grid[0][1] = 0; grid[0][2] = 0;
    	}
    	if(grid[0][2] == 1 && grid[0][3] == 1) {
    		terms.add("~AB"); grid[0][2] = 0; grid[0][3] = 0;
    	}
    	if(grid[1][0] == 1 && grid[1][1] == 1) {
    		terms.add("A~B"); grid[1][0] = 0; grid[1][1] = 0;
    	}
    	if(grid[1][1] == 1 && grid[1][2] == 1) {
    		terms.add("~BC"); grid[1][1] = 0; grid[1][2] = 0;
    	}
    	if(grid[1][2] == 1 && grid[1][3] == 1) {
    		terms.add("~A~B"); grid[1][2] = 0; grid[1][3] = 0;
    	}
    	if(grid[0][0] == 1 && grid[1][0] == 1) {
    		terms.add("A~C"); grid[0][0] = 0; grid[1][0] = 0;
    	}
    	if(grid[0][1] == 1 && grid[1][1] == 1) {
    		terms.add("AC"); grid[0][1] = 0; grid[1][1] = 0;
    	}
    	if(grid[0][2] == 1 && grid[1][2] == 1) {
    		terms.add("~AC"); grid[0][2] = 0; grid[1][2] = 0;
    	}
    	if(grid[0][3] == 1 && grid[1][3] == 1) {
    		terms.add("~A~C"); grid[0][3] = 0; grid[1][3] = 0;
    	}
    	if(grid[0][0] == 1 && grid[0][3] == 1) {
    		terms.add("B~C"); grid[0][0] = 0; grid[0][3] = 0;
    	}
    	if(grid[1][0] == 1 && grid[1][3] == 1) {
    		terms.add("~B~C"); grid[1][0] = 0; grid[1][3] = 0;
    	}
    	if(grid[0][0] == 1)
    		terms.add("AB~C");
    	if(grid[1][0] == 1)
    		terms.add("A~B~C");
    	if(grid[0][1] == 1)
    		terms.add("ABC");
    	if(grid[1][1] == 1)
    		terms.add("A~BC");
    	if(grid[0][2] == 1)
    		terms.add("~ABC");
    	if(grid[1][2] == 1)
    		terms.add("~A~BC");
    	if(grid[0][3] == 1)
    		terms.add("~AB~C");
    	if(grid[1][3] == 1)
    		terms.add("~A~B~C");
    	if(terms.size() > 0)
    		System.out.print(terms.get(0));
    	for(int i = 1; i < terms.size(); i++)
    		System.out.print(" + " + terms.get(i));
    	System.out.println();
    }
}