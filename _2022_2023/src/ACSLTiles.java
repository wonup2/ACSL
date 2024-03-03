import java.util.*;
import java.io.*;


public class ACSLTiles {

    static Scanner in;
    //static BufferedReader in;
    //static StringTokenizer st;
    static int n;
    static String s;
    
    
    static void init() {        
        n = in.nextInt(); in.nextLine();
        s = in.nextLine();
        
        //Scanner
        //n = Integer.parseInt(in.readLine());    //BufferedReader
    }
    
    
              
    
    public static void main(String[] args) throws IOException {
        
        in = new Scanner(System.in);
        //in = new BufferedReader(new InputStreamReader(System.in));
        
        init();
        int result = findDiscardSum(n, s);
        System.out.println(result);
        
        in.close();        
    }
    public static int findDiscardSum(int originalRows, String tiles) {
        int ans = 0;
        String[] row = String.valueOf(originalRows).split("");
        char[] tileArr;
        boolean dt = false;
        //for(int i = 0; i<row.length;i++){
       //     System.out.println(row[i]);
       // }
        
        
        for(int i=0; i<tiles.length(); i+=3){
            tileArr = tiles.substring(i, i+2).toCharArray();
            //System.out.print(tileArr[0] + " " + tileArr[1] + " ");
            if(tileArr[0] == tileArr[1]){
                dt = true;
            }
            for(int j=0; j<4; j++){
                if(tileArr[0] == row[j].charAt(row[j].length()-1)){
                    row[j] += tileArr[0] + tileArr[1];
                    break;
                }
                else if(tileArr[1]==row[j].charAt(row[j].length()-1)){
                    row[j] += tileArr[1] + tileArr[0];
                    break;
                }
                else{
                    ans += Character.getNumericValue(tileArr[0]) + Character.getNumericValue(tileArr[1]);              
                }
            }   
        }
        return ans;
    }
    public static String rotate(String row){
        return row.substring(1)+ row.charAt(0); // switch
    }
    
    
    static class pair implements Comparable<pair>{

        int a, b;
        
        pair(int x, int y){
            a = x; 
            b = y;
        }
        
        public String toString() {
            return a+" "+b;
        }
        @Override
        public int compareTo(pair that) {
            
            return this.a - that.a;    //sort by a
        }
        
    }
}