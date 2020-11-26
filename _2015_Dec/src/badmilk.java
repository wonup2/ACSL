import java.util.*;
import java.io.*;

public class badmilk {
	static Scanner in;
	static PrintWriter out;
	static milk time[];
	static boolean drunk[][], possible[];
	static int n, m, d, s;
	public static void main(String[] args) throws IOException {
		init();
	}
	
	static void init() throws IOException {
		in = new Scanner(new File("badmilk.in"));
		
		n = in.nextInt();
		m = in.nextInt();
		d = in.nextInt();
		s = in.nextInt();
		time = new milk[d+s];
		for(int i = 0; i < d; i++)
			time[i] = new milk(in.nextInt(), in.nextInt(), in.nextInt());
		
		for(int i = 0; i < s; i++)
			time[d+i] = new milk(in.nextInt(), -1, in.nextInt());
		
		//System.out.println(Arrays.toString(time));
		drunk = new boolean[m+1][n+1];
		possible = new boolean[m+1];
	}
}

class milk implements Comparable<milk>{

	int person;
	int milk;
	int time;
	
	milk(int p, int m, int t){
		person = p;
		milk = m;
		time = t;
	}
	
	public String toString() {
		return person + " " + milk + " " + time;
	}
	@Override
	public int compareTo(milk that) {

		if(this.time > that.time) return 1;
		else if(this.time < that.time) return -1;
		else {
			if(this.milk > that.milk) return -1;
			else return 1;
		}
	}
	
}


