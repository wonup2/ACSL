import java.util.*;
import java.io.*;
public class _2018_2019 {
    static Scanner input;
    static String a1, a2, a3, a4, a5;
    public static void main(String[] args) throws IOException {
        try {
        init();
        solve();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void init() throws IOException {
        input = new Scanner(new File("_2018_2019.in"));
        a1 = input.next(); a2 = input.next(); a3 = input.next(); a4 = input.next(); a5 = input.next();
    }
    public static void solve() throws IOException {
        System.out.println(a1.length());
        int a2tot = 0;
        for(int count = 0; count < a2.length(); count ++) {
            a2tot += Character.getNumericValue(a2.charAt(count));
        }
        System.out.println(a2tot);
        int a3tot = 0;
        for(int count = 0; count < a3.length(); count ++) {
            if(count % 2 == 0) {
                a3tot += Character.getNumericValue(a3.charAt(count));
            }
        }
        System.out.println(a3tot);
        int a4c = 0;
        for(int count = 0; count < a4.length(); count ++) {
            if(a4.charAt(count) == '4') {
                a4c ++;
            }
        }
        System.out.println(a4c);
        System.out.println(a5.charAt(a5.length() / 2 + (a5.length() % 2) - 1));
    }

}