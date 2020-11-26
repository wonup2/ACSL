import java.io.*;
import java.util.*;
public class string {

    static Scanner in;
    static PrintWriter out;
    static String hayley;
    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {

        try {
            in = new Scanner(System.in);
            out = new PrintWriter(new File("string.out"));

            init();
            solve();

            for(int i =0; i < list.size(); i++) {
                list.get(i);
            }

            in.close();
            out.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    static private void init() {
        hayley = in.nextLine();
    }

    static private void solve() {
        int count =1;
        for(int i =0; i < hayley.length(); i++) {

            String temp = "";

            for(int j =0; j < hayley.length(); j++) {
                if(j+count <= hayley.length())
                temp += hayley.substring(j, j + count)+ " ";

            }
            System.out.println(temp);
            count++;
            list.add(temp);

        }
    }

}