package Contest2;
/*
Gene Lee
12th Grade
Stempia
Senior 3 Contest 1
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Senior1920Contest1_Number_Transformation_Gene {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new File("1920c1sr.in"));
		for(int test=0;test<5;test++) {
			long N=Long.parseLong(sc.next());
			int[] Nans=convertN(N);
			int P=Nans.length-sc.nextInt();
			for(int i=0;i<P;i++)
				Nans[i]+=Nans[P];
			for(int i=P+1;i<Nans.length;i++)
				Nans[i]=(int)Math.abs(Nans[i]-Nans[P]);
			Nans[P]=findFactor(N);
			System.out.println(returnAns(Nans));
		}
	}
	
	static int findFactor(long N) {
		int ans=0;
		while(true) {
			long factor=maxFactor(N);
			if(factor==-1)break;
			ans++;
			while(N%factor==0)N/=factor;
		}
		return ans;
	}
	
	private static long maxFactor(long N) {
		if(isPrime(N))return N;
		for(long i=(long) Math.sqrt(N);i>1;i--)
			if(N%i==0&&isPrime(i))return i;
		return -1;
	}
	
	private static boolean isPrime(long N) {
		if(N==1)return false;
		long limit=(long)Math.sqrt(N);
		for(long i=2;i<=limit;i++)
			if(N%i==0)return false;
		return true;
	}
	
	static String returnAns(int[] N) {
		StringBuilder sb=new StringBuilder();
		for(int i:N)
			sb.append(i);
		return sb.toString();
	}
	
	static int[] convertN(long Ntemp) {
		String N=Ntemp+"";
		int[] ret=new int[N.length()];
		int i=0;
		for(char c:N.toCharArray())
			ret[i++]=c-'0';
		return ret;
	}

}
