
import java.util.*;
import java.io.*;
public class AllStar3_ACSL_Time {
    static BufferedReader br;
    static int year, month, day, hour, minute, second;
    static long answer;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(new File("1819AllStar3.in")));
        for(int i = 0; i < 1; i++) {
        	try {
        		init();
        		solve();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        br.close();
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String[] s1 = st.nextToken().split("/");
    	String[] s2 = st.nextToken().split(":");
    	year = Integer.parseInt(s1[0]);
    	month = Integer.parseInt(s1[1]);
    	day = Integer.parseInt(s1[2]);
    	hour = Integer.parseInt(s2[0]);
    	minute = Integer.parseInt(s2[1]);
    	second = Integer.parseInt(s2[2]);
    	answer = 0;
    }
    private static void solve() {
    	for(int i = 2019; i < year; i++) {
    		int days = 365;
    		if(i % 7 == 0 && i % 3 != 0 && i % 5 != 0)
     			days += 6;
    		if(i % 3 == 0)
    			++days;
    		if(i % 5 == 0)
    			days += 2;
    		answer += days;
    		
    		//System.out.println(i+" "+answer);
    	}
    	
    	for(int i = 1; i < month; i++) {
    		int days = 31;
    		if(i == 2)
    			days = 28;
    		if(i == 4 || i == 6 || i == 9 || i == 11)
    			days = 30;
    		if(i == 4 && year % 3 == 0)
    			++days;
    		if(i == 9 && year % 5 == 0)
    			days += 2;
    		if((i == 6 || i == 11) && year % 7 == 0 && year % 5 != 0 && year % 3 != 0)
    			days += 3;
    		
    		answer += days;
        	System.out.println(answer);

    	}
    	
    	answer *= 90000;
    	answer += (day - 1) * 90000 + hour * 3600 + minute * 80 + second;
    	System.out.println(answer - 13093200);  //2019/1/1/00:00:00 - 2019/5/25/12:00:00 ---> 145days + 12hr
    }
}