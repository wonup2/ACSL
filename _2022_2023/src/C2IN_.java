
public class C2IN_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int findLastBinary(String s) 
    {
    	// Convert each character in the string to its binary equivalent
        StringBuilder binaryStringBuilder = new StringBuilder();
        
        byte[] asciiBytes = s.getBytes(); // get the ASCII representation of the string as a byte array
        
        for (byte b : asciiBytes) 
        {
            String binaryString = Integer.toBinaryString(b); // convert each byte to its binary representation
            binaryStringBuilder.append(binaryString); // append the binary string to the StringBuilder
        }
        		        
        boolean ifBothFound = true;
        boolean frontFound = false;
        boolean backFound = false;
        
        int binaryNum = 0; // Binary number to convert and find
        
        while(ifBothFound)
        {
        	String binaryStr = Integer.toString(binaryNum); // Convert binary number to string
        	StringBuilder reversed = new StringBuilder(binaryStr).reverse(); // Reverses the string above using a stringbuilder
        	String reversedBinaryStr = reversed.toString(); // The reversed string of the binary number
        	
        	
	        int frontFoundIndex = -1; // Index where binaryStr was found
	        
	        for (int i = 0; i <= binaryStringBuilder.length() - binaryStr.length(); i++) // Loop through StringBuilder
	        { 
	            String substring = binaryStringBuilder.substring(i, i + binaryStr.length()); // Get substring of same length as binaryStr
	            if(binaryStr.equals(substring)) // If substring matches binaryStr
	            { 
	                frontFoundIndex = i; // Save index where binaryStr was found
	                
	                binaryStringBuilder.delete(frontFoundIndex, frontFoundIndex + binaryStr.length());
	                
	                frontFound = true;
	                break; // Exit loop
	            }
	        }
	        
	        
	        int backFoundIndex = -1; // Index where reversedBinaryStr was found
	        
	        binaryStringBuilder = binaryStringBuilder.reverse();
	        
	        for (int i = 0; i <= binaryStringBuilder.length() - reversedBinaryStr.length(); i++)// Loop through StringBuilder
	        { 
	            String substring = binaryStringBuilder.substring(i, i + reversedBinaryStr.length()); // Get substring of same length as reversedBinaryStr
	            
	            if (reversedBinaryStr.equals(substring))
	            {
	            	backFoundIndex = binaryStringBuilder.length() - (reversedBinaryStr.length() + i); // Save index where binaryStr was found
	                
	                binaryStringBuilder.delete(backFoundIndex, backFoundIndex + reversedBinaryStr.length());
	                
	                backFound = true;
	                break; // Exit loop
	            }
	            
	        }

	        if(frontFound == false && backFound == false)
	        {
	        	ifBothFound = false;
	        }
	        else
	        {
	        	binaryNum++;
	        }
        }
        
			return binaryNum;
        }

}
