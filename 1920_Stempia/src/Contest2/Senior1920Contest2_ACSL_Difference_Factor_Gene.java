package Contest2;
/*
Gene Lee
12th Grade
Stempia
Senior 3 Contest 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Senior1920Contest2_ACSL_Difference_Factor_Gene {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(new File("1920c2sr.in"));
		for(int test=0;test<5;test++) {
			String s1=STEP1(sc.nextLine());
			String s2=STEP1(sc.nextLine());
			System.out.println(run(s1,s2));
		}
	}
	
	public static String STEP1(String s) {
		StringBuilder sb=new StringBuilder();
		for(char c:s.toCharArray())
			if(Character.isLetter(c))
				sb.append(c);
		return sb.toString().toUpperCase();
	}
	
	public static int run(String s1,String s2) {
		String lcs=lcs(s1,s2);
		if(lcs==null)
			return 0;
		int i1=s1.indexOf(lcs);//get [0,i1)
		int i2=s2.indexOf(lcs);//get [0,i1)
		return lcs.length()+run(s1.substring(0,i1),s2.substring(0,i2))+run(s1.substring(i1+lcs.length()),s2.substring(i2+lcs.length()));
	}
	
	public static String lcs(String s11,String s22) {
		String s1=s11+"";
		String s2=s22+"";
		if(s1.length()<s2.length()) {
			String temp=s1;
			s1=s2;
			s2=temp;
		}
		String ret=null;
		for(int len=s2.length();len>0;len--) {
			for(int i=0;i+len<=s1.length();i++)
				if(s2.indexOf(s1.substring(i, i+len))!=-1&&(ret==null||ret.compareTo(s1.substring(i, i+len))>0)) {
					ret=s1.substring(i, i+len);
				}
			if(ret!=null)
				break;
		}
		return ret;
	}

}
