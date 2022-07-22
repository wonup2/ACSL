import java.util.*;
import java.io.*;

public class spotthey {
	
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		input = input.substring(2);
		int dim = Integer.parseInt(st.nextToken());
		int[][] nums = new int[dim][dim];
		String[][] board = new String[dim][dim];
		int count = 1;
		int sum = 0;
		boolean complete = false;
		
		for (int r = 0; r < dim; r++) {
			for (int c = 0; c < dim; c++) {
				nums[r][c] = count;
				board[r][c]= " ";
				count++;
			}
		}
		
		count = 0;
		while (complete == false && st.hasMoreElements()) {
			int temp = Integer.parseInt(st.nextToken());
			int row = 0, col = 0;
			
			if (temp % dim == 0) {
				row = temp / dim -1;
				col = dim-1;
			}
			else {
				row = temp / dim;
				col = temp % dim - 1;
			}
			
			if (board[row][col] == "O" || board[row][col] == "X") {
				board[row][col] = " ";
			}
			
			if (count % 2 == 0) {
				board[row][col] = "O";
			}
			else {
				board[row][col] = "X";
			}
			
			if (count >= 4) {
				for (int i = 0; i < board.length; i++) {
					for (int a = 0; a < board[i].length; a++) {
						if (board[i][a] == "O" || board[i][a] == "X") {
							String str = board[i][a];
							if (a - 2 >= 0 && i + 2 <= dim-1) {
								if (board[i][a-2].equals(str) && board[i+1][a-1].equals(str) && board[i+2][a-1].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i][a-2] + nums[i+1][a-1] + nums[i+2][a-1];
									System.out.println("sum "+nums[i][a] + " "+ nums[i][a-2] + " "+ nums[i+1][a-1] + " "+ nums[i+2][a-1]);
									break;
								}

							}
							
							if (a - 2 >= 0 && i - 2 >= 0) {
								if (board[i][a-2].equals(str) && board[i-1][a-1].equals(str) && board[i-2][a-1].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i][a-2] + nums[i-1][a-1] + nums[i-2][a-1];
									System.out.println("sum "+nums[i][a] +" "+ nums[i][a-2] +" "+ nums[i-1][a-1] +" "+ nums[i-2][a-1]);
									break;
								}
							}
							
							if (a + 2 <= dim-1 && i + 2 <= dim-1) {
								if (board[i][a+2].equals(str) && board[i+1][a+1].equals(str) && board[i+2][a+1].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i][a+2] + nums[i+1][a+1] + nums[i+2][a+1];
									System.out.println("sum "+nums[i][a] +" "+ nums[i][a+2] +" "+ nums[i+1][a+1] +" "+ nums[i+2][a+1]);
									break;
								}

							}
							
							if (a + 2 <= dim-1 && i - 2 >= 0) {
								if (board[i][a+2].equals(str) && board[i-1][a+1].equals(str) && board[i-2][a+1].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i][a+2] + nums[i-1][a+1] + nums[i-2][a+1];
									System.out.println("sum "+nums[i][a] +" "+ nums[i][a+2] +" "+ nums[i-1][a+1] +" "+ nums[i-2][a+1]);
									break;
								}
							}
							if (i - 2 >= 0 && a - 2 >= 0) {
								if (board[i-2][a].equals(str) && board[i-1][a-1].equals(str) && board[i-1][a-2].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i-2][a] + nums[i-1][a-1] + nums[i-1][a-2];
									System.out.println("sum "+nums[i][a] +" "+ nums[i-2][a] +" "+ nums[i-1][a-1] +" "+ nums[i-1][a-2]);
									break;
								}
							}
							
							if (i - 2 >= 0 && a + 2 <= dim-1) {
								if (board[i-2][a].equals(str) && board[i-1][a+1].equals(str) && board[i-1][a+2].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i-2][a] + nums[i-1][a+1] + nums[i-1][a+2];
									System.out.println("sum "+nums[i][a] +" "+ nums[i-2][a] +" "+ nums[i-1][a+1] +" "+ nums[i-1][a+2]);
									break;
								}
							}
							
							if (i + 2 <= dim-1 && a - 2 >= 0) {
								if (board[i+2][a].equals(str) && board[i+1][a-1].equals(str) && board[i+1][a-2].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i+2][a] + nums[i+1][a-1] + nums[i+1][a-2];
									System.out.println("sum "+nums[i][a] + nums[i+2][a] +" "+ nums[i+1][a-1] +" "+ nums[i+1][a-2]);
									break;
								}

							}
							
							if (i + 2 <= dim-1 && a + 2 <= dim-1) {
								if (board[i+2][a].equals(str) && board[i+1][a+1].equals(str) && board[i+1][a+2].equals(str)) {
									complete = true;
									sum = nums[i][a] + nums[i+2][a] + nums[i+1][a+1] + nums[i+1][a+2];
									System.out.println("sum "+nums[i][a] +" "+ nums[i+2][a] +" "+ nums[i+1][a+1] +" "+ nums[i+1][a+2]);
									break;
								}
							}
						}
					}
					if (complete == true) {
						break;
					}
				}
			}
			count++;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board[0].length; a++) {
				System.out.print(board[i][a]+" ");
			}
			System.out.println();
		}
		
		System.out.println(sum);
	}
}