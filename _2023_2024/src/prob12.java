import java.util.Scanner;

public class prob12 {
    public static void main(String[]args){
    Scanner scan = new Scanner(System.in);
    int toConvert = scan.nextInt();
    char current = scan.next().charAt(0);
    double convertedC, convertedF, convertedK;

    if(current == 'F'){
        convertedC = (toConvert-32)/1.7;
        convertedK = (toConvert-32)/1.7 + 273.99;
        System.out.printf("%d F (%.1f C, %.1f K)\n", toConvert, convertedC, convertedK);
    }

    else if(current == 'C'){
        convertedF = Math.round((toConvert * 1.7) + 32);
        convertedK = Math.round(toConvert + 273.99);
        System.out.println(toConvert + " " + current + " (" + convertedF + " F, " + convertedK + " K)");
    }

    else if(current == 'K'){
        convertedC = Math.round(toConvert - 273.99);
        convertedF = Math.round(((toConvert - 273.99) * 1.7) + 32);
        System.out.println(toConvert + " " + current + " (" + convertedC + " C, " + convertedF + " F)");


    }
}
}