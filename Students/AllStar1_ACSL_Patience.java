
import java.util.*;
import java.io.*;
public class AllStar1_ACSL_Patience {
    static BufferedReader br;
    static ArrayList<ArrayList<String>> s;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(new File("1819AllStar1.in")));
        for(int i = 0; i < 1; i++) {
        	try {
        		init();
        		solve();
        	}
        	catch(Exception e) {
        		e.printStackTrace(); //use while coding, comment out when submitting
        		//System.out.println("error"); //use when submitted, comment out when coding
        	}
        }
        br.close();
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	s = new ArrayList<ArrayList<String>>();
    	
    	while(st.hasMoreTokens()) {
    		String sss = st.nextToken();
    		String str = convert(sss.charAt(0)) + sss.charAt(1);
    		int num = Integer.parseInt(str.substring(0, 2));
    		char id = str.charAt(str.length() - 1);
    		boolean foundPile = false;
    		for(int i = 0; i < s.size(); i++) {
    			boolean kingToAce = false;
    			String yee = s.get(i).get(s.get(i).size() - 1);
    			if(num == 13 && Integer.parseInt(yee.substring(0, 2)) == 1)
    				kingToAce = true;
    			if((num < Integer.parseInt(yee.substring(0, 2)) || kingToAce) && id != yee.charAt(2)) {
    				foundPile = true;
    				s.get(i).add(str);
    				break;
    			}
    		}
    		if(!foundPile) {
    			s.add(new ArrayList<String>());
        		s.get(s.size() - 1).add(str);
    		}
    	}
    }
    private static void solve() {
       int[] sizes = new int[s.size()];
       int maxSize = 0;
       for(int i = 0; i < s.size(); i++) {
    	   sizes[i] = s.get(i).size();
    	   if(sizes[i] > maxSize)
    		   maxSize = sizes[i];
       }
       boolean[] isMaxSize = new boolean[s.size()];
       for(int i = 0; i < sizes.length; i++)
    	   if(sizes[i] == maxSize)
    		   isMaxSize[i] = true;
       int minSum = Integer.MAX_VALUE;
       for(int i = 0; i < isMaxSize.length; i++) {
    	   if(!isMaxSize[i])
    		   continue;
    	   int sum = 0;
    	   for(int j = 0; j < s.get(i).size(); j++)
    		   sum += Integer.parseInt(s.get(i).get(j).substring(0, 2));
    	   if(sum < minSum)
    		   minSum = sum;
       }
       System.out.println(minSum);
    }
    
    private static String convert(char c) {
    	if(c == 'A')
    		return "01";
    	else if(c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
    		return "0" + c;
    	else if(c == 'T')
    		return "10";
    	else if(c == 'J')
    		return "11";
    	else if(c == 'Q')
    		return "12";
    	else
    		return "13";
    }
}