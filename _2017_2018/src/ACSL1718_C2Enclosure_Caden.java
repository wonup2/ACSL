/*
Caden Kang, Grade 7
abcobot
ACSL 2017-2018 2nd Contest
Junior Division
Friday, February 2, 2018
*/
import java.util.*;
import java.io.*;
public class ACSL1718_C2Enclosure_Caden {
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("1718C2jr.in"));
		
		for (int i = 0; i < 5; i++) {
			//get data
			String str = in.next();
			
			//find ( or )
			int l1 = str.indexOf("(") + 1;
			int l2 = str.indexOf(")") + 1;
			
			String result = "";
			
			if (l1 > l2) {
				for (int j = l1 + 4 ; j <= str.length() + 1; j = j + 2) {
						result += j + " ";
				}
			}
			
			else {
				String r = "";
				for (int j = l2 - 3; j >= 0; j = j - 2) {
						r += j + " ";
				}
				
				for (int j = r.length() - 2; j > -1; j--) {
					result += r.substring(j, j + 1);
				}
			}
			
			System.out.println(result);
		}
	}
}
