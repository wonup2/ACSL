import java.util.*;

public class A4_seega {
	
	static Scanner in;
	static char seega[][];
	
	public static void main(String[] args){
		
		in = new Scanner(System.in);
					
		for(int a=1; a<=5; a++){
			init();
			System.out.println(solve(seega,'X'));
			System.out.println(solve(seega,'O'));				
		}
	}
	
	
	static void init() {
		
		seega = new char[5][5];
		for(int i=0; i<5;i++)			
			for(int j=0; j<5; j++)
				seega[i][j]='-';
						
		int num=in.nextInt();
		
		int n = 0;
		
		for(int i=0; i<num; i++){
			n = in.nextInt();
			seega[(n-1)/5][(n-1)%5] = 'X';
		}
		
		for(int i=0; i<num; i++){
			n = in.nextInt();
			seega[(n-1)/5][(n-1)%5] = 'O';
		}
				
		//System.out.println(Arrays.deepToString(seega));		
	}
	
	static String solve(char[][] seega, char type){
		
		int pos=0;
		
		for(int r=0; r<5; r++){
			for(int c=0; c<5; c++){
				if(seega[r][c]==type){
					pos = canKill(seega,r,c);
					if(pos!=0) return pos+"";
				}				
			}
		}
		
		for(int r=0; r<5; r++){
			for(int c=0; c<5; c++){
				if(seega[r][c]==type && isDanger(seega,r,c)){
					pos = canSafe(seega,r,c);
					if(pos!=0) return pos+"";
				}				
			}
		}
		
		for(int r=0; r<5; r++){
			for(int c=0; c<5; c++){
				if(seega[r][c]==type){
					pos = canSafe(seega,r,c);
					if(pos!=0) return pos+"";
				}				
			}
		}
		
		return "LOSE A TURN";
	}
	
	static int canKill(char[][] s, int r, int c){
		
		char p1 = s[r][c];
		
		char p2 = flip(p1);
		
		if(r+1<5 && s[r+1][c]=='-'){
			if( c-2>=0 && s[r+1][c-2]==p1 && s[r+1][c-1]==p2 
			 || c+2<5  && s[r+1][c+2]==p1 && s[r+1][c+1]==p2 
			 || r+3<5  && s[r+2][c]==p2   && s[r+3][c]==p1)
			 
				return cellNum(r+1,c);
		}
		
		if(r-1>=0 && s[r-1][c]=='-'){
			if( c-2>=0 && s[r-1][c-2]==p1 && s[r-1][c-1]==p2 
			 || c+2<5  && s[r-1][c+2]==p1 && s[r-1][c+1]==p2 
			 || r-3>=0 && s[r-2][c]==p2   && s[r-3][c]==p1)
			
				return cellNum(r-1,c);
		}
		
		if(c+1<5 && s[r][c+1]=='-'){
			if( r-2>=0 && s[r-2][c+1]==p1 && s[r-1][c+1]==p2 
			 || r+2<5  && s[r+2][c+1]==p1 && s[r+1][c+1]==p2 
			 || c+3<5  && s[r][c+2]==p2   && s[r][c+3]==p1)
				
				return cellNum(r,c+1);
		}
		
		if(c-1>=0 && s[r][c-1]=='-'){
			if( r-2>=0 && s[r-2][c-1]==p1 && s[r-1][c-1]==p2 
			 || r+2<5  && s[r+2][c-1]==p1 && s[r+1][c-1]==p2 
			 || c-3>=0 && s[r][c-2]==p2   && s[r][c-3]==p1)
			
				return cellNum(r,c-1);
		}
		
		return 0;
	}
	
	public static int canSafe(char[][] s, int r, int c){
		
		char p1 = s[r][c];
		char p2 = flip(p1);
		
		//B1
		if(s[2][2]=='-'&& (cellNum(r,c)==18 ||cellNum(r,c)==12 || cellNum(r,c)==14 || cellNum(r,c)==8))		 
			return 13;
		
		//B2
		if(r+1<5 && s[r+1][c]=='-'){
			if( c-1>=0 && s[r+1][c-1]==p2 && c+1<5 && s[r+1][c+1]==p2 )
				return cellNum(r+1,c);
		}
		
		if(r-1>=0 && s[r-1][c]=='-'){
			if( c-1>=0 && s[r-1][c-1]==p2 && c+1<5 && s[r-1][c+1]==p2 )
				return cellNum(r-1,c);
		}
		
		if(c+1<5 && s[r][c+1]=='-'){
			if( r-1>=0 && s[r-1][c+1]==p2 && r+1<5 && s[r+1][c+1]==p2 )
				return cellNum(r,c+1);
		}
		
		if(c-1>=0 && s[r][c-1]=='-'){
			if( r-1>=0 && s[r-1][c-1]==p2 && r+1<5 && s[r+1][c-1]==p2 )
				return cellNum(r,c-1);
		}
		
		
		//B3&B4
		if(c+1<5 && s[r][c+1]=='-')  return cellNum(r,c+1);		
		
		if(c-1>=0 && s[r][c-1]=='-') return cellNum(r,c-1);
		
		if(r+1<5 && s[r+1][c]=='-')  return cellNum(r+1,c);
		
		if(r-1>=0 && s[r-1][c]=='-') return cellNum(r-1,c);
		
		
		return 0;
	}
	
	public static boolean isDanger(char[][] s, int r, int c){
		
		char p1 = s[r][c];
		char p2 = flip(p1);
		

		if(r+1<5 && s[r+1][c]==p2){
			if( r-1>=0 && (c-1>0 && s[r-1][c-1]==p2 || c+1<5 && s[r-1][c+1]==p2) )
				return true;
		}
		
		if(r-1>=0 && s[r-1][c]==p2){
			if( r+1<5 && (c-1>0 && s[r+1][c-1]==p2 || c+1<5 && s[r+1][c+1]==p2) )
				return true;
		}
		
		if(c+1<5 && s[r][c+1]==p2){
			if( c-1>=0 && (r-1>0 && s[r-1][c-1]==p2 || r+1<5 && s[r+1][c-1]==p2) )
				return true;
		}
		
		if(c-1>=0 && s[r][c-1]==p2){
			if( c+1<5 && (r-1>0 && s[r-1][c+1]==p2 || r+1<5 && s[r+1][c+1]==p2) )
				return true;
		}
		
		return false;
	}
	
	public static char flip(char type){
		if(type=='X')
			return 'O';
		if(type=='O')
			return 'X';
		return '-';
	}
	
	public static int cellNum(int r, int c){
		return 1+c+r*5;
	}
}

/*

3 1 8 21 2 5 9
3 1 2 6 3 7 11
2 7 10 8 11
2 8 18 7 9
2 7 14 1 8


3
7
LOSE A TURN
4
9
6
13
6
9
6

*/