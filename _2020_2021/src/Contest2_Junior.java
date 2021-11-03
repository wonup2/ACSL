import java.util.*;
public class Contest2_Junior {
	
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		String s = in.nextLine();
		String result = lexStrings(s);
		System.out.println(result);
	}

	public static String lexStrings(String s) {
		
		String ret = "";

		s = s.toLowerCase();
		s = s.replaceAll("[^a-z]","");
				
		while(true) {
			
			TreeSet<String> a= new TreeSet<String>();
			for(int i=0; i<s.length(); i++)
				a.add(s.charAt(i)+"");		
			
			for(String c:a) {
				s = s.replaceFirst(c, "");
				ret+=c;
			}
			
			if(s.length()==0) break;		
		}
			
		String ans = ret.charAt(0)+"";
		for(int i=1; i<ret.length(); i++) {
			if(ret.charAt(i)!=ans.charAt(ans.length()-1)) ans+=ret.charAt(i);
		}
		
		return ans;
	 }	
}

/*
A good sorting algorithm. 
1. adghilmnorstagiortgo
Tennessee is the volunteer state. 
2. aehilnorstuvenstenstestete
Einstein was a genius. 
3. aeginstuwaeinseins
Tom Sawyer & the Mississippi River 
4. aehimoprstvwyeimprsteirsisis
She sells seashells by the seashore.
5. abehlorstyaehlsehlsehlseseses
*/
 

