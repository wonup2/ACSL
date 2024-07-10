import java.util.*;

public class C2_IN_Book {

	static Scanner in;
	static int n;
	static String a[][];
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		n = 1;
		while(n-->0) {
			init();
			solve();
		}
	}
	
	static void init() {
		a = new String[20][200];
		int s=0, w=0;
		String word = "";
		while(true) {
			word = in.next(); 
			char end = word.charAt(word.length()-1);
			

			if(swc(word)) break;
			if(word.length()==1) {
				String _word = word.replaceAll("[^a-zA-Z0-9]", "");
				if(_word.length()==0) continue;
			}
			
			word=word.replaceAll("[^a-zA-Z0-9]", " "); 
			StringTokenizer st = new StringTokenizer(word);
			while(st.hasMoreTokens()) {
				a[s][w]= st.nextToken();
				w++;
			}
			if(end=='.'||end=='?'||end=='!') { s++; w=0; }
			
		}
		
		print(a);
		System.out.println(word);
		String temp[] = word.split("\\."); 
		System.out.println(Arrays.toString(temp));
		s = Integer.parseInt(temp[0])-1;
		w = Integer.parseInt(temp[1])-1;
		int c = Integer.parseInt(temp[2])-1;

		String ans=a[s][w].charAt(c)+"";
		
		String[] swc = in.nextLine().split(" ");
		System.out.println(Arrays.toString(swc));
		for(int i=1; i<swc.length; i++){
			word = swc[i]; System.out.println(word);

			if(word==null) break;
			String t[] = word.split("\\.");
			s = Integer.parseInt(t[0])-1;
			w = Integer.parseInt(t[1])-1;
			c = Integer.parseInt(t[2])-1;
			
			if(a[s][w]==null || a[s][w].length()<=c) {ans+=" ";continue;}

			ans+=a[s][w].charAt(c); System.out.println(ans);
		}
		
		System.out.println(ans);
	}
	
	static void print(String[][] a) {
		System.out.println();
		for(int i=0; i<a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
	
	static boolean swc(String s) {		
		String s1 = s.replace(".", "");
		return s.length()-s1.length()==2;
	}
	

	static void solve() {
		
	}

}
