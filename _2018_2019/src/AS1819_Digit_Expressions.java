//Gene

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class AS1819_Digit_Expressions {
	
	static int cnt=0;
	static ArrayList<BigInteger>parts=new ArrayList<BigInteger>();
	public static int solve(String s) {
		//split into parts and update "parts"
		split(s);
		//select indices to use +,-,* (1-for loop,2-for loop, 3-for loop)
		cnt=0;
		System.out.println(parts);
		for(int i=0;i<parts.size()-1;i++) {
			evalSingle(comb(0,i+1),comb(i+1,parts.size()));//tries +,-, and * at index i and i+1
			for(int j=i+1;j<parts.size()-1;j++) {
				evalDouble(comb(0,i+1),comb(i+1,j+1),comb(j+1,parts.size()));//tries +-*, unique operators for i and j
				for(int k=j+1;k<parts.size()-1;k++) {
					evalTriple(comb(0,i+1),comb(i+1,j+1),comb(j+1,k+1),comb(k+1,parts.size()));
				}
			}
		}
		return cnt;
	}
	
	public static void split(String s) {
		parts.clear();
		StringBuilder sb=new StringBuilder("0");
		for(char c:s.toCharArray()) {
			if(c!='0') {
				BigInteger add=new BigInteger(sb.toString());
				if(!add.equals(BigInteger.ZERO))
					parts.add(add);
				sb=new StringBuilder();
			}
			sb.append(c);
		}
		BigInteger add=new BigInteger(sb.toString());
		if(!add.equals(BigInteger.ZERO))
			parts.add(add);
	}
	
	public static BigInteger comb(int i,int j) {
		StringBuilder sb=new StringBuilder();
		while(i<j) {
			sb.append(parts.get(i));
			i++;
		}
		return new BigInteger(sb.toString());
	}
	
	public static void evalSingle(BigInteger b1,BigInteger b2) {
		if(b1.add(b2).compareTo(BigInteger.ZERO)>0) {
			System.out.println(cnt+" " + b1+" + "+b2);

			cnt++;
		}
		
		if(b1.compareTo(b2)>0) {
			System.out.println(cnt+" "+b1+" - "+b2);

			cnt++;
		}

		if(b1.compareTo(BigInteger.ZERO)>0&&b2.compareTo(BigInteger.ZERO)>0) {
			System.out.println(cnt+" "+b1+" * "+b2);

			cnt++;
		}
		
		else if(b1.compareTo(BigInteger.ZERO)<0&&b2.compareTo(BigInteger.ZERO)<0) {
			System.out.println(cnt+" "+b1+" * "+b2);
			cnt++;
		}

	}
	
	public static void evalDouble(BigInteger b1,BigInteger b2,BigInteger b3) {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				if(i==j)continue;
				BigInteger ans;
				if(j==0) {//j==*, do j first
					ans=b2.multiply(b3);
					if(i==1)
						ans=b1.add(ans);
					else
						ans=b1.subtract(ans);
				}
				else {
					if(i==0)
						ans=b1.multiply(b2);
					else if(i==1)
						ans=b1.add(b2);
					else
						ans=b1.subtract(b2);
					if(j==1)
						ans=ans.add(b3);
					else
						ans=ans.subtract(b3);
				}
				if(ans.compareTo(BigInteger.ZERO)>0)
					cnt++;
			}
	}

	public static void evalTriple(BigInteger b1,BigInteger b2,BigInteger b3,BigInteger b4) {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				if(i==j)continue;
				int k=3-i-j;
				BigInteger ans;
				if(k==0) {
					if(i==1)//j==2
						ans=b1.add(b2).subtract(b3.multiply(b4));
					else//i==2, j==1
						ans=b1.subtract(b2).add(b3.multiply(b4));
				}
				else if(j==0) {//j==*, do j first
					if(i==1)//k==2
						ans=b1.add(b2.multiply(b3)).subtract(b4);
					else//i==2,k==1
						ans=b1.subtract(b2.multiply(b3)).add(b4);
				}
				else {//i==0
					if(j==1)//k==2
						ans=b1.multiply(b2).add(b3).subtract(b4);
					else//j==2, k==1
						ans=b1.multiply(b2).subtract(b3).add(b4);
				}
				if(ans.compareTo(BigInteger.ZERO)>0)
					cnt++;
			}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<1;i++) {
			String s=sc.nextLine();
			System.out.println(solve(s));
		}
	}

}
