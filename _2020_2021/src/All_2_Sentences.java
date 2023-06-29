import java.util.*;
public class All_2_Sentences {
	static Scanner in;
	static HashMap<Character, ArrayList<String>> parts;
	static String a[][];
	static int n;
	static String s[];
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void reset() {
		parts = new HashMap<Character, ArrayList<String>>();
		parts.put('N', new ArrayList<String>());
		parts.put('C', new ArrayList<String>());
		parts.put('V', new ArrayList<String>());
		parts.put('J', new ArrayList<String>());
		parts.put('B', new ArrayList<String>());
		parts.put('P', new ArrayList<String>());
		

		for(int i=0; i<n; i++) {
			char key = a[i][0].charAt(0);
			ArrayList<String> temp = new ArrayList<String>();
			for(int j=1; j<a[i].length; j++) {
				temp.add(a[i][j]);
			}
			parts.put(key, temp);
		}
	}
	static int convert(char c) {
		if(c=='N') return 0;
		if(c=='C') return 1;
		if(c=='V') return 2;
		if(c=='J') return 3;
		if(c=='B') return 4;
		if(c=='P') return 5;
		else return -1;
	}
	static void reset(char c) {

		parts.put(c, new ArrayList<String>());
		
		int i=convert(c);
		ArrayList<String> temp = new ArrayList<String>();
		for(int j=0; j<a[i].length; j++) {
			temp.add(a[i][j]);
		}
		parts.put(c, temp);		
	}

	static void init() {
		n = in.nextInt(); in.nextLine();
		a = new String[n][];
		
		for(int i=0; i<n; i++) {
			a[i] = in.nextLine().split(" ");	
		}
		
		s = in.nextLine().split(" ");		

		reset();
		
		//System.out.println(parts);
	}
	
	static void solve() {
		String ans="";		

		for(String com:s) {
		
			String temp="";
			String end="";
			for(int i=0; i<com.length(); i++) {
				char key = com.charAt(i); 
								
				if(key=='Q') { temp+="What"; end="?";}
				else if(key=='D' || key=='I') end=".";
				else if(key=='E') end+="!";				
				else if(key=='T') temp+=" the";
				else if(key=='A' && vowel(temp.charAt(i+1))) temp+=" an";
				else if(key=='A') temp+=" a";	
				else {
					temp+=" "+parts.get(key).remove(0); 		

					if(parts.get(key).size()==0) reset();
				}
			}		
			temp = temp.trim(); 
			temp = temp.substring(0,1).toUpperCase() + temp.substring(1); 
			ans+=temp+end+" "; 
		}
		System.out.println(ans);

	}
	
	static boolean vowel(char c) {
		return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
	}
}
