import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Tokens {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(new File("a"));

		String s = "I am a boy";
		StringTokenizer st = new StringTokenizer(s);
		
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());

	}

}
