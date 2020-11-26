package Contest1;
/*
Julia M. Jung
10th grade
Voice of Calling
Contest 1 Intermediate 3
*/



import java.util.*;
import java.io.*;
public class IN_transformation_Julia {

    static Scanner in;
    static String N, ans;
    static int P, pval;
    static int[] n;

    public static void main(String[] args) throws IOException {

        in = new Scanner(new File("1920c1in.in"));

        for(int i =0; i < 5; i++) {
            try {
                init();
                solve();
            }catch(Exception e) {
                e.printStackTrace();
                System.out.println("error");
            }
        }
        in.close();
    }

    static private void init() {
        N = in.next();
        P = in.nextInt();
        n = new int[N.length()];


        for(int i =0; i < N.length(); i++) {
            n[i] =Integer.parseInt(N.substring(i, i+1));
        }

        pval = n[n.length-P];

    }

    static private void solve() {
        boolean chk = false;
        // false = before Pth 
        // true = after Pth

        for(int i =0; i < N.length(); i++) {
            if(i == n.length-P) {
                chk = true;
                System.out.print(n[i]);
                continue;
            }
            if(!chk) {
                if(pval + n[i] <10) 
                    n[i] = pval+n[i];
                else 
                    n[i] = (pval+n[i])%10;
            }else {
                n[i] = Math.abs(pval- n[i]);
            }

            System.out.print(n[i]);
        }

        System.out.println("");

    }

}