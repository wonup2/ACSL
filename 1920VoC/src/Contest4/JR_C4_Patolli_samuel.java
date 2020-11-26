package Contest4;
/*
Name: Samuel Nam
Grade: 9
Team: Voice of Calling
Division: Junior
2019-2020 ACSL Contest 4
*/
import java.io.*;
import java.util.*;
public class JR_C4_Patolli_samuel{

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1920c4jr.in"));
		for(int z = 0; z < 5; z++){
			int o1 = in.nextInt();
			int o2 = in.nextInt();
			int o3 = in.nextInt();
			int p  = in.nextInt();
			int num = in.nextInt();
			
			for(int i=0; i<num; i++){
				int temp = in.nextInt();
				if(p+temp<=52){
					if(p+temp!=o1 && p+temp!=o2 && p+temp!=o3){
						p+=temp;

						if(isPrime(p)){
							int temp1 = o1-p;
							int temp2 = o2-p;
							int temp3 = o3-p;
							ArrayList<Integer> list = new ArrayList<Integer>();
							if(temp1>0)
								list.add(temp1);
							if(temp2>0)
								list.add(temp2);
							if(temp3>0)
								list.add(temp3);
							int min = 999999999;
							for(int j=0; j<list.size(); j++){
								min = Math.min(min, list.get(j));
							}
							if(min>6)
								p+=6;
							else
								p+=(min-1);
						}
						
						else if(p>4 && isSquare(p)){
							int temp1 = p-o1;
							int temp2 = p-o2;
							int temp3 = p-o3;
							ArrayList<Integer> list = new ArrayList<Integer>();
							if(temp1>0)
								list.add(temp1);
							if(temp2>0)
								list.add(temp2);
							if(temp3>0)
								list.add(temp3);
							int min = 999999999;
							for(int j=0; j<list.size(); j++){
								min = Math.min(min, list.get(j));
							}
							if(min>6)
								p-=6;
							else
								p-=(min-1);
						}
						
						else {
							int check = p;
							if(p-temp<7 && p>7 || p-temp<12 && p>12 || p-temp<17 && p>17 || p-temp<22 && p>22 || p-temp<27 && p>27 || p-temp<35 && p>35 || p-temp<40 && p>40 || p-temp<45 && p>45 || p-temp<50 && p>50){
								p-=temp;
								for(int j=p+1; j<=p+temp; j++){
									if(j%temp==0 && j!=o1 && j!=o2 && j!=o3){
										p=j;
										break;
									}
									
								}
							}						
						}		
					}
				}
				else
					continue;
			}
			if(p==52)
				System.out.println("GAME OVER");
			else
				System.out.println(p);
		}
		
		

	}
	public static boolean isPrime(int p){
		for(int i=2;i<=p/2;i++)
		{
	           double temp=p%i;
		   if(temp==0)
		   {
		      return false;
		   }
		}
		return true;
	}
	public static boolean isSquare(double x){ 
		double sq = Math.sqrt(x); 
		return ((sq - Math.floor(sq)) == 0); 
    } 
}
