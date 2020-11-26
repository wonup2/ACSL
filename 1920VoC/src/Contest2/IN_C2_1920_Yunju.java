package Contest2;
/*
 * Yunju Song 10
 * Voice of Calling
 * Inter 3
 */


import java.io.*;
import java.util.*;
public class IN_C2_1920_Yunju {
	static Scanner in;
	static String[] temp1;
	static String[] temp2;
	static ArrayList<String> first;
	static ArrayList<String> second;
	static int size;
	static boolean precheck = false;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C2IN.in"));
		
		 for(int i=0; i<10; i++){
				try{			
					init();
					System.out.println(solve());			
				}
				catch(Exception e){
					//System.out.println("Error");
	                e.printStackTrace();
				}
	        }
		 
		 in.close();

	}
	static void init(){
		temp1 = in.next().split("");
		temp2 = in.next().split("");
		first = new ArrayList<String>(Arrays.asList(temp1));
		second = new ArrayList<String>(Arrays.asList(temp2));
		
	}
	static int solve(){
		int asf = 0;
		boolean check = false;
		
		while(check == false){
			
			precheck = false;
			
			if(first.size() <= second.size()) size = first.size();
			else size = second.size();
			
			duplicate();
			
			if(first.size() <= second.size()) size = first.size();
			else size = second.size();
			
			//if characters are like after removal
			for(int i = 0; i < size-1; i++){
				if(first.get(i).equals(second.get(i+1))){
					second.remove(i);
					size = size-1;
					duplicate();
					i=i-1;
					precheck = true;
				}
				else if(first.get(i+1).equals(second.get(i))){
					first.remove(i);
					size = size-1;
					duplicate();
					i=i-1;
					precheck = true;
				}
			}
			
			if(precheck == false){
				break;
			}
			
		}
		//get asf
		if(first.size() <= second.size()) size = first.size();
		else size = second.size();
		for(int i = 0; i < size; i++){
			String a = first.get(i);
			String b = second.get(i);
			asf += (a.charAt(0) - 'A') - (b.charAt(0) - 'A');
		}
		asf += Math.abs(first.size() - second.size());
		return asf;
	}
	static void duplicate(){
		//if characters are like
		for(int i = 0; i < size; i++){
			if(first.get(i).equals(second.get(i))){
				first.remove(i);
				second.remove(i);
				size = size - 1;
				i--;
				precheck = true;
			}
		}
	}
	
}


