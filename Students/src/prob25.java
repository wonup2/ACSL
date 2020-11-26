import java.util.*;
import java.io.*;
public class prob25 {
	
	static Scanner in;
	static int hexes, cases;
	static int[][] odd = {{0,-1}, {1,-1}, {1,0}, {0,1}, {-1,0}, {-1,-1}};
	static int[][] even = {{0,-1},{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}};
	static int startx, starty, endx, endy, cnt, bigx, smallx, bigy, smally;
	static TreeMap<String, String> map = new TreeMap<String, String>();
	static String [][] grid;
	static boolean[][] v;
	static TreeSet<Integer> cntset;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		init();
		in.close();
	}
	
	static void init() {
		hexes = in.nextInt();
		cases = in.nextInt(); in.nextLine();
		grid = new String[cases][2];
		for(int i = 0; i < hexes; i++) {
			String[] temp = in.nextLine().split(" ");
			map.put(temp[1], temp[0]);
		}
		for(int i = 0; i < cases; i++) {
			v = new boolean[100][100];
			String[] temp = in.nextLine().split(" ");
			grid[i][0] = temp[0];
			grid[i][1] = temp[1];
			cntset=new TreeSet<Integer>();
			solve(temp);
			System.out.println(cntset.first()-1);
		}
	}
	
	static int getx(String s) {
		return Integer.parseInt(s.substring(0, 2));
	}
	
	static int gety(String s) {
		return Integer.parseInt(s.substring(2));
	}
	
	static void solve(String[] arr) {
		String start = arr[0], end = arr[1];
		System.out.println(arr[0] + " " + arr[1].toString());
		startx = getx(map.get(start)); starty = gety(map.get(start)); endx = getx(map.get(end)); endy = gety(map.get(end));
		cnt=0;
		bigx=Math.max(startx, endx);
		smallx=Math.min(startx, endx);
		bigy=Math.max(starty, endy);
		smally=Math.min(starty, endy);

		dfs(startx, starty); 			

	}
	
	static void dfs(int x, int y) {
		if(x == endx && y == endy) {
			cntset.add(cnt);
			return;
		}
		if(v[x][y]) return;
		v[x][y] = true;				
		cnt++;

		for(int i = 0; i < 6; i++) {
			int nx=0;
			int ny=0;
			if(x%2==0) {
				nx = x + even[i][0];
				ny = y + even[i][1];
			}
			else {
				nx = x + odd[i][0];
				ny = y + odd[i][1];
			}
			if(nx < 1 || nx > 99 || ny < 1 || ny > 99 )	continue;
			if(!v[nx][ny] && smallx<=nx&&nx<=bigx&&smally<=ny&&ny<=bigy) {
				//System.out.println("000target (x, y): " + endx + " " + endy + ", current: (" + nx + ", " + ny + ")");
				dfs(nx, ny);
			}					
		}
	}
}


