

import java.util.*;

public class Contest4_IN {

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
		
		 String ans = "";
		 int cnt = 0;
		 
		 double orgReal = (double)realPartC;
		 double orgImaginary = (double)imagPartC;
		 
		 orgReal = Math.round(orgReal * 100) / 100.0;
		 orgImaginary = Math.round(orgImaginary * 100) / 100.0;		 
		 
		 double real = orgReal;
		 double imaginary = orgImaginary;
		 
		 ArrayList<Double> realList = new ArrayList<Double>();
		 ArrayList<Double> imaginaryList = new ArrayList<Double>();

		 realList.add(real);
		 imaginaryList.add(imaginary);
		 
		 while(true) {
			 
			 cnt++;
			 
			 double Creal = real*real - imaginary*imaginary + orgReal;
			 double Cimaginary = 2*real*imaginary + orgImaginary;
			 
			 real = Math.round(Creal * 100) / 100.0;
			 imaginary = Math.round(Cimaginary * 100) / 100.0;			 
				
			 int idxReal = realList.indexOf(real);
			 int idxImaginary = imaginaryList.indexOf(imaginary);
			 
			 if(idxReal!=-1 && idxReal == idxImaginary) {
				 ans = cnt-idxReal + "";
				 break;
			 }
			 
			 if(Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2)) > 4) {
				 cnt++;
				 ans = "ESCAPES " + cnt;				
				 break;
			 }		
			 
			 if(cnt==500) {
				 ans = "1";
				 break;
			 }
			 
			 realList.add(real);
			 imaginaryList.add(imaginary);		
		 }

		 return ans;		 
	}
}

/*
-0.1 0.75
2.0 -0.3
-0.5 0.56
-1.21 -0.32
0.01 -0.64
-0.52 0.57
-1.07 -0.2
-1.04 -0.28
0.33 0.77
0.26 -0.02
*/