package Stempia.contest1;
//Erin Kim
//ABCobot Intermediate 5
//Contest 1



import java.util.*;
import java.io.*;

public class IN_NumberTransformation_Erin {
    static Scanner in;
    static int digit, solitary, calculation;
    static int [] numArray;
    static String [] temp;
    static String start, end;

    public static void main(String [] args) throws IOException{
        in = new Scanner(new File("contest1.in"));
        for(int x = 0; x < 5; x++) {
            try {
                init();
                solve();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("Error");
            }
        }
        in.close();
    }

    public static void init() {
        temp = in.next().split("");
        solitary = Integer.parseInt(in.next());
        numArray = new int[temp.length];
        start = "";
        end = "";
    }

    public static void solve() {
        for(int i = 0 ; i < temp.length; i++) {
            numArray[i] = Integer.parseInt(temp[i]);
        }
        int calculation = numArray.length - solitary;
        digit = numArray[calculation];
        for(int i = 0 ; i < calculation; i++) {
            start += (numArray[i] + digit) % 10 + "";
        }
        for(int i = calculation + 1; i < numArray.length; i++) {
            int sum = Math.abs(numArray[i] - digit);
            end += sum;
        }
        System.out.println(start + digit + end);
    }
}