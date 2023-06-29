import java.util.*;

public class C1_2122_IN_FibonacciClock  {
	static Scanner in;
	static String[] a;
    static int hr;
    static int mn;

	public static void main(String[] args) {
		in = new Scanner(System.in);
	
		for(int i=0; i<5; i++) {
			init();
		}
	}
	
	static void init() {
		a = in.nextLine().split(" ");
		hr = 0;
		mn = 0;
		for (int i = 0; i < a.length; i++) solve(i);
        print();
	}
	
	static void solve(int i) {
        int val = 1;

        if (i == 2) val = 2;
        if (i == 3) val = 3;
        if (i == 4) val = 5;
        
        if (a[i].equals("R")) hr += val;
        if (a[i].equals("G")) mn += val;
        if (a[i].equals("B")) {
            hr += val;
            mn += val;
        }
	}

    static void print() {
        mn *= 5;
        if (mn > 60){
            hr += mn / 60;
            mn %= 60;
        }
        System.out.println(hr + ":" + mn);
    }
}