public class permutation {

	public static void main(String[] args) {

		String s = "0123";
		permut(s, "");
	}

	static void permut(String left, String right) {
		
		if(left=="") {
			System.out.println(right);
		}
		
		for(int i=0; i<left.length(); i++) {
			char c = left.charAt(i);
			String l = left.substring(0, i) + left.substring(i+1);
			String r = right + c;
			
			permut(l, r);
		}		
	}	
	
	
}