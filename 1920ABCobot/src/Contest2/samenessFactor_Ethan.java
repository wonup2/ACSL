package Contest2;

/*
    Name: Ethan Byeon
    Grade: 11
    Team: Stempia
    Division: Intermediate
    Contest 2
*/

import java.util.*;
import java.io.*;

public class samenessFactor_Ethan {

    static Scanner in;    
    static ArrayList f, s;

    public static void main(String[] args) throws IOException{
        
        in = new Scanner(new File("1920C2IN.in"));
        
        solve();

        in.close();
    }

    static void solve() {

        while(in.hasNextLine()) {
            String[] split = (in.nextLine()).split(" ");

            f = new ArrayList<String>();
            s = new ArrayList<String>();

            for(int i = 0; i < split[0].length(); i++) {
                f.add(split[0].charAt(i));
            }

            for(int i = 0; i < split[1].length(); i++) {
                s.add(split[1].charAt(i));
            }

            while(true) {
                remove();
                if(!(shift())) break;
            }
            System.out.println(calc(f, s));
        }
    }

    static void remove() {
        
        for(int i = 0; i < Math.min(f.size(), s.size()); i++) {
            if(f.get(i) == s.get(i)) {
                f.remove(i);
                s.remove(i);
                i = -1;
            }
        }
        
    }

    static boolean shift() {

        for(int i = 0; i < Math.min(f.size(), s.size()) - 1; i++) {
            if(f.get(i) == s.get(i + 1)){
                s.remove(i);
                return true;
            }else if(s.get(i) == f.get(i + 1)) {
                f.remove(i);
                return true;
            }
        }

        return false;
    }

    static int calc(ArrayList<String> a, ArrayList<String> b) {

        int total = 0;

        String x = "";
        String y = "";

        for(int i = 0; i < a.size(); i++) {
            x += String.valueOf(a.get(i));
        }
        
        for(int i = 0; i < b.size(); i++) {
            y += String.valueOf(b.get(i));
        }

        if(x.length() <= y.length()) {
            for(int i = 0; i < x.length(); i++){
                char c = x.charAt(i);
                char n = y.charAt(i);
                total += c - n;
            }
            
            int diff = y.length() - x.length();
            total += diff;

        } else if(x.length() >= y.length()) {
            for(int i = 0; i < y.length(); i++){
                char c = x.charAt(i);
                char n = y.charAt(i);
                total += c - n;
            }
            
            int diff = x.length() - y.length();
            total += diff;
        }

        return total; 
    }
    
}