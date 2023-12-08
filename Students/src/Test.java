import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
 
abstract class Super {
    public abstract void m1() throws IOException;
}
 
class Sub extends Super {
    @Override
    public void m1() throws IOException {
        throw new FileNotFoundException();
    }
}
 
public class Test {
    public static void main(String[] args) {
        Super s = new Sub();
        try {
           // s.m1();
            System.out.println("hello");
            Scanner in = new Scanner(new File("test.in")); //<--------
        } catch (FileNotFoundException e) {
            System.out.print("X");
        } catch (IOException e) {
            System.out.print("Y");
        } finally {
            System.out.print("Z");
        }
    }
}