import java.util.*;
public class C1_JR_chmod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		String a = "";
		String b = "";
		
		for(int i=0; i<3; i++) {
			int n = in.nextInt();
			a+=conv(n);
			b+=conv1(n);
		}
		
		System.out.println(a + "and" + b);
	}

	static String conv(int a) {
		
		if(a==0) return "000 ";
		if(a==1) return "001 ";
		if(a==2) return "010 ";
		if(a==3) return "011 ";
		if(a==4) return "100 ";
		if(a==5) return "101 ";
		if(a==6) return "110 ";
		if(a==7) return "111 ";
		else return "";
	}
	
	static String conv1(int a) {
		
		if(a==0) return " ---";
		if(a==1) return " --x";
		if(a==2) return " -w-";
		if(a==3) return " -wx";
		if(a==4) return " r--";
		if(a==5) return " r-x";
		if(a==6) return " rw-";
		if(a==7) return " rwx";
		else return "";
	}
}
