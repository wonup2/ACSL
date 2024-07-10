package allStar;
import java.util.*;

public class hexFractions1 {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		
		for(int x = 0; x < 1; x++) {
			double decimal = Double.parseDouble(in.next());
			
			double [] conversion = new double[15];
			
			for(int i = 0; i < conversion.length; i++) {
				decimal *= 16;
				String temp = String.format("%.2f", decimal);
				
				conversion[i] = Double.valueOf(temp);
				decimal = Double.valueOf(temp); System.out.print(decimal + " " + temp + " ");
				while(decimal >= 1) {
					decimal--;
				}
			}
			
			System.out.print(Arrays.toString(conversion) + " ");
			
			String ans = "";
			for(int i = 0; i < conversion.length; i++) {
				String [] temp = ("" + conversion[i]).split("\\.");
				
				if(temp[0].equals("10")) {
					ans += "A";
				} else if(temp[0].equals("11")) {
					ans += "B";
				} else if(temp[0].equals("12")) {
					ans += "C";
				} else if(temp[0].equals("13")) {
					ans += "D";
				} else if(temp[0].equals("14")) {
					ans += "E";
				} else if(temp[0].equals("15")) {
					ans += "F";
				} else {
					ans += temp[0];
				}
				
				conversion[i] = Double.parseDouble("0." + temp[1]);
			}
			
			int repeat = -1;
			outer:
			for(int i = 0; i < conversion.length; i++) {
				double chk = conversion[i];
				for(int j = i + 1; j < conversion.length; j++) {
					if(conversion[j] == chk) {
						repeat = j;
						break outer;
					}
				}
			}
			
			System.out.print(repeat + " ");
			System.out.print(Arrays.toString(conversion) + " ");
			
			System.out.print(".");
			if(repeat == -1 || repeat > 10) {
				System.out.println(ans.substring(0, 10));
			} else {
				System.out.println(ans.substring(0, repeat));
			}
		}
		
		in.close();
	}
}

/*
.5
.75
.25
.1875
.6875
.013
.14
.144
.65
.88
.375
.875
.5625
.282
.556
.24
.28
.76
.1
.55
*/