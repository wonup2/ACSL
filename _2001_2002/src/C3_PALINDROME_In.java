import java.util.*;
public class C3_PALINDROME_In {

	public static void main(String[] args) {
		//input
		Scanner in = new Scanner(System.in);
				
		for(int i = 0; i<4; i++){
			String result = "None, ";
			String n = in.next();  //1211
			int b = in.nextInt();  //3
			Long sum = 0l;
			int count = 0;
			
			while(true){	
				
				//reverse -- 1121(3)
				String reverse = new StringBuilder(n).reverse().toString();
				//System.out.println("reverse " + reverse);
				
				//change n base b to decimal -- 1121(3) to 43(10)
				//change reverse base b to decimal -- 1211(3) to 49(10)
				Long n1 = Long.parseLong(n, b);
				Long n2 = Long.parseLong(reverse, b);
								
				//sum n1 and n2 -- 43 + 49 = 92
				sum = n1+n2;				
				
				//convert sum decimal to base b -- 92(10) to 10102(3)
				String convert = Long.toString(sum,b);
								
				//isPalindrom(10102) ? -- break;
				if(isPalindrom(convert+"")){
					result = convert;
					break;
				}
				//Is count 10? -- break;
				if(count==9){
					result += convert;
					break;
				}
				
				n = convert; 
				count++;
			}
			System.out.println(result);
		}
	}
	
	public static boolean isPalindrom(String s){
		return s.equals(new StringBuilder(s).reverse().toString());
	}
}
/*
87 10
1211 3
3112 4
196 10

Answer
4884
112211
233332
NONE, 18211171
*/