import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String [] a = {"1", "2", "3", null};

		
		int n = 2;
		int m = 3;
		for(int i = n+1; i<m; i++) {
            a[i-1] = a[i];
       }
       
		m--;
        a[m] = null;
       
		System.out.println(Arrays.toString(a));
		
	}

}
