
//package _201415;

import java.io.*;
import java.util.*;
public class acslballjr {
    static class pair implements Comparable<pair>{
        public int score;
        public String name;
        public pair(int score, String name){
            this.score = score;
            this.name = name;
        }
        public String toString(){
            return this.score + " " + this.name;
        }
        public int compareTo(pair that){
            return this.score-that.score;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] name = new String[8];
        int[] one = new int[8];
        int[] two = new int[8];
        int[] three = new int[8];

        for(int i = 0; i<8; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            name[i] = st.nextToken();
            one[i] = Integer.parseInt(st.nextToken());
            two[i] = Integer.parseInt(st.nextToken());
            three[i] = Integer.parseInt(st.nextToken());
        }

        //How many three point goals were scored by all 8 players
        int count = 0;
        for(int i = 0; i<8; i++) count+=three[i];
        System.out.println(count);

        //Who scored the most goals?
        int most = 0;
        int person = 0;
        for(int i = 0; i<8; i++){
            int tmp = one[i] + two[i] + three[i];
            if(tmp>most) {
                most = tmp;
                person = i;
            }
        }
        System.out.println(name[person]);

        //Who was the highest scorer?
        most = 0;
        person = 0;
        for(int i = 0; i<8; i++){
            int tmp = one[i] + 2*two[i] + 3*three[i];
            if(tmp>most) {
                most = tmp;
                person = i;
            }
            //System.out.println("SCORE " + tmp + '\n' + "Person " + person + '\n');
        }
        System.out.println(name[person]);

        //How many points did the winning team score?
        int sum1 = 0;
        int sum2 = 0;
        pair[] team1 = new pair[4];
        pair[] team2 = new pair[4];
        for(int i = 0; i<4; i++){
            team1[i]= new pair(one[i] + 2*two[i] + 3*three[i], name[i]);
            team2[i]= new pair(one[i+4] + 2*two[i+4] + 3*three[i+4], name[i+4]);
            sum1 += team1[i].score;
            sum2 += team2[i].score;
        }
        Arrays.sort(team1);
        Arrays.sort(team2);
        System.out.println(Math.max(sum1, sum2));

        //Who was the 2nd highest scorer on the losing team?
        int winning = sum1>sum2 ? 1 : 0;
        //System.out.println(Arrays.toString(team2));
        if(winning==0) System.out.println(team1[2].name);
        else System.out.println(team2[2].name);
    }


}
/*
Sample Input:
Larry 2 5 0
Moe 3 2 1
Curly 3 4 0
Shemp 5 3 2
Harpo 3 2 1
Groucho 4 3 1
Zeppo 0 0 0
Chico 9 1 1

Test Input:
Dick 4 4 4
Harry 3 1 1
Tom 0 0 5
Mike 2 1 2
Ellen 2 2 4
Beth 8 6 0
Anne 3 1 1
Mary 2 1 2
 */
