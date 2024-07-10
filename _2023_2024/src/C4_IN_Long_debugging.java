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

public class C4_IN_Long_debugging {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String s = "2 2 32 16 2 2 8 256 2 128 4 16 64 16 32 8 8 4 16 4 8 8 32 64 2 64 8 64 8 256 128 256 16 8 32 16 32 64 128 2";		
		s = "2 4 256 128 4 256 32 8 64 64 64 128 16 256 64 64 4 4 64 64 64 4 8 64 2 32 4 2 128 256 16 64 64 2 8 256 32 32 32 2";		
		s = "256 8 4 16 128 64 4 32 256 256 8 32 8 4 2 64 8 8 2 8 64 16 64 16 128 4 4 4 32 64 64 2 8 8 32 128 128 128 64 4";		
		s = "256 16 256 2 32 2 32 2 16 8 32 2 256 64 16 4 2 128 2 32 8 8 32 256 2 2 4 8 32 128 16 16 32 64 256 4 16 128 4 8";
		s = "2 64 32 32 8 32 32 128 256 32 64 128 64 32 32 64 128 16 8 64 8 4 256 64 64 64 256 64 64 4 8 128 64 32 256 256 256 128 64 8";
		s = "256 128 64 128 32 32 16 8 256 16 4 2 16 64 4 4 128 32 256 8 16 16 64 256 4 32 64 2 64 8 256 2 128 16 2 8 128 256 4 32";
		s = "4 16 8 2 32 2 2 8 32 4 2 16 16 4 128 128 32 4 2 128 128 64 8 128 128 4 2 16 32 16 8 8 128 64 32 32 8 128 2 128";
		s = "8 8 16 64 64 256 2 128 16 4 4 64 4 64 16 256 16 64 64 32 32 64 64 256 128 8 128 64 2 16 4 16 256 4 8 64 256 32 16 64";
		s = "256 16 256 2 32 2 32 2 16 8 32 2 256 64 16 4 2 128 2 32 8 8 32 256 2 2 4 8 32 128 2 16 32 64 256 4 2 128 4 8";	
		s = "8 128 4 128 32 16 16 4 256 16 32 4 16 64 4 8 64 64 256 8 16 2 2 256 4 32 128 2 64 8 256 32 128 16 2 8 64 64 128 32";

