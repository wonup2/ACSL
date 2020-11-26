package Contest4;
/*
 * name: Julia Jeong
 * grade: 10th
 * team: Voice of Calling
 * date: 04/07/20
 * division: Intermediate 3
 */

import java.io.*;
import java.util.*;
public class IN_patolli_Julia {

	static Scanner in;
	static HashSet <Integer> prime = new HashSet<Integer>();
	static HashSet <Integer> perfect = new HashSet<Integer>();
	static ArrayList<Integer> p;
	static int[] dice;
	static String ans;
	static int op1,op2,op3;
	static int start, n;

	public static void main(String[] args) {
		
		prime.add(1);
		prime.add(2);
		prime.add(3);
		prime.add(5);
		prime.add(7);
		prime.add(11);
		prime.add(13);
		prime.add(17);
		prime.add(19);
		prime.add(23);
		prime.add(29);
		prime.add(31);
		prime.add(37);
		prime.add(41);
		prime.add(43);
		prime.add(47);
		
		perfect.add(4);
		perfect.add(9);
		perfect.add(16);
		perfect.add(25);
		perfect.add(36);
		perfect.add(49);
		
		
		try {
			in = new Scanner (new File("1920c4in.in"));
			for(int i =0; i <5; i++) {
				init();
				System.out.println(solve());
			}
			
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void init() {
		ans = "";
		op1 = in.nextInt();
		op2 = in.nextInt();
		op3 = in.nextInt();
		
		p = new ArrayList<Integer>();
		p.add(in.nextInt());
		p.add(in.nextInt());
		p.add(in.nextInt());
		
		n = in.nextInt();
		dice = new int[n];
		for(int i =0; i < n; i++) {
			dice[i] = in.nextInt();
		}
		
		//.out.println(p);
		//System.out.println("dice: " + Arrays.toString(dice));
	}
	
	private static String solve() {

		for(int i =0; i < n; i++) {
			Collections.sort(p);
			//System.out.println(p);
			int go = p.get(0) + dice[i];
			play(go, dice[i]);		}
		Collections.sort(p);
		//System.out.println(p);
		ans = "";
		if(p.size() == 0)
			return "GAME OVER";
		for(int i =0; i < p.size(); i++) {
			ans += p.get(i)+ " ";
		}
		
		return ans.substring(0, ans.length()-1);
		
	}
		
	private static void play (int x, int di) {
		int curr = p.get(0);    		//System.out.print( curr+ " + " + di +" = "+x);

		if(x > 52)
			return;
		else if(x == 52)
			p.remove(0);
		else {
			if(!occupied(x)) {
				return;
			}else {
				
				if(prime.contains(x)) {   					//System.out.print(" prim: " );

					fSix(x); 
				}else if(perfect.contains(x)) {   					//System.out.print(" square: " );

					bSix(x);
				}else if(turn(curr, x)){  					//System.out.print(" rulw9: " );

					goMult(curr, di);
				}else {
					p.remove(0);
					p.add(x);
				}
			}
		}
		//System.out.println(p.get(p.size()-1));
	}
	private static boolean occupied(int x) {
		if(x == op1 || x == op2 || x == op3)
			return false;
		for(int i =0; i < p.size();i++) {
			if(p.get(i) == x)
				return false;
		}
		return true;
	}
	
	private static boolean turn(int x, int y) {
		if(x<=6 && y >=8)
			return true;
		else if(x<= 11&& y>= 13)
			return true;
		else if(x<= 16&& y>= 18)
			return true;
		else if(x<= 21&& y>= 23)
			return true;
		else if(x<= 26&& y>= 28)
			return true;
		else if(x<= 34&& y>= 36)
			return true;
		else if(x<= 39&&y>= 41)
			return true;
		else if(x<= 44&& y>= 46)
			return true;
		else if(x<= 49&& y>= 51)
			return true;
		return false;
	}
	
	private static void fSix(int x) {
		int max = x +6;
		

		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(op1);
		temp.add(op2);
		temp.add(op3);
		for(int i =1; i < p.size(); i++) {
			temp.add(p.get(i));
		}
		Collections.sort(temp);
		//System.out.print(temp);
		for(int i =0; i < temp.size(); i++) {
			if(temp.get(i)<=max && temp.get(i)>x) {
				p.remove(0);
				p.add(temp.get(i)-1);
				
				return;
			}
		}
		p.remove(0);
		p.add(max);
		
	}
	
	private static void bSix(int x) {
		int min = x-6;
		if(min <1)
			min =1;

		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(op1);
		temp.add(op2);
		temp.add(op3);
		for(int i =1; i < p.size(); i++) {
			temp.add(p.get(i));
		}
		Collections.sort(temp);
		for(int i =temp.size()-1; i >= 0; i--) {
			if(temp.get(i)>=min && temp.get(i)<x) {
				p.remove(0);
				p.add(temp.get(i)+1);
				return;
			}
		}
		
		p.remove(0);
		p.add(min);
	}

	private static void goMult(int cur, int di) {
		
		int begin = (cur/di + 1) * di;
		//System.out.print("begin= " + begin + " ");
		for(int i =begin; i <= 52; i += di) {
			if(!occupied(i)) {
				return;
				
			}else {
				p.remove(0);
				p.add(i);
				return;
			}
		}
		return;
	}
}
