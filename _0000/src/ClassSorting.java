import java.util.Arrays;

public class ClassSorting {

	public static void main(String[] args) {
		
		pair[] r = new pair[3];
		r[0] = new pair("Baron", 97);
		r[1] = new pair("Christian", 97);
		r[2] = new pair("Colin", 89);
		Arrays.sort(r);
		System.out.println(Arrays.toString(r));
	}

}

class pair implements Comparable<pair>{
	String name;
	int score;
	pair(String n, int s){
		name = n;
		score = s;
	}
	public String toString() {
		return name +" : "+ score;
	}
	@Override
	public int compareTo(pair that) {
		
		if(this.score > that.score) return 1;
		else if(this.score < that.score) return -1;
		else {		
			if(this.name.compareTo(that.name) > 0) return 1;
			else return -1;
		}		
	}
}
