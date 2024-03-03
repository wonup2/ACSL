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
     * Complete the 'decodeMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING text
     *  2. STRING message
     */

    public static String decodeMessage(String text, String message) {

        return "";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = bufferedReader.readLine();
        String message = bufferedReader.readLine();

        String result = Result.decodeMessage(text, message);
        
        System.out.println(result);
    }
}
