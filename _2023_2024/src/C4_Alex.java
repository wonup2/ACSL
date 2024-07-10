import java.util.*;

public class C4_Alex {

	public static void main(String[] args) {
		String s = "512 256 128 64 32 16 8 4 16 512 256 128 32 16 64 32 16 256 16 128 8 4 64 64 32 64 8 4 8 4 128 16 32 8 256 16 256 64 512 32";
		s = "256 128 64 128 32 32 16 8 256 16 4 2 16 64 4 4 128 32 256 8 16 16 64 256 4 32 64 2 64 8 256 2 128 16 2 8 128 256 4 32";
		s = "256 8 4 16 128 64 4 32 256 256 8 32 8 4 2 64 8 8 2 8 64 16 64 16 128 4 4 4 32 64 64 2 8 8 32 128 128 128 64 4";
		s = "2 2 32 16 2 2 8 256 2 128 4 16 64 16 32 8 8 4 16 4 8 8 32 64 2 64 8 64 8 256 128 256 16 8 32 16 32 64 128 2";
//512 256 128 64 32 16 8 4 16 512 256 128 32 16 64 32 16 256 16 128 8 4 64 64 32 64 8 4 8 4 128 16 32 8 256 16 256 64 512 32
//512 256 128 64 32 16 8 4 16 512 256 128 32 16 64 32 16 256 16 128 8 4 64 64 32 64 8 4 8 4 128 16 32 8 256 16 256 64 512 32
		s = "256 8 4 16 128 64 4 32 256 256 8 32 8 4 2 64 8 8 2 8 64 16 64 16 128 4 4 4 32 64 64 2 8 8 32 128 128 128 64 4";


		String ans = play2248(s);
		System.out.println(ans);
	}
	
	static void print(int[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print("\t"+a[i][j]);
			}
			System.out.println();
		}
	}
	
	static void print(boolean[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print("\t"+a[i][j]);
			}
			System.out.println();
		}
	}
	
	public static String play2248(String boardValues) {
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 4, 8, 16,
		32, 64, 128, 256));

		 StringTokenizer st = new StringTokenizer(boardValues);
		 int[][] board = new int[8][5];
		 boolean[][] taken = new boolean[8][5];
		
		 for(int i = 0; i < 8; i++){
		 for(int j = 0; j < 5; j++){
		 board[i][j] = Integer.parseInt(st.nextToken());
		 }
		 }
		 
//--------->>
	        System.out.println("original");
	        print(board);
//--------->>  
	        
		 int sum = 0;
		 int nextRow = 0;
		 int nextCol = 0;
		 whole:
		 for(int row = 0; row < 8; row++){
			 for(int col = 0; col < 5; col++){
				 for(ArrayList<Integer> loc : getAvailable(row, col, true, taken)){
					 nextRow = loc.get(0);
					 nextCol = loc.get(1);
					 if(board[row][col] == board[nextRow][nextCol]){
						 sum = board[row][col] + board[nextRow][nextCol];
						 taken[row][col] = true;
						 break whole;
					 }
				 }
			 }
		 }
		 
//--------->>
	        System.out.println("step 1");
	        print(taken);
	        System.out.println(sum+" "+ nextRow +" "+ nextCol);
//--------->>  
	        
		 ArrayList<ArrayList<Integer>> available = getAvailable(nextRow, nextCol, false, taken);
		 int nr = 0;
		 int nc = 0;
		 int current;
		 int next;
		 hole: 
		 while(!available.isEmpty()){
			current = board[nextRow][nextCol]; 
			for(ArrayList<Integer> loc : available){
				nr = loc.get(0);
				nc = loc.get(1);
				next = board[nr][nc];

				if(current == next || current * 2 == next){
					sum += board[nr][nc];
					taken[nextRow][nextCol] = true;

					nextRow = nr;
					nextCol = nc;
					available = getAvailable(nextRow, nextCol, false, taken);
					continue hole; 
				}
			 }

			 break;
		 }
		 
//--------->>
	        System.out.println("step 2");
	        print(taken);
//--------->>  
		
		 
	    int numm = 256;
		if(sum > numm){
			while(numm < sum){
				 numm *= 2;
				 nums.remove(0);
				 nums.add(numm);
			}
		}
		else{
			for(int i : nums){
				 if(sum <= i){
					 numm = i;
					 break;
				 }
			 }
		 }
		 board[nextRow][nextCol] = numm;

//--------->>
        System.out.println("step 3");
        System.out.println(numm+" "+nums);
        print(board);
//--------->> 		
		
		
		 ArrayList<Integer> column;
		 for(int col = 0; col < 5; col++){
			 column = new ArrayList<>();
			 for(int row = 0; row < 8; row++){
				 if(!nums.contains(board[row][col]) || taken[row][col]) column.add(0, 0);			 
				 else column.add(board[row][col]);			 
			 }	
	
			 for(int r = 0; r < 8; r++)
				 board[r][col] = column.remove(0);			 
		 }
//--------->>
		 System.out.println("step 4");
		 print(board);
//--------->> 
		 
		 int n;
		 for(int row = 0; row < 8; row++){
			 for(int col = 0; col < 5; col++){	
				 if(board[row][col] == 0){
					 n = nums.remove(7);
					 nums.add(0, n);
					 board[row][col] = n;
				 }
			 }
		 }
		 
//--------->>
		 System.out.println("step 5");
		 print(board);
		 System.out.println(nums);
//--------->> 
		
		 String s = "";
		 for(int[] r : board){
			 for(int c : r){
				 s += c + " ";
			 }
		 }
		
		 return s.substring(0, s.length() -1);
		
	}
		
		public static ArrayList<ArrayList<Integer>> getAvailable(int row, int col, boolean start, boolean[][] taken){
			 
			 ArrayList<ArrayList<Integer>> available = new ArrayList<>();
			 
			 if(!start && col - 1 >= 0 && !taken[row][col -1])available.add(new	ArrayList<>(Arrays.asList(row, col - 1)));
			 if(col + 1 <= 4 && !taken[row][col + 1])available.add(new	ArrayList<>(Arrays.asList(row, col + 1)));
			 if(row + 1 <= 7){
				 if(col - 1 >= 0 && !taken[row + 1][col - 1])available.add(new ArrayList<>(Arrays.asList(row + 1, col - 1)));
				 if(!taken[row + 1][col])available.add(new ArrayList<> (Arrays.asList(row + 1, col)));
				 if(col + 1 <= 4 && !taken[row + 1][col + 1])available.add(new ArrayList<>(Arrays.asList(row + 1, col + 1)));
			 }
			 
			 //System.out.println(available);
			 return available;
		 }
		
}


//256 128 64 16 128 256 32 16 256 256 64 8 32 4 2 64 32 8 2 8 64 64 64 16 128 4 4 4 32 64 64 2 8 8 32 128 128 128 64 4
//256 128 64 16 128 256 32 16 256 256 64 8 32 4 2 64 32 8 2 8 64 64 64 16 128 4 4 4 32 64 64 2 8 8 32 128 128 128 64 4

