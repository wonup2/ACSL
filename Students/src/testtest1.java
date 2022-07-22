import java.util.Arrays;

public class testtest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		String s = "ABCCBA";
		StringBuilder sb = new StringBuilder(s);

		System.out.println(sb);
		sb.reverse();	
		
		
		if(s.equals(sb.toString())) System.out.println(true);
		else System.out.println(false);
	

	}

}
