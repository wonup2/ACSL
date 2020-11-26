package Contest3;
/*
 * Name: Hemosoo Woo
 * Grade: 9th
 * Team: Stempia
 * Division: Junior Contest 3
 */
import java.util.*;
import java.io.*;
public class JR_3Veitch_Hemosoo {
	static Scanner in;
	static String b[], c;
	static int hold, a[];
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C3JR.in"));
		for(int i = 0; i < 10; i++) {
			try {
				a = new int[8];
				int num = Integer.parseInt(in.next(), 16);
				String bin = Integer.toBinaryString(num);				
				bin = String.format("%8s", bin).replace(" ", "0");
				for(int j = 0; j < 8; j++) {
					a[j] = Character.getNumericValue(bin.charAt(j));
				}
				init();
				solve();
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error");
			}
		}
	}
	public static void init() {
		hold = 0;
		b = new String[5];
		c = "";
	}
	public static void solve() {
		if(a[0] == 1 && a[1] == 1 && a[2] == 1 && a[3] == 1) {
			b[hold] = "B";
			hold++;
			a[0] = 0;
			a[1] = 0;
			a[2] = 0;
			a[3] = 0;
		} if(a[4] == 1 && a[5] == 1 && a[6] == 1 && a[7] == 1) {
			b[hold] = "~B";
			hold++;
			a[4] = 0;
			a[5] = 0;
			a[6] = 0;
			a[7] = 0;
		} if(a[0] == 1 && a[1] == 1 && a[4] == 1 && a[5] == 1) {
			b[hold] = "A";
			hold++;
			a[0] = 0;
			a[1] = 0;
			a[4] = 0;
			a[5] = 0;
		} if(a[1] == 1 && a[2] == 1 && a[5] == 1 && a[6] == 1) {
			b[hold] = "C";
			hold++;
			a[1] = 0;
			a[2] = 0;
			a[5] = 0;
			a[6] = 0;
		} if(a[2] == 1 && a[3] == 1 && a[7] == 1 && a[6] == 1) {
			b[hold] = "~A";
			hold++;
			a[2] = 0;
			a[3] = 0;
			a[7] = 0;
			a[6] = 0;
		}   if(a[0] == 1 && a[3] == 1 && a[4] == 1 && a[7] == 1) {
			b[hold] = "~C";
			hold++;
			a[0] = 0;
			a[3] = 0;
			a[4] = 0;
			a[7] = 0;
		}  if(a[0] == 1 && a[1] == 1) {
			b[hold] = "AB";
			hold++;
			a[0] = 0;
			a[1] = 0;
		}  if(a[1] == 1 && a[2] == 1) {
			b[hold] = "BC";
			hold++;
			a[1] = 0;
			a[2] = 0;
		}  if(a[2] == 1 && a[3] == 1) {
			b[hold] = "~AB";
			hold++;
			a[2] = 0;
			a[3] = 0;
		}  if(a[4] == 1 && a[5] == 1) {
			b[hold] = "A~B";
			hold++;
			a[4] = 0;
			a[5] = 0;
		}  if(a[5] == 1 && a[6] == 1) {
			b[hold] = "~BC";
			hold++;
			a[5] = 0;
			a[6] = 0;
		}  if(a[6] == 1 && a[7] == 1) {
			b[hold] = "~A~B";
			hold++;
			a[6] = 0;
			a[7] = 0;
		}  if(a[0] == 1 && a[4] == 1) {
			b[hold] = "A~C";
			hold++;
			a[0] = 0;
			a[4] = 0;
		} if(a[1] == 1 && a[5] == 1) {
			b[hold] = "AC";
			hold++;
			a[1] = 0;
			a[5] = 0;
		} if(a[2] == 1 && a[6] == 1) {
			b[hold] = "~AC";
			hold++;
			a[2] = 0;
			a[6] = 0;
		} if(a[3] == 1 && a[7] == 1) {
			b[hold] = "~A~C";
			hold++;
			a[3] = 0;
			a[7] = 0;
		} if(a[0] == 1 && a[3] == 1) {
			b[hold] = "B~C";
			hold++;
			a[0] = 0;
			a[3] = 0;
		}  if(a[4] == 1 && a[7] == 1) {
			b[hold] = "~B~C";
			hold++;
			a[4] = 0;
			a[7] = 0;
		} if(a[0] == 1) {
			b[hold] = "AB~C";
			hold++;
		} if(a[4] == 1) {
			b[hold] = "A~B~C";
			hold++;
		} if(a[1] == 1) {
			b[hold] = "ABC";
			hold++;
		} if(a[5] == 1) {
			b[hold] = "A~BC";
			hold++;
		} if(a[2] == 1) {
			b[hold] = "~ABC";
			hold++;
		} if(a[6] == 1) {
			b[hold] = "~A~BC";
			hold++;
		} if(a[3] == 1) {
			b[hold] = "~AB~C";
			hold++;
		} if(a[7] == 1) {
			b[hold] = "~A~B~C";
			hold++;
		}
		c += b[0];
		for(int i = 1; i < b.length; i++) {
			if(b[i] != null) {
				c += " + " + b[i];
			}
		}
		System.out.println(c);
	}
}
