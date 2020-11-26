package Contest2;
/*
 Julia Jung
 10th grade
 Voice Of Calling
 Intermediate 3
 Contest 2
*/
import java.io.*;
import java.util.*;
public class IN_asf_Julia {
	
	static Scanner in;
	static String one, two;
	static ArrayList<String> a, b;
	static int length;
	static boolean change;

	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C2IN.in"));
		
		 try {
			 for(int i =0; i < 10; i++) {
				 init();
				 solve();
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 in.close();

	}
	
	static void init(){
		change = false;

		a = new ArrayList<String>();
		b = new ArrayList<String>();
		
		one = in.next();
		two = in.next();
		
		for(int i =0; i < one.length(); i++) {
			a.add("" + one.charAt(i));
		}
		for(int i =0; i < two.length(); i++) {
			b.add("" + two.charAt(i));
		}
		
	}
	
	static void solve(){
		
		while(!change){
			change = false;
			length = Math.min(a.size(), b.size());
			checksame();
			length = Math.min(a.size(), b.size());
			away1();
			if(!change) 
				break;	
		}
		
		//calculating asf
		length = Math.min(a.size(), b.size());
		int ans = 0;
		for(int i = 0; i < length; i++){
			String first = a.get(i);
			String second = b.get(i);
		
			ans += (first.charAt(0) - 'A') - (second.charAt(0) - 'A');
		}
		ans += Math.abs(a.size() - b.size());
		System.out.println(ans);
	}
	
	static void checksame(){
		for(int i = 0; i < length; i++){
			if(a.get(i).equals(b.get(i))){
				change = true;
				a.remove(i);
				b.remove(i);
				length--;
				i--;
			}
		}
	}
	
	static void away1() {
		for(int i = 0; i < length-1; i++){
			if(a.get(i).equals(b.get(i+1))){
				b.remove(i);
				length--;
				checksame();
				i--;
				change = true;
			}
			else if(a.get(i+1).equals(b.get(i))){
				a.remove(i);
				length--;
				checksame();
				i--;
				change = true;
			}
		}
	}
	
}
