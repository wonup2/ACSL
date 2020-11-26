package Contest1;
/*
Name: Julian Ha
Grade: 11
Team: Stempia 
Division: Senior 3
Contest 1
*/

import java.util.*;
import java.io.*;
public class SR_Contest1 {

    static Scanner in;
    static String n;
    static int p;
    static int val;
    static String ans;

    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("1920c1sr.in"));
        for(int i=0; i<5; i++) {
	        try {
	            init();
	            solve();            
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
        }
    }

    public static void init() {
        n = in.next();
        p = in.nextInt();
        val = Integer.parseInt(n.charAt(n.length() - p) + "");
        ans = "";
    }

    public static void solve() {

        Set<Integer> factors = new HashSet<Integer>();

        for (int i = 0; i < (n.length() - p); i++) {
            ans += (Integer.parseInt(String.valueOf(n.charAt(i))) + val);
        }

        long temp = Long.parseLong(n);
        for (int i = 2; i < temp / i; i++) {
            while (temp % i == 0) {
                factors.add(i);
                temp /= i;
            }
        }

        if (temp > 2)
            factors.add((int)temp);

        ans += factors.size();

        for (int i = (n.length() - p) + 1; i < n.length(); i++) {
            ans += Math.abs(Integer.parseInt(n.charAt(i) + "") - val);
        }
        System.out.println(ans);
    }

}