package Contest3;
/*
 * name: Hayley Song
 * team: Voice of Calling
 * date: 03/08/20
 * division: Intermediate 3
 */
import java.util.*;
import java.io.*;
import java.math.*;

public class IN_Veitch_Hayley {

	static Scanner in;
	static ArrayList<String> d = new ArrayList<String>();
	static String[][] v;
	static String input;

	public static void main(String[] args) {
		try {
			in = new Scanner(new File("1920c3in.in"));
			for (int i = 0; i < 5; i++) {
				init();
				solve();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		v = new String[4][4];
		input = in.nextLine();
	}

	public static void solve() {
		String temp = "";
		for (int i = 0; i < input.length(); i++) {
			if ((input.charAt(i) + "").equals("+")) {
				// temp += " ";
				d.add(temp);
				temp = "";
				continue;
			} else {
				temp += (input.charAt(i) + "");
			}
		}
		d.add(temp);
		// System.out.println(temp);
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).equals("B") || d.get(i).equals("~B") || d.get(i).equals("D") || d.get(i).equals("~D")) {
				fillRow(d.get(i));
			}
			if (d.get(i).equals("A") || d.get(i).equals("~A") || d.get(i).equals("C") || d.get(i).equals("~C")) {
				fillColumn(d.get(i));
			}else {
				fillRand(d.get(i));
			}
		}
		//System.out.println(d);
		d.clear();
		String t = "";
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v.length; j++) {
				//System.out.println(v[i][j]);
				if(v[i][j] == "x") {
					v[i][j] = "1";
				}else {
					v[i][j] = "0";
				}
			}
		}
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v.length; j++) {
				t += v[i][j];
			}
		}
		String ans = new BigInteger(t, 2).toString(16);
		ans = String.format("%4s", ans).replace(" ", "0");
		System.out.println(ans.toUpperCase());
	}

	public static void fillRow(String s) {
		for (int i = 0; i < v.length; i++) {
			if (s.equals("B")) {
				v[0][i] = "x";
				v[1][i] = "x";
			} else if (s.equals("~B")) {
				v[2][i] = "x";
				v[3][i] = "x";
			} else if (s.equals("D")) {
				v[1][i] = "x";
				v[2][i] = "x";
			} else if (s.equals("~D")) {
				v[0][i] = "x";
				v[3][i] = "x";
			}
		}
	}

	public static void fillColumn(String s) {
		for (int i = 0; i < v.length; i++) {
			if (s.equals("A")) {
				v[i][0] = "x";
				v[i][1] = "x";
			} else if (s.equals("~A")) {
				v[i][2] = "x";
				v[i][3] = "x";
			} else if (s.equals("C")) {
				v[i][1] = "x";
				v[i][2] = "x";
			} else if (s.equals("~C")) {
				v[i][0] = "x";
				v[i][3] = "x";
			}
		}
	}
	
	public static void fillRand(String s) {
		ArrayList<String> temp = new ArrayList<String>();
		String tem = "";
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i)+"").equals("~")) {
				tem = (s.charAt(i)+"") + (s.charAt(i+1)+"");
				temp.add(tem);
				i++;
			}else {
				temp.add(s.charAt(i)+"");
			}
		}
		//System.out.println(temp);
		int [][] str = new int[4][4];
		for(int i = 0; i < temp.size(); i++) {
			for(int j = 0; j < str.length; j++) {
				if (temp.get(i).equals("B")) {
					str[0][j]++;
					str[1][j]++;
				} else if (temp.get(i).equals("~B")) {
					str[2][j]++;
					str[3][j]++;
				} else if (temp.get(i).equals("D")) {
					str[1][j]++;
					str[2][j]++;
				} else if (temp.get(i).equals("~D")) {
					str[0][j]++;
					str[3][j]++;
				}else if (temp.get(i).equals("A")) {
					str[j][0]++;
					str[j][1]++;
				} else if (temp.get(i).equals("~A")) {
					str[j][2]++;
					str[j][3]++;
				} else if (temp.get(i).equals("C")) {
					str[j][1]++;
					str[j][2]++;
				} else if (temp.get(i).equals("~C")) {
					str[j][0]++;
					str[j][3]++;
				}
			}
		}
		for(int i = 0; i < str.length; i++) {
			for(int j = 0; j < str.length; j++) {
				if(str[i][j] == temp.size()) {
					v[i][j] = "x";
				}
				//System.out.println(v[i][j]);
			}
		}
		//System.out.println();
	}

}
/*AB+~AB+~A~B
AB~C~D+AB~CD+~A~B~CD
AB~C~D+~AB~C~D+A~B~C~D
B~D+~B~D
~A~BD+~A~B~D
B~D+~A~BD+A~B~C
~B~C+BCD+B~C~D
A~C+ACD+~A~CD
AB~D+~ABD+A~BD+~A~B~D
B~D+~A~CD+~A~B~C~D*/