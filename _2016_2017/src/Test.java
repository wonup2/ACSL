import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] a = {7, 6, 2, 2, 1, 1, 0, 0};
		ArrayList<String> b = new ArrayList<String>();
		
		for(int i=0; i<a.length; i++) b.add(a[i]+"");
		
		int cnt=0;
		int num = 76221100;
		while(cnt<50) {
			num--;
			String s[] = (num+"").split("");
			
			for(int i=0; i<s.length; i++) {
				b.remove(s[i]);
			}
			
			if(b.size()==0){
				cnt++;
				b = new ArrayList<String>();

			}
		}

		System.out.println(num);
	}

}
