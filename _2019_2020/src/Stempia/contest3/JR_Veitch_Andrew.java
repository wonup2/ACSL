package Stempia.contest3;
//Andrew Kim 9th Grade
//ABCobot
//Contest 3 Junior

import java.io.*;
import java.util.Scanner;

public class JR_Veitch_Andrew {
static Scanner in;
static char a[][];
static String input;
static String ans;

public static void main (String args[]) throws IOException {
in = new Scanner(new File("1920c3jr.in"));
for(int gLoop = 0; gLoop < 5; gLoop++) {
init();
solve();
}
}

public static void init() {
ans = "";
a = new char[2][];
input = in.next();
a[0] = conv(input.charAt(0)).toCharArray();
a[1] = conv(input.charAt(1)).toCharArray();
}

public static String conv(char c) {
if(c == '0') return "0000";
else if(c == '1') return "0001";
else if(c == '2') return "0010";
else if(c == '3') return "0011";
else if(c == '4') return "0100";
else if(c == '5') return "0101";
else if(c == '6') return "0110";
else if(c == '7') return "0111";
else if(c == '8') return "1000";
else if(c == '9') return "1001";
else if(c == 'A') return "1010";
else if(c == 'B') return "1011";
else if(c == 'C') return "1100";
else if(c == 'D') return "1101";
else if(c == 'E') return "1110";
else return "1111";
}

public static void solve() {
//Group 4
if(a[0][0] == '1' && a[0][1] == '1' && a[1][0] == '1' && a[1][1] == '1') {
ans += "A + ";
a[0][0] = '0';
a[0][1] = '0';
a[1][0] = '0';
a[1][1] = '0';
}

if(a[0][1] == '1' && a[0][2] == '1' && a[1][1] == '1' && a[1][2] == '1') {
ans += "C + ";
a[0][1] = '0';
a[0][2] = '0';
a[1][1] = '0';
   a[1][2] = '0';
}

   if(a[0][2] == '1' && a[0][3] == '1' && a[1][2] == '1' && a[1][3] == '1') {
ans += "~A + ";
   a[0][2] = '0';
   a[0][3] = '0';
   a[1][2] = '0';
   a[1][3] = '0';
   }
   
   if(a[0][0] == '1' && a[0][1] == '1' && a[0][2] == '1' && a[0][3] == '1') {
ans += "B + ";
a[0][0] = '0';
a[0][1] = '0';
a[0][2] = '0';
   a[0][3] = '0';
   }
   
   if(a[1][0] == '1' && a[1][1] == '1' && a[1][2] == '1' && a[1][3] == '1') {
ans += "~B + ";
a[1][0] = '0';
a[1][1] = '0';
a[1][2] = '0';
   a[1][3] = '0';
   }
   
   if(a[0][0] == '1' && a[1][0] == '1' && a[0][3] == '1' && a[1][3] == '1') {
    ans += "~C + ";
a[0][0] = '0';
a[1][0] = '0';
a[0][3] = '0';
   a[1][3] = '0';
   }
   
   //Group 2
   
   if(a[0][0] == '1' && a[0][1] == '1') {
    ans += "AB + ";
    a[0][0] = '0';
    a[0][1] = '0';
   }
   
   if(a[0][1] == '1' && a[0][2] == '1') {
    ans += "BC + ";
    a[0][1] = '0';
    a[0][2] = '0';
   }
   
   if(a[0][2] == '1' && a[0][3] == '1') {
    ans += "~AB + ";
    a[0][2] = '0';
    a[0][3] = '0';
   }
   
   if(a[1][0] == '1' && a[1][1] == '1') {
    ans += "A~B + ";
    a[1][0] = '0';
    a[1][1] = '0';
   }
   
   if(a[1][1] == '1' && a[1][2] == '1') {
    ans += "~BC + ";
    a[1][1] = '0';
    a[1][2] = '0';
   }
   
   if(a[1][2] == '1' && a[1][3] == '1') {
    ans += "~A~B + ";
    a[1][2] = '0';
    a[1][3] = '0';
   }
   
   if(a[0][0] == '1' && a[1][0] == '1') {
    ans += "A~C + ";
    a[0][0] = '0';
    a[1][0] = '0';
   }
   
   if(a[0][1] == '1' && a[1][1] == '1') {
    ans += "AC + ";
    a[0][1] = '0';
    a[1][1] = '0';
   }
   
   if(a[0][2] == '1' && a[1][2] == '1') {
    ans += "~AC + ";
    a[0][2] = '0';
    a[1][2] = '0';
   }
   
   if(a[0][3] == '1' && a[1][3] == '1') {
    ans += "~A~C + ";
    a[0][3] = '0';
    a[1][3] = '0';
   }
   
   if(a[0][0] == '1' && a[0][3] == '1') {
    ans += "B~C + ";
    a[0][0] = '0';
    a[0][3] = '0';
   }
   
   if(a[1][0] == '1' && a[1][3] == '1') {
    ans += "~B~C + ";
    a[1][0] = '0';
    a[1][3] = '0';
   }
   
   //Group 1
   if(a[0][0] == '1') {
    ans += "AB~C + ";
    a[0][0] = '0';
   }
   
   if(a[0][1] == '1') {
    ans += "ABC + ";
    a[0][1] = '0';
}
   
   if(a[0][2] == '1') {
    ans += "~ABC + ";
    a[0][2] = '0';
   }
   
   if(a[0][3] == '1') {
    ans += "~AB~C + ";
    a[0][3] = '0';
   }
   
   if(a[1][0] == '1') {
    ans += "A~B~C + ";
    a[1][0] = '0';
   }
   
   if(a[1][1] == '1') {
    ans += "A~BC + ";
    a[1][1] = '0';
}
   
   if(a[1][2] == '1') {
    ans += "~A~BC + ";
    a[1][2] = '0';
   }
   
   if(a[1][3] == '1') {
    ans += "~A~B~C + ";
    a[1][3] = '0';
   }
   
   ans = ans.substring(0, ans.length()-3);
System.out.println(ans);
}
}
