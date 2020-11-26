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

class Result2 {

    /*
     * Complete the 'familyTree' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY parent_child
     *  2. STRING request
     */
	
	public static HashMap<String,HashSet<String>> children;
	public static HashMap<String,HashSet<String>> parents;
	public static String ans =null;
	//public static String[] possible = {"DUD","U","UU","UUU","D","DD","DDD","A"
    public static String familyTree(List<List<String>> parent_child, String request) {
    	children = new HashMap<String,HashSet<String>>();
    	parents = new HashMap<String,HashSet<String>>();
    	HashSet<String> arr = new HashSet<String>();
    	for(int i =0;i<parent_child.size();i++)
    	{
    		String p = parent_child.get(i).get(0);
    		String c = parent_child.get(i).get(1);
    		arr.add(p);
    		arr.add(c);
    		if(!children.containsKey(p))
    		{
    			children.put(p, new HashSet<String>());
    		}
    		HashSet<String> temp = children.get(p);
    		temp.add(c);
    		children.put(p, temp);
    		if(!parents.containsKey(c))
    		{
    			parents.put(c, new HashSet<String>());
    		}
    		HashSet<String> temp2 = parents.get(c);
    		temp2.add(p);
    		parents.put(c, temp2);
    	}
    	String[] tarr = request.split(" ");
    	String name1 = tarr[0];
    	String name2 = tarr[1];
    	//spouse
    	if(isSpouse(name1,name2))
    		return "spouse";
    	for(String n1:arr)
    	{
    		for(String n2:arr)
    		{
    			if(isSpouse(n1,n2))
    			{
    				//System.out.println(n1+" "+n2);
    				HashSet<String> newParents = new HashSet<String>();
    				if(parents.containsKey(n1))
    					for(String p:parents.get(n1))
    						newParents.add(p);
    				if(parents.containsKey(n2))
    					for(String p:parents.get(n2))
    						newParents.add(p);
    				parents.put(n1, newParents);
    				parents.put(n2, newParents);
    				
    				HashSet<String> newChildren = new HashSet<String>();
    				if(children.containsKey(n1))
    					for(String c:children.get(n1))
    						newChildren.add(c);
    				if(children.containsKey(n2))
    					for(String c:children.get(n2))
    						newChildren.add(c);
    				for(String c:newChildren)
    				{
    					HashSet<String> temp = parents.get(c);
    					temp.add(n1);
    					temp.add(n2);
    				}
    				children.put(n1, newChildren);
    				children.put(n2,newChildren);
    			}
    		}
    	}
    	//System.out.println(parents.get("Mike"));
    	//System.out.println(parents.get("Ella"));
    	
    	parentChecker(name1,name2,0);
    	if(ans!=null)
    		return ans;
    	childChecker(name1,name2,0);
    	if(ans!=null)
    		return ans;
    	//sibling
    	if(isSibling(name1,name2))
    	{
    		return "sibling";
    	}
    	if(isCousin(name1,name2))
    	{
    		return "cousin";
    	}
    	if(isSecondCousin(name1,name2))
    	{
    		return "second cousin";
    	}
    	if(isPibling(name1,name2))
    	{
    		return "pibling";
    	}
    	if(isGrandPibling(name1,name2))
    	{
    		return "grandpibling";
    	}
    	if(isPibling(name2,name1))
    	{
    		return "nibling";
    	}
    	if(isGrandPibling(name2,name1))
    	{
    		return "grandnibling";
    	}
    	
    	return "";
    }
    public static boolean isGrandPibling(String name1,String name2)
    {
    	if(!parents.containsKey(name1))
    		return false;
    	for(String p:parents.get(name1))
    	{
    		if(parents.containsKey(p))
    		{
    			for(String gp:parents.get(p))
    			{
    				if(isSibling(gp,name2))
    					return true;
    			}
    		}
    	}
    	return false;
    }
    public static boolean isPibling(String name1, String name2)
    {
    	if(!parents.containsKey(name1))
    		return false;
    	for(String p:parents.get(name1))
    	{
    		if(isSibling(name2,p))
    			return true;
    	}
    	return false;
    }
    public static boolean isSpouse(String name1,String name2)
    {
    	if(!children.containsKey(name1)||!children.containsKey(name2))
    		return false;
    	for(String c:children.get(name1))
    	{
    		if(children.get(name2).contains(c))
    		{
    			return true;
    		}
    	}
    	return false;
    }
    public static boolean isSecondCousin(String name1,String name2)
    {
    	if(!parents.containsKey(name1)||!parents.containsKey(name2))
    		return false;
    	for(String p1:parents.get(name1))
    	{
    		for(String p2:parents.get(name2))
    		{
    			if(isCousin(p1,p2))
    				return true;
    		}
    	}
    	return false;
    }
    public static boolean isCousin(String name1,String name2)
    {
    	if(!parents.containsKey(name1)||!parents.containsKey(name2))
    		return false;
    		
    	for(String p1:parents.get(name1))
    	{
    		for(String p2:parents.get(name2))
    		{
    			if(isSibling(p1,p2))
    				return true;
    		}
    	}
    	return false;
    }
    public static boolean isSibling(String name1, String name2)
    {
    	if(!parents.containsKey(name1)||!parents.containsKey(name2))
    		return false;
    	for(String p:parents.get(name1))
    		if(parents.get(name2).contains(p))
    			return true;
    	return false;
    }
    public static void childChecker(String cur, String end,int moves)
    {
    	if(cur.equals(end))
    	{
    		if(moves==1)
    			ans="child";
    		else if(moves==2)
    			ans = "grandchild";
    		else
    			ans = "great-grandchild";
    		return;
    	}
    	if(moves==3)
    		return;
    	if(children.containsKey(cur))
    		for(String c:children.get(cur))
    			childChecker(c,end,moves+1);
    }
    public static void parentChecker(String cur, String end,int moves)
    {
    	if(cur.equals(end))
    	{
    		if(moves==1)
    			ans="parent";
    		else if(moves==2)
    			ans = "grandparent";
    		else
    			ans = "great-grandparent";
    		return;
    	}
    	if(moves==3)
    		return;
    	if(parents.containsKey(cur))
    		for(String p:parents.get(cur))
    			parentChecker(p,end,moves+1);
    }
    /*
    public static void backtrack(String cur,String end,String moves)
    {
    	if(cur.equals(end))
    	{
    		
    		return;
    	}
    	if(moves.length()==3)
    		return;
    	if(!parents.get(cur).isEmpty())
    	{
	    	for(String sib:children.get(parents.get(cur).get(0)))
	    	{
	    		backtrack(sib,end,moves+"A");
	    	}
    	}
    	for(String child:children.get(cur))//down
    	{
    		backtrack(child,end,moves+"D");
    	}
    	for(String parent: parents.get(cur))
    	{
    		backtrack(parent,end,moves+"U");
    	}

    }*/

}

public class AS2_FamilyTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int numInputs = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> parent_child = new ArrayList<>();

        IntStream.range(0, numInputs).forEach(i -> {
            try {
                parent_child.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        String request = bufferedReader.readLine();

        String result = Result2.familyTree(parent_child, request);
        System.out.println(result);
        
        /*bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
