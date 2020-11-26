package Contest2;
/*
 * Joshua Nam
 * Grade 10
 * Division Intermediate 5
 * 1-25-2020
 * Stempia
 */
import java.util.*;
import java.io.*;
public class IN_SamenessFactor_Int_Joshua {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("1920C2IN.in"));
		for(int z = 0; z < 5; z++) {
			String a = in.next();
			String b = in.next();
			ArrayList<String> s1 = new ArrayList<String>();
			ArrayList<String> s2 = new ArrayList<String>();
			for(int i = 0; i < a.length(); i++) {
				s1.add(a.charAt(i)+"");
			}
			for(int i = 0; i < b.length(); i++) {
				s2.add(b.charAt(i)+"");
			}
			int min = Math.min(s1.size(), s2.size());
			int j = 0;
			while(j < min) {
				if(s1.get(j).equals(s2.get(j))) {
					s1.remove(j);
					s2.remove(j);
					min--;
				}
				else 
					j++;
			}
			ArrayList<String> temp1 = new ArrayList<String>(s1);
			ArrayList<String> temp2 = new ArrayList<String>(s2);
			for(int i = 0; i < min-1; i++) {
				if(temp2.get(i+1).equals(temp1.get(i))) {
					temp2.remove(i);
					j = 0;
					min = Math.min(temp1.size(), temp2.size());
					while(j < min) {
						if(temp1.get(j).equals(temp2.get(j))) {
							temp1.remove(j);
							temp2.remove(j);
							min--;
						}
						else
							j++;
					}
					i--;
				}
				else if(temp1.get(i+1).equals(temp2.get(i))) {
					temp1.remove(i);
					j = 0;
					min = Math.min(temp1.size(), temp2.size());
					while(j < min) {
						if(temp1.get(j).equals(temp2.get(j))) {
							temp1.remove(j);
							temp2.remove(j);
							min--;
						}
						else
							j++;
					}
					i--;
				}

				min = Math.min(temp1.size(), temp2.size());

			}
			s1 = (ArrayList<String>) temp1.clone();
			s2 = (ArrayList<String>) temp2.clone();
			min = Math.min(s1.size(), s2.size());
			int res = 0;
			for(int i = 0; i < min; i++) {
				int x = (s1.get(i).charAt(0) - s2.get(i).charAt(0));
				res += x;
			}
			int diff = Math.max(s1.size(), s2.size()) - min;
			res += diff;
			System.out.println(res);
		}
	}

}
/*
BLAMEABLENESSES BLAMELESSNESSES
MEZZAMINES RAZZMATAZZ
ABBREVIATIONS ABBREVIATORS
ABCDEFGHIJKLMNO ABKCLDZZHQJWWLX
ABCDEFHIJKL ABXEWFRRH
*/