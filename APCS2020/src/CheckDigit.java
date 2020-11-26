public class CheckDigit
{
	private static int count;
	
	public static int getCheck(int num)
	{ /* implementation not shown */ 
		
	}
	
	public static boolean isValid(int numWithCheckDigit)
	{
		int front = numWithCheckDigit/10;
		int back = numWithCheckDigit%10;
		
		if(getCheck(front)==back) {
			return true;
		}
		
		count++;
		return false;
	}
}