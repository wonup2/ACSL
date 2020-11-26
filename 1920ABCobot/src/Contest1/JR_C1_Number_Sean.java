package Contest1;
/*
 Name: Sean Kim
 Team: ABCobot
 Division: junior5
 Date: 12/5/2019
 */
import java.util.*;
import java.io.*;
public class JR_C1_Number_Sean {
    static Scanner in;
    static int[] N;
    static int P;
    static int D;
    static String ans;
    public static void main(String[] args)throws IOException{
        in = new Scanner(new File("c1jr.in"));
          for(int i=0; i<5; i++){
          try{
            init();
            solve();
          }
          catch(Exception e){
            e.printStackTrace();
            System.out.println("error");
          }
        }
    }
      private static void init(){
      String[] temp = in.nextLine().split(" ");
      //System.out.println(temp[0]);
        N = new int[temp[0].length()];
      for(int i = 0; i < temp[0].length(); i++) {
          N[i] = Integer.parseInt(temp[0].substring(i,i+1));
      }
      P = Integer.parseInt(temp[1]);
      D = Integer.parseInt(temp[2]);
     // System.out.println(Arrays.toString(N));
    }
      private static void solve(){
      if(N[N.length-P] >= 0 && (N[N.length-P] <= 4)){
          int temp = N[N.length-P] + D;
          String t = "" + temp;
          t = t.substring(t.length()-1);
          temp = Integer.parseInt(t);
          N[N.length-P] = temp;
      }else {
          int temp = Math.abs(N[N.length-P] - D);
          String t = "" + temp;
          t = t.substring(0,1);
          temp = Integer.parseInt(t);
          N[N.length-P] = temp;
      }
      for(int i = N.length-P+1; i < N.length; i++) {
          N[i] = 0;
      }
      ans = "";
      for(int i = 0; i < N.length; i++) {
          ans = ans + "" + N[i];
      }
      System.out.println(ans);
      }
}