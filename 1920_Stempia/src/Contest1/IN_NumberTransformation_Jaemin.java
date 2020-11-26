package Contest1;
/*
Name: Jaemin Choi 
Grade: 10
Team: Stempia 
Division: Intermediate 5
Contest 1
*/
import java.io.File;
import java.io.IOException;
import java.util.*;

public class IN_NumberTransformation_Jaemin {

public static void main(String[] args) throws IOException{
Scanner in = new Scanner(new File("1920c1in.in"));
for(int i = 0; i < 5; i++) {
String n = in.next();
int p = in.nextInt();


//get integer that is 'p' from the right
char a = n.charAt(n.length() - p);
int index = n.indexOf(a);
int ind = Integer.parseInt(String.valueOf(a));
//System.out.println(index);

//add
for(int j = 0; j < n.length() - p; j++) {
char b = n.charAt(j);
int addi = Integer.parseInt(String.valueOf(b));
int total = (ind + addi)%10;

System.out.print(total);
}
System.out.print(a);
//subtract
for(int k = n.length() - p+1; k < n.length(); k++) {
char b = n.charAt(k);
int addi = Integer.parseInt(String.valueOf(b));
int total = Math.abs(ind-addi);

System.out.print(total);
}

System.out.println();

}

}

}

