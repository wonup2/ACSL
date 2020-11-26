package Contest1;
import java.util.*;
import java.io.*;
/*
 * name: Colin Kwon
 * team: ABCobot
 * division: JUnior 5
 * date: 12/5/19
 */
public class JR_Number_Transformation_Colin {
	public static void main(String[] args)throws IOException {
		Scanner in = new Scanner(new File("c1JR.in"));
		for(int i = 0; i < 5; i++) {
			String[] temp = in.nextLine().split(" ");
			String numbers = temp[0];
			int position = Integer.parseInt(temp[1]);
			int transition = Integer.parseInt(temp[2]);
			int integer = Character.getNumericValue(numbers.charAt(numbers.length()-position));
			String transform = "";
			String replace = "";
			String ans = numbers.substring(0,numbers.length()-position);
			if(integer <= 4) {
				transform += integer+transition;
				replace += transform.substring(transform.length()-1);
			}else if(integer >= 5 && integer <= 9) {
				transform += java.lang.Math.abs(integer-transition);
				replace = transform.substring(0,1);
			}
			ans += replace;
			for(int j = ans.length()-1; j < numbers.length()-1; j++) {
				ans+= "0";
			}
			System.out.println(ans);
		}
	}
}