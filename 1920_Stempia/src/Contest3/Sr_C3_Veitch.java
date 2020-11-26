package Contest3;
/*
Donggun Kwak
Senior Division 2019-2020
Stempia
 */
import java.util.*;
import java.io.*;
public class Sr_C3_Veitch {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new FileReader(new File("veitch.in")));
		for(int c = 0;c<5;c++)
		{
			String line = in.next().trim();
			int hex = Integer.parseInt(line, 16);
			String binary = Integer.toBinaryString(hex);
			while(binary.length()<16)
				binary = "0"+binary;
			//System.out.println(binary);
			boolean[][] grid = new boolean[4][4];
			for(int i=0;i<4;i++)
			{
				for(int j = 0;j<4;j++)
				{
					if(binary.charAt(i*4+j)=='1')
					grid[i][j] = true;
				}
			}

			StringBuilder ans = new StringBuilder();
			String cur = "2";
			while(!cur.equals(""))
			{
				cur = do8(grid);
				ans.append(cur);
			}

			cur = "2";
			while(!cur.equals(""))
			{
				cur = do4(grid);
				ans.append(cur);
			}
		
			cur = "2";
			while(!cur.equals(""))
			{
				cur = do4Adj(grid);
				ans.append(cur);
			}
		
			cur = "2";
			while(!cur.equals(""))
			{
				cur = doCorners(grid);
				ans.append(cur);
			}
			
			cur = "2";
			while(!cur.equals(""))
			{
				cur = do2(grid);
				ans.append(cur);
			}
			
			cur = "2";
			while(!cur.equals(""))
			{
				cur = do2Adj(grid);
				ans.append(cur);
			}
		
			cur = "2";
			while(!cur.equals(""))
			{
				cur = do1(grid);
				ans.append(cur);
			}
			System.out.println(ans.substring(0,ans.length()-1));			
		}		
	}
	public static StringBuilder toLetters(int x, int y)
	{
		StringBuilder ret = new StringBuilder(); 
		if(y==0||y==1)
			ret.append("A");
		else
			ret.append("~A");
		if(x==0||x==1)
			ret.append("B");
		else
			ret.append("~B");
		if(y==0||y==3)
			ret.append("~C");
		else
			ret.append("C");
		if(x==0||x==3)
			ret.append("~D");
		else
			ret.append("D");
		return ret;
			
	}
	public static String toExpress(boolean[] regular,boolean[] not)
	{
		StringBuilder ans = new StringBuilder();
		if(regular[0]&&!not[0])
			ans.append("A");
		else if(!regular[0]&&not[0])
			ans.append("~A");
		
		if(regular[1]&&!not[1])
			ans.append("B");
		else if(!regular[1]&&not[1])
			ans.append("~B");
		
		if(regular[2]&&!not[2])
			ans.append("C");
		else if(!regular[2]&&not[2])
			ans.append("~C");
		
		if(regular[3]&&!not[3])
			ans.append("D");
		else if(!regular[3]&&not[3])
			ans.append("~D");
		return ans.toString();
	}
	public static void changeExpressToArr(StringBuilder cur, boolean[] regular, boolean[] not)
	{
		for(int k=0;k<cur.length();k++)
		{
			if(cur.charAt(k)=='~')
			{
				not[cur.charAt(k+1)-'A'] = true;
				k++;
			}
			else
			{
				regular[cur.charAt(k)-'A']=true;
			}
		}
	}
	public static String do1(boolean[][] grid)
	{
		for(int i=0;i<4;i++)
		{
			for(int j = 0;j<4;j++)
			{
				if(grid[i][j])
				{
					boolean[] regular = new boolean[4];
					boolean[] not = new boolean[4];
					changeExpressToArr(toLetters(i,j),regular,not);
					grid[i][j] = false;
					return toExpress(regular,not)+"+";
				}
			}
		}
		return "";
	}
	public static String do2Adj(boolean[][] grid)
	{
		for(int a = 0;a<3;a++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i = a;i<a+1;i++)
			{
				temp = temp&grid[i][0]&grid[i][3];
				changeExpressToArr(toLetters(i,0),regular,not);
				changeExpressToArr(toLetters(i,3),regular,not);
			}
			if(temp)
			{
				for(int i = a;i<a+1;i++)
				{
					grid[i][0] = false;
					grid[i][3] = false;
				}
				return toExpress(regular,not)+"+";
			}
			
		}
		for(int a = 0;a<3;a++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i = a;i<a+1;i++)
			{
				temp = temp&grid[0][i]&grid[3][i];
				changeExpressToArr(toLetters(0,i),regular,not);
				changeExpressToArr(toLetters(3,i),regular,not);
			}
			if(temp)
			{
				for(int i = a;i<a+1;i++)
				{
					grid[0][i] = false;
					grid[3][i] = false;
				}
				return toExpress(regular,not)+"+";
			}
		}
		return "";
	}
	public static String do2(boolean[][] grid)
	{
		for(int r = 0;r<4;r++)
		{
			for(int c= 0;c<4;c++)
			{
				if(c!=3)
				{
					boolean temp = true;
					boolean[] regular = new boolean[4];
					boolean[] not = new boolean[4];
					for(int i = c;i<c+2;i++)
					{
						temp = temp&grid[r][i];
						changeExpressToArr(toLetters(r,i),regular,not);
					}
					if(temp)
					{
						for(int i = c;i<c+2;i++)
						{
							grid[r][i] = false;
						}
						return toExpress(regular,not)+"+";
					}
				}
			}
		}
		for(int r= 0;r<4;r++)
		{
			for(int c = 0;c<4;c++)
			{
				if(r!=3)
				{
					boolean temp = true;
					boolean[] regular = new boolean[4];
					boolean[] not = new boolean[4];
					for(int i =r;i<r+2;i++)
					{
						temp = temp&grid[i][c];
						changeExpressToArr(toLetters(i,c),regular,not);
					}
					//System.out.println(r+" "+c+" - "+ temp);
					if(temp)
					{
						for(int i=r;i<r+2;i++)
						{
							grid[i][c] = false;
						}
						return toExpress(regular,not)+"+";
					}
				}
				
			}
		}
		return "";
	}
	public static String doCorners(boolean[][] grid)
	{
		boolean temp = true;
		temp = temp&grid[0][0]&grid[0][3]&grid[3][0]&grid[3][3];
		if(temp)
		{
			grid[0][0] = false;
			grid[0][3] = false;
			grid[3][0] = false;
			grid[3][3] = false;
			return "~C~D+";
		}
		return"";
	}
	public static String do4Adj(boolean[][] grid)
	{
		for(int a = 0;a<3;a++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i = a;i<a+2;i++)
			{
				temp = temp&grid[0][i]&grid[3][i];
				changeExpressToArr(toLetters(0,i),regular,not);
				changeExpressToArr(toLetters(3,i),regular,not);
			}
			if(temp)
			{
				for(int i = a;i<a+2;i++)
				{
					grid[0][i] = false;
					grid[3][i] = false;
				}
				return toExpress(regular,not)+"+";
			}
		}
		for(int a = 0;a<3;a++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i = a;i<a+2;i++)
			{
				temp = temp&grid[i][0]&grid[i][3];
				changeExpressToArr(toLetters(i,0),regular,not);
				changeExpressToArr(toLetters(i,3),regular,not);
			}
			if(temp)
			{
				for(int i = a;i<a+2;i++)
				{
					grid[i][0] = false;
					grid[i][3] = false;
				}
				return toExpress(regular,not)+"+";
			}
		}
		return "";
	}
	public static String do4(boolean[][] grid)
	{
		for(int r = 0;r<4;r++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i =r;i<=r;i++)
			{
				for(int j = 0;j<4;j++)
				{
					temp = temp&grid[i][j];
					StringBuilder cur = toLetters(i,j);
					changeExpressToArr(cur,regular,not);
				}
			}
			if(temp)
			{
				for(int i =r;i<=r;i++)
				{
					for(int j = 0;j<4;j++)
					{
						grid[i][j] = false;
					}
				}
				return toExpress(regular,not)+"+";
			}
		}
		for(int r = 0;r<4;r++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i =r;i<=r;i++)
			{
				for(int j = 0;j<4;j++)
				{
					temp = temp&grid[j][i];
					StringBuilder cur = toLetters(j,i);
					changeExpressToArr(cur,regular,not);
				}
			}
			if(temp)
			{
				for(int i =r;i<=r;i++)
				{
					for(int j = 0;j<4;j++)
					{
						grid[j][i] = false;
					}
				}
				return toExpress(regular,not)+"+";
			}
		}
		for(int r=0;r<3;r++)
		{
			for(int c= 0;c<3;c++)
			{
				boolean temp = true;
				boolean[] regular = new boolean[4];
				boolean[] not = new boolean[4];
				for(int i =r;i<r+2;i++)
				{
					for(int j = c;j<c+2;j++)
					{
						temp = temp&grid[i][j];
						StringBuilder cur = toLetters(i,j);
						changeExpressToArr(cur,regular,not);
					}
				}
				if(temp)
				{
					for(int i =r;i<r+2;i++)
					{
						for(int j = c;j<c+2;j++)
						{
							grid[i][j] = false;
						}
					}
					return toExpress(regular,not)+"+";
				}
			}
		}
		return "";
	}
	public static String do8(boolean[][] grid)
	{
		for(int r = 0;r<3;r++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i =r;i<r+2;i++)
			{
				for(int j = 0;j<4;j++)
				{
					temp = temp&grid[i][j];
					StringBuilder cur = toLetters(i,j);
					changeExpressToArr(cur,regular,not);
				}
			}
			if(temp)
			{
				for(int i =r;i<r+2;i++)
				{
					for(int j = 0;j<4;j++)
					{
						grid[i][j] = false;
					}
				}
				return toExpress(regular,not)+"+";
			}
		}
		for(int r = 0;r<3;r++)
		{
			boolean temp = true;
			boolean[] regular = new boolean[4];
			boolean[] not = new boolean[4];
			for(int i =r;i<r+2;i++)
			{
				for(int j = 0;j<4;j++)
				{
					temp = temp&grid[j][i];
					StringBuilder cur = toLetters(j,i);
					changeExpressToArr(cur,regular,not);
				}
			}
			if(temp)
			{
				for(int i =r;i<r+2;i++)
				{
					for(int j = 0;j<4;j++)
					{
						grid[j][i] = false;
					}
				}
				return toExpress(regular,not)+"+";
			}
		}
		//end-row x's
		boolean temp = true;
		boolean[] regular = new boolean[4];
		boolean[] not = new boolean[4];
		for(int i = 0;i<4;i++)
		{
			temp = temp&grid[0][i]&grid[3][i];
			changeExpressToArr(toLetters(0,i),regular,not);
			changeExpressToArr(toLetters(3,i),regular,not);
		}
		if(temp)
		{
			for(int i = 0;i<4;i++)
			{
				grid[0][i] = false;
				grid[3][i] = false;
			}
			return toExpress(regular,not)+"+";
		}
		
		temp = true;
		regular = new boolean[4];
		not = new boolean[4];
		for(int i = 0;i<4;i++)
		{
			temp = temp&grid[i][0]&grid[i][3];
			changeExpressToArr(toLetters(i,0),regular,not);
			changeExpressToArr(toLetters(i,3),regular,not);
		}
		if(temp)
		{
			for(int i = 0;i<4;i++)
			{
				grid[i][0] = false;
				grid[i][3] = false;
			}
			return toExpress(regular,not)+"+";
		}
		
		return "";
	}

}
