package Contest4;
/*
Julian Ha
11th Grade
Stempia
Senior 3 Contest 4
*/

import java.util.*;
import java.io.*;

public class seniorContest4_Julian {
	
	static BufferedReader br;
	static PrintWriter out;
	static StringTokenizer st;
	static ArrayList<Integer> p1, p2, temp;
	static int n, p1sum, p2sum;
	static Queue<Integer> rolls;
	static int[] banned = {7, 12, 17, 22, 27, 35, 40, 45, 50};

	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new FileReader(new File("1920c4sr.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("seniorContest4.out")));
		for(int i=0; i<5; i++) {
		init();
		solve();
		}
		
		br.close();
		out.close();

	}
	
	private static void init() throws IOException {
		
		p1 = new ArrayList<Integer>();
		p2 = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 3; i++) {
			p1.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < 3; i++) {
			p2.add(Integer.parseInt(st.nextToken()));
		}
		
		n = Integer.parseInt(st.nextToken());
		rolls = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			rolls.add(Integer.parseInt(st.nextToken()));
		}
		
		p1sum = 0;
		p2sum = 0;
		
	}
	
	private static void solve() {
		
		int ori=0,marker=0, roll=0;
		boolean isP1 = true;
		
		while (!rolls.isEmpty()) {
			
			Collections.sort(p1); 			
			Collections.sort(p2);			
			
			if (isP1)
				ori = p1.get(0);
			else
				ori = p2.get(0);
			
			roll = rolls.poll();
			
			marker = ori + roll;    //System.out.print(ori+" + "+roll+" = "+ marker);
			
			
			if (marker > 52 || p1.contains(marker) || p2.contains(marker)) {//System.out.print(" Occupied ");
				marker = ori;
			}

			else if (isPrime(marker)) { 	
				marker = movePrime(marker); //System.out.print(" prim " + marker);
			}
			
			else if (isSquare(marker)) {
				marker = moveSquare(marker, ori); //System.out.print(" square " + marker);
			}
			
			else if (isRule9(marker, ori, roll)) {  
				marker = moveRule9(roll, marker, ori);//System.out.print(" rule9 " + marker);
			}
			
			if (marker == 52) {		//System.out.print(" 52! ");
				if (isP1)
					p1.remove(0);
				else
					p2.remove(0);
				continue;
			}
					
		
			if (isP1)
				p1.set(0, marker);
			else
				p2.set(0, marker);
			
			//System.out.println(p1+" "+p2);
			isP1 = !isP1;			
		}			

		for (int i = 0; i < p1.size(); i++) {
			p1sum += p1.get(i);
		}
		for (int i = 0; i < p2.size(); i++) {
			p2sum += p2.get(i);
		}
		
		System.out.println(p1sum + " " + p2sum);
		
	}
	
	private static boolean isPrime(int marker) {
		
        for (int i = 2; i <= marker/2; i++)  {
            if (marker % i == 0) 
                return false; 
        }
        return true;
	}
	
	private static int movePrime(int marker) {
		
		temp = reset();//System.out.println(temp);
		
		for (int i = 0; i < 6; i++) {
			if (temp.contains(marker+1)) {
				break;
			}
			marker++;
		}
		
		return marker;
		
	}
	
	private static boolean isSquare(int marker) {
		if(marker<9) return false;
		return (int)Math.sqrt(marker) == Math.sqrt(marker);		
	}
	
	private static int moveSquare(int marker, int ori) {
		  temp = reset();
		  for (int i = 0; i <6 ; i++) {
		    if (temp.contains(marker-1) &&  marker-1 !=ori) 
		        break;
		    marker--;
		  }
		  return marker; 
		}
	
	private static boolean isRule9(int marker, int ori, int roll) {
		
		for (int i = 0; i < 9; i++) {
			if (ori < banned[i] && marker > banned[i]) {
				return true;
			}
		}
		
		return false;
		
	}

	private static int moveRule9(int roll, int marker, int ori) {
		
		temp = reset();		//System.out.println(temp);		
	
		for (int i = marker; i >= ori; i--) {
			
			if (i % roll == 0 && !temp.contains(i)) {
				return i;
			}			
		}
		
		return ori;
		
	}

	private static ArrayList<Integer> reset() {
		
		ArrayList<Integer> ret = new ArrayList<Integer>();
		
		ret.addAll(0, p1);
		ret.addAll(0, p2);
		
		Collections.sort(ret);
		
		return ret;
		
	}
	
}

/*
[1, 9, 18] [3, 10, 17] 3
1 + 3 = 4 noRule4
[4, 9, 18] [3, 10, 17] 1
3 + 1 = 4[4, 9, 18] [3, 10, 17] 6
4 + 6 = 10[4, 9, 18] [3, 10, 17] 4
3 + 4 = 7 Prime8
[4, 9, 18] [8, 10, 17] 6
4 + 6 = 10[4, 9, 18] [8, 10, 17] 6
8 + 6 = 14 Rule912
[4, 9, 18] [10, 12, 17] 5
4 + 5 = 9[4, 9, 18] [10, 12, 17] 5
10 + 5 = 15 Rule915

31 44

*/