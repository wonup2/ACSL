package Contest4;
/*
Name: Nathan Kang
Grade: 8
Team: Voice of Calling
Division: Junior
Date: 4/6/2020
2019-2020 ACSL Contest 4
*/
import java.util.*;
import java.io.*;
public class JR_Patolli_nathan{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1920C4Jr.in")));
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] board = new boolean[53];
			for(int j = 0; j < 3; j++)
				board[Integer.parseInt(st.nextToken())] = true;
			int index = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			for(int j = 0; j < r; j++) {
				int diceRoll = Integer.parseInt(st.nextToken());
				index += diceRoll;
				if(index > 52 || board[index])
					index -= diceRoll;
				else if(index == 52)
					break;
				else if(isPrime(index)) {
					for(int k = 1; k <= 6; k++) {
						++index;
						if(board[index]) {
							--index;
							break;
						}
					}
				}
				else if((int)(Math.sqrt(index)) == Math.sqrt(index) && index > 4) {
					for(int k = 1; k <= 6; k++) {
						--index;
						if(board[index]) {
							++index;
							break;
						}
					}
				}
				else if(hToV(index - diceRoll, index)) {
					boolean b = false;
					for(int k = index; k >= index - diceRoll; k--) {
						if(k % diceRoll == 0 && !board[k]) {
							index = k;
							b = true;
							break;
						}
					}
					if(!b)
						index -= diceRoll;
				}				

			}
			System.out.println(index < 52 ? index : "GAME OVER");
		}
		br.close();
	}
	public static boolean isPrime(int n) {
		boolean prime = true;
		for(int i = 2; i <= n / 2; i++) {
			if(n % i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
	public static boolean hToV(int n1, int n2) {
		if(n1 >= 3 && n1 <= 6 && n2 >= 8 && n2 <= 12 || n1 >= 8 && n1 <= 11 && n2 >= 13 && n2 <= 17 || n1 >= 13 && n1 <= 16
				&& n2 >= 18 && n2 <= 22 || n1 >= 18 && n1 <= 21 && n2 >= 23 && n2 <= 27 || n1 >= 22 && n1 <= 26 && n2 >= 28
				&& n2 <= 32 || n1 >= 30 && n1 <= 34 && n2 >= 36 && n2 <= 40 || n1 >= 36 && n1 <= 39 && n2 >= 41 && n2 <= 45
				|| n1 >= 41 && n1 <= 44 && n2 >= 46 && n2 <= 50 || n1 >= 46 && n1 <= 49 && n2 >= 51 && n2 <= 52 || n1 == 2 &&
				n2 == 8 || n1 == 7 && n2 == 13 || n1 == 12 && n2 == 18 || n1 == 17 && n2 == 23 || n1 == 22 && n2 == 28 || 
				n1 == 35 && n2 == 41 || n1 == 40 && n2 == 46 || n1 == 45 && n2 == 51) {
			return true;
		}
		return false;
	}
}