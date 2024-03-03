import java.util.*;

public class C2IN_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		findLastBinary(in.nextLine());
	}
	
	public static void findLastBinary(String s) 
    {
    	// Convert each character in the string to its binary equivalent
		//s = s.replace(" ",""); System.out.println(s);
        StringBuilder sb = new StringBuilder();
        
        byte[] asciiBytes = s.getBytes(); // get the ASCII representation of the string as a byte array
        System.out.println(Arrays.toString(asciiBytes));
        for (byte b : asciiBytes) 
        {
            String binaryString = Integer.toBinaryString(b); // convert each byte to its binary representation            
            for(int i=0;i<=8-binaryString.length(); i++) binaryString = "0"+binaryString;
            sb.append(binaryString); // append the binary string to the StringBuilder
        }
        		        
        System.out.println(sb);
        
        int front = 0;
        int back = 0;
        
        int num = 0; // Binary number to convert and find
        s= sb.toString();
        while(true){
        	
	        String bin = Integer.toBinaryString(num);
	        
	        front = s.indexOf(bin);
	        
	        if(front==-1) break;
	        
	        s = s.replaceFirst(bin, "");
	        
	        back = s.lastIndexOf(bin);

	        if(back!=-1) s = s.substring(0, back) + s.substring(back+1);
	        
	        num++;     
    
        }
        System.out.println(num-1);
    }
}
