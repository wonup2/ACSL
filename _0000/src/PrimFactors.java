import java.util.HashSet;

public class PrimFactors {

	public static void main(String[] args) {
			
		HashSet<Long> prim = new HashSet<Long>();
        long n = Long.parseLong("102438");
        
        for (long i = 2; i < n; i++) {
            while (n % i == 0) {
            	prim.add(i);
                n /= i;    
            }
        }
        if (n > 2)
           prim.add(n);
               
        
        System.out.println(prim);        
            

	}
}
