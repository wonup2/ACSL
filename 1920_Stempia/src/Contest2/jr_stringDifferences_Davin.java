package Contest2;
/*
Davin Jeong 9
2019-2020 ACSL Contest 2 Junior Division
Stempia
*/
import java.io.*;
import java.util.*;

public class jr_stringDifferences_Davin {
    static BufferedReader in;
    static String first, second;

    public static void main(String[] args) throws IOException{
        in = new BufferedReader(new FileReader("1920c2jr.in"));

        for(int z=0; z<5; z++) {
            try {
                input();
                solve();

            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        in.close();
    }

    public static void solve(){
        first = one(first);
        second = one(second);
        first = two(first);
        second = two(second);
        three();
        four();
        System.out.println(mostValuable());
    }

    public static String one(String a){
        char[] arr = a.toCharArray();
        String res = "";
        for(int i = 0; i<a.length()-1; i++){
            if(arr[i]==arr[i+1] && !isVowel(arr[i])) i++;
            res+=arr[i];
        }
        if(!(arr[a.length()-2]==arr[a.length()-2+1] && !isVowel(arr[a.length()-2]))) res+=arr[a.length()-1];
        return res;
    }

    public static String two(String a){
        char[] arr = a.toCharArray();
        String res = arr[0]+"";
        for(int i = 1; i<a.length(); i++){
            if(!isVowel(arr[i])) {
                res+=arr[i];
            }
        }
        return res;
    }

    public static boolean isVowel(char a){
        if(a=='A' || (a=='E' || (a=='I' || (a=='O' || a=='U')))) return true;
        else return false;
    }

    public static void three (){
        String res1 = "";
        String res2 = "";

        int min = Math.min(first.length(), second.length());

        char[] a = first.toCharArray();
        char[] b = second.toCharArray();

        for(int i = 0; i<min; i++){
            if(a[i] !=b[i]){
                res1+=a[i];
                res2+=b[i];
            }
        }

        res1+=first.substring(min, first.length());
        res2+=second.substring(min, second.length());

        first = res1;
        second = res2;
        return;
    }

    public static void four(){
        String res1 = "";
        String res2 = "";

        int min = Math.min(first.length(), second.length());

        char[] a = first.toCharArray();
        int aLen = a.length;
        char[] b = second.toCharArray();
        int bLen = b.length;

        for(int i = 1 ; i<=min; i++){
            if(a[aLen-i] != b[bLen-i]){
                res1 = a[aLen-i] + res1;
                res2 = b[bLen-i] + res2;
            }
        }

        for(int i = 0; i<aLen-min; i++){
            res1=a[i]+res1;
        }
        for(int i = 0; i<bLen-min; i++){
            res2=b[i]+res2;
        }

        first = res1;
        second = res2;
        return;
    }

    public static String mostValuable(){
        if(first.length()<second.length()) return first;
        else if(first.length()>second.length()) return second;
        else{
            if(first.compareTo(second)>0) return second;
            else return first;
        }
    }

    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        first = st.nextToken();
        second = st.nextToken();

    }
}
