import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class C4_JR_Regex {
	static Scanner in;
	static String[] a;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("c4jr.in"));
		for(int i=0; i<3; i++) {
			a = in.nextLine().split(", ");  ///<------
			for(int j=0; j<5; j++) {
				solve();
			}
		}
	}

	static void solve() {
		String p = in.nextLine();
		String ans = "";
		for(int i=0; i<a.length; i++) {
			boolean b = Pattern.matches(p, a[i]);
			if(b) ans+= a[i]+" ";
		}
		if(ans.length()==0) System.out.println("NONE");
		else System.out.println(ans);
	}
}
