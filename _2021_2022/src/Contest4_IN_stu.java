

import java.util.*;

public class Contest4_IN_stu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		for(int i=0; i<10; i++) {
		float a = Float.parseFloat(in.next());
		float b = Float.parseFloat(in.next());
		String ans = cycleLength(a, b);
		
		System.out.println(ans);
		}

	}
	
	public static String cycleLength(float realPartC, float imagPartC) {
		   double originalReal = (double)realPartC;
	        double originalImag = (double)imagPartC;
//	        System.out.println(originalReal);
//	        System.out.println(originalImag);
	        int counter = 0;
	        String ans = "";
	        originalReal = Math.round(originalReal*100)/100.0;
	        originalImag = Math.round(originalImag*100)/100.0;
	        double real = originalReal;
	        double imag = originalImag;
//	        System.out.println(real);
//	        System.out.println(imag);
	        
	        
	        double tempReal = 0;
	        double tempImag = 0;
	        double tempAbs = 0;
	        ArrayList<Double> realList = new ArrayList<Double>();
	        ArrayList<Double> imagList = new ArrayList<Double>();
	        realList.add(real);
	        imagList.add(imag);
	        while(true) {
	        	

	            counter++;

	            tempReal = (real*real) - (imag*imag) + originalReal;
	            tempImag = 2*real*imag + originalImag;

	            real = Math.round(tempReal*100)/100.0;
	            imag = Math.round(tempImag*100)/100.0;
	            
	            int realIndex = realList.indexOf(real);
	            int imagIndex = imagList.indexOf(imag);

	            if(realIndex != -1 && realIndex == imagIndex) {
	                ans = counter-realIndex + "";
	                break;
	            }

	            tempAbs = Math.sqrt(real*real + imag*imag);
	            if(tempAbs > 4) {
	                ans = "ESCAPES " + (counter+1);
	                break;
	            }
	            
	            if(counter==500) {
					 ans = "1";
					 break;
				 }
	            realList.add(real);
	            imagList.add(imag);
	    
	        }
	        return ans;
	}
}
