import java.io.*;
import java.util.*;


public class PrintMyself {

	public static void main(String[] args) throws IOException {

		//Scanner in = new Scanner(new File("input.txt"));
//		while(in.hasNextLine())
//		out.println(in.nextLine());
		
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
				
		PrintWriter out = new PrintWriter(new File("out.txt"));
		
		String s = "";
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			s=in.readLine();
			if(s==null) break;
			sb.append(s).append("\n");
			
		}
		
		out.print(sb.toString());
		
		out.close();
	}

}
