package Contest4;
/*
Davin Jeong 9
2019-2020 ACSL Contest 4 Junior Division
Stempia
*/

import java.io.*;
import java.util.*;

public class JR_patolli_Davin {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("1920c4jr.in"));
       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        initPre();

        Queue<String> sol = new LinkedList<String>();

        for(int z = 0; z<5; z++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            create(st);

            boolean over = false;

            //Start
            for(int tmp : rolls){
                int pos = tmp + cur;

                //Basic rules
                if(blocked(pos)) continue;
                if(pos==52){
                    sol.add("GAME OVER");
                    over = true;
                    break;
                }
                if(pos>52) continue;

                //Complex rules
                if(prime[pos]){
                    cur = pos;

                    for(int i = pos+1; i<=pos+6; i++){
                        if(blocked(i)) break;
                        cur=i;
                    }
                }
                else if(squares[pos]){
                    cur = pos;

                    for(int i = pos-1; i>=pos-6; i--){
                        if(blocked(i)) break;
                        cur=i;
                    }
                }
                else{
                    if(rule9(cur, pos)){
                        for(int i = cur; i<=pos; i++){
                            if(i%tmp==0 && !blocked(i)) cur = i;
                        }
                    }
                    else{
                        cur = pos;
                    }
                }
            }

            if(!over) sol.add(cur + "");
        }

        for(String tmp : sol){
            System.out.println(tmp);
        }

        in.close();
    }

    public static boolean rule9(int cur, int pos){
        //Hand-fill here because time-limit doesn't matter and much easier to implement
        boolean[] horz = {false, false, false, false, true, true, true, true, false, true, true, true, true, false, true, true, true, true, false, true, true, true, true, false, false, false, false, true, false, false, false, false, true, true, true, true, false, true, true, true, true, false, true, true, true, true, false, true, true, true, true, false, false};
        //System.out.println(horz.length);

        boolean h = false;

        for(int i = cur+1; i<=pos; i++){
            if(horz[i]) h = true;
            if(h && !horz[i]) return true;
        }
        return false;
    }

    public static boolean blocked(int i){
        if(opp[0]==i || opp[1]==i || opp[2]==i){
            return true;
        }
        return false;
    }

    public static int opp[], cur, r, rolls[];

    public static void create(StringTokenizer st){
        opp = new int[3];
        for(int i = 0; i<3; i++)opp[i] = Integer.parseInt(st.nextToken());

        cur = Integer.parseInt(st.nextToken());

        r = Integer.parseInt(st.nextToken());
        rolls = new int[r];
        for(int i = 0; i<r; i++) rolls[i] = Integer.parseInt(st.nextToken());
    }

    static boolean[] prime, squares;

    public static void initPre(){

        //Sieve
        int n = 52;

        prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        //Brute Force Squares
        squares = new boolean[n+1];
        int root = (int)Math.sqrt(52.0);

        for(int i = 3; i<=root; i++){
            if(i*i<=n) squares[i*i] = true;
        }
    }

}


