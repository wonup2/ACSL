import java.util.*;

public class Contest3_Junior {

	static boolean[][] a;
	static Scanner in;
	static String ans;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			init();
			solve();
		}
	}

	static void init() {
		
		String input = in.next();
		
		a = new boolean[4][4];
		
		
		//System.out.println(Arrays.toString(a[0]));
		//System.out.println(Arrays.toString(a[1]));
		
		//System.out.println(hexToBin(input.charAt(0)));
		//System.out.println(hexToBin(input.charAt(1)));

		fill(0, hexToBin(input.charAt(0)));
		fill(1, hexToBin(input.charAt(1)));	

		//System.out.println(Arrays.toString(a[0]));
		//System.out.println(Arrays.toString(a[1]));

				
	}
	
	static void solve() {
		ans = "";
		
		checkFour();
		checkTwo();
		checkOne();
		
		System.out.println(ans.substring(3));
	}
	
	
	static void checkFour() {
		if(a[0][0] && a[0][1] && a[0][2] && a[0][3]) {
			ans += " + B";
			a[0][0] = a[0][1] = a[0][2] = a[0][3] = false;
		}
		if(a[1][0] && a[1][1] && a[1][2] && a[1][3]) {
			ans += " + ~B";
			a[1][0] = a[1][1] = a[1][2] = a[1][3] = false;
		}
		if(a[0][0] && a[0][1] && a[1][0] && a[1][1]) {
			ans += " + A";
			a[0][0] = a[0][1] = a[1][0] = a[1][1] = false;
		}
		if(a[0][1] && a[0][2] && a[1][1] && a[1][2]) {
			ans += " + C";
			a[0][1] = a[0][2] = a[1][1] = a[1][2] = false;
		}
		if(a[0][2] && a[0][3] && a[1][2] && a[1][3]) {
			ans += " + ~A";
			a[0][2] = a[0][3] = a[1][2] = a[1][3] = false;
		}
		if(a[0][0] && a[0][3] && a[1][0] && a[1][3]) {
			ans += " + ~C";
			a[0][0] = a[0][3] = a[1][0] = a[1][3] = false;
		}
	}
	
	static void checkTwo() {
		if(a[0][0] && a[0][1]) { //1
			ans += " + AB";
			a[0][0] = a[0][1] = false;
		}
		
		if(a[0][1] && a[0][2]) { //2
			ans += " + BC";
			a[0][1] = a[0][2] = false;
		}
		
		if(a[0][2] && a[0][3]) { //3
			ans += " + ~AB";
			a[0][2] = a[0][3] = false;
		}
		
		if(a[1][0] && a[1][1]) { //4
			ans += " + A~B";
			a[1][0] = a[1][1] = false;
		}
		
		if(a[1][1] && a[1][2]) { //5
			ans += " + ~BC";
			a[1][1] = a[1][2] = false;
		}
		
		if(a[1][2] && a[1][3]) { //6
			ans += " + ~A~B";
			a[1][2] = a[1][3] = false;
		}
		
		if(a[0][0] && a[1][0]) { //7
			ans += " + A~C";
			a[0][0] = a[1][0] = false;
		}
		
		if(a[0][1] && a[1][1]) { //8
			ans += " + AC";
			a[0][1] = a[1][1] = false;
		}
		
		if(a[0][2] && a[1][2]) { //9
			ans += " + ~AC";
			a[0][2] = a[1][2] = false;
		}
		
		if(a[0][3] && a[1][3]) { //10
			ans += " + ~A~C";
			a[0][3] = a[1][3] = false;
		}
		
		if(a[0][0] && a[0][3]) { //11
			ans += " + B~C";
			a[0][0] = a[0][3] = false;
		}
		
		if(a[1][0] && a[1][3]) { //12
			ans += " + ~B~C";
			a[1][0] = a[1][3] = false;
		}
	}
	
	static void checkOne() {
	
		if(a[0][0]) ans += " + AB~C";
		if(a[0][1]) ans += " + ABC";
		if(a[0][2]) ans += " + ~ABC";
		if(a[0][3]) ans += " + ~AB~C";
		if(a[1][0]) ans += " + A~B~C";
		if(a[1][1]) ans += " + A~BC";
		if(a[1][2]) ans += " + ~A~BC";
		if(a[1][3]) ans += " + ~A~B~C";
	}
	
	
	static String hexToBin(char c) {
		int num = Integer.parseInt(c+"", 16);
		String bin = Integer.toBinaryString(num);
		//System.out.println("1: "+bin + " "+bin.length());
		 
		int len = bin.length();
		for(int i=0; i<4-len; i++)
			bin = "0" + bin;
		
		//System.out.println(bin);
		return bin;
	}
	
	
	static void fill(int n, String s) {
		
		for(int i=0; i<4; i++) {
			if(s.charAt(i)=='1') a[n][i] = true;
		}
	}
	
	static void _fill(int n, char m) {
	
		if(m=='1') {
			a[n][3] = true;			
		}
		else if(m=='2') {
			a[n][2] = true;				
		}
		else if(m=='3') {
			a[n][2] = true;	
			a[n][3] = true;	
		}
		else if(m=='4') {
			a[n][1] = true;	
		}
		else if(m=='5') {
			a[n][1] = true;	
			a[n][3] = true;
		}
		else if(m=='6') {
			a[n][1] = true;	
			a[n][2] = true;
		}
		else if(m=='7') {
			a[n][1] = true;	
			a[n][2] = true;	
			a[n][3] = true;
		}
		else if(m=='8') {			
			a[n][0] = true;	
		}
		else if(m=='9') {			
			a[n][0] = true;	
			a[n][3] = true;	
		}
		else if(m=='A') {			
			a[n][0] = true;	
			a[n][2] = true;	
		}
		else if(m=='B') {			
			a[n][0] = true;	
			a[n][2] = true;	
			a[n][3] = true;	
		}
		else if(m=='C') {			
			a[n][0] = true;	
			a[n][1] = true;	
		}
		else if(m=='D') {			
			a[n][0] = true;	
			a[n][1] = true;	
			a[n][3] = true;	
		}
		else if(m=='E') {			
			a[n][0] = true;	
			a[n][1] = true;	
			a[n][2] = true;	
		}
		else if(m=='F') {			
			a[n][0] = true;	
			a[n][1] = true;	
			a[n][2] = true;	
			a[n][3] = true;	
		}		
	}

}
