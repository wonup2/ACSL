import java.util.*;

public class C4JR_Targets {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int size = in.nextInt();in.nextLine();
		String target = in.nextLine();
		System.out.println(arrowForMostTargets(size, target));
		
	}
	public static String arrowForMostTargets(int size, String targets) {
		int [][] a = new int [size][size];
		
		int max = 0;
		String ans = "";

		String[] p = targets.split(" ");
		for(int i=0; i<p.length; i++) {
			int f = Integer.parseInt(p[i])/10;
			int s = Integer.parseInt(p[i])%10;
			a[f][s] = 1;
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				for(int c='A'; c<='H'; c++) {					
					if(i==0||j==0||i==size-1||j==size-1) {	
						if(max < check(a, i, j, (char)c)) {							
							ans = i+""+j+""+(char)c;
							max = check(a, i, j, (char)c);
						}
					}
				}
			}		
		}
		
		return ans;
	}
	
	public static int check(int a[][], int r, int c, char l) {
		
		
		
		int cnt = 0;
				
		if(l == 'A') {
			while(c>=0) {				
				cnt+=a[r][c];				
				if(cnt>0 && a[r][c]==0) break;
				c--;
			}
		}	
		
		return cnt;
	}
}
