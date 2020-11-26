import java.util.*;
import java.io.*;
public class C1JR_Digits {

	static int[] a;
	static int max, index;
	static Scanner in;
	
	public static void main(String[] args) throws IOException {
	
		in = new Scanner(new File("C1JR.in"));
		for(int i = 0; i<10; i++) {
			try {
				init();
				System.out.print(i+1+ ": ");
				solve();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error");				
			}
		}
	}
	
	static void init() {
		String s[] = in.nextLine().split("");  //132 
	//	System.out.println(Arrays.toString(s));
		a=new int [s.length];
		for(int i = 0; i<s.length; i++) {
			a[i] = Integer.parseInt(s[i]); //(1,3,2)
	}
	}
	static void solve() {
		//fine max, find maxIndex
		int index = 0;
		int max = a[0];
		for(int i=1; i<a.length; i++) {
			if(a[i]>max) {
				max = a[i];
				index = i;
			}
		}
		
	//	System.out.println(max+ " " + index);
		
		
		//check is max odd? change to 0... even? +4
		
		if(max%2==1) {
			max = 0;
		}
		else if(max%2==0) {
			max = (max+4)%10;
			
		}
		
	//	System.out.println(max+ " "+ index);
		//reset max
		a[index] = max;
		
		//print
		if(a[0]!=0) System.out.print(a[0]);
		
		for(int i=1; i<a.length; i++)
			System.out.print(a[i]);
		
		
		System.out.println();
		
	}

}
