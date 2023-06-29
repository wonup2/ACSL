
public class NumberConvert {

	public static void main(String[] args) {

		//dec --> computer number
		System.out.println( Integer.toHexString(10)); 		//a
		System.out.println( Integer.toOctalString(10));  	//12
		System.out.println( Integer.toBinaryString(10)); 	//1010  <--- String
		System.out.println( Integer.toString(17, 5));
		

		//computer number --> dec
		System.out.println( Integer.parseInt("1010", 2)); 	//10  dectobin
		System.out.println( Integer.parseInt("12", 8)); 	//10  dectooct
		System.out.println( Integer.parseInt("A", 16)); 	//10  dectohex	 
		System.out.println( Integer.parseInt("17", 17));	//10  dectobase17
	
		
		//octal -> hex ------> octal -> integer -> hex
		String oct_hex = Integer.toString(Integer.parseInt("17", 8), 16);
		System.out.println(oct_hex);  //f
	}
}
