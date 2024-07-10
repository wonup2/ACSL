
public class print2Darr {
	static void print(int[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print("\t"+a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static void print(boolean[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print("\t"+a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
