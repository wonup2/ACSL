import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solve {

    /*
     * Complete the 'syllables' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING word as parameter.
     */
	
	public static String[] prefix = {"co","de","dis","pre","re","un"};
	public static String[] suffix = {"age","ful","ing","less","ment"};
	public static String[] twocons = {"ch","ck","ph","sh","th","wh","wr"};
	
    public static int syllables(String word) {
    	String result1 = "";
    	String result2 = "";
    	for(String s:prefix)
    	{
    		if(word.length()>=s.length())
    		{
    			if(word.substring(0,s.length()).equals(s))
    			{
    				result1=s+"|";
    				word = word.substring(s.length());
    				break;
    			}
    		}
    	}
    	for(String s:suffix)
    	{
    		if(word.length()>=s.length())
    		{
    			if(word.substring(word.length()-s.length()).equals(s))
    			{
    				result2="|"+s;
    				word = word.substring(0,word.length()-s.length());
    				break;
    			}
    		}
    	}
    	//System.out.println(word);
    	for(int i = 0;i<word.length();i++)
    	{
    		if(isVowel(word.charAt(i)))
    		{
    			//System.out.println(i+": "+word.charAt(i));
    			String inbetween = "";
    			boolean change = false;
    			boolean vowel2 = false;
    			for(int j=i+1;j<word.length();j++)
    			{
    				
    				if(isVowel(word.charAt(j)))
    				{
    					//System.out.println(word.charAt(i)+ " "+inbetween+" "+word.charAt(j));
    					vowel2 = true;
    					if(inbetween.length()==0)
    					{
    						i=j-1;
    						break;
    					}
    					if(consCount(inbetween)==1)
    					{
    						result1+=word.charAt(i)+"|"+inbetween;
    					}
    					else
    					{
    						if(inbetween.length()==2)
    						{
    							result1+=word.charAt(i)+""+inbetween.charAt(0)+"|"+inbetween.charAt(1);
    						}
    						else
    						{
    							if(consCount(inbetween.substring(0,2))==1)
    							{
    								result1+=word.charAt(i)+inbetween.substring(0,2)+"|"+inbetween.substring(2);
    							}
    							else
    							{
    								result1+=word.charAt(i)+""+inbetween.charAt(0)+"|"+inbetween.substring(1);
    							}
    						}
    					}
    					i=j-1;
    					change = true;
    					break;
    				}
    				inbetween+=word.charAt(j);
    			}
    			if(!vowel2)
    			{
					result1+=word.charAt(i)+inbetween;
					i=word.length()-1;
    			}
    			else if(!change)
    			{
    				result1+=word.charAt(i)+inbetween;
    			}
    		}
    		else
    		{
    			result1+=word.charAt(i);
    		}
    	}
    	System.out.println(result1+result2);
		String s = result1+result2;
    	int ans = 0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='|')
				ans+=i;
		}
		return ans;    	
    }
    public static int consCount(String s)
    {
    	if(s.length()==1)
    		return 1;
    	for(String doub:twocons)
    	{
    		if(s.substring(0,2).equals(doub))
    		{
    			s= s.substring(2);
    			break;
    		}
    	}
    	if(s.length()!=0)
    		return 2;
    	else
    		return 1;
    }
    public static boolean isVowel(char c)
    {
    	return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

}

public class AS1_Syllables {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String word = bufferedReader.readLine();

        int result = Solve.syllables(word);
        System.out.println(result);
        
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
