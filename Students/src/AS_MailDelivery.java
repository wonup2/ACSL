


import java.util.*;
import java.io.*;

public class AS_MailDelivery {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<String> original = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			original.add(in.next());
		}
		in.nextLine();
		for (int i = 0; i < 5; i++) {
			int newN = in.nextInt();
			String[] newH = new String[newN];
			for (int j = 0; j < newN; j++) {
				newH[j] = in.next();
			}
			char gate = in.next().charAt(0);
			int k = in.nextInt();

			String[] houses = new String[original.size() + newN];
			int pos = 0;
			for (String element : original) {
				houses[pos] = element;
				pos++;
			}

			for (String element : newH) {
				houses[pos] = element;
				pos++;
			}
			
			for (int j = 0; j < houses.length; j++) {
				String zeroes = "";
				for(int l = 0; l < 5 - houses[j].length(); l++)
					zeroes += "0";
				houses[j] = houses[j].substring(0, 1) + zeroes + houses[j].substring(1);
			}
			Arrays.sort(houses);
			//System.out.println(Arrays.toString(houses));

			ArrayList<String> order = new ArrayList<String>();
			for (int j = 0; j < houses.length; j++) {
				if ((houses[j].charAt(0) - 'A') >= (gate - 'A') && (houses[j].charAt(houses[j].length() - 1) - '0') % 2 != 0) {
					order.add(houses[j]);
				}
			}
			for (int j = 0; j < houses.length; j++) {
				if ((houses[j].charAt(0) - 'A') < (gate - 'A') && (houses[j].charAt(houses[j].length() - 1) - '0') % 2 != 0) {
					order.add(houses[j]);
				}
			}
			for (int j = 0; j < houses.length; j++) {
				if ((houses[j].charAt(0) - 'A') >= (gate - 'A') && (houses[j].charAt(houses[j].length() - 1) - '0') % 2 == 0) {
					order.add(houses[j]);
				}
			}
			for (int j = 0; j < houses.length; j++) {
				if ((houses[j].charAt(0) - 'A') < (gate - 'A') && (houses[j].charAt(houses[j].length() - 1) - '0') % 2 == 0) {
					order.add(houses[j]);
				}
			}
			//System.out.println(order.size());
			String answer = order.get(k - 1);
			if(answer.substring(1, 4).equals("000"))
				answer = answer.substring(0, 1) + answer.substring(4);
			else if(answer.substring(1, 3).equals("00"))
				answer = answer.substring(0, 1) + answer.substring(3);
			else if(answer.substring(1, 2).equals("0"))
				answer = answer.substring(0, 1) + answer.substring(2);
			System.out.println(answer);
			for(int j = 0; j < newH.length; j++)
				original.add(newH[j]);
//			for (int j = 0; j < order.size(); j++) {
//				System.out.print(order.get(j) + " ");
//			}
//			System.out.println(Arrays.toString(houses));
		}
	}
}
