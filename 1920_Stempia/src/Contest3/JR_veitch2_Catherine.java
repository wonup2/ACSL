package Contest3;
/*
Catherine 9th Grade
2019-2020 ACSL Contest 3 Junior Division
team name....
*/
import java.util.*;
import java.io.*;
public class JR_veitch2_Catherine {
	static int[][]grid;
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1920c3jr.in"));
		for(int x = 0; x < 5; x++) {
			String line = in.nextLine();
			grid = new int[2][4];
			boolean[][] visited = new boolean[2][4];
			int[] one = new int[4];
			int[] two = new int[4];
			int a = 0;
			if(line.substring(0,1).equals("A") || line.substring(0,1).equals("B")||line.substring(0,1).equals("C")||line.substring(0,1).equals("D")||line.substring(0,1).equals("E")||line.substring(0,1).equals("F")) {
				a = line.charAt(0) - 'A'+ 10;
			}else {
				a = Integer.parseInt(line.substring(0,1));
			}
			int b = 0;
			if(line.substring(1).equals("A") || line.substring(1).equals("B")||line.substring(1).equals("C")||line.substring(1).equals("D")||line.substring(1).equals("E")||line.substring(1).equals("F")) {
				b= line.charAt(1) - 'A'+10;
			}else {
				b = Integer.parseInt(line.substring(1));
			}	
			String c = Integer.toBinaryString(a);
			String d = Integer.toBinaryString(b);
			int y = c.length()-1;
			for(int i = 3; i >= 4 - c.length(); i--) {
				grid[0][i] = c.charAt(y)-48;
				y--;
			}
			y = d.length()-1;
			for(int i = 3; i >= 4 - d.length(); i--) {
				grid[1][i] = d.charAt(y)-48;
				y--;
			}
			ArrayList<String> list = new ArrayList<String>();
			if(priority1part1()) {
				list.add("B");
				for(int i = 0; i < 4; i++) {
					grid[0][i] = 0;
				}
			}
			if (priority1part2()){
				list.add("~B");
				for(int i = 0; i < 4; i++) {
					grid[1][i] = 0;
				}
			}
			if (priority1part3()) {
				list.add("A");
				grid[0][0] = 0;
				grid[0][1] = 0;
				grid[1][0] = 0;
				grid[1][1] = 0;
			}
			if (priority1part4()) {
				list.add("C");
				grid[0][1] = 0;
				grid[1][1] = 0;
				grid[0][2] = 0;
				grid[1][2] = 0;
			}
			if(priority1part5()) {
				list.add("~A");
				grid[0][2] = 0;
				grid[1][2] = 0;
				grid[0][3] = 0;
				grid[1][3] = 0;
			}
			//2nd priority
			if(priority2()) {
				list.add("~C");
				grid[0][0] = 0;
				grid[1][0] = 0;
				grid[0][3] = 0;
				grid[1][3] = 0;
			}
			
			//3rd priority
			if(grid[0][0] ==1 && grid[0][1] ==1) {
				list.add("AB");
				grid[0][0] = 0;
				grid[0][1] = 0;
			}
			if(grid[0][1] ==1 && grid[0][2] ==1) {
				list.add("BC");
				grid[0][2] = 0;
				grid[0][1] = 0;
			}
			if(grid[0][2] ==1 && grid[0][3] ==1) {
				list.add("~AB");
				grid[0][2] = 0;
				grid[0][3] = 0;
			}
			if(grid[1][0] ==1 && grid[1][1] ==1) {
				list.add("A~B");
				grid[1][0] = 0;
				grid[1][1] = 0;
			}
			if(grid[1][1] ==1 && grid[1][2] ==1) {
				list.add("~BC");
				grid[1][1] = 0;
				grid[1][2] = 0;
			}
			if(grid[1][2] ==1 && grid[1][3] ==1) {
				list.add("~A~B");
				grid[1][2] = 0;
				grid[1][3] = 0;
			}
			if(grid[0][0] ==1 && grid[1][0] ==1) {
				list.add("A~C");
				grid[0][0] = 0;
				grid[1][0] = 0;
			}
			if(grid[0][1] ==1 && grid[1][1] ==1) {
				list.add("AC");
				grid[0][1] = 0;
				grid[1][1] = 0;
			}
			if(grid[0][2] ==1 && grid[1][2] ==1) {
				list.add("~AC");
				grid[0][2] = 0;
				grid[1][2] = 0;
			}if(grid[0][3] ==1 && grid[1][3] ==1) {
				list.add("~A~C");
				grid[0][3] = 0;
				grid[1][3] = 0;
			}
			
			//4th priority
			if(grid[0][0] == 1&& grid[0][3] == 1) {
				list.add("B~C");
				grid[0][0] = 0;
				grid[0][3] = 0;
			}
			if(grid[1][0] == 1&& grid[1][3] == 1) {
				list.add("~B~C");
				grid[1][0] = 0;
				grid[1][3] = 0;
			}
			
			//5th priority
			if(grid[0][0] == 1){
				list.add("AB~C");
			}
			if(grid[0][1] == 1){
				list.add("ABC");
			}
			if(grid[0][2] == 1){
				list.add("~ABC");
			}
			if(grid[0][3] == 1){
				list.add("~AB~C");
			}
			if(grid[1][0] == 1){
				list.add("A~B~C");
			}
			if(grid[1][1] == 1){
				list.add("A~BC");
			}
			if(grid[1][2] == 1){
				list.add("~A~BC");
			}
			if(grid[1][3] == 1){
				list.add("~A~B~C");
			}
			String ans = "";
			for(int i = 0; i < list.size(); i++) {
				if(i !=0) {
					ans += " + " +list.get(i);
				}
				else {
					ans += list.get(i);
				}
			}
			System.out.println(ans);
		}
	}
	public static boolean priority3part1() {
		if(grid[0][0] ==0) {
			return false;
		}
		if(grid[0][1] ==0) {
			return false;
		}
		return true;
	}
	public static boolean priority2() {
		if(grid[0][0] ==0) {
			return false;
		}
		if(grid[1][0] ==0) {
			return false;
		}
		if(grid[0][3] ==0) {
			return false;
		}
		if(grid[1][3] ==0) {
			return false;
		}
		return true;
		
	}
	public static boolean priority1part1() {
		for(int i = 0; i < 4; i++) {
			if(grid[0][i] != 1) {
				return false;
			}
		}
		return true;
	}
	public static boolean priority1part2() {
		for(int i = 0; i < 4; i++) {
			if(grid[1][i] != 1) {
				return false;
			}
		}
		return true;
	}
	public static boolean priority1part3() {
		if(grid[0][0] != 1) {
			return false;
		}
		if(grid[0][1] != 1) {
			return false;
		}
		if(grid[1][0] != 1) {
			return false;
		}
		if(grid[1][1] != 1) {
			return false;
		}
		return true;
	}
	public static boolean priority1part4() {
		if(grid[0][1] != 1) {
			return false;
		}
		if(grid[0][2] != 1) {
			return false;
		}
		if(grid[1][1] != 1) {
			return false;
		}
		if(grid[1][2] != 1) {
			return false;
		}
		return true;
	}
	public static boolean priority1part5() {
		if(grid[0][2] != 1) {
			return false;
		}
		if(grid[0][3] != 1) {
			return false;
		}
		if(grid[1][2] != 1) {
			return false;
		}
		if(grid[1][3] != 1) {
			return false;
		}
		return true;
	}
}
