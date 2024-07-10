
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class C4_IN_Long {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = "2 2 32 16 2 2 8 256 2 128 4 16 64 16 32 8 8 4 16 4 8 8 32 64 2 64 8 64 8 256 128 256 16 8 32 16 32 64 128 2";		
		//512 256 128 64 32 16 8 4 16 512 256 128 32 16 64 32 16 256 16 128 8 4 64 64 32 64 8 4 8 4 128 16 32 8 256 16 256 64 512 32
		//512 256 128 64 32 16 8 4 16 512 256 128 32 16 64 32 16 256 16 128 8 4 64 64 32 64 8 4 8 4 128 16 32 8 256 16 256 64 512 32

		System.out.println(play2248(s));		
	}
	
    public static String play2248(String boardValues) {
    	
        // make the board
        int[][] board = new int[8][5];
        boolean[][] visited = new boolean[8][5];
        StringTokenizer st = new StringTokenizer(boardValues);

        while (st.hasMoreTokens()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }     
        
        // find the first tile 
        List<int[]> path = new ArrayList<>();
        int currentrow = 0;
        int currentcol = 0;
        int value = 0;
        boolean pathfound = false;

        outerloop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                // Try to find the initial pair
                if (j < 4 && board[i][j] == board[i][j + 1] && !visited[i][j] && !visited[i][j + 1]) {
                    value = board[i][j];
                    path.add(new int[]{i, j});
                    path.add(new int[]{i, j + 1});
                    visited[i][j] = true;
                    visited[i][j + 1] = true;
                    currentrow = i;
                    currentcol = j + 1;
                    pathfound = true;
                }
                else if (i < 7 && j > 0 && board[i][j] == board[i + 1][j - 1] && !visited[i][j] && !visited[i + 1][j - 1]) {
                    value = board[i][j];
                    path.add(new int[]{i, j});
                    path.add(new int[]{i + 1, j - 1});
                    visited[i][j] = true;
                    visited[i + 1][j - 1] = true;
                    currentrow = i + 1;
                    currentcol = j - 1;
                    pathfound = true;
                }
                else if (i < 7 && board[i][j] == board[i + 1][j] && !visited[i][j] && !visited[i + 1][j]) {
                    value = board[i][j];
                    path.add(new int[]{i, j});
                    path.add(new int[]{i + 1, j});
                    visited[i][j] = true;
                    visited[i + 1][j] = true;
                    currentrow = i + 1;
                    currentcol = j;
                    pathfound = true;
                }
                else if (i < 7 && j < 4 && board[i][j] == board[i + 1][j + 1] && !visited[i][j] && !visited[i + 1][j + 1]) {
                    value = board[i][j];
                    path.add(new int[]{i, j});
                    path.add(new int[]{i + 1, j + 1});
                    visited[i][j] = true;
                    visited[i + 1][j + 1] = true;
                    currentrow = i + 1;
                    currentcol = j + 1;
                    pathfound = true;
                }
                if (pathfound) {
                    break outerloop;
                }
            }
        }        

        //find the path
        while (true) {
            int currentvalue = value;
            boolean moved = false;

            if (currentcol > 0 && (currentvalue == board[currentrow][currentcol - 1] 
            		|| currentvalue * 2 == board[currentrow][currentcol - 1]) && !visited[currentrow][currentcol - 1]) {
                value = board[currentrow][currentcol - 1];
                path.add(new int[]{currentrow, currentcol - 1});
                visited[currentrow][currentcol - 1] = true;
                currentcol--;
                moved = true;
            }
            else if (currentcol < 4 && (currentvalue == board[currentrow][currentcol + 1] 
            		|| currentvalue * 2 == board[currentrow][currentcol + 1]) && !visited[currentrow][currentcol + 1]) {
                value = board[currentrow][currentcol + 1];
                path.add(new int[]{currentrow, currentcol + 1});
                visited[currentrow][currentcol + 1] = true;
                currentcol++;
                moved = true;
            }
            else if (currentrow < 7 && currentcol > 0 && (currentvalue == board[currentrow + 1][currentcol - 1] 
            		|| currentvalue * 2 == board[currentrow + 1][currentcol - 1]) && !visited[currentrow + 1][currentcol - 1]) {
                value = board[currentrow + 1][currentcol - 1];
                path.add(new int[]{currentrow + 1, currentcol - 1});
                visited[currentrow + 1][currentcol - 1] = true;
                currentrow++;
                currentcol--;
                moved = true;
            }
            else if (currentrow < 7 && (currentvalue == board[currentrow + 1][currentcol] 
            		|| currentvalue * 2 == board[currentrow + 1][currentcol]) && !visited[currentrow + 1][currentcol]) {
                value = board[currentrow + 1][currentcol];
                path.add(new int[]{currentrow + 1, currentcol});
                visited[currentrow + 1][currentcol] = true;
                currentrow++;
                moved = true;
            }
            else if (currentrow < 7 && currentcol < 4 && (currentvalue == board[currentrow + 1][currentcol + 1] 
            		|| currentvalue * 2 == board[currentrow + 1][currentcol + 1]) && !visited[currentrow + 1][currentcol + 1]) {
                value = board[currentrow + 1][currentcol + 1];
                path.add(new int[]{currentrow + 1, currentcol + 1});
                visited[currentrow + 1][currentcol + 1] = true;
                currentrow++;
                currentcol++;
                moved = true;
            }

            if (!moved) {
                break;
            }
        }
        
        //Change the last tile position to unvisited
        visited[currentrow][currentcol] = false;
        
                
        // calculate power of 2 to replace final tile in path
        int sum = path.stream().mapToInt(pos -> board[pos[0]][pos[1]]).sum();
        int powerof2 = 1;
        while (powerof2 < sum) {
            powerof2 *= 2;
        }
        
        //Change the last tile to powerof2
        board[currentrow][currentcol] = powerof2;
        
        //create powersList
        List<Integer> powerlist = new ArrayList<Integer>();
        
        if(powerof2<256) powerof2 = 256;  //<-------------------You missed this part
        
        for(int i=0; i<8; i++) {
        	powerlist.add(powerof2);
        	powerof2/=2;
        }
        
        // remove all tiles in path except final and the number < smallest number of powersList
        int smallest = powerlist.get(powerlist.size()-1);
        for (int i = 0; i < 8; i++) {
        	for(int j = 0; j <5; j++) {
        		if(visited[i][j] || board[i][j]<smallest) board[i][j] = 0;
        	}
        }
 
        // shift other tiles down
        for (int col = 0; col < 5; col++) {
            int shiftIndex = 7;
            for (int row = 7; row >= 0; row--) {
                if (board[row][col] != 0) {
                    if (row != shiftIndex) {
                        board[shiftIndex][col] = board[row][col];
                        board[row][col] = 0;
                    }
                    shiftIndex--;
                }
            }
        }

        //fill an empty space with new tiles.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <5; j++) {
                if (board[i][j] == 0) {
                	board[i][j] = powerlist.get(0);
                	powerlist.add(powerlist.remove(0));
                }
            }
        }

        // board to a single string in row major order
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                ans.append(board[i][j]).append(" ");
            }
        }
        return ans.toString().trim();
    }
}
