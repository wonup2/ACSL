package Contest3;
//Hannah Moon 9th
//Voice of Calling
//Junior Contest 3

import java.util.*;
import java.io.*;

public class JR_veitch_Hannah {
	
	static Scanner in;
	static int [] arry;
	static String [] ans;

	public static void main(String[] args) throws FileNotFoundException{
		
		in = new Scanner (new File ("1920c3jr.in"));
		for (int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		in.close();

	}
	
	static void init () throws IOException {
		
		arry = new int [8];
		ans = new String [4];
		for (int i = 0; i < 4; i++) {
			ans[i] = "0";
		}
		String pos = in.nextLine();
		for (int i = 0; i < 2; i++) {
			char t1 = pos.charAt(i);
			int temp = 0;
			if (i == 1) temp = 4;
			if (t1 == '0') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 0;
				arry [2 + temp] = 0;
				arry [3 + temp] = 0;
			}if (t1 == '1') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 0;
				arry [2 + temp] = 0;
				arry [3 + temp] = 1;
			} if (t1 == '2') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 0;
				arry [2 + temp] = 1;
				arry [3 + temp] = 0;
			} if (t1 == '3') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 0;
				arry [2 + temp] = 1;
				arry [3 + temp] = 1;
			}if (t1 == '4') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 1;
				arry [2 + temp] = 0;
				arry [3 + temp] = 0;
			} if (t1 == '5') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 1;
				arry [2 + temp] = 0;
				arry [3 + temp] = 1;
			} if (t1 == '6') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 1;
				arry [2 + temp] = 1;
				arry [3 + temp] = 0;
			} if (t1 == '7') {
				arry [0 + temp] = 0;
				arry [1 + temp] = 1;
				arry [2 + temp] = 1;
				arry [3 + temp] = 1;
			}if (t1 == '8') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 0;
				arry [2 + temp] = 0;
				arry [3 + temp] = 0;
			} if (t1 == '9') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 0;
				arry [2 + temp] = 0;
				arry [3 + temp] = 1;
			}if (t1 == 'A') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 0;
				arry [2 + temp] = 1;
				arry [3 + temp] = 0;
			} if (t1 == 'B') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 0;
				arry [2 + temp] = 1;
				arry [3 + temp] = 1;
			}if (t1 == 'C') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 1;
				arry [2 + temp] = 0;
				arry [3 + temp] = 0;
			} if (t1 == 'D') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 1;
				arry [2 + temp] = 0;
				arry [3 + temp] = 1;
			} if (t1 == 'E') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 1;
				arry [2 + temp] = 1;
				arry [3 + temp] = 0;
			} if (t1 == 'F') {
				arry [0 + temp] = 1;
				arry [1 + temp] = 1;
				arry [2 + temp] = 1;
				arry [3 + temp] = 1;
			}
		}
	}
	
	static void solve () {
		
		int hold = 0;
		if(arry[0] == 1 && arry[1] == 1 && arry[2] == 1 && arry[3] == 1) {
            ans[hold] = "B";
            hold++;
            arry[0] = 0;
            arry[1] = 0;
            arry[2] = 0;
            arry[3] = 0;
        } if(arry[4] == 1 && arry[5] == 1 && arry[6] == 1 && arry[7] == 1) {
            ans[hold] = "~B";
            hold++;
            arry[4] = 0;
            arry[5] = 0;
            arry[6] = 0;
            arry[7] = 0;
        } if(arry[0] == 1 && arry[1] == 1 && arry[4] == 1 && arry[5] == 1) {
            ans[hold] = "A";
            hold++;
            arry[0] = 0;
            arry[1] = 0;
            arry[4] = 0;
            arry[5] = 0;
        } if(arry[1] == 1 && arry[2] == 1 && arry[5] == 1 && arry[6] == 1) {
            ans[hold] = "C";
            hold++;
            arry[1] = 0;
            arry[2] = 0;
            arry[5] = 0;
            arry[6] = 0;
        } if(arry[2] == 1 && arry[3] == 1 && arry[7] == 1 && arry[6] == 1) {
            ans[hold] = "~A";
            hold++;
            arry[2] = 0;
            arry[3] = 0;
            arry[7] = 0;
            arry[6] = 0;
        }   if(arry[0] == 1 && arry[3] == 1 && arry[4] == 1 && arry[7] == 1) {
            ans[hold] = "~C";
            hold++;
            arry[0] = 0;
            arry[3] = 0;
            arry[4] = 0;
            arry[7] = 0;
        }  if(arry[0] == 1 && arry[1] == 1) {
            ans[hold] = "AB";
            hold++;
            arry[0] = 0;
            arry[1] = 0;
        }  if(arry[1] == 1 && arry[2] == 1) {
            ans[hold] = "BC";
            hold++;
            arry[1] = 0;
            arry[2] = 0;
        } 
        if(arry[2] == 1 && arry[3] == 1) {
            ans[hold] = "~AB";
            hold++;
            arry[2] = 0;
            arry[3] = 0;
        } 
        if(arry[4] == 1 && arry[5] == 1) {
            ans[hold] = "A~B";
            hold++;
            arry[4] = 0;
            arry[5] = 0;
        } 
        if(arry[5] == 1 && arry[6] == 1) {
            ans[hold] = "~BC";
            hold++;
            arry[5] = 0;
            arry[6] = 0;
        } 
        if(arry[6] == 1 && arry[7] == 1) {
            ans[hold] = "~A~B";
            hold++;
            arry[6] = 0;
            arry[7] = 0;
        } 
        if(arry[0] == 1 && arry[4] == 1) {
            ans[hold] = "A~C";
            hold++;
            arry[0] = 0;
            arry[4] = 0;
        } if(arry[1] == 1 && arry[5] == 1) {
            ans[hold] = "AC";
            hold++;
            arry[1] = 0;
            arry[5] = 0;
        } 
        if(arry[2] == 1 && arry[6] == 1) {
            ans[hold] = "~AC";
            hold++;
            arry[6] = 0;
            arry[2] = 0;
        } 
        if(arry[3] == 1 && arry[7] == 1) {
            ans[hold] = "~A~C";
            hold++;
            arry[3] = 0;
            arry[7] = 0;
        } 
        if(arry[0] == 1 && arry[3] == 1) {
            ans[hold] = "B~C";
            hold++;
            arry[0] = 0;
            arry[3] = 0;
        } 
        if(arry[4] == 1 && arry[7] == 1) {
            ans[hold] = "~B~C";
            hold++;
            arry[4] = 0;
            arry[7] = 0;
        } 
        if (arry[0] == 1) {
        	ans[hold] = "AB~C";
            hold++;
            arry[0] = 0;
        }
        if (arry[1] == 1) {
        	ans[hold] = "ABC";
            hold++;
            arry[1] = 0;
        }
        if (arry[2] == 1) {
        	ans[hold] = "~ABC";
            hold++;
            arry[2] = 0;
        }
        if (arry[3] == 1) {
        	ans[hold] = "~AB~C";
            hold++;
            arry[3] = 0;
        }
        if (arry[4] == 1) {
        	ans[hold] = "A~B~C";
            hold++;
            arry[4] = 0;
        }
        if (arry[5] == 1) {
        	ans[hold] = "A~BC";
            hold++;
            arry[5] = 0;
        }if (arry[6] == 1) {
        	ans[hold] = "~A~BC";
            hold++;
            arry[6] = 0;
        }
        if (arry[7] == 1) {
        	ans[hold] = "~A~B~C";
            hold++;
            arry[7] = 0;
        }
        
		for(int i = 0; i < 3;i++) {
			if (ans[i+1].equals("0")) {
				System.out.print(ans[i]);
				break;
			}
			else {
				System.out.print(ans[i] +  " + ");
			}
		}
		System.out.println();
	
	}
}
