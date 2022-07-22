import java.util.*;
public class C3_JR_1718{

    static Scanner in;
    static int [][] a;
    
    public static void main(String [] args) {
        
        in = new Scanner(System.in);
        
        init();
        int r = in.nextInt();
        int c = in.nextInt();
        String result = solve(r, c);
        System.out.println(result);
        
    }
    
    static void init() {
        
        String input[] = in.nextLine().split(", ");        
        a = new int[4][4];
        
        for(int i = 0; i<4; i++) {
            
            String s = input[i];
            int zero = 4 % s.length();
            for(int j = 0; j<zero; j++) s = "0" + s;
                
            for(int j = 0; j<4; j++) {
                
                a[i][j] = s.charAt(j) - '0';
            }
        }
        
        //System.out.println(Arrays.deepToString(a));
    }
    
    static String solve(int r, int c) {
        
    	r = r-1;
    	c = c-1;
        for(int i = 0; i<6; i++) {

            if(a[r][c]==0) {
            	a[r][c]++;
            	if(a[r][c]==4) a[r][c]=0;
                c++;
                if(c>3) c=0;                
        
            }else if(a[r][c]==1) {
            	a[r][c]++;
            	if(a[r][c]==4) a[r][c]=0;
                c--;
                if(c<0) c=3;
        
            }else if(a[r][c]==2) {
            	a[r][c]++;
            	if(a[r][c]==4) a[r][c]=0;
                r--;
                if(r<0) r=3;
            
            }else {
            	a[r][c]++;
            	if(a[r][c]==4) a[r][c]=0;
                r++;
                if(r>3) r=0;
            }
            
        	//System.out.println(r+" "+ c +" "+Arrays.deepToString(a));

        }
        
        return (r+1) + ", " + (c+1);
        
    } 
    
}

//231, 1233, 1302, 1201