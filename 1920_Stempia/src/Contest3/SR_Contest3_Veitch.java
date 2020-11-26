package Contest3;
/*
Gene Lee 12th
Stempia
Senior 3
Contest 3
*/

import java.io.*;
import java.util.*;
public class SR_Contest3_Veitch {
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(new File("veitch.in"));
		for(int test=0;test<5;test++) {
			String hex=sc.nextLine().toUpperCase();
			boolean[][] binary=convert(hex);
			HashSet<String>coords=getCoords(binary);
			String ans=answer(coords);
			if(ans.length()!=0)
				ans=ans.substring(0,ans.length()-1);
			System.out.println(ans);
		}
	}
	
	static String answer(HashSet<String>p) {
		if(p.isEmpty())
			return "";
		if(B(p).size()==8)
			return "B+"+answer(remove(B(p),p));
		if(D(p).size()==8)
			return "D+"+answer(remove(D(p),p));
		if(notB(p).size()==8)
			return "~B+"+answer(remove(notB(p),p));
		if(A(p).size()==8)
			return "A+"+answer(remove(A(p),p));
		if(C(p).size()==8)
			return "C+"+answer(remove(C(p),p));
		if(notA(p).size()==8)
			return "~A+"+answer(remove(notA(p),p));
		if(notD(p).size()==8)
			return "~D+"+answer(remove(notD(p),p));
		if(notC(p).size()==8)
			return "~C+"+answer(remove(notC(p),p));
		if(B(notD(p)).size()==4)
			return "B~D+"+answer(remove(B(notD(p)),p));
		if(B(D(p)).size()==4)
			return "BD+"+answer(remove(B(D(p)),p));
		if(notB(D(p)).size()==4)
			return "~BD+"+answer(remove(notB(D(p)),p));
		if(notB(notD(p)).size()==4)
			return "~B~D+"+answer(remove(notB(notD(p)),p));
		if(A(notC(p)).size()==4)
			return "A~C+"+answer(remove(A(notC(p)),p));
		if(A(C(p)).size()==4)
			return "AC+"+answer(remove(A(C(p)),p));
		if(notA(C(p)).size()==4)
			return "~AC+"+answer(remove(notA(C(p)),p));
		if(notA(notC(p)).size()==4)
			return "~A~C+"+answer(remove(notA(notC(p)),p));
		if(A(B(p)).size()==4)
			return "AB+"+answer(remove(A(B(p)),p));
		if(A(D(p)).size()==4)
			return "AD+"+answer(remove(A(D(p)),p));
		if(A(notB(p)).size()==4)
			return "A~B+"+answer(remove(A(notB(p)),p));
		if(B(C(p)).size()==4)
			return "BC+"+answer(remove(B(C(p)),p));
		if(C(D(p)).size()==4)
			return "CD+"+answer(remove(C(D(p)),p));
		if(notB(C(p)).size()==4)
			return "~BC+"+answer(remove(notB(C(p)),p));
		if(notA(B(p)).size()==4)
			return "~AB+"+answer(remove(notA(B(p)),p));
		if(notA(D(p)).size()==4)
			return "~AD+"+answer(remove(notA(D(p)),p));
		if(notA(notB(p)).size()==4)
			return "~A~B+"+answer(remove(notA(notB(p)),p));
		if(B(notC(p)).size()==4)
			return "B~C+"+answer(remove(B(notC(p)),p));
		if(notC(D(p)).size()==4)
			return "~CD+"+answer(remove(notC(D(p)),p));
		if(notB(notC(p)).size()==4)
			return "~B~C+"+answer(remove(notB(notC(p)),p));
		if(A(notD(p)).size()==4)
			return "A~D+"+answer(remove(A(notD(p)),p));
		if(C(notD(p)).size()==4)
			return "C~D+"+answer(remove(C(notD(p)),p));
		if(notA(notD(p)).size()==4)
			return "~A~D+"+answer(remove(notA(notD(p)),p));
		if(notC(notD(p)).size()==4)
			return "~C~D+"+answer(remove(notC(notD(p)),p));
		if(p.size()==16)
			return "+"+answer(remove(p,p));
		if(A(B(notD(p))).size()==2)
			return "AB~D+"+answer(remove(A(B(notD(p))),p));
		if(B(C(notD(p))).size()==2)
			return "BC~D+"+answer(remove(B(C(notD(p))),p));
		if(notA(B(notD(p))).size()==2)
			return "~AB~D+"+answer(remove(notA(B(notD(p))),p));
		if(A(B(D(p))).size()==2)
			return "ABD+"+answer(remove(A(B(D(p))),p));
		if(B(C(D(p))).size()==2)
			return "BCD+"+answer(remove(B(C(D(p))),p));
		if(notA(B(D(p))).size()==2)
			return "~ABD+"+answer(remove(notA(B(D(p))),p));
		if(A(notB(D(p))).size()==2)
			return "A~BD+"+answer(remove(A(notB(D(p))),p));
		if(notB(C(D(p))).size()==2)
			return "~BCD+"+answer(remove(notB(C(D(p))),p));
		if(notA(notB(D(p))).size()==2)
			return "~A~BD+"+answer(remove(notA(notB(D(p))),p));
		if(A(notB(notD(p))).size()==2)
			return "A~B~D+"+answer(remove(A(notB(notD(p))),p));
		if(notB(C(notD(p))).size()==2)
			return "~BC~D+"+answer(remove(notB(C(notD(p))),p));
		if(notA(notB(notD(p))).size()==2)
			return "~A~B~D+"+answer(remove(notA(notB(notD(p))),p));
		if(p.size()==16)
			return "+"+answer(remove(p,p));
		if(A(B(notC(p))).size()==2)
			return "AB~C+"+answer(remove(A(B(notC(p))),p));
		if(A(notC(D(p))).size()==2)
			return "A~CD+"+answer(remove(A(notC(D(p))),p));
		if(A(notB(notC(p))).size()==2)
			return "A~B~C+"+answer(remove(A(notB(notC(p))),p));
		if(A(B(C(p))).size()==2)
			return "ABC+"+answer(remove(A(B(C(p))),p));
		if(A(C(D(p))).size()==2)
			return "ACD+"+answer(remove(A(C(D(p))),p));
		if(A(notB(C(p))).size()==2)
			return "A~BC+"+answer(remove(A(notB(C(p))),p));
		if(notA(B(C(p))).size()==2)
			return "~ABC+"+answer(remove(notA(B(C(p))),p));
		if(notA(C(D(p))).size()==2)
			return "~ACD+"+answer(remove(notA(C(D(p))),p));
		if(notA(notB(C(p))).size()==2)
			return "~A~BC+"+answer(remove(notA(notB(C(p))),p));
		if(notA(B(notC(p))).size()==2)
			return "~AB~C+"+answer(remove(notA(B(notC(p))),p));
		if(notA(notC(D(p))).size()==2)
			return "~A~CD+"+answer(remove(notA(notC(D(p))),p));
		if(notA(notB(notC(p))).size()==2)
			return "~A~B~C+"+answer(remove(notA(notB(notC(p))),p));
		if(B(notC(notD(p))).size()==2)
			return "B~C~D+"+answer(remove(B(notC(notD(p))),p));
		if(B(notC(D(p))).size()==2)
			return "B~CD+"+answer(remove(B(notC(D(p))),p));
		if(notB(notC(D(p))).size()==2)
			return "~B~CD+"+answer(remove(notB(notC(D(p))),p));
		if(notB(notC(notD(p))).size()==2)
			return "~B~C~D+"+answer(remove(notB(notC(notD(p))),p));
		if(A(notC(notD(p))).size()==2)
			return "A~C~D+"+answer(remove(A(notC(notD(p))),p));
		if(A(C(notD(p))).size()==2)
			return "AC~D+"+answer(remove(A(C(notD(p))),p));
		if(notA(C(notD(p))).size()==2)
			return "~AC~D+"+answer(remove(notA(C(notD(p))),p));
		if(notA(notC(notD(p))).size()==2)
			return "~A~C~D+"+answer(remove(notA(notC(notD(p))),p));
		if(A(B(notC(notD(p)))).size()==1)
			return "AB~C~D+"+answer(remove(A(B(notC(notD(p)))),p));
		if(A(B(C(notD(p)))).size()==1)
			return "ABC~D+"+answer(remove(A(B(C(notD(p)))),p));
		if(notA(B(C(notD(p)))).size()==1)
			return "~ABC~D+"+answer(remove(notA(B(C(notD(p)))),p));
		if(notA(B(notC(notD(p)))).size()==1)
			return "~AB~C~D+"+answer(remove(notA(B(notC(notD(p)))),p));
		if(A(B(notC(D(p)))).size()==1)
			return "AB~CD+"+answer(remove(A(B(notC(D(p)))),p));
		if(A(B(C(D(p)))).size()==1)
			return "ABCD+"+answer(remove(A(B(C(D(p)))),p));
		if(notA(B(C(D(p)))).size()==1)
			return "~ABCD+"+answer(remove(notA(B(C(D(p)))),p));
		if(notA(B(notC(D(p)))).size()==1)
			return "~AB~CD+"+answer(remove(notA(B(notC(D(p)))),p));
		if(A(notB(notC(D(p)))).size()==1)
			return "A~B~CD+"+answer(remove(A(notB(notC(D(p)))),p));
		if(A(notB(C(D(p)))).size()==1)
			return "A~BCD+"+answer(remove(A(notB(C(D(p)))),p));
		if(notA(notB(C(D(p)))).size()==1)
			return "~A~BCD+"+answer(remove(notA(notB(C(D(p)))),p));
		if(notA(notB(notC(D(p)))).size()==1)
			return "~A~B~CD+"+answer(remove(notA(notB(notC(D(p)))),p));
		if(A(notB(notC(notD(p)))).size()==1)
			return "A~B~C~D+"+answer(remove(A(notB(notC(notD(p)))),p));
		if(A(notB(C(notD(p)))).size()==1)
			return "A~BC~D+"+answer(remove(A(notB(C(notD(p)))),p));
		if(notA(notB(C(notD(p)))).size()==1)
			return "~A~BC~D+"+answer(remove(notA(notB(C(notD(p)))),p));
		if(notA(notB(notC(notD(p)))).size()==1)
			return "~A~B~C~D+"+answer(remove(notA(notB(notC(notD(p)))),p));
		return "ERROR";
	}
	
	static HashSet<String> remove(HashSet<String>remove,HashSet<String>p){
		HashSet<String>ret=new HashSet<String>();
		for(String s:p)
			if(!remove.contains(s))
				ret.add(s);
		return ret;
	}
	
	static HashSet<String> A(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(cell.endsWith("0")||cell.endsWith("1"))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> notA(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(!(cell.endsWith("0")||cell.endsWith("1")))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> B(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(cell.startsWith("0")||cell.startsWith("1"))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> notB(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(!(cell.startsWith("0")||cell.startsWith("1")))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> C(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(cell.endsWith("2")||cell.endsWith("1"))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> notC(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(!(cell.endsWith("2")||cell.endsWith("1")))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> D(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(cell.startsWith("2")||cell.startsWith("1"))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> notD(HashSet<String>coords){
		HashSet<String>ret=new HashSet<String>();
		for(String cell:coords)
			if(!(cell.startsWith("2")||cell.startsWith("1")))
				ret.add(cell);
		return ret;
	}
	
	static HashSet<String> getCoords(boolean[][] binary){
		HashSet<String>ret=new HashSet<String>();
		for(int i=0;i<binary.length;i++)
			for(int j=0;j<binary[i].length;j++)
				if(binary[i][j])
					ret.add(i+""+j);
		return ret;
	}

	static boolean[][] convert(String hex){
		boolean[][] ret=new boolean[hex.length()][];
		for(int i=0;i<hex.length();i++) {
			ret[i]=charToBin(hex.charAt(i));
		}
		return ret;
	}
	
	static boolean[] charToBin(char c){
		int value=0;
		switch(c) {
		case '0':value=0;break;
		case '1':value=1;break;
		case '2':value=2;break;
		case '3':value=3;break;
		case '4':value=4;break;
		case '5':value=5;break;
		case '6':value=6;break;
		case '7':value=7;break;
		case '8':value=8;break;
		case '9':value=9;break;
		case 'A':value=10;break;
		case 'B':value=11;break;
		case 'C':value=12;break;
		case 'D':value=13;break;
		case 'E':value=14;break;
		case 'F':value=15;break;
		}
		boolean[] ret=new boolean[4];
		int N=4;
		while(N-->0) {
			ret[N]=value%2==1;
			value/=2;
		}
		return ret;
	}

}
