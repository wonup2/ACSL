import java.util.*;
import java.util.Scanner;

public class C42 {
static Scanner in;
static String array[];
static ArrayList<Integer> path = new ArrayList<>();
static int locationi, locationj, sum, newTile;
static List<List<Integer>> boardValues = new ArrayList<List<Integer>>(); 
static List<List<Integer>> copyBoard = new ArrayList<List<Integer>>();

static String finalBoard[][];
static boolean checked;

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
	
		String s = "8 128 4 128 32 16 16 4 256 16 32 4 16 64 4 8 64 64 256 8 16 2 2 256 4 32 128 2 64 8 256 32 128 16 2 8 64 64 128 32";
		array = s.split(" ");
		
		 int idx = 0;
	        for (int i = 0; i < 8; i++) {
	            List<Integer> row = new ArrayList<>();
	            for (int j = 0; j < 5; j++) {
	                row.add(Integer.parseInt(array[idx]));
	                idx++;
	            }
	            boardValues.add(row);
	        }
        
	    System.out.println(boardValues)  ;
	        
		for (int i=0;i<8; i++) {
			if (!checked) {
				for (int j=0; j<5; j++) {
				
					if (!checked && j < 4 && boardValues.get(i).get(j).equals(boardValues.get(i).get(j + 1))) {
                	
						path.add(boardValues.get(i).get(j));			
						path.add(boardValues.get(i).get(j + 1));
                    
						boardValues.get(i).set(j, 0);

                    
	                	locationi= i;
	                	locationj = j+1;
	                	checked = true;
	                	boardValues.get(i).remove(j);
	                	break;
			
					}
           
					else if (!checked && i < 7 && j > 0 && boardValues.get(i).get(j).equals(boardValues.get(i + 1).get(j - 1))) {
		            	 path.add(boardValues.get(i).get(j));
		                 path.add(boardValues.get(i + 1).get(j - 1));
		             	 boardValues.get(i).set(j, 0);
		
		                 locationi = i + 1;
		                 locationj = j - 1;
		                 checked = true;
		                 break;
					}
		            else if (!checked && i < 7 && boardValues.get(i).get(j).equals(boardValues.get(i + 1).get(j))) {
		                path.add(boardValues.get(i).get(j));
		                path.add(boardValues.get(i + 1).get(j));
		            	boardValues.get(i).set(j, 0);
		
		                locationi = i + 1;
		                locationj = j;
		                checked = true;
		                break;
		            } 
		            
		            else if (!checked && i < 7 && j < 4 && boardValues.get(i).get(j).equals(boardValues.get(i + 1).get(j + 1))) {
		                path.add(boardValues.get(i).get(j));
		                path.add(boardValues.get(i + 1).get(j + 1));
		            	boardValues.get(i).set(j, 0);
		
		                locationi = i + 1;
		                locationj = j + 1;
		                checked = true;
		                break;
		            }
           
				}
			
			}
		}
				
		
		System.out.println(path +" " + locationi + " "+ locationj);
		int i = locationi;
		int j = locationj;
		boolean find = true;
		
