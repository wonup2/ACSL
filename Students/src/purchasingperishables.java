import java.util.*;

class purchasingperishables{
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();

        long min = Long.MAX_VALUE;
        long total = 0l;
        
        for(int i=0; i<n; i++){
        	int cost = in.nextInt(); 
            min = Math.min(min, cost);
            //System.out.println(cost+" "+min);
            total+=min;
        }
        
        System.out.println(total);
    }
}