package Contest2;


import java.util.*;
import java.io.*;

/*
 name :Hannah Moon
 grade :9
 team :Voice of Calling
 division: junior 
 contest 2
 */
public class C2_StringDifferences_Hannah {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner (new File ("1920C2JR.in"));
		for (int z = 0; z < 5; z++) {
		String city1 = in.next();
		String city2 = in.next();
		String final1 = "";
		String final2 = "";
		final1 += final1 + city1.charAt(0);
		int nextchar = 1;
		for (int i = 1; i < city1.length(); i++) {
			char temp = final1.charAt(nextchar-1);
			if (temp != city1.charAt(i)) {
				final1 += city1.charAt(i);
				nextchar++;
			}
		}
		final2 += final2 + city2.charAt(0);
		nextchar = 1;
		for (int i = 1; i < city2.length(); i++) {
			char temp = final2.charAt(nextchar-1);
			if (temp != city2.charAt(i)) {
				final2 += city2.charAt(i);
				nextchar++;
			}
		}
		//System.out.println(final1 + final2);
		String f1 = "";
		String f2 = "";
		f1 += final1.charAt(0);
		f2 += final2.charAt(0);
		for (int i = 1; i < final1.length(); i++) {
			char temp = final1.charAt(i);
			if (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
				continue;
			}
			else {
				f1 += temp;
			}
		}
		for (int i = 1; i < final2.length(); i++) {
			char temp = final2.charAt(i);
			if (temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U') {
				continue;
			}
			else {
				f2 += temp;
			}
		}
		//System.out.println(f1 + " " + f2);
		String [] no1 = f1.split("");
		String [] no2 = f2.split("");
		final1 = "";
		final2 = "";
		int len = 0;
		if (no1.length < no2.length) {
			len = no1.length;
		}
		else len = no2.length;
		//System.out.println(len);
		//System.out.println(Arrays.toString(no1));
		//System.out.println(Arrays.toString(no2));
		for (int i = 0; i < len; i++) {
			if (no1[i].equals(no2[i])) {
				continue;
			}
			else {
				final1 += no1[i];
				final2 += no2[i];
			}
		}
		//System.out.println(final1 + " " + final2);
		if (len < no1.length) {
			for (int i = len; i < no1.length; i++) {
				final1 += no1[i];
			}
		}
		else if (len < no2.length) {
			for (int i = len; i < no2.length; i++) {
				final2 += no2[i];
			}
		}
		//System.out.println(final1 + " " + final2);
		String []ff1 = new String [final1.length()];
		String []ff2 = new String [final2.length()];
		int curr = 0;
		for (int i = final1.length()-1; i >= 0; i--) {
			char tt = final1.charAt(i);
			String s = Character.toString(tt);
			ff1[curr] = s;
			curr++;
		}
		curr = 0;
		for (int i = final2.length()-1; i >= 0; i--) {
			char tt = final2.charAt(i);
			String s = Character.toString(tt);
			ff2[curr] = s;
			curr++;
		}
		//System.out.println(Arrays.toString(ff1));
		//System.out.println(Arrays.toString(ff2));
		len = 0;
		if (ff1.length < ff2.length) {
			len = ff1.length;
		}
		else len = ff2.length;
		//System.out.println(len);
		final1 = "";
		final2 = "";
		for (int i = 0; i < len; i++) {
			if (ff1[i].equals(ff2[i])) {
				continue;
			}
			else {
				final1 += ff1[i];
				final2 += ff2[i];
			}
		}
		if (len < ff1.length) {
			for (int i = len; i < ff1.length; i++) {
				final1 += ff1[i];
			}
		}
		else if (len < ff2.length) {
			for (int i = len; i < ff2.length; i++) {
				final2 += ff2[i];
			}
		}
		//System.out.println(final1 + " " + final2);
		String []fff1 = new String [final1.length()];
		String []fff2 = new String [final2.length()];
		curr = 0;
		for (int i = final1.length()-1; i >= 0; i--) {
			char tt = final1.charAt(i);
			String s = Character.toString(tt);
			fff1[curr] = s;
			curr++;
		}
		curr = 0;
		for (int i = final2.length()-1; i >= 0; i--) {
			char tt = final2.charAt(i);
			String s = Character.toString(tt);
			fff2[curr] = s;
			curr++;
		}
		//System.out.println(Arrays.toString(fff1));
		//System.out.println(Arrays.toString(fff2));
		final1 = "";
		final2 = "";
		if (fff1.length < fff2.length) {
			for (int i = 0; i < fff1.length; i++) {
				System.out.print(fff1[i]);
			}
		}
		else if (fff1.length > fff2.length) {
			for (int i = 0; i < fff2.length; i++) {
				System.out.print(fff2[i]);
			}
		}
		else {
			String tt1 = fff1[0];
			String tt2 = fff2[0];
			char temp1 = tt1.charAt(0);
			char temp2 = tt2.charAt(0);
			int t1 = temp1;
			int t2 = temp2;
			if (t1 < t2) {
				for (int i = 0; i < fff1.length; i++) {
					System.out.print(fff1[i]);
				}
			}
			if (t1 > t2) { 
				for (int i = 0; i < fff2.length; i++) {
					System.out.print(fff2[i]);
				}
			}
		}
		System.out.println("");
		}
	}

}
