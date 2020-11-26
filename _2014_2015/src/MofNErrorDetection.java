
//package _201415;

import java.io.*;
import java.util.*;
public class MofNErrorDetection {

    public static int n, num;
    public static String mask;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(int z = 0; z<10; z++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            mask = st.nextToken();
            num = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            n = mask.length();
            int cap = (int)Math.pow(2, n);

            ArrayList<String> works = new ArrayList<String>();

            for(int a = 0; a<cap; a++){
                String binaryRep = toBinary(a);
                if(correctCount(binaryRep)){
                    int sum = useMask(binaryRep);
                    if(sum==k) works.add(binaryRep);
                }
            }

            if(works.size()==0){
                System.out.println("NONE");
            }
            else{
                String line = works.toString();
                int m = line.length();
                System.out.println(line.substring(1, m-1));
            }
        }
    }

    public static int useMask(String binaryRep){
        int sum = 0;
        for(int i = 0; i<n; i++){
            if(binaryRep.charAt(i)=='1'){
                sum+=mask.charAt(i)-'0';
            }
        }
        return sum;
    }

    public static String toBinary(int a){
        String tmp = Integer.toBinaryString(a);
        while(tmp.length()<n) tmp="0"+tmp;
        return tmp;
    }

    public static boolean correctCount(String binaryRep){
        int count = 0;
        for(int i = 0; i<n; i++){
            if(binaryRep.charAt(i)=='1'){
                count++;
            }
        }
        if(count==num) return true;
        return false;
    }
}
/*
Sample Input:
01236 2 8
01247 2 5
0012345 2 9
001234 3 6
12345 2 4
01236 2 0
01247 2 7
0012345 2 1
001234 3 3
12345 2 0

Test Output:
001248 3 7
001245 3 8
001236 2 2
001226 3 9
12345 2 5
001248 3 0
001245 3 5
001236 2 6
001226 3 0
012345 2 5
 */
