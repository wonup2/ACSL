
public class printpractice {

	public static void main(String[] args) {
		
		System.out.println(hello());		
		hello("hi");
		
		String s = hello(4, 3, 'A');
		System.out.println(4+""+3);
		System.out.println('A'+'B'); //131  A=65, B=66 ---> 65+66
		System.out.println('A'+""+'B'); //AB
	}
	
	public static String hello() {
		return "Hello World";
	}
	public static String hello(int n, int m, char s) {
		System.out.println(n + m + "" + s);
		return "Hello "+n;
	}
	public static void hello(String n) {
		System.out.println(n);
	}
}
