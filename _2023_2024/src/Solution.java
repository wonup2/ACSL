import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'play2248' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING boardValues
     *  2. STRING pathValues
     */

    public static String play2248(String boardValues, String pathValues) {
        int[][] array = new int[8][5];
        int height = 0;
        int length = 0;
        int[] arr = new int[40];
        StringTokenizer st1 = new StringTokenizer(boardValues, " ");
        int i=0;
        while (st1.hasMoreTokens()){
            arr[i] = Integer.parseInt(st1.nextToken()); 
            i++; 
        }
        
        System.out.println(Arrays.toString(arr));
        for(i = 0; i < 40; i++){
            if(i%5 == 0 && i != 0){
                height++;
                length = 0;
            }
            array[height][length] = arr[i];
        }
        
        st1 = new StringTokenizer(pathValues, " ");
        int pathLength = (pathValues.length()+1)/3;  System.out.println(pathLength);
        int[] path = new int[pathLength];
        
        i = 0;
        while (st1.hasMoreTokens()){
            path[i++] = Integer.parseInt(st1.nextToken());
        }
                
        System.out.println(Arrays.toString(path));
        
        int total = 0;
        for(i = 0; i < pathLength; i++){        	
            int x = path[i]/10 - 1;
            int y = path[i]%10 - 1;
            total += array[x][y];
            if(i-1 == pathLength){
                
                 array[x][y] = (int)(Math.log(total) / Math.log(2));
            }
            array[x][y] = 0;
        }
        
        for(i = 7; i > 8; i--){
            for(int j = 4; j>0;j--){
                if(array[i][j] == 0){
                    for(int k = i; k > 1; k--){
                        array[k][j] = array[k-1][j];
                        array[k-1][j] = 0;
                    }
                }
            }
        }
        String answer = "";
        int track = 0; 
        int[] trackArray = {256, 128, 64, 32, 16, 4, 2};
        for(i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){
                if(array[i][j] == 0){
                    array[i][j] = trackArray[track%7];
                    answer += array[i][j] + " ";
                }
            }
        }
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String boardValues = bufferedReader.readLine();

        String pathValues = bufferedReader.readLine();

        String result = Result.play2248(boardValues, pathValues);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

/*

4 128 4 128 32 16 16 4 256 16 32 4 16 64 4 8 64 64 256 8 16 2 2 256 4 32 128 2 64 8 256 32 128 16 2 8 32 32 4 32
13 23 32 41 51 61 72 82 83


*/