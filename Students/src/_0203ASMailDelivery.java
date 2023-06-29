import java.util.*;
import java.io.*;

public class _0203ASMailDelivery {
	
	static TreeSet<pair> odd, even;
	static BufferedReader in;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));		
		odd = new TreeSet<pair>();
		even = new TreeSet<pair>();
		
		String[] input = in.readLine().split(", ");
		for(int i=1; i<input.length; i++) {
			int id = Integer.parseInt(input[i].substring(1));
			if(id%2==0) even.add(new pair(input[i].charAt(0), id));
			else odd.add(new pair(input[i].charAt(0), id));
		}
		
		for(int i=0; i<5; i++) {
			input = in.readLine().split(", ");
			for(int j=1; j<input.length-2; j++) {
				int id = Integer.parseInt(input[j].substring(1));
				if(id%2==0) even.add(new pair(input[j].charAt(0), id));
				else odd.add(new pair(input[j].charAt(0), id));
			}
			
			solve(input[input.length-2].charAt(0)-'A'+1, Integer.parseInt(input[input.length-1]));
		}
	}
	
	static void solve(int gate, int housecnt) {
		
		LinkedList<pair> ocopy = new LinkedList<pair>();
		ocopy.addAll(odd);
		LinkedList<pair> ecopy = new LinkedList<pair>();
		ecopy.addAll(even);

		System.out.println(ocopy);
		System.out.println(ecopy);
		System.out.println("                          "+ gate+" "+housecnt);
		
		int ansidx = 0;
		for(int i=0; i<ecopy.size(); i++) {
			if(ecopy.get(i).gate >= gate) {
				ansidx=i;
				break;
			}
		}
		for(int i=0; i<ocopy.size(); i++) {
			if(ocopy.get(i).gate >= gate) {
				ansidx=i;
				break;
			}
		}
		System.out.println("Ansidx = "+ansidx);
		
		int i = ansidx;
		boolean oddcheck = true;
		int cnt = 0;
		while(true) {
			if(ocopy.size()==0) oddcheck=false;
			cnt++;
			
			if(oddcheck) i %= ocopy.size();
			else i %= ecopy.size();
			
			if(cnt==housecnt) {
				if(oddcheck) {
					System.out.println(ocopy.get(i));
				}
				else System.out.println(ecopy.get(i));
				break;
			}
			
			if(oddcheck) ocopy.remove(i);
			else ecopy.remove(i);
			i++;
			
			System.out.println(ocopy);
			System.out.println(ecopy);
		}
		
	}
	
	static class pair implements Comparable<pair> {
		
		int gate, id;
		pair(char a, int b){
			gate = a-'A'+1;
			id = b;
		}
		
		public String toString() {
			return gate+" "+id;
		}
		
		@Override
		public int compareTo(_0203ASMailDelivery.pair that) {
			// TODO Auto-generated method stub
			if(this.gate==that.gate) return this.id-that.id;
			return this.gate-that.gate;
		}
		
	}
}
