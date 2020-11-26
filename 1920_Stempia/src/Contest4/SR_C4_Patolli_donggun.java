package Contest4;
/*
Donggun Kwak
10th Grade
Stempia
Senior 3 Contest 4
 */
import java.util.*;
import java.io.*;
public class SR_C4_Patolli_donggun {
	public static int[][] grid = {{0,0,0,0,1,52,0,0,0,0},
			{0,0,0,0,2, 51,0,0,0,0},
			{7, 6, 5, 4, 3, 50, 49, 48, 47, 46},
			{8, 9, 10, 11, 12, 41, 42, 43, 44, 45},
			{17, 16, 15, 14, 13, 40, 39, 38, 37, 36},
			{18, 19, 20, 21, 22, 31, 32, 33, 34, 35},
			{0,0,0,0,23, 30,0,0,0,0},
			{0,0,0,0,24, 29,0,0,0,0},
			{0,0,0,0,25, 28,0,0,0,0},
			{0,0,0,0,26, 27,0,0,0,0}};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in =new Scanner(new FileReader(new File("1920C4Sr.in")));
		pos[] tocoords = new pos[53];
		for(int i=0;i<10;i++)
		{
			for(int j =0;j<10;j++)
			{
				if(grid[i][j]!=0)
					tocoords[grid[i][j]] = new pos(i,j);
			}
		}
		for(int t =0;t<5;t++)
		{
			//System.out.println("==========");
			TreeSet<Integer> p1 = new TreeSet<Integer>();
			TreeSet<Integer> p2 = new TreeSet<Integer>();
			p1.add(in.nextInt());
			p1.add(in.nextInt());
			p1.add(in.nextInt());
			p2.add(in.nextInt());
			p2.add(in.nextInt());
			p2.add(in.nextInt());			
			int r = in.nextInt();
			for(int i =0;i<r;i++)
			{
				int roll = in.nextInt();
				//System.out.println("p1: "+ p1.toString());
				//System.out.println("p2: "+ p2.toString());
				if(i%2==0)//p1
				{
					int prev = p1.pollFirst();
					int cur = prev +roll;
					if(p1.contains(cur)||p2.contains(cur)||cur>52)
					{
						p1.add(prev);
						continue;
					}
					if(isPrime(cur))
					{
						for(int j=1;j<=6;j++)
						{
							cur++;
							if(p1.contains(cur)||p2.contains(cur))
							{
								cur--;
								break;
							}
						}
					}
					else if(perfectSquare(cur))
					{
						for(int j=1;j<=6;j++)
						{
							cur--;
							if(p1.contains(cur)||p2.contains(cur))
							{
								cur++;
								break;
							}
						}
					}
					else
					{
						boolean horizontal = false;
						boolean vertical = false;
						
						for(int j=prev+1;j<=prev+roll;j++)
						{
							if(tocoords[j-1].y-tocoords[j].y!=0)
								horizontal = true;
							else if(tocoords[j-1].x-tocoords[j].x!=0&&horizontal)
								vertical = true;
						}
						//System.out.println(horizontal+" "+vertical+" "+roll);
						if(horizontal&&vertical)
						{
							cur = prev;
							for(int j =prev+roll;j>=prev;j--)
							{
								if(j%roll==0&&!((p1.contains(j)||p2.contains(j))))
								{
									cur = j;
									break;
								}
							}
						}
					}
					//System.out.println("p1 change "+cur);
					if(cur==52)
						continue;
					p1.add(cur);
				}
				else//p2
				{
					int prev = p2.pollFirst();
					int cur = prev +roll;
					if(p1.contains(cur)||p2.contains(cur)||cur>52)
					{
						p2.add(prev);
						continue;
					}
					if(cur==52)
						continue;
					if(isPrime(cur))
					{
						for(int j=1;j<=6;j++)
						{
							cur++;
							if(p1.contains(cur)||p2.contains(cur))
							{
								cur--;
								break;
							}
						}
					}
					else if(perfectSquare(cur))
					{
						for(int j=1;j<=6;j++)
						{
							cur--;
							if(p1.contains(cur)||p2.contains(cur))
							{
								cur++;
								break;
							}
						}
					}
					else
					{
						boolean horizontal = false;
						boolean vertical = false;
						
						for(int j=prev+1;j<=prev+roll;j++)
						{
							if(tocoords[j-1].y-tocoords[j].y!=0)
								horizontal = true;
							else if(tocoords[j-1].x-tocoords[j].x!=0&&horizontal)
								vertical = true;
						}
						//System.out.println(horizontal+" "+vertical+" "+roll);
						if(horizontal&&vertical)
						{
							cur = prev;
							for(int j =prev+roll;j>=prev;j--)
							{
								if(j%roll==0&&!((p1.contains(j)||p2.contains(j))))
								{
									cur = j;
									break;
								}
							}
						}
					}
					//System.out.println("p2 change "+ cur);
					if(cur==52)
						continue;
					p2.add(cur);
				}
			}
			//System.out.println(p1);
			//System.out.println(p2);
			int a = 0;
			int b = 0;
			while(!p1.isEmpty())
				a+=p1.pollFirst();
			while(!p2.isEmpty())
				b+=p2.pollFirst();
			System.out.println(a+" "+b);
		}
		
		
	}
	static class pos
	{
		int x, y;
		public pos(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public static boolean perfectSquare(int n)
	{
		int temp = (int)Math.sqrt(n);
		return n==temp*temp;
	}
	public static boolean isPrime(int n)
	{
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}

}
