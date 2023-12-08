import java.util.*;

public class Contest1_JR {
	static Scanner in;
	static String a[];
	static String b[];
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		String s = in.nextLine();
		a = new String[4];
		for(int i=0; i<4; i++)
			a[i] = s.charAt(i)+"";
		
		b = in.nextLine().split(" ");
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(b));

	}
	
	static void solve() {
		
		for(int i=0; i<b.length; i++) {
			char f = b[i].charAt(0);
			char s = b[i].charAt(1);
			
			for(int j=0; j<4; j++) {
				char end = a[j].charAt(a[j].length()-1);
				if(end==f) { a[j] = a[j]+b[i]; b[i]=""; break;}
				else if (end==s) { a[j] = a[j]+s+f; b[i]=""; break;}
			}
			//System.out.println(Arrays.toString(a));

		}
		
		//System.out.println(Arrays.toString(b));
		
		int sum = 0;
		for(int i=0; i<b.length; i++) {
			if(b[i]=="") continue;
			int n = Integer.parseInt(b[i]);
			sum += n/10 + n%10;
		}
		
		System.out.println(sum);
	}

}