		while(find) {
                
			find = false;
			if ( j > 0 && (boardValues.get(i).get(j).equals(boardValues.get(i).get(j - 1)) 
						|| (boardValues.get(i).get(j) * 2) == (int)(boardValues.get(i).get(j - 1)))) {
                	
                path.add(boardValues.get(i).get(j - 1));
                boardValues.get(i).set(j, 0);
                j= j-1;
                find = true;
			}
               
            else if (j <4 && (boardValues.get(i).get(j).equals(boardValues.get(i).get(j + 1)) 
            				|| boardValues.get(i).get(j) * 2 == (int)(boardValues.get(i).get(j + 1)))) {
            	path.add(boardValues.get(i).get(j + 1));
            	boardValues.get(i).set(j, 0);
            	
				j=j+1;
                find = true;
			}
      
            else if ((i < 7 && j > 0) && (boardValues.get(i).get(j).equals(boardValues.get(i + 1).get(j - 1)) 
            						||  (boardValues.get(i).get(j) * 2)==(int)(boardValues.get(i + 1).get(j - 1)))) { 
            	path.add(boardValues.get(i + 1).get(j - 1));            
          		boardValues.get(i).set(j, 0);
                i = i+1;
                j--;
                find = true;
            }
                
            else if (i <7 && (boardValues.get(i).get(j)== (int)(boardValues.get(i + 1).get(j)) 
            					|| boardValues.get(i).get(j) * 2 == (int)(boardValues.get(i + 1).get(j)))) {
            	
            	System.out.println("111");
            	path.add(boardValues.get(i+1).get(j));
            	boardValues.get(i).set(j, 0); 
                 i = i+1;                
                find = true;


			}
                
            else if ((i < 7 && j < 4) && (boardValues.get(i).get(j).equals(boardValues.get(i + 1).get(j + 1))
            							|| boardValues.get(i).get(j) * 2 == (int)(boardValues.get(i + 1).get(j + 1)))) { 
            
            	path.add(boardValues.get(i + 1).get(j + 1));
            	boardValues.get(i).set(j, 0);

                i++;
                j++;
                find = true;
            }
		}
	
		System.out.println("path: "+path);
		/*
		int last = path.get(path.size()-1);
		int lastR = -1;
		int lastC = -1;
		for (i=0; i<boardValues.size(); i++) {
			List <Integer> row = boardValues.get(i);
			for (j=0; j<row.size(); j++) {
				if (row.get(j)==last) {
					lastR = i;
					lastC = j;
				}
			}
		}

		for (int i=0; i<path.size(); i++) {
			sum+= path.get(i);
		}
		sum = path.stream().mapToInt(Integer::intValue).sum();
		int replace = 1;
		while (replace<sum) {
			replace *=2;
		}
		
		boardValues.get(lastR).set(lastC, replace);
		
		boolean largest = true;
		for (List<Integer> row: boardValues) {
			for (int value:row) {
				if (value > replace) {
					largest = false;
					break;
				}
			}
			if (!largest) {
				break;
			}
		}
		
		if (largest) {
			int powersOfTwo = (int) (Math.log(replace) / Math.log(2));
		    if (powersOfTwo > 8) {
		        for (List<Integer> row : boardValues) {
		            for (int i = 0; i < row.size(); i++) {
		                int currentValue = row.get(i);
		                if (currentValue <= (int) Math.pow(2, Math.abs(8-powersOfTwo))){
		                	row.set(i, 0);
		                }
		            }
		        }
		    }
		}
		for (int j=0; j<5; j++) {
			for (int i=7; i>0; i--) {
				if (boardValues.get(i).get(j)==0) {
					for (int k=i-1; k>=0; k--) {
						if (boardValues.get(k).get(j)!=0) {
							boardValues.get(i).set(j, boardValues.get(k).get(j));
							boardValues.get(k).set(j, 0);
							break;
						}
					}
				}
			}
		}
		
		newTile = replace;
		for (int i=0; i<8; i++) {
			for (int j=0; j<5; j++) {
				if (boardValues.get(i).get(j)==0) {
					boardValues.get(i).set(j, newTile);
					newTile /=2;
					
					if (newTile <=(int) Math.pow(2, Math.abs(8-(int) (Math.log(replace) / Math.log(2))))) { 
						newTile = replace;
					}
					
				}
			}
		}
		
		//1024 512 256 128 64 
		//32 16 8 128 1024 
		//256 512 256 256 128 
		//32 64 32 64 32
		//16 16 8 256 16 
		//32 128 64 256 8 
		//256 128 8 64 8 
		//8 16 1024 16 32
		
//512 256 128 128 64
//32 16 8 256 32
//4 512 256 64 16
//8 128 64 256 4 
//16 128 32 256 8
//32 16 16 64 4
//256 64 64 16 8
//8 128 128 512 32
		
		
		System.out.println(path);
		System.out.println(boardValues);
		*/
}
}
