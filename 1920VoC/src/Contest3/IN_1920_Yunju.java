package Contest3;

import java.io.*;
import java.util.*;
/*
 Yunju Song
 10th grade
 Voice Of Calling
 intermediate
 */
public class IN_1920_Yunju {
	static Scanner in;
	static String[] line;
	static String[][] temp;
	static int[][] ans;
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("1920C3IN.in"));
		
		 for(int i=0; i<5; i++){
				try{			
					init();
					System.out.println(solve());			
				}
				catch(Exception e){
					//System.out.println("Error");
	                e.printStackTrace();
				}
	        }
		 
		 in.close();
	}
	static void init(){
		String t = in.nextLine();
		temp = new String[4][4];
		String input = "";
		ans = new int[4][4];
		String temps = "";
		
		input += " ";
		for(int i = 0; i < t.length(); i++){
			if(t.substring(i,i+1).equals("+")){
				input+= " ";
			}
			
			else input+= t.substring(i,i+1);
		}
		for(int i = 1; i < input.length(); i++){
			
			if(input.charAt(i-1)!='~'&&input.charAt(i)!='~' &&input.charAt(i)!=' '){
				temps+="*"+input.substring(i,i+1);
			}
			else temps += input.charAt(i);
		}
	//	System.out.println(input);

	
		line = temps.split(" ");
		
		//System.out.println(Arrays.toString(line));
		//System.out.println(input);
		
		temp[0][0] = "*A*B~C~D";
		temp[0][1] = "*A*B*C~D";
		temp[0][2] = "~A*B*C~D";
		temp[0][3] = "~A*B~C~D";
		
		temp[1][0] = "*A*B~C*D";
		temp[1][1] = "*A*B*C*D";
		temp[1][2] = "~A*B*C*D";
		temp[1][3] = "~A*B~C*D";
		
		temp[2][0] = "*A~B~C*D";
		temp[2][1] = "*A~B*C*D";
		temp[2][2] = "~A~B*C*D";
		temp[2][3] = "~A~B~C*D";
		
		temp[3][0] = "*A~B~C~D";
		temp[3][1] = "*A~B*C~D";
		temp[3][2] = "~A~B*C~D";
		temp[3][3] = "~A~B~C~D";
		
		
		
	}
	static String solve(){
		String result = "";
		
		
		for(int i = 0; i < line.length; i++){
			String a = line[i];
				
				for(int j = 0; j < 4; j++){
					for(int k = 0; k < 4; k++){
						boolean check = true;
						for(int l = 0; l < a.length()-1; l+=2){
							
							String b = ""+a.charAt(l)+a.charAt(l+1);
							
							if(!temp[j][k].contains(b)){
								check = false;
							}
							
						}
						if(check) ans[j][k] = 1;
					}
				}
			
			
			
		}
		
		String[] arr = new String[4];
		
		for(int i =0 ; i< 4; i++){
			arr[i] ="";
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				arr[i] += ""+ans[i][j];
			}
		}
		//System.out.println(Arrays.toString(arr));
		
		int[] decimal = new int[4];
		
		for(int i = 0; i < 4; i++){
			decimal[i] = Integer.parseInt(arr[i],2);
		}
		//System.out.println(Arrays.toString(decimal));
		
		for(int i = 0; i < 4; i++){
			result += ""+Integer.toHexString(decimal[i]);
			result = result.toUpperCase();
		}
		return result;
	}

}
