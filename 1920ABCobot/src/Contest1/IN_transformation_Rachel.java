package Contest1;
//Rachel Lee
//ABCobot Intermediate 5
//Contest 1


import java.io.*;
import java.util.*;
public class IN_transformation_Rachel { 

    static Scanner in;
    static String input[];
    static String str;
    static int n;
    static int temp;
    static String [] bigNum;
    static int value;
    static int absolute;

    public static void main(String [] args) throws IOException{
        in = new Scanner(new File("Contest1.in"));

        for(int i = 0; i < 5; i++) {
            try {
                init();
                solve();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        in.close();
    }
    private static void init() {
        input = in.nextLine().split(" ");
        n = Integer.parseInt(input[1]);
        str = input[0];
        bigNum = str.split("");
    }
    private static void solve() {
        int difference = str.length()-n;
        int theNum = Integer.parseInt(str.substring(difference, difference+1));

        for(int i = 0; i < difference; i++) {
            value =Integer.parseInt(bigNum[i]);
            value+=theNum;
            if(value>9) {
                bigNum[i]=Integer.toString(value%10);
            }else {
                bigNum[i] = Integer.toString(value);
            }
        }
        for(int i = difference+1; i < bigNum.length; i++) {
            temp = Integer.parseInt(bigNum[i]);
            absolute = temp - theNum;
            bigNum[i] = Integer.toString(Math.abs(absolute));
        }
        for(int i = 0; i < bigNum.length; i++) {
            System.out.print(bigNum[i]);
        }
        System.out.println();
    }
}