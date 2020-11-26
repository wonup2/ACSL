import java.util.*;
public class Simple_Calculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		char[] a;
		int sum = 0;
		a = s.toCharArray();
		for(int i = 0;i<a.length;i++) {
			if(i==0) {
				sum = sum + a[i]-'0';
			}
			else if(a[i]=='+') {
				sum = sum +(a[i+1]-'0');
			}
			else if(a[i]=='-') {
				sum = sum - (a[i+1]-'0');
			}
			else if(a[i]=='=') {
				System.out.println(sum);
				break;
			}
		}
		in.close();
	}
}