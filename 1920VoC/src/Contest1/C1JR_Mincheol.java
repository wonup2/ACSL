package Contest1;
/*
Name: Mincheol Song
Grade: 9
2019-2020 ACSL Contest 1 Junior 5 Division
Team : North Hollywood High School
*/

import java.io.*;
import java.util.*;

public class C1JR_Mincheol {

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("1920C1jr.in"));

        for(int i=0; i<5;i++) {
            String input = in.next();
            int p = in.nextInt();
            int d = in.nextInt();

            String s1 = "";
            for(int j = 0; j<input.length()-p; j++) {
                s1 += input.charAt(j);
            }

            if(input.charAt(input.length()-p)=='0' || input.charAt(input.length()-p)=='1' || input.charAt(input.length()-p)=='2' || input.charAt(input.length()-p)=='3' || input.charAt(input.length()-p)=='4') {
                s1+= ((input.charAt(input.length()-p)-'0'+d) + "").charAt(0) ;
            }
            else {
                s1+= ((Math.abs(input.charAt(input.length()-p)-'0'-d))+"").charAt(0);
            }
            
            String str = s1;
            for(int l=input.length()-p; l<input.length()-1;l++) {
                str +='0';
            }
            
            System.out.println(str);
        }
    }
}


