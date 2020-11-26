package Contest1;
/*
Name: Nathan Kang
Grade: 8
2019-2020 ACSL Contest 1 Junior 5 Division
Team : North Hollywood High School
*/

import java.util.*;
import java.io.*;
public class C1JR_NumberTransformation_Nathan {
    static BufferedReader br;
    static int[] num;
    static int p;
    static int d;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(new File("1920C1Jr.in")));
        for(int i = 0; i < 5; i++) {
        	try {
        		init();
        		solve();
        	}
        	catch(Exception e) {
//        		e.printStackTrace(); //use while coding, comment out when submitting
        		System.out.println("error"); //use when submitted, comment out when coding
        	}
        }
        br.close();
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String s = st.nextToken();
    	num = new int[s.length() + 1];
    	for(int i = 1; i < num.length; i++)
    		num[i] = Integer.parseInt(s.substring(i - 1, i));
    	p = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    }
    private static void solve() {
    	int digit = num[num.length - p];
    	int newDigit = 0;
    	if(digit < 5) {
    		digit += d;
    		newDigit = digit % 10;
    	}
    	else {
    		digit -= d;
    		digit = Math.abs(digit);
    		newDigit = Integer.parseInt(String.valueOf(digit).substring(0, 1));
    	}
    	num[num.length - p] = newDigit;
    	for(int i = num.length - p + 1; i < num.length; i++)
    		num[i] = 0;
    	String s = "";
    	for(int i = 0; i < num.length; i++)
    		s += num[i];
    	System.out.println(Long.parseLong(s));
    }
}