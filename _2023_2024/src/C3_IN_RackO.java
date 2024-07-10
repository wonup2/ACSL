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

public class C3_IN_RackO {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		String c = in.nextLine();
		
		int ans = playRackO(a, b, c);
		System.out.println(ans);
	}
	
    public static int playRackO(String info, String rack, String pile) {
        int s = Integer.parseInt(info.split(" ")[0]);
        int n = Integer.parseInt(info.split(" ")[1]);
        
        List<Integer> rackList = new ArrayList<>();        
        for (String card : rack.split(" ")) 
            rackList.add(Integer.parseInt(card));
                
        List<Integer> pileList = new ArrayList<>();
        for (String card : pile.split(" ")) 
            pileList.add(Integer.parseInt(card));
               
        while (!RackInOrder(rackList) && !pileList.isEmpty()) {
        	
            if(RackInOrder(rackList)) break;

            int card = pileList.get(0);
            pileList.remove(0);
            
            boolean cardUsed = false;
            
            //check 1
            for (int i = 1; i < s; i++) {

                if (card+1 == rackList.get(i)) { 
                    rackList.set(i - 1, card);
                    cardUsed = true;             
                    break;
                } 
            }
            
            if(cardUsed) continue;
            
            //check 2
            for (int i = 0; i < s-1; i++) {

                if (card -1 == rackList.get(i)) { 
                    rackList.set(i + 1, card);
                    cardUsed = true;             
                    break;
                } 
            }
            
            if(cardUsed) continue;

            //check 3
            for (int i = 0; i < s-2; i++) {
            	int a = rackList.get(i);
            	int b = rackList.get(i+1);
            	int c = rackList.get(i+2);

                if (!(a<b && b<c) && (a<card&&card<c)) { 
                    rackList.set(i + 1, card);
                    cardUsed = true;             
                    break;
                } 
            }
            
            if(cardUsed) continue;

            //check 4           	
            if (card<rackList.get(1)&&rackList.get(0)>rackList.get(1)) { 
                rackList.set(0, card);
                cardUsed = true;             
            }
            
            if(cardUsed) continue;

            //check 5
            if (card>rackList.get(s-2)&&rackList.get(s-1)<rackList.get(s-2)) { 
                rackList.set(s-1, card);
                cardUsed = true;             
                System.out.println("card: " + card +" rackList "+ rackList);               
            }            
        }        
        
        int value = 0;        

        if(RackInOrder(rackList)) {

        	int bonus = 1;        	
        	for(int i=0; i<s; i++) {
        		value += rackList.get(i);
        		if(i<s-1 && rackList.get(i)+1 == rackList.get(i+1)) bonus++;  
        		else {
        			if(bonus>=3) value+=bonus*5;
        			bonus=1;
        		}
        	}        	
        }
        
        else {
        	
        	for(int i=0; i<s-1; i++) 
        		if(rackList.get(i) > rackList.get(i+1)) value--;        	
        }

        return value;
    }
    
    public static boolean RackInOrder(List<Integer> rack) {
    	
        for (int i = 0; i < rack.size() - 1; i++) 
            if (rack.get(i) > rack.get(i + 1)) return false;           
     
        return true;
    }   
}