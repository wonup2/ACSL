import java.util.TreeSet;

//https://www.codestepbystep.com/problem/view/java/strings/removeDuplicates
//https://www.codestepbystep.com/problem/view/java/strings/removeAll
//removeAll
//removeFirst
//abcabcabcccc ---> abcabcabc 


public class Contest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String s = "aaaaa";
		System.out.println(s.replace("a", "b"));		//------> bbbbb	
		System.out.println(s.replaceFirst("a", "b"));  	// -----> baaaa

		String x = "abcabcabc";
		TreeSet<String> set = new TreeSet<String>();
		for(int i=0; i<x.length(); i++)
			set.add(x.substring(i, i+1));
		
		System.out.println(set);	// ------> [a, b, c]
		
		String ans = "";
		for(String letter: set)
			ans+=letter;  
		
		System.out.println(ans); // --------> abc
		
	}

}
