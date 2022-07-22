import java.util.*;

public class A2_FiboClock {
	static Scanner in;
	static int hour, min, sec;
	static ArrayList<String> ans;
	static char s[] = {'b','c','g','k','m', 'r','w','y'};
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		for(int i=0; i<1; i++) {
			init();
			solve();
		}
		
	}
	
	static void init() {
		
		String s[] = in.nextLine().split(":");
		
		hour = Integer.parseInt(s[0]);
		min = Integer.parseInt(s[1]) / 5;
		sec = Integer.parseInt(s[2]) / 5;
		
		ans = new ArrayList<String>();
		
	}
	
	static void solve() {
		
		permut();
		
		for(String s: ans)
			System.out.print(s + " ");
		
	}
		
	static void permut() {
		
		for(int a=0; a<8; a++) {
			for(int b=0; b<8; b++) {
				for(int c=0; c<8; c++) {
					for(int d=0; d<8; d++) {
						for(int e=0; e<8; e++) {
							String temp = ""+s[a]+s[b]+s[c]+s[d]+s[e];
							if(check(temp))	ans.add(temp);							
						}
					}
				}
			}
		}
	}	
	
	static boolean check(String str) {
		
		int t[] = {1, 1, 2, 3, 5};
		int h=0,m=0,s=0;
		
		for(int i=0; i<5; i++) {
			char c = str.charAt(i);
			if(c=='r') h+=t[i];
			else if(c=='g') m+=t[i];
			else if(c=='b') s+=t[i];
			else if(c=='c') {
				m+=t[i];
				s+=t[i];
			}
			else if(c=='m') {
				h+=t[i];
				s+=t[i];
			}
			else if(c=='y') {
				h+=t[i];
				m+=t[i];
			}
			else if(c=='w') {
				h+=t[i];
				m+=t[i];
				s+=t[i];
			}
		}
		
		return h==hour && m==min && s==sec;
	}
}
