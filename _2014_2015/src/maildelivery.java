
//package _201415;

import java.io.*;
import java.util.*;
public class maildelivery {
    static class house implements Comparable<house>{
        public char gate;
        public int num;
        public house(char gate, int num){
            this.gate = gate;
            this.num = num;
        }
        public String toString(){
            return this.gate+ "" + this.num;
        }
        public int compareTo(house that){
            if(that.gate==this.gate) return this.num-that.num;
            else return this.gate-that.gate;
        }
    }

    public static ArrayList<house> list;

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<house>();

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++){
            String tmp = st.nextToken();
            list.add(new house(tmp.charAt(0), Integer.parseInt(tmp.substring(1))));
        }
        Collections.sort(list);

        for(int z = 0; z<5; z++){
            st = new StringTokenizer(in.readLine());
            int m = Integer.parseInt(st.nextToken());
            n+=m;

            for(int j = 0; j<m; j++){
                String tmp = st.nextToken();
                list.add(new house(tmp.charAt(0), Integer.parseInt(tmp.substring(1))));
            }
            Collections.sort(list);

            char start = st.nextToken().charAt(0);
            int k = Integer.parseInt(st.nextToken());

            int entry = 0;
            for(int i = 0; i<n; i++){
                if(list.get(i).gate == start){
                    entry = i;
                    break;
                }
            }

            // [entry, n) -> [0, n], again for outside
            System.out.println(traverse(entry, k));
        }
    }

    public static String traverse(int entry, int k){
        int n = list.size();

        int count = 0;
        for(int i = entry; i<n; i++){
            house tmp = list.get(i);
            if(tmp.num%2==1){
                count++;
                if(count==k){
                    return tmp.toString();
                }
            }
        }
        for(int i = 0; i<entry; i++){
            house tmp = list.get(i);
            if(tmp.num%2==1){
                count++;
                if(count==k){
                    return tmp.toString();
                }
            }
        }

        for(int i = entry; i<n; i++){
            house tmp = list.get(i);
            if(tmp.num%2==0){
                count++;
                if(count==k){
                    return tmp.toString();
                }
            }
        }
        for(int i = 0; i<entry; i++){
            house tmp = list.get(i);
            if(tmp.num%2==0){
                count++;
                if(count==k){
                    return tmp.toString();
                }
            }
        }
        return null;
    }
}
/*
Sample:
5 A435 B84 B97 B124 D4301
1 C321 B 4
2 C2 C84 A 5
0 B 7
1 D34 D 9
3 A241 B510 D43 C 10

Test:
6 B40 B20 C60 A312 D2 D15
0 D 5
2 B7 B50 A 3
2 B30 B60 C 7
1 C153 C 1
4 A111 C525 C100 D81 B 12
 */
