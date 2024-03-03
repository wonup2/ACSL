import java.io.*;
import java.util.*;

public class ACSLTiles_Senior {
    static Scanner in;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int s = in.nextInt(); in.nextLine();
		String a = in.nextLine();
		String b = in.nextLine();
		
		int result = findHandSum(s, a, b);
		System.out.println(result);		
	}
	public static int findHandSum(int originalRows, String handTiles, String drawPile) {
        List<String> hand = new ArrayList<>(Arrays.asList(handTiles.split(" ")));
        List<String> draw = new ArrayList<>(Arrays.asList(drawPile.split(" ")));
        String _or = Integer.toString(originalRows);
        while (_or.length() < 4) {
            _or = "0" + _or;
        }
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).length() < 2) {
                hand.set(i, "0" + hand.get(i));
            }
        }
        for (int i = 0; i < draw.size(); i++) {
            if (draw.get(i).length() < 2) {
                draw.set(i, "0" + draw.get(i));
            }
        }
        List<String> rows = new ArrayList<>();
        rows.add(_or.substring(0, 1));
        rows.add(_or.substring(1, 2));
        rows.add(_or.substring(2, 3));
        rows.add(_or.substring(3, 4));

        int r = 0;
        int dd = -1;
        while (!hand.isEmpty()) {
            boolean exit = false;
            boolean found = false;
            for (int i = 0; i < hand.size(); i++) {
                int to = -1;
                int r_it = r;
                while (true) {
                    if (dd != -1) {
                        int c = check(rows.get(dd), hand.get(i));
                        if (c == 0) {
                            to = dd;
                            dd = -1;
                            break;
                        } else if (c == 1) {
                            to = dd;
                            dd = -1;
                            Collections.reverse(Arrays.asList(hand.get(i).split("")));
                            break;
                        } else if (c == 2) {
                            dd = r_it;
                            to = dd;
                            break;
                        } else break;
                    } else {
                        int c = check(rows.get(r_it), hand.get(i));
                        if (c == 0) {
                            to = r_it;
                            break;
                        } else if (c == 1) {
                            to = r_it;
                            Collections.reverse(Arrays.asList(hand.get(i).split("")));
                            break;
                        } else if (c == 2) {
                            dd = r_it;
                            to = r_it;
                            break;
                        }
                        r_it++;
                        if (r_it > 3) r_it = 0;
                        if (r_it == r) {
                            break;
                        }
                    }
                }
                if (to == -1) {
                    // continue
                } else {
                    rows.set(to, hand.get(i));
                    hand.remove(i);
                    found = true;
                    r = to + 1;
                    if (r > 3) r = 0;
                    if (dd != -1) {
                        r = dd;
                    }
                    break;
                }
            }
            if (!found) {
                if (draw.isEmpty()) {
                    exit = true;
                    break;
                }
                hand.add(draw.get(0));
                draw.remove(0);
            }
            if (exit) {
                break;
            }
        }
        int sum = 0;
        for (String s : hand) {
            for (char c : s.toCharArray()) {
                sum += c - '0';
            }
        }
        return sum;
    }

    public static int check(String a, String b) {
        char test = a.charAt(a.length() - 1);
        if (b.length() == 1) {
            if (b.charAt(0) == test) return 0;
            else return -1;
        }
        if (b.charAt(0) == test && b.charAt(1) == test) return 2; // double
        if (b.charAt(0) == test) return 0;
        if (b.charAt(1) == test) return 1;
        return -1;
    }

}
