public class ConvertNumber {

	public static void main(String[] args) {
	
		// integer -> binary
		String int_bin = Integer.toString(5, 2);
		System.out.println(int_bin);   //101		
		
		// integer -> hex
		String int_oct = Integer.toString(9, 8);
		System.out.println(int_oct);   //11
		
		// integer -> hex
		String int_hex = Integer.toString(14, 16);
		System.out.println(int_hex);   //e  
		System.out.println(int_hex.toUpperCase());   //E
		
		// binary -> integer
		int bin_int = Integer.parseInt("101", 2);  
		System.out.println(bin_int);  //5
		
		// hex -> integer
		int hex_int = Integer.parseInt("B", 16);
		System.out.println(hex_int); //11
				
		// octal -> integer
		int oct_int = Integer.parseInt("10", 8);
		System.out.println(oct_int); //8
		
		
		//octal -> hex ------> octal -> integer -> hex
		String oct_hex = Integer.toString(Integer.parseInt("17", 8), 16);
		System.out.println(oct_hex);  //f
		
		
		
	}
}
