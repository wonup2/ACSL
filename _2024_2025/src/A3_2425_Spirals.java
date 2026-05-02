import java.util.*;

public class A3_2425_Spirals {

	static String type;
	static int col, row, t1, t2, arr[][];
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		type=in.next();
		col=in.nextInt();
		row=in.nextInt();
		t1=in.nextInt();
		t2=in.nextInt();
		
		if(type.equals("inward")) inward() ;
		else outward();

	}
	
	static void distance() {
		
		int c1=0, r1=0, c2=0, r2=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(arr[i][j]==t1) {c1=i; r1=j;}
				if(arr[i][j]==t2) {c2=i; r2=j;}
			}
		}
		
		int ans = Math.abs(c1-c2) + Math.abs(r1-r2);
		System.out.println(ans);
	}
	
	static void inward() {
		 arr = new int[row][col];

	     int top = 0, bottom = row - 1;
	     int left = 0, right = col - 1;

	     int num = 1;

	     while (top <= bottom && left <= right) {
	    	 
	    	 //right
	    	 for (int c = left; c <= right; c++) arr[top][c] = num++;
	            
	         top++;

	         //down
	         for (int r = top; r <= bottom; r++) arr[r][right] = num++;
	            
	         right--;

	         //left
	       	 for (int c = right; c >= left; c--) arr[bottom][c] = num++;
	         
	       	 bottom--;

	         //up
	         for (int r = bottom; r >= top; r--) arr[r][left] = num++;
	             
	         left++;
	     }
	}
	
	static void outward() {

	    int r = 0, c = 0;
	    int num = 1;

	    int r1=0, c1=0, r2=0, c2=0;

	    // 시작 위치 체크
	    if (num == t1) { r1=r; c1=c; }
	    if (num == t2) { r2=r; c2=c; }

	    int step = 3;

	    while (true) {

	        // right →
	        System.out.print("right: ");
	        for (int i = 0; i < step; i++) {
	            c++;
	            num++;
	            System.out.printf("(%d, %d) ", r, c);

	            if (num == t1) { r1=r; c1=c; }
	            if (num == t2) { r2=r; c2=c; }
	        }
	        System.out.println();

	        // down ↓
	        System.out.print("down: ");
	        for (int i = 0; i < step; i++) {
	            r++;
	            num++;
	            System.out.printf("(%d, %d) ", r, c);

	            if (num == t1) { r1=r; c1=c; }
	            if (num == t2) { r2=r; c2=c; }
	        }
	        System.out.println();

	        step++;

	        // left ←
	        System.out.print("left: ");
	        for (int i = 0; i < step; i++) {
	            c--;
	            num++;
	            System.out.printf("(%d, %d) ", r, c);

	            if (num == t1) { r1=r; c1=c; }
	            if (num == t2) { r2=r; c2=c; }
	        }
	        System.out.println();

	        // up ↑
	        System.out.print("up: ");
	        for (int i = 0; i < step; i++) {
	            r--;
	            num++;
	            System.out.printf("(%d, %d) ", r, c);

	            if (num == t1) { r1=r; c1=c; }
	            if (num == t2) { r2=r; c2=c; }
	        }
	        System.out.println();

	        step++;

	        // 둘 다 찾으면 종료
	        if ((r1!=0 || c1!=0) && (r2!=0 || c2!=0)) break;
	    }

	    int ans = Math.abs(c1-c2) + Math.abs(r1-r2);
	    System.out.println(ans);
	}
}
