import java.io.*;
import java.util.*;
public class Patience {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("Patience.in"));
		for(int z=0; z<10; z++){
			String s = in.nextLine();
			String cards[] = s.split(" ");
			int n = cards.length;
			ArrayList<ArrayList<String>> pile = new ArrayList<ArrayList<String>>();
			pile.add(new ArrayList<String>());
			pile.get(0).add(cards[0]);
			for(int i=1; i<n; i++){
				int temp =0;
				char sb = cards[i].charAt(1);
				char tb = cards[i].charAt(0);
				int b=0;
				if(tb=='A')
					b=1;
				else if(tb=='T')
					b=10;
				else if(tb=='J')
					b=11;
				else if(tb=='Q')
					b=12;
				else if(tb=='K')
					b=13;
				else
					b=tb-48;
				while(true){
					int t = pile.get(temp).size();
					char ta = pile.get(temp).get(t-1).charAt(0);
					
					char sa = pile.get(temp).get(t-1).charAt(1);
					
					int a=0;
					
					if(ta=='A')
						a=1;
					else if(ta=='T')
						a=10;
					else if(ta=='J')
						a=11;
					else if(ta=='Q')
						a=12;
					else if(ta=='K')
						a=13;
					else
						a=ta-48;
					
					if(a>b && sa!=sb || b==13 && a==1 && sa!=sb){
						pile.get(temp).add(cards[i]);
						break;
					}
					else{
						if(temp+1==pile.size()){
							temp+=1;
							pile.add(new ArrayList<String>());
							pile.get(temp).add(cards[i]);
							break;
						}
						else{
							temp+=1;
						}
					}
				}
			}
			int max=0;
			int t = 0;
			for(int i=0; i<pile.size(); i++){
				if(pile.get(i).size()>max){
					max=pile.get(i).size();
				}
			}
			ArrayList list = new ArrayList<Integer>();
			for(int i=0; i<pile.size(); i++){
				if(pile.get(i).size()==max){
					list.add(i);
				}
			}
			
			
			int num=999999999;
			for(int j=0; j<list.size(); j++){
				int sum=0;
				for(int i=0; i<max; i++){
					String temp = pile.get((int) list.get(j)).get(i);
					char tb = temp.charAt(0);
					int b=0;
					if(tb=='A')
						b=1;
					else if(tb=='T')
						b=10;
					else if(tb=='J')
						b=11;
					else if(tb=='Q')
						b=12;
					else if(tb=='K')
						b=13;
					else
						b=tb-48;
					sum+=b;
				}
				num=Math.min(sum, num);
			}
			System.out.println(num);
		}
	}

}
