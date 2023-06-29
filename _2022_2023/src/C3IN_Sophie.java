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

	static ArrayList
	<Character
	> letters
	= new ArrayList
	<Character
	>();
	 static ArrayList
	<Integer
	> vals
	= new ArrayList
	<Integer
	>();

	 public static String listByValue(String input) {
	 String str
	= input
	;
	 letters.add(str.charAt(0));
	 vals.add(0);

	 int index
	=
	1
	;
	 while(index
	< str.length()) {

	 if(str.charAt(index) <= letters.get(0)) {
	 letters.add(0, str.charAt(index));
	 vals.add(0, vals.get(0)+
	1);

	}else {
	 for(int
	i
	=
	0;
	i
	< letters.size();
	i++) {

	 if(i == letters.size()
	-
	1) {
	 letters.add(str.charAt(index));
	 vals.add(vals.get(vals.size()
	-
	1)+
	1);
	 break
	;


	}else {
	 help(str.charAt(index));
	 break
	;

	}

	}

	}
	 index++
	;

	}



	 String combined
	= ""
	;
	 int max
	= Collections.max(vals);

	 ArrayList
	<String
	> temp
	= new ArrayList
	<String
	>();
	 for(int
	i
	=
	0;
	i <= max;
	i++) {
	 for(int
	j
	=
	0;
	j
	< letters.size();
	j++) {
	 if(vals.get(j) ==
	i) {
	 temp.add(letters.get(j)+"");

	}

	}
	 Collections.sort(temp);
	 for(int
	j
	=
	0;
	j
	< temp.size();
	j++) {
	 combined+= temp.get(j);

	}
	 temp.clear();

	}

	 return combined
	;



	}

	 public static void help(Character let) {
	 for(int
	i
	=
	0;
	i
	< letters.size();
	i++) {
	 if(i == letters.size()
	-
	1 && let
	> letters.get(i)) {
	 letters.add(let);
	 vals.add(vals.get(i)+
	1);
	 break
	;

	}else if(let <= letters.get(i)) {
	 letters.add(i, let);


	 if(vals.get(i) > vals.get(i-1)) {
	 vals.add(i, vals.get(i)+1);

	 }else {
	 vals.add(i, vals.get(i-1)+1);
	 }
	 break;
	 }
	 }
	 }
	
}

public class C3IN_Sophie {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<10; i++) {
        	String s = bufferedReader.readLine();

        	String result = Result.listByValue(s);
        	System.out.println(result);
        }

        bufferedReader.close();
    }
}
