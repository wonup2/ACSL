import java.util.Scanner;
public class Golf {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sumPar = 0;
        int sumScore = 0;
        String result = "";
        for(int i=0; i<4; i++) {
            int par = in.nextInt();
            int score = in.nextInt();

            if(par == score) result = "par";
            else if(par == score-1) result = "bogey";
            else if(par == score-2) result = "double bogey";
            else if(par == score+1) result = "birdie";
            else if(par == score+2) result = "eagle";

            sumPar += par;
            sumScore += score;

            System.out.println(result);
        }

        if(sumPar < sumScore) result = (sumScore-sumPar + " over par");
        else if(sumPar > sumScore) result = (sumPar-sumScore + " below par");
        else result = "par";
        System.out.println(result);
    }
}
