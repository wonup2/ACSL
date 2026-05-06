package allStar;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		char c = 'a';
		//if(Character.isLetter(c)) System.out.println("true");
	
		if('A' <= c && c <= 'Z') System.out.println(c +" is capital");
		
		
		String s = "abc:de:fg";
		
		String a[] = s.split("de");
		
		System.out.println(Arrays.toString(a));
		
		System.out.println(a[0]);
		
	}

}
