package Contest3;
/*
Davin Jeong 9
2019-2020 ACSL Contest 3 Junior Division
Stempia
*/
import java.io.*;
import java.util.*;

public class JR_veitch_Davin {
    static class pair{
        public int r;
        public int c;
        public pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int[][] arr, color;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("1920c3jr.in"));

        for(int z = 0; z<10; z++){
            //Input
            char[] input = in.readLine().trim().toCharArray();
            arr = convert(input);
            //System.out.println(z + " " + Arrays.toString(arr[0]) + "\n" + Arrays.toString(arr[1]));
            StringBuilder res = new StringBuilder();
            visited = new boolean[2][4];

            //1. Group 4 adjacent X's
            //2. Group 4 end column adjacent X's

            int[][] group4R = {
                    {0,0,0,0},
                    {1,1,1,1},
                    {0,0,1,1},
                    {0,0,1,1},
                    {0,0,1,1},
                    {0,0,1,1}
            };
            int[][] group4C = {
                    {0,1,2,3},
                    {0,1,2,3},
                    {0,1,0,1},
                    {1,2,1,2},
                    {2,3,2,3},
                    {0,3,0,3}
            };

            for(int group = 0; group<6; group++){
                boolean viable = true;
                ArrayList<pair> tmp = new ArrayList<pair>();
                for(int i = 0; i<4; i++){
                    if(!isViable(group4R[group][i], group4C[group][i])) {
                        viable = false;
                        break;
                    }
                    tmp.add(new pair(group4R[group][i], group4C[group][i]));
                }

                if(viable) res.append("+" + getTerm(tmp));
            }

            //3. Group 2 Adjacent X's
            for(int i = 0; i<2; i++){
                for(int j = 0; j<4-1; j++){
                    if(isViable(i, j) && isViable(i,j+1)){
                        ArrayList<pair> tmp = new ArrayList<pair>();
                        tmp.add(new pair(i,j));
                        tmp.add(new pair(i,j+1));
                        res.append("+"+getTerm(tmp));
                    }
                }
            }
            for(int j = 0; j<4; j++){
                if(isViable(0,j) && isViable(1,j)){
                    ArrayList<pair> tmp = new ArrayList<pair>();
                    tmp.add(new pair(0,j));
                    tmp.add(new pair(1,j));
                    res.append("+"+getTerm(tmp));
                }
            }

            //4. Group 2 end column adjacent X's
            if(isViable(0,0) && isViable(0,3)){
                res.append("+B~C");
                visited[0][0] = true; visited[0][3] = true;
            }
            if(isViable(1,0) && isViable(1,3)){
                res.append("+~B~C");
                visited[1][0] = true; visited[1][3] = true;
            }

            //5. Represent single X's
            for(int i = 0; i<2; i++){
                for(int j = 0; j<4; j++){
                    if(isViable(i,j)){
                        ArrayList<pair> tmp = new ArrayList<pair>();
                        tmp.add(new pair(i,j));
                        res.append("+" + getTerm(tmp));
                    }
                }
            }

            System.out.println(res.toString().substring(1));
        }

    }

    public static boolean isViable(int r, int c){
        return !visited[r][c] && arr[r][c]==1;
    }
    public static String getTerm (ArrayList<pair> list){
        boolean[] included = new boolean[6];//A,~A,B,~B,C,~C
        for(pair cur : list){
            visited[cur.r][cur.c] = true;

            if(cur.r == 0) included[2] = true;
            else if(cur.r == 1) included[3] = true;

            if(cur.c==0){
                included[0] = true;
                included[5] = true;
            }
            if(cur.c==1){
                included[0] = true;
                included[4] = true;
            }
            if(cur.c==2) {
                included[1] = true;
                included[4] = true;
            }
            if(cur.c==3){
                included[1] = true;
                included[5] = true;
            }
        }

        String term = "";
        if(included[0] && !included[1]) term+="A";
        else if(included[1] && !included[0]) term+="~A";
        if(included[2] && !included[3]) term+="B";
        else if(included[3] && !included[2]) term+="~B";
        if(included[4] && !included[5]) term+="C";
        else if(included[5] && !included[4]) term+="~C";

        return term;
    }


    public static int[][] convert (char[] input){
        int[][] arr = new int[2][4];

        for(int i = 0; i<2; i++){
            char tmp = input[i];
            String hexa = Integer.toBinaryString(Integer.parseInt(tmp+"", 16));
            while(hexa.length()<4) hexa = "0"+hexa;

            for(int j = 0; j<4; j++){
                arr[i][j] = hexa.charAt(j)-'0';
            }
        }

        return arr;
    }

}
