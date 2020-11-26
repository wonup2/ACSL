package Contest1;
/*
Name: Donggun Kwak
Grade: 10
Team: Stempia 
Division: Senior 3
Contest 1
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class SR_C1_NumberTransformation_Kwak {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920c1sr.in"));
		for(int c = 0;c<5;c++)
		{
			String str = in.next();
			int p =in.nextInt();
			int[] arr = new int[str.length()];
			for(int i =0;i<str.length();i++)
			{
				arr[i] = Integer.parseInt(str.substring(i,i+1));
			}
			int index = str.length()-p;
			int pth = arr[index];
			StringBuilder ans = new StringBuilder();
			for(int i = 0;i<index;i++)
			{
				ans.append((arr[i]+pth));
			}
			ans.append(primes(Long.parseLong(str)));
			for(int i =index+1;i<str.length();i++)
			{
				ans.append(Math.abs(pth-arr[i]));
			}
			System.out.println(ans);		
		}
	}
	
	public static int primes(long n)
	{
		HashSet<Long> c = new HashSet<Long>();
		while(n%2==0)
		{
			c.add((long) 2);
			n/=2;
		}
		System.out.println(c);
		for(int i =3;i<=Math.sqrt(n);i+=2)
		{
			while(n%i==0)
			{
				c.add((long) i);
				n/=i;
			}
		}
		if(n>2)
			c.add(n);
			
		return c.size();
	}
}
