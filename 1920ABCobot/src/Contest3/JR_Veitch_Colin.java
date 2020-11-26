package Contest3;
/*
 * Name: Colin Kwon
 * Grade: 9th
 * Team: ABCobot
 * Division: Junior
 * Contest 3
 */

import java.util.*;
import java.io.*;

public class JR_Veitch_Colin {
static Scanner in;
static String s;
static char[] grid;
public static void main(String[] args) throws IOException {

in = new Scanner(new File("1920C3JR.in"));

for(int i=0; i<5; i++) {
try {
init();
solve();
}
catch(Exception e) {
System.out.println("Error");
e.printStackTrace();
}
}
in.close();
}

static void init() {
s = in.nextLine();
int num = Integer.parseInt(s, 16);
String bin = Integer.toBinaryString(num);
bin = String.format("%8s", bin).replace(" ", "0");
grid = new char[8];
for(int j = 0; j < 8; j++) {
grid[j] = bin.charAt(j);
}
}

static void solve() {
String ans = "";
//4 square
if(grid[0] == '1' && grid[1] == '1' && grid[4] == '1' && grid[5] == '1') {
grid[0] = '0';
grid[1] = '0';
grid[4] = '0';
grid[5] = '0';
ans += "A+";
}
if(grid[1] == '1' && grid[2] == '1'&& grid[5] == '1' && grid[6] == '1') {
grid[1] = '0';
grid[2] = '0';
grid[5] = '0';
grid[6] = '0';
ans += "C+";
}

if(grid[2] == '1' && grid[3] == '1' && grid[6] == '1' && grid[7] == '1') {
grid[2] = '0';
grid[3] = '0';
grid[6] = '0';
grid[7] = '0';
ans += "~A+";
}
//four across
if(grid[0] == '1' && grid[1] == '1' && grid[2] == '1' && grid[3] == '1') {
grid[0] = '0';
grid[1] = '0';
grid[2] = '0';
grid[3] = '0';
ans += "B+";
}
if(grid[4] == '1' && grid[5] == '1' && grid[6] == '1' && grid[7] == '1') {
grid[4] = '0';
grid[5] = '0';
grid[6] = '0';
grid[7] = '0';
ans += "B~+";
}
//four split
if(grid[0] == '1' && grid[4] == '1' && grid[3] == '1' && grid[7] == '1') {
grid[0] = '0';
grid[4] = '0';
grid[3] = '0';
grid[7] = '0';
ans += "~C+";
}
//two top across
if(grid[0] == '1' && grid[1] == '1') {
grid[0] = '0';
grid[1] = '0';
ans += "AB+";
}
if(grid[1] == '1' && grid[2] == '1') {
grid[1] = '0';
grid[2] = '0';
ans += "BC+";
}
if(grid[2] == '1' && grid[3] == '1') {
grid[2] = '0';
grid[3] = '0';
ans += "~AB+";
}
//two bottom across
if(grid[4] == '1' && grid[5] == '1') {
grid[5] = '0';
grid[4] = '0';
ans += "A~B+";
}
if(grid[5] == '1' && grid[6] == '1') {
grid[5] = '0';
grid[6] = '0';
ans += "~BC+";
}
if(grid[6] == '1' && grid[7] == '1') {
grid[6] = '0';
grid[7] = '0';
ans += "~A~B+";
}
//two vertical
if(grid[0] == '1' && grid[4] == '1') {
grid[0] = '0';
grid[4] = '0';
ans += "A~C+";
}
if(grid[1] == '1' && grid[5] == '1') {
grid[1] = '0';
grid[5] = '0';
ans += "AC+";
}
if(grid[2] == '1' && grid[6] == '1') {
grid[2] = '0';
grid[6] = '0';
ans += "~AC+";
}
if(grid[3] == '1' && grid[7] == '1') {
grid[3] = '0';
grid[7] = '0';
ans += "~A~C+";
}
//two split
if(grid[3] == '1' && grid[0] == '1') {
grid[3] = '0';
grid[0] = '0';
ans += "B~C+";
}
if(grid[4] == '1' && grid[7] == '1') {
grid[7] = '0';
grid[4] = '0';
ans += "~B~C+";
}
//one
if(grid[0] == '1') {
grid[0] = '0';
ans += "AB~C+";
}
if(grid[1] == '1') {
grid[1] = '0';
ans += "ABC+";
}
if(grid[2] == '1') {
grid[2] = '0';
ans += "~ABC+";
}
if(grid[3] == '1') {
grid[3] = '0';
ans += "~AB~C+";
}
if(grid[4] == '1') {
grid[4] = '0';
ans += "A~B~C+";
}
if(grid[5] == '1') {
grid[5] = '0';
ans += "A~BC+";
}
if(grid[6] == '1') {
grid[6] = '0';
ans += "~A~BC+";
}
if(grid[7] == '1') {
grid[7] = '0';
ans += "~A~B~C+";
}
ans = ans.substring(0,ans.length()-1);
System.out.println(ans);

}
}
