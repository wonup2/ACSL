package Contest3;
/*
 * Joshua Nam
 * Grade 10
 * Division Intermediate 5
 * 1-25-2020
 * Stempia
 */
import java.util.*;
import java.io.*;
public class IN_Veitch_Int_Joshua {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File("1920C3IN.in"));
		for(int z = 0; z < 5; z++) {
			String inp = in.nextLine();
			String temp = "";
			ArrayList<String> a = new ArrayList<String>();
			for(int i = 0; i < inp.length(); i++) {
				if(inp.charAt(i) != '+')
					temp += inp.charAt(i);
				else {
					a.add(temp);
					temp = "";
				}
			}
			a.add(temp);
			ArrayList<String> res = new ArrayList<String>();
			res.add("0000"); res.add("0000"); res.add("0000"); res.add("0000");
			boolean[][] table = new boolean[4][4];
			for(int i = 0; i < a.size(); i++) {
				String cond = a.get(i);
				eval(table, cond, res);
			}
			
			for(int i = 0; i < 4; i++) {
				System.out.print(Integer.toHexString(Integer.parseInt(res.get(i), 2)).toUpperCase());
			}
			System.out.println();
		}
	}
	
	public static void eval(boolean[][] arr, String cond, ArrayList<String> res) {
		String check = cond.replaceAll("~", "");
		boolean mult = false;
		
		if(check.length() > 1)
			mult = true;
		
		if(cond.contains("~A")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(j>=2)
						arr[i][j] = true;
				}
			}
		}
		else if(cond.contains("A")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(j<=1)
						arr[i][j] = true;
				}
			}
		}
		
		if(cond.contains("~B")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(mult && cond.indexOf("~B") != 0) {
						if(i>=2 && arr[i][j])
							arr[i][j] = true;
						else
							arr[i][j] = false;
					}
					else {
						if(i>=2)
							arr[i][j] = true;
					}
				}
			}
		}
		else if(cond.contains("B")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(mult && cond.indexOf("B") != 0) {
						if(i<=1 && arr[i][j])
							arr[i][j] = true;
						else
							arr[i][j] = false;
					}
					else {
						if(i<=1)
							arr[i][j] = true;
					}
				}
			}
		}
		
		if(cond.contains("~C")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(mult && cond.indexOf("~C") != 0) {
						if((j == 0 || j == 3) && arr[i][j])
							arr[i][j] = true;
						else
							arr[i][j] = false;
					}
					else {
						if(j==0 || j==3)
							arr[i][j] = true;
					}
				}
			}
		}
		else if(cond.contains("C")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(mult && cond.indexOf("C") != 0) {
						if((j == 1 || j == 2) && arr[i][j])
							arr[i][j] = true;
						else
							arr[i][j] = false;
					}
					else {
						if(j==1 || j==2)
							arr[i][j] = true;
					}
				}
			}
		}
		
		if(cond.contains("~D")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(mult && cond.indexOf("~D") != 0) {
						if((i == 0 || i == 3) && arr[i][j])
							arr[i][j] = true;
						else
							arr[i][j] = false;
					}
					else {
						if(i==0 || i==3)
							arr[i][j] = true;
					}
				}
			}
		}
		else if(cond.contains("D")) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(mult && cond.indexOf("D") != 0) {
						if((i == 1 || i == 2) && arr[i][j])
							arr[i][j] = true;
						else
							arr[i][j] = false;
					}
					else {
						if(i==1 || i==2)
							arr[i][j] = true;
					}
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			String temp = res.get(i);
			for(int j = 0; j < 4; j++) {
				if(arr[i][j]) {
					temp = temp.substring(0, j) + "1" + temp.substring(j+1);
					res.set(i, temp);
				}
			}
		}
	}

}
/*
AB+~AB+~A~B
AB~C~D+AB~CD+~A~B~CD
AB~C~D+~AB~C~D+A~B~C~D
B~D+~B~D
~A~BD+~A~B~D
B~D+~A~BD+A~B~C
~B~C+BCD+B~C~D
A~C+ACD+~A~CD
AB~D+~ABD+A~BD+~A~B~D
B~D+~A~CD+~A~B~C~D
 */
