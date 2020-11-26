
public class CheckDigit {

	private static count;
	public static int getCheck(int num)
	{ /* implementation not shown */ }
	
	public static boolean isValid(int numWithCheckDigit) 
	{
		int f = numWithCheckDigit/10;
		int b = numWithCheckDigit%10;
		if( getCheck(f) == b ) return true;
		else
		{
			count++;
			return false;
		}
	}
}
