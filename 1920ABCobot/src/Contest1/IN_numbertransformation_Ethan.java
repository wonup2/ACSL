package Contest1;
//Ethan Byeon Grade 11
//ABCobot Intermediate 5
//Contest 1

import java.util.*;
import java.io.*;

public class IN_numbertransformation_Ethan {
    static Scanner in;
    static String s;
    static int n;
    public static void main(String[] args) throws IOException {
        in = new Scanner(new File("contest1.in"));
        for(int i = 0; i < 5; i++) {
            try {
                init();
                System.out.print(i + 1 + ": ");
                solve();
            }catch(Exception e) {
                System.out.println("Error");
                e.printStackTrace();
            }
        }
        in.close();
    }

    static void init() {
        String[] a = (in.nextLine()).split(" ");
        s = a[0];
        n = Integer.parseInt(a[1]);
    }

    static String solve() {
        String num = "";
        int p = s.length() - n;
        int pdigit = Integer.parseInt(s.substring(p, p + 1));

        for(int i = 0; i < s.length(); i++){
            if(i < p){
                num += (Integer.parseInt(s.substring(i, i + 1)) + pdigit) % 10;
            }

            if(i == p){
                num += s.substring(p, p + 1);
            }

            if(i > p){
                num += Math.abs(Integer.parseInt(s.substring(i, i + 1)) - pdigit);
            }
        }
        System.out.println(num);
        return "";
    }
}