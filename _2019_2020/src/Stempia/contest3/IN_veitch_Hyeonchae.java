package Stempia.contest3;
/*
name: Hyeonchae Kim
grade: 10th
team: ABCobot
division: Intermediate 3
Contest 3
*/
import java.util.*;
import java.io.*;

public class IN_veitch_Hyeonchae {
	
	static Scanner in;
	static String[][] diagram;
	static int[][] diagram2;
	static String[] input;
	
	public static void main(String [] args) throws FileNotFoundException {
		
		in = new Scanner(new File("1920c3in.in"));
		
		for(int i = 0; i < 5; i++) {
			
			try {
				
				init();
				System.out.println(solve());
			
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public static void init() {
		
		diagram = new String[][] {{"'A'B~C~D", "'A'B'C~D", "~A'B'C~D", "~A'B~C~D"}, {"'A'B~C'D", "'A'B'C'D", "~A'B'C'D", "~A'B~C'D"},
				{"'A~B~C'D", "'A~B'C'D", "~A~B'C'D", "~A~B~C'D"}, {"'A~B~C~D", "'A~B'C~D", "~A~B'C~D", "~A~B~C~D"}};
		
		diagram2 = new int[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
		
		String temp = in.nextLine();
		input = temp.replace("+"," ").split(" ");
		for(int i = 0; i < input.length; i++) {
        
			input[i] = conv(input[i]);
        
		}
				
	}
	
	public static String solve() {
		
		for(int i = 0; i < input.length; i++) {
			
			for(int j = 0; j < diagram.length; j++) {
				
				for(int x = 0; x < diagram.length; x++) {
					
					if(diagram[j][x].contains(input[i].substring(0,2))) {
						
						if(input[i].length() > 2 && diagram[j][x].contains(input[i].substring(2,4))) {
							
							if(input[i].length() > 4 && diagram[j][x].contains(input[i].substring(4,6))) {
								
								if(input[i].length() > 6 && diagram[j][x].contains(input[i].substring(6,8))) {
									
									diagram2[j][x] = 1;
									
								}else if(input[i].length() == 6) {
									
									diagram2[j][x] = 1;
									
								}
								
							}else if(input[i].length() == 4) {
								
								diagram2[j][x] = 1;
								
							}
							
						}else if(input[i].length() == 2) {
							
							diagram2[j][x] = 1;
							
						}
						
					}
					
				}
				
			}
			
		}
		
		//hexadecimal
		String ans = "";
		for(int i = 0; i < diagram2.length; i++) {
			
			int temp = 0;
			if(diagram2[i][0] == 1)
				temp = 8;
			if(diagram2[i][1] == 1)
				temp += 4;
			if(diagram2[i][2] == 1)
				temp += 2;
			if(diagram2[i][3] == 1)
				temp += 1;
			
			if(temp == 10)
				ans += "A";
			else if(temp == 11)
				ans += "B";
			else if(temp == 12)
				ans += "C";
			else if(temp == 13)
				ans += "D";
			else if(temp == 14)
				ans += "E";
			else if(temp == 15)
				ans += "F";
			else
				ans += temp;
			
		}
		
		return ans;
		
	}
	
	public static String conv(String s) {
		
		String ans = "";
		
        for(int i = 0; i < s.length(); i++) {
        	
            char c = s.charAt(i);
            
            if(c!='~')
                ans+="'"+c;
            else {
                ans+="~" + s.charAt(i+1);
                i++;
            }
        
        }
        
        return ans;
		
	}

}
