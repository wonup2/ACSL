package Contest3;

import java.io.*;
import java.util.*;
public class JR_Veitch_Samuel {
	static Scanner in;
	static String fbi;
	static String sbi;
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("1920c3jr.in"));
		for(int i=0; i<5; i++) {
            try {            
                init();
                solve();
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        in.close();

	}
	
	static void init(){
		String n = in.nextLine();
		String f = Character.toString(n.charAt(0));
		String s = Character.toString(n.charAt(1));
		
		fbi = String.format("%04d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(f, 16))));
		sbi = String.format("%04d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(s, 16))));
		
	}
	
	static void solve(){
		list = new ArrayList<String>();
		if(fbi.charAt(0)=='1' && fbi.charAt(1)=='1' && fbi.charAt(2)=='1' && fbi.charAt(3)=='1'){
			list.add("B");
			fbi = "0000";
		}
		if(sbi.charAt(0)=='1' && sbi.charAt(1)=='1' && sbi.charAt(2)=='1' && sbi.charAt(3)=='1'){
			list.add("~B");
			sbi = "0000";
		}
		if(fbi.charAt(0)=='1' && fbi.charAt(1)=='1' && sbi.charAt(0)=='1' && sbi.charAt(1)=='1'){
			list.add("A");
			fbi = "00" + Character.toString(fbi.charAt(2)) + Character.toString(fbi.charAt(3));
			sbi = "00" + Character.toString(sbi.charAt(2)) + Character.toString(sbi.charAt(3));
		}
		if(fbi.charAt(1)=='1' && fbi.charAt(2)=='1' && sbi.charAt(1)=='1' && sbi.charAt(2)=='1'){
			list.add("C");
			fbi = Character.toString(fbi.charAt(0)) + "00" + Character.toString(fbi.charAt(3));
			sbi = Character.toString(sbi.charAt(0)) + "00" + Character.toString(sbi.charAt(3));
		}
		if(fbi.charAt(2)=='1' && fbi.charAt(3)=='1' && sbi.charAt(2)=='1' && sbi.charAt(3)=='1'){
			list.add("~A");
			fbi = Character.toString(fbi.charAt(0)) + Character.toString(fbi.charAt(1)) + "00";
			sbi = Character.toString(sbi.charAt(0)) + Character.toString(sbi.charAt(1)) + "00";
		}
		
		//-------------------fixed------------------------------------
		if(fbi.charAt(0)=='1' && fbi.charAt(3)=='1' && sbi.charAt(0)=='1' && sbi.charAt(3)=='1'){
			list.add("~C");
			fbi = "0" + fbi.charAt(1) + fbi.charAt(2) + "0";
			sbi = "0" + sbi.charAt(1) + sbi.charAt(2) + "0";
		}
		//-------------------fixed------------------------------------

		
		
		if(fbi.charAt(0)=='1' && fbi.charAt(1)=='1'){
			list.add("AB");
			fbi = "00" + Character.toString(fbi.charAt(2)) + Character.toString(fbi.charAt(3));
		}
		if(fbi.charAt(1)=='1' && fbi.charAt(2)=='1'){
			list.add("BC");
			fbi = Character.toString(fbi.charAt(0)) + "00" + Character.toString(fbi.charAt(3));
		}
		if(fbi.charAt(2)=='1' && fbi.charAt(3)=='1'){
			list.add("~AB");
			fbi = Character.toString(fbi.charAt(0)) + Character.toString(fbi.charAt(1)) + "00";
		}
		
		if(sbi.charAt(0)=='1' && sbi.charAt(1)=='1'){
			list.add("A~B");
			sbi = "00" + Character.toString(sbi.charAt(2)) + Character.toString(sbi.charAt(3));
		}
		if(sbi.charAt(1)=='1' && sbi.charAt(2)=='1'){
			list.add("~BC");
			sbi = Character.toString(sbi.charAt(0)) + "00" + Character.toString(sbi.charAt(3));
		}
		if(sbi.charAt(2)=='1' && sbi.charAt(3)=='1'){
			list.add("~A~B");
			sbi = Character.toString(sbi.charAt(0)) + Character.toString(sbi.charAt(1)) + "00";
		}
		
		if(fbi.charAt(0)=='1' && sbi.charAt(0)=='1'){
			list.add("A~C");
			fbi = "0" + Character.toString(fbi.charAt(1)) + Character.toString(fbi.charAt(2)) + Character.toString(fbi.charAt(3));
			sbi = "0" + Character.toString(sbi.charAt(1)) + Character.toString(sbi.charAt(2)) + Character.toString(sbi.charAt(3));
		}
		if(fbi.charAt(1)=='1' && sbi.charAt(1)=='1'){
			list.add("AC");
			fbi = Character.toString(fbi.charAt(0)) + "0" + Character.toString(fbi.charAt(2)) + Character.toString(fbi.charAt(3));
			sbi = Character.toString(fbi.charAt(0)) + "0" + Character.toString(fbi.charAt(2)) + Character.toString(fbi.charAt(3));
		}
		if(fbi.charAt(2)=='1' && sbi.charAt(2)=='1'){
			list.add("~AC");
			fbi = Character.toString(fbi.charAt(0)) + Character.toString(fbi.charAt(1)) + "0" + Character.toString(fbi.charAt(3));
			sbi = Character.toString(sbi.charAt(0)) + Character.toString(sbi.charAt(1)) + "0" + Character.toString(sbi.charAt(3));
		}
		if(fbi.charAt(3)=='1' && sbi.charAt(3)=='1'){
			list.add("~A~C");
			fbi = Character.toString(fbi.charAt(0)) + Character.toString(fbi.charAt(1)) + Character.toString(fbi.charAt(2)) + "0";
			sbi = Character.toString(sbi.charAt(0)) + Character.toString(sbi.charAt(1)) + Character.toString(sbi.charAt(2)) + "0";
		}
		
		
		//-------------------fixed------------------------------------

		if(fbi.charAt(0)=='1' && fbi.charAt(1)=='0' && fbi.charAt(2)=='0' && fbi.charAt(3)=='1') {
			list.add("B~C");
			fbi = "0" + Character.toString(fbi.charAt(1)) + Character.toString(fbi.charAt(2)) + "0";
		}
		if(sbi.charAt(0)=='1' && sbi.charAt(1)=='0' && sbi.charAt(2)=='0' && sbi.charAt(3)=='1') {
			list.add("~B~C");
			sbi = "0" + Character.toString(sbi.charAt(1)) + Character.toString(sbi.charAt(2)) + "0";
		}
		//-------------------fixed------------------------------------

		
		if(fbi.charAt(0)=='1')
			list.add("AB~C");
		if(fbi.charAt(1)=='1')
			list.add("ABC");
		if(fbi.charAt(2)=='1')
			list.add("~ABC");
		if(fbi.charAt(3)=='1')
			list.add("~AB~C");
		if(sbi.charAt(0)=='1')
			list.add("A~B~C");
		if(sbi.charAt(1)=='1')
			list.add("A~BC");
		if(sbi.charAt(2)=='1')
			list.add("~A~BC");
		if(sbi.charAt(3)=='1')
			list.add("~A~B~C");
		
		String ans = list.get(0);
		if(list.size()>1)
			for(int j=1; j<list.size(); j++){
				ans = ans + " + " + list.get(j);
			}
		System.out.println(ans);
		
	}
}
