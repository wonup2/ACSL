import java.util.*;
import java.io.*;

public class AS4_Detection {
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1415as4.in"));
		for (int i = 0; i < 20; i++) {
			String ans = "";
			String maskStr = in.next();
			int[] mask = new int[maskStr.length()];
			for (int j = 0; j < mask.length; j++)
				mask[j] = Integer.parseInt(maskStr.substring(j, j + 1));
			int num = Integer.parseInt(in.next());
			String temp = "";
			for (int j = 0; j < num; j++)
				temp += "1";
			for (int j = 0; j < mask.length - num; j++)
				temp += "0";
			int n = Integer.parseInt(in.next());
			list = new ArrayList<String>();
			combinations(temp, "");
			boolean somethingPrint = false;
			for (int j = 0; j < list.size(); j++) {
				String string = list.get(j);
				int res = 0;
				for (int k = 0; k < string.length(); k++) {
					if (string.charAt(k) == '1') {
						res += mask[k];
					}
				}
				if (res == n) {
					ans += string + " ";
					somethingPrint = true;
				}
			}
			if (somethingPrint) {
				System.out.println(ans.substring(0, ans.length() - 1));
			} else {
				System.out.println("NONE");
			}
		}
	}

	public static void combinations(String str, String results) {
		if (str.length() == 0) {
			list.add(results);
			return;
		}
		boolean[] b = new boolean[2];
		for (int i = 0; i < str.length(); i++) {
			int n = Integer.parseInt(str.substring(i, i + 1));
			String temp = str.substring(0, i) + str.substring(i + 1);
			if (!b[n])
				combinations(temp, results + str.substring(i, i + 1));
			b[n] = true;
		}
	}
}