		System.out.println(play2248(s));		
	}
	
	static void print(int[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print("\t"+a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static void print(boolean[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print("\t"+a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
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
        
//--------->>
        System.out.println("board");
        print(board);
//--------->>        
        
        // find path
        ArrayList<Integer> path = new ArrayList<Integer>();
        int currentrow = 0;
        int currentcol = 0;
        int value = 0;
        boolean pathfound = false;

        stop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                // Try to find the initial pair
                if (j < 4 && board[i][j] == board[i][j + 1] && !visited[i][j] && !visited[i][j + 1]) {

                    path.add(board[i][j]);
                    path.add(board[i][j + 1]);
                    
                    visited[i][j] = true;
                    visited[i][j + 1] = true;
                    
                    currentrow = i;
                    currentcol = j + 1;
                    
                    pathfound = true;
                }
                else if (i < 7 && j > 0 && board[i][j] == board[i + 1][j - 1] && !visited[i][j] && !visited[i + 1][j - 1]) {
                   
                    path.add(board[i][j]);
                    path.add(board[i + 1][j - 1]);
                    
                    visited[i][j] = true;
                    visited[i + 1][j - 1] = true;
                    
                    currentrow = i + 1;
                    currentcol = j - 1;
                    
                    pathfound = true;
                }
                else if (i < 7 && board[i][j] == board[i + 1][j] && !visited[i][j] && !visited[i + 1][j]) {
                    
                	path.add(board[i][j]);
                    path.add(board[i + 1][j]);
                    
                    visited[i][j] = true;
                    visited[i + 1][j] = true;
                    
                    currentrow = i + 1;
                    currentcol = j;
                    
                    pathfound = true;
                }
                else if (i < 7 && j < 4 && board[i][j] == board[i + 1][j + 1] && !visited[i][j] && !visited[i + 1][j + 1]) {
                 
                	path.add(board[i][j]);
                    path.add(board[i + 1][j + 1]);
                    
                    visited[i][j] = true;
                    visited[i + 1][j + 1] = true;
                    
                    currentrow = i + 1;
                    currentcol = j + 1;
                    
                    pathfound = true;
                }
                
                if (pathfound) break stop;                
            }
        }
        
//--------->>
        System.out.println("Find initial path: " + path + " " + currentrow + " " + currentcol);
        System.out.println("visited");
        print(visited);
//--------->>        

        
       	
       	boolean moved = true;
		int currentvalue = path.get(path.size()-1);
		
        while (moved) {
        	
        	moved = false;
        	
            if (currentcol > 0 && (currentvalue == board[currentrow][currentcol - 1] 
            		|| currentvalue * 2 == board[currentrow][currentcol - 1]) && !visited[currentrow][currentcol - 1]) {
            	
            	currentvalue = board[currentrow][currentcol - 1];
                path.add(currentvalue);
                visited[currentrow][currentcol - 1] = true;
                
                currentcol--;
                moved = true;                
            }
            
            else if (currentcol < 4 && (currentvalue == board[currentrow][currentcol + 1] 
            		|| currentvalue * 2 == board[currentrow][currentcol + 1]) && !visited[currentrow][currentcol + 1]) {
            	
            	currentvalue = board[currentrow][currentcol + 1];
                path.add(currentvalue);
                visited[currentrow][currentcol + 1] = true;
                currentcol++;
                moved = true;
            }
            
            else if (currentrow < 7 && currentcol > 0 && (currentvalue == board[currentrow + 1][currentcol - 1] 
            		|| currentvalue * 2 == board[currentrow + 1][currentcol - 1]) && !visited[currentrow + 1][currentcol - 1]) {
            	currentvalue = board[currentrow + 1][currentcol - 1];
                path.add(currentvalue);
                visited[currentrow + 1][currentcol - 1] = true;
                currentrow++;
                currentcol--;
                moved = true;
            }
            
            else if (currentrow < 7 && (currentvalue == board[currentrow + 1][currentcol] 
            		|| currentvalue * 2 == board[currentrow + 1][currentcol]) && !visited[currentrow + 1][currentcol]) {
            	currentvalue = board[currentrow + 1][currentcol];
                path.add(currentvalue);
                visited[currentrow + 1][currentcol] = true;
                currentrow++;
                moved = true;
            }
            
            else if (currentrow < 7 && currentcol < 4 && (currentvalue == board[currentrow + 1][currentcol + 1] 
            		|| currentvalue * 2 == board[currentrow + 1][currentcol + 1]) && !visited[currentrow + 1][currentcol + 1]) {
                value = board[currentrow + 1][currentcol + 1];
                path.add(currentvalue);
                visited[currentrow + 1][currentcol + 1] = true;
                currentrow++;
                currentcol++;
                moved = true;
            }
            
        }
        
        visited[currentrow][currentcol] = false;

//--------->>
        System.out.println("path: " + path);
        print(visited);
//--------->>  
        
        
                
        // calculate power of 2 to replace final tile in path
        int sum = 0;
        for(int n:path) sum+=n;
        
        int powerof2 = 1;
        while (powerof2 < sum) powerof2 *= 2;
        
        
        //change the last position
        board[currentrow][currentcol] = powerof2;

//--------->>
        System.out.println("step 3");
        System.out.println(powerof2);
        print(board);
//--------->>
        
        
        //create powersList
        List<Integer> powerlist = new ArrayList<Integer>();
        
        if(powerof2 < 256) powerof2 = 256;
        
        for(int i=0; i<8; i++) {
        	powerlist.add(powerof2);
        	powerof2/=2;
        }
        
        //512, 256, 128, 64, 32, 16, 8, 4
        
//--------->>
        System.out.println("step 4");
        System.out.println(powerlist);
//--------->>
        
        
        // remove all tiles in path except final and the number < smallest number of powersList
        int smallest = powerlist.get(powerlist.size()-1);
        
        for (int i = 0; i < 8; i++) {
        	for(int j = 0; j <5; j++) {
        		if(visited[i][j] || board[i][j]<smallest) board[i][j] = 0;
        	}
        }

//--------->>
        System.out.println("step 5");
        print(board);
//--------->>
       
        
        for(int c = 0; c<5; c++) {
    		ArrayList<Integer> temp = new ArrayList<Integer>();
        	for(int r = 7; r>=0; r--) {
        		if(board[r][c]!=0) {
        			temp.add(board[r][c]);
        			board[r][c] = 0;
        		}
        	}
        	
        	for(int r = 7; r>=0; r--) {
        		board[r][c] = temp.remove(0);
        		if(temp.size()==0) break;
        	}
        }

//--------->>
        System.out.println("step 6");
        print(board);
//--------->>
        
        //fill up the new tile at 0
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <5; j++) {
                if (board[i][j] == 0) {
                	board[i][j] = powerlist.get(0);
                	powerlist.add(powerlist.remove(0));
                }
            }
        }
        
//--------->>
        System.out.println("step 7");
        print(board);
//--------->>

        // board to a single string in row major order
        String ans = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                ans+=board[i][j] + " ";
            }
        }
        //return ans.toString().trim();
        
        return ans;
    }
}
