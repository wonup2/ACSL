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

class Result1 {

    public static String onlyLeftOrRight(String input) {
        ArrayList<String> chars=new ArrayList<>();
        ArrayList<Integer> nums=new ArrayList<>();
        ArrayList<Integer> none=new ArrayList<>();
        ArrayList<Integer> ntwo=new ArrayList<>();
        String one="";
        String two="";
        chars.add(input.substring(0,1));
        nums.add(0);
        if(input.substring(1,2).compareTo(chars.get(0))<=0) {
            chars.add(0,input.substring(1,2));
            nums.add(0,1);
        } else{
            chars.add(1,input.substring(1,2));
            nums.add(1,1);
        }
        for(int i=2;i<input.length();i++) {
            String b=input.substring(i,i+1);
            boolean c=false;
            for(int j=0;j<chars.size();j++) {
                if(b.compareTo(chars.get(j))<=0) {
                    chars.add(j, b);
                    c=true;
                    if(j==0) {
                        nums.add(0,nums.get(0)+1);
                    } else {
                        nums.add(j, Math.max(nums.get(j-1), nums.get(j))+1);
                    }
                    break;
                }
            }
            if(!c) {
                chars.add(chars.size(), b);
                nums.add(nums.size(), nums.get(nums.size()-1)+1);
            }
        }
        for(int i=1;i<nums.size();i++) {
            ntwo.add(nums.get(i));
        }
        for(int i=0;i<nums.size();i++) {
            int g=nums.get(i)+1;
            boolean currl=false, currr=false;

            for(int j=none.size()-1;j>=0;j--) {
                if(none.get(j)<g-1) {
                    break;
                } else {
                    if(none.get(j)==g) {
                        currl=true;
                    }
                }
            }
            for(int j=0;j<ntwo.size();j++) {
                if(ntwo.get(j)<g-1) {
                    break;
                } else {
                    if(ntwo.get(j)==g) {
                        currr=true;
                    }
                }
            }
            if(currr&&!currl) {
                two+=chars.get(i);
            } else if(!currr&&currl) {
                one+=chars.get(i);
            }
            none.add(nums.get(i));
            if(ntwo.size()>0) {
                ntwo.remove(0);
            }
        }
        if(one.length()==0) {
            one="NONE";
        }
        if(two.length()==0) {
            two="NONE";
        }
        
        return one+" "+two;  
    }
}


public class C3IN_Raina {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        for(int i=0; i<10; i++) {
        String s = bufferedReader.readLine();

        String result = Result1.onlyLeftOrRight(s);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        }
        bufferedReader.close();
        //bufferedWriter.close();
    }
}
