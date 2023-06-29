import java.util.*;

public class ACSL_Cycle {

	static Scanner in;
	static ArrayList<Integer> a[];
	static boolean v[], p[];
	static int n, cycle;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		
		n = in.nextInt();
		a = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) a[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {
			char s[] = in.next().toCharArray();
			for(int j=0; j<s.length; j++) 
				if(s[j]!='0') a[i].add(j+1);
			
		}
	
		p = new boolean[n+1];
		
		int cnt=0;	
		
		for(int i=1; i<=n; i++) {
			v = new boolean[n+1];
			dfs(i);			
		}

		System.out.println(cnt);

	}

	static void dfs(int i) {
		v[i]=true;
		
		for(int u:a[i]) {
			if(!v[u]) dfs(u);
			else if(!p[u]) cycle++;
		}
		
		p[i] = true;
	}
}
