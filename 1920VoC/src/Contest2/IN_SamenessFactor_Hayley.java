package Contest2;
/*
 * name: Hayley Song
 * team: Voice of Calling
 * date: 01/25/20
 * division: Intermediate 3
 */

import java.util.*;
import java.io.*;

public class IN_SamenessFactor_Hayley {

	static Scanner in;
	static String[] str, str1;
	static ArrayList<String> a1, a2;
	static boolean check;
	static int len;

	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920C2in.in"));
		for (int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("Error");
			}
		}
		in.close();
	}

	private static void init() {
		str = in.next().split("");
		str1 = in.next().split("");
		a1 = new ArrayList<String>(Arrays.asList(str));
		a2 = new ArrayList<String>(Arrays.asList(str1));
		// System.out.println(a1);
		// System.out.println(a2);
	}

	private static void solve() {
		int asf = 0;
		boolean chk = false;
		while (!chk) {
			check = false;
			len = Math.min(a1.size(), a2.size());
			same();
			if (!check)
				break;
			len = Math.min(a1.size(), a2.size());
			for (int i = 0; i < len - 1; i++) {
				if (a1.get(i).equals(a2.get(i + 1))) {
					a2.remove(i);
					len--;
					same();
					i--;
					check = true;
				} else if (a1.get(i + 1).equals(a2.get(i))) {
					a1.remove(i);
					len--;
					same();
					i--;
					check = true;
				}
			}
			if (!check)
				break;
		}
		// calculate asf
		len = Math.min(a1.size(), a2.size());
		String s = "";
		String s1 = "";
		for (int i = 0; i < len; i++) {
			s = a1.get(i);
			s1 = a2.get(i);
			asf += ((s.charAt(0) - 'A') - (s1.charAt(0) - 'A'));
		}
		asf += Math.abs(a1.size() - a2.size());
		System.out.println(asf);
	}

	static void same() {
		for (int i = 0; i < len; i++) {
			if (a1.get(i).equals(a2.get(i))) {
				a1.remove(i);
				a2.remove(i);
				len--;
				i--;
				check = true;
			}
		}

	}
}
