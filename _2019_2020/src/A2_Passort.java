import java.io.*;
import java.util.*;

class Result {

    public static char[] correct, arr;
    public static int n;

    public static int passort(String line) {

        line = line.replaceAll("[^A-Za-z0-9]", "");

        n = line.length();

        correct = line.toCharArray();
        Arrays.sort(correct);

        arr = line.toCharArray();

        int count = 0;

        while(!sorted()){

            swapSmallest();
            count++;

            if(sorted()) break;

            swapLargest();
            count++;
        }

        return count;
    }

    public static void swapSmallest(){
        int small = 0;
        for(int i = 0; i<n; i++){ //Find smallest character not in place
            if(arr[i]!=correct[i]){
                small = i;
                break;
            }
        }

        int repl = 0;
        for(int i = small+1; i<n; i++){ //First index where I can get correct[i]
            if(arr[i]==correct[small]){
                repl = i;
                break;
            }
        }

        char orig = arr[small];
        arr[small] = correct[small];
        arr[repl] = orig;
    }

    public static void swapLargest(){
        int large = n-1;
        for(int i = n-1; i>=0; i--){ //Find smallest character not in place
            if(arr[i]!=correct[i]){
                large = i;
                break;
            }
        }

        int repl = 0;
        for(int i = large-1; i>=0; i--){ //First index where I can get correct[i]
            if(arr[i]==correct[large]){
                repl = i;
                break;
            }
        }

        char orig = arr[large];
        arr[large] = correct[large];
        arr[repl] = orig;
    }

    public static boolean sorted(){
        for(int i = 0; i<n; i++){
            if(correct[i]!=arr[i]) {
                return false;
            }
        }
        return true;
    }

}

public class A2_Passort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      
        String line = bufferedReader.readLine();

        int result = Result.passort(line);
        System.out.println(result);       
        bufferedReader.close();
    }
}
