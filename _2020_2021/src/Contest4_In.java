import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Contest4_In {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Math.round(-0.1218999999999999*100)/100.0);
		Result r = new Result();
		double a = -1.21;
		double b = -0.32 ; 
		String ans = r.cycleLength(a, b);
		
		System.out.println(ans);
	}
	

}
class Result {
	 /*
	 * Complete the 'cycleLength' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts following parameters:
	 * 1. FLOAT realPartC
	 * 2. FLOAT imagPartC
	 */
	 public static String cycleLength(double realPartC, double imagPartC) {
		 
		 DecimalFormat df = new DecimalFormat("0.0000");
		 DecimalFormat df2 = new DecimalFormat("0.00");
		 df.setRoundingMode(RoundingMode.HALF_UP);
		 double fReal = realPartC;
		 double fImag = imagPartC;
		 ArrayList<Complex> list = new ArrayList<Complex>();
		 boolean escape = false;
		 int cnt = 1;
		 
		 while(list.isEmpty() || fReal != realPartC || fImag != imagPartC) {
			 
			 double tempR = fReal * fReal - fImag * fImag + realPartC;
			 double tempI = 2 * fReal * fImag + imagPartC;
			 //System.out.println(cnt+") "+fReal+" "+fImag);

			 fReal = Double.parseDouble(df2.format(Double.parseDouble(df.format(tempR))));
			 fImag = Double.parseDouble(df2.format(Double.parseDouble(df.format(tempI))));
			 System.out.println(cnt+") "+tempR+" "+tempI);

			 System.out.println(cnt+") "+fReal+" "+fImag);
			 ++cnt;
			 boolean contains = false;
			 int index = -1;
			 for(Complex c : list) {
				 ++index;
				 if(c.r == fReal && c.i == fImag) {
					 //System.out.println("contains: " + index+") "+fReal+" "+fImag);
					 contains = true;
					 break;
				 }
			 }
			 
			 list.add(new Complex(fReal, fImag));

			 if(contains) {
			 	++index;
			 	cnt = cnt - index;
			 	break;
			 }
			 	
			 if(Math.sqrt(fReal * fReal + fImag * fImag) > 4) {
			 	escape = true;
			 	break;
			 }
		}
		 System.out.println(fReal+" "+fImag);

		 return escape ? "ESCAPES " + cnt : "" + (cnt - 1);
		 
	 }
		
	 static class Complex {
		 
		 public double r;
		 public double i;
		 
		 public Complex(double real, double imaginary) {
			 r = real;
			 i = imaginary;
		 
		 }		
		 
		 public String toString() {
			 return r+" "+i;
		 }
	 }
	}
