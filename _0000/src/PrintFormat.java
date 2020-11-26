import java.text.DecimalFormat;

public class PrintFormat {

	public static void main(String[] args) {

		
		double a = 35.6780;
		System.out.printf("%.2f %s\n", a, "lee");  	//35.68	
		System.out.printf("%5.2f \n", 37.0);  		//3.7  -> 03.70
		System.out.printf("%-10s\n", "Lee");  		//Lee          
		System.out.printf("%10s\n", "Lee");  		//       Lee 
		System.out.printf("$%,3.2f", 12345678.0);  	//1234  -> 1,234

		
		DecimalFormat currency = new DecimalFormat("$##.##");   	
		double money = .456;
		String output = currency.format(money);	
		System.out.println(output);  // $0.46
		
		currency = new DecimalFormat("$0.00");	
		money = .4;
		output = currency.format(money);	
		System.out.println(output);   // $0.40

		System.out.printf("%02d:%02d",3, 4);
		System.out.printf("%.2f", 3.6547);
	}

}
