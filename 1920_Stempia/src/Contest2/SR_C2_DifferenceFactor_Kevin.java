package Contest2;
/*
Donggun Kwak
10th Grade
Stempia
Senior 3 Contest 2
 */
import java.util.*;
import java.io.*;
public class SR_C2_DifferenceFactor_Kevin {

	public static int total;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("1920C2Sr.in")));
		for(int c = 0;c<5;c++)
		{
			String str1 = format(in.nextLine());
			String str2 = format(in.nextLine());
			total = 0;
			//System.out.println(str1);
			//System.out.println(str2);
			run(str1,str2);
			System.out.println(total);
		}
	}
	public static void run(String str1 ,String str2)
	{
		String longestCommon = "";
		for(int i = 0;i<str1.length();i++)//start 1
		{
			for(int j = i+1;j<=str1.length();j++)//end 1
			{
				String cur = str1.substring(i,j);
				if(cur.length()<longestCommon.length())
					continue;
				for(int k = 0;k<=str2.length()-cur.length();k++)//start 2
				{
					if(cur.equals(str2.substring(k,k+cur.length())))
					{
						if(cur.length()>longestCommon.length()||(cur.length()==longestCommon.length()&&cur.compareTo(longestCommon)<0))
						{
							longestCommon = cur;
						}
					}
				}
			}
		}
		//System.out.println(longestCommon);
		if(longestCommon.equals(""))
			return;
		int len = longestCommon.length();
		total+=len;
		int start1 = str1.indexOf(longestCommon);
		int end1 = start1+len;
		int start2 = str2.indexOf(longestCommon);
		int end2 = start2 +len;
		String a1 = str1.substring(0,start1);
		String a2 = str2.substring(0,start2);
		String b1 = str1.substring(end1);
		String b2 = str2.substring(end2);
		//System.out.println(a1+", "+a2);
		//System.out.println(b1+", "+b2);
		run(a1,a2);
		run(b1,b2);
	}
	public static String format(String str)
	{
		String ret ="";
		for(int i =0;i<str.length();i++)
		{
			if(str.charAt(i)>='a'&&str.charAt(i)<='z')
				ret+=str.charAt(i);
			else if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
				ret+=str.charAt(i);
		}
		return ret.toUpperCase();
	}

}
