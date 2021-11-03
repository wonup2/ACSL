
public class Contest1_Junior {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(sumOfLastRow(4326,1234, 80));		
	}

	public static int sumOfLastRow(int s, int d, int r) {
		
		 int firstNum = digitsSum(s);	 
		 

		 int finalRowLastNum = firstNum;
		 
		 for (int i=0;i<r-2;i++) {
			 finalRowLastNum = rowLastNum(finalRowLastNum, d, i+2);
		 }
		 
		 int passedNum = finalRowLastNum;
		 int lastRowSum = 0;
		 
		 for (int i=0;i<r;i++) {
			 passedNum += d;
			 while (passedNum>=10) {
				 passedNum = digitsSum(passedNum);
			 }
			 lastRowSum += passedNum;
		 }
		 return lastRowSum;
	 }
	
	 public static int digitsSum(int s) {
		 int digit = 0;
		 int sum = 0;
		 while (s > 0) {
			 digit = s%10;
			 sum += digit;
			 s/=10;
		 }
		 return sum;
	}
		 
	public static int rowLastNum (int passedNum, int d, int rowNum) {
		 for (int i=0;i<rowNum;i++) {
			 passedNum += d;
			 	while (passedNum>=10) {
			 		passedNum = digitsSum(passedNum);
			 	}
		 }
		 return passedNum;
	 }
}
