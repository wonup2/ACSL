import java.util.*;

public class Contest1_JR_Tiles {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int s = in.nextInt(); in.nextLine();
		String a = in.nextLine();
		
		int result = findDiscardSum(s, a);
		System.out.println(result);		
	}
	
	static int findDiscardSum(int originalRows, String tiles) {
		
		String[] rows = {String.valueOf(originalRows / 1000), String.valueOf((originalRows / 100) % 10), String.valueOf((originalRows / 10) % 10), String.valueOf(originalRows % 10)};
        String discardPile = "";

        int idx = 0;
        while (idx < tiles.length()) {
        	
            boolean placed = false;
            String tile = tiles.substring(idx, idx + 2);
            System.out.println(tile);
            
            
            for (int i = 0; i < 4; i++) {
                
                if (rows[i].charAt(rows[i].length() - 1) == tile.charAt(0)) {
                	//coding
                	
                	placed = true;
                    break;
                }
                
                else if(rows[i].charAt(rows[i].length() - 1) == tile.charAt(1)) {
                	//coding
                
                	placed = true;
                    break;
                }                
            }
            
            
            if (!placed) {
                discardPile += tile;
            }
            
            idx += 3;  //<-------- not 2 you have to think about space between the numbers.
        }
        
        
        int sum = 0;
        for (int i=0; i<discardPile.length(); i++) {
              sum += Integer.parseInt(discardPile.charAt(i) + "");            
        }
        
        return sum;

	}
}
