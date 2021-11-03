package Stempia.contest3;
//Roy Park 
//9th Grade
//ABCobot
//Junior

import java.util.*;
import java.io.*;
public class JR_Veitch_Roy {
	static Scanner in;
	static String[][] arr;
	static String s, a, b, str;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c3jr.in"));
		try {
			for(int i = 0;i<5;i++) {
				init();
				solve();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void init() {
		s = in.nextLine();
		a = s.charAt(0)+"";
		b= s.charAt(1)+"";
		arr = new String[2][4];
		Arrays.fill(arr[0], "0");
		Arrays.fill(arr[1], "0");
		str = "";
	}
	public static void solve() {
		String x = convertBin(a);
		String y = convertBin(b);
		for(int i = 0;i<4;i++) {
			arr[0][i] = x.charAt(i)+"";
			arr[1][i] = y.charAt(i)+"";
		}
		four();
		two();
		one();
		str = str.substring(0, str.length()-2);
		System.out.println(str);
		
	}
	public static String convertBin(String hex) {
		int dec = Integer.parseInt(hex, 16);
		String bin = Integer.toBinaryString(dec);
		if(bin.length()==1) bin = "000"+bin;
		else if(bin.length()==2) bin = "00"+bin;
		else if(bin.length()==3) bin = "0"+bin;
		return bin;
	}
	public static void four() {
		if(arr[0][0].equals("1")&&arr[0][1].equals("1")&&arr[0][2].equals("1")&&arr[0][3].equals("1")) {
			str+="B + ";
			arr[0][0] = "0";
			arr[0][1] = "0";
			arr[0][2] = "0";
			arr[0][3] = "0";
		}
		if(arr[1][0].equals("1")&&arr[1][1].equals("1")&&arr[1][2].equals("1")&&arr[1][3].equals("1")) {
			str+="~B + ";
			arr[1][0] = "0";
			arr[1][1] = "0";
			arr[1][2] = "0";
			arr[1][3] = "0";
		}
		if(arr[0][0].equals("1")&&arr[0][1].equals("1")&&arr[1][0].equals("1")&&arr[1][1].equals("1")) {
			str +="A + ";
			arr[0][0] = "0";
			arr[0][1] = "0";
			arr[1][0] = "0";
			arr[1][1] = "0";
		}
		if(arr[0][1].equals("1")&&arr[0][2].equals("1")&&arr[1][1].equals("1")&&arr[1][2].equals("1")) {
			str += "C + ";
			arr[0][1] = "0";
			arr[0][2] = "0";
			arr[1][1] = "0";
			arr[1][2] = "0";
		}
		if(arr[0][2].equals("1")&&arr[0][3].equals("1")&&arr[1][2].equals("1")&&arr[1][3].equals("1")) {
			str+="~A + ";
			arr[0][2] = "0";
			arr[0][3] = "0";
			arr[1][2] = "0";
			arr[1][3] = "0";
		}
	
		if(arr[0][0].equals("1")&&arr[1][0].equals("1")&&arr[0][3].equals("1")&&arr[1][3].equals("1")) {
			str+="~C + ";
			arr[0][0] = "0";
			arr[1][0] = "0";
			arr[0][3] = "0";
			arr[1][3] = "0";
		}
	}
	public static void two() {
		if(arr[0][0].equals("1")&&arr[0][1].equals("1")) {
			str+="AB + ";
			arr[0][0] = "0";
			arr[0][1] = "0";
		}
		if(arr[0][1].equals("1")&&arr[0][2].equals("1")) {
			str+="BC + ";
			arr[0][1] = "0";
			arr[0][2] = "0";
		}
		if(arr[0][2].equals("1")&&arr[0][3].equals("1")) {
			str+="~AB + ";
			arr[0][2] = "0";
			arr[0][3] = "0";
		}
		if(arr[1][0].equals("1")&&arr[1][1].equals("1")) {
			str+="A~B + ";
			arr[1][0] = "0";
			arr[1][1] = "0";
		}
		if(arr[1][1].equals("1")&&arr[1][2].equals("1")) {
			str+="~BC + ";
			arr[1][1] = "0";
			arr[1][2] = "0";
		}
		if(arr[1][2].equals("1")&&arr[1][3].equals("1")) {
			str+="~A~B + ";
			arr[1][2] = "0";
			arr[1][3] = "0";
		}
		if(arr[0][0].equals("1")&&arr[1][0].equals("1")) {
			str+="A~C + ";
			arr[0][0] = "0";
			arr[1][0] = "0";
		}
		if(arr[0][1].equals("1")&&arr[1][1].equals("1")) {
			str+="AC + ";
			arr[0][1] = "0";
			arr[1][1] = "0";
		}
		if(arr[0][2].equals("1")&&arr[1][2].equals("1")) {
			str+="~AC + ";
			arr[0][2] = "0";
			arr[1][2] = "0";
		}
		if(arr[0][3].equals("1")&&arr[1][3].equals("1")) {
			str+="~A~C + ";
			arr[0][3] = "0";
			arr[1][3] = "0";
		}
		if(arr[0][0].equals("1")&&arr[0][3].equals("1")) {
			str+="B~C + ";
			arr[0][0] = "0";
			arr[0][3] = "0";
		}
		if(arr[1][0].equals("1")&&arr[1][3].equals("1")) {
			str+="~B~C + ";
			arr[1][0] = "0";
			arr[1][3] = "0";
		}

	}
	public static void one() {
		if(arr[0][0].equals("1")) {
			str+="AB~C + ";
			arr[0][0] = "0";
		}
		if(arr[0][1].equals("1")) {
			str+="ABC + ";
			arr[0][1] = "0";
		}
		if(arr[0][2].equals("1")) {
			str+="~ABC + ";
			arr[0][2] = "0";
		}
		if(arr[0][3].equals("1")) {
			str+="~AB~C + ";
			arr[0][3] = "0";
		}
		if(arr[1][0].equals("1")) {
			str+="A~B~C + ";
			arr[1][0] = "0";
		}
		if(arr[1][1].equals("1")) {
			str+="A~BC + ";
			arr[1][1] = "0";
		}
		if(arr[1][2].equals("1")) {
			str+="~A~BC + ";
			arr[1][2] = "0";
		}
		if(arr[1][3].equals("1")) {
			str+="~A~B~C + ";
			arr[1][3] = "0";
		}
	}
}
