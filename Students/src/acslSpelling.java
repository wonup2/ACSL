
//package _201415;

import java.io.*;
import java.util.*;
public class acslSpelling {
	
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<5; i++){
            String input = in.readLine();
            System.out.println(pluralify(input));
        }
        for(int i = 0; i<5; i++){
            String[] input = in.readLine().split(" ");
            System.out.println(suffixAdd(input[0], input[1]));
        }
    }
    
    public static String pluralify (String word){
        int n = word.length();

        List<String> rule1a =  Arrays.asList("ch", "sh");
        List<Character> rule1b = Arrays.asList('s', 'x', 'z');
        if(rule1a.contains(word.substring(n-2)) || rule1b.contains(word.charAt(n-1))){
            return word + "es";
        }

        List<Character> vowels = Arrays.asList('a','e','i','o','u');
        if(word.charAt(n-1)=='y'){
            if(vowels.contains(word.charAt(n-2))){
                return word + "s";
            }
            else return word.substring(0, n-1) + "ies";
        }

        if(word.charAt(n-1)=='f'){
            return word.substring(0, n-1) + "ves";
        }
        if(word.substring(n-2).equals("fe")){
            return word.substring(0, n-2) + "ves";
        }

        if (word.charAt(n - 1) == 'o'){
            if(vowels.contains(word.charAt(n - 2))){
                return word + "s";
            }
            else return word + "es";
        }

        return word + "s";
    }

    public static String suffixAdd (String word, String suffix){
        List<Character> vowels = Arrays.asList('a','e','i','o','u');
        int n = word.length();

        if(word.charAt(n-1) == 'e' && vowels.contains(suffix.charAt(0))){
            return word.substring(0, n-1) + suffix;
        }

        if(suffix.charAt(0)!='i' && word.charAt(n-1)=='y'){
            return word.substring(0, n-1) + "i" + suffix;
        }

        /*
        Double a final single consonant when a single vowel precedes the consonant
         */
        if(vowels.contains(suffix.charAt(0))){
            int i = n-2;
            int count = 0;
            while(i>=0 && vowels.contains(word.charAt(i))){
                count++;
                i--;
            }

            if (!vowels.contains(word.charAt(n - 1)) && count==1) {
                return word + word.charAt(n-1) + "" + suffix;
            }
        }

        return word + suffix;
    }
}
/*
Sample Input:
church
redeploy
candy
midwife
rodeo
guide ance
like ness
pity ful
occupy ing
occur ence

Test Input:
suffix
contest
scarf
raspberry
auto
beauty ful
compute ing
bookkeep ing
differ ence
amuse ment
 */
