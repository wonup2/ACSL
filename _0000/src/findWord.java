
public class findWord {

	public static void main(String[] args) {

		String seek = "aaa";
		
		String str = "aaabcaaadddcccaaajkjhkaaa";
		
		int first = str.indexOf(seek);
		
		int second = str.indexOf(seek, first+seek.length());
		
		System.out.println(first+" "+second);
		
	}
}
