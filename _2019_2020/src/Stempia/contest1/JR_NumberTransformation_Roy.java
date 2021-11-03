package Stempia.contest1;
//Roy Park 9th grade
//ABCobot, Junior 5 Division
//Contest 1

import java.util.*;

import java.io.*;

public class JR_NumberTransformation_Roy {

    static Scanner in;

    static String[] arr;

    static String n, paper;

    static int pos, trans, z;

    public static void main(String[] args)throws IOException {

        in = new Scanner(new File("C1JR.in"));

        for(int i = 0;i<5;i++) {

            try{

            init();

            solve();

            } catch(Exception e){

                e.printStackTrace();

            }

        }

    }

    public static void init() {

        n = in.next();

        arr = new String[n.length()];

        z = arr.length;

        for(int i = 0;i<z;i++) {

            arr[i]=n.substring(i, i+1);

        }

        pos=in.nextInt();

        trans=in.nextInt();

        paper = "";

    }

    public static void solve() {

        boolean first = false;

        boolean second = false;

        if(Integer.parseInt(arr[z-pos])>=0&&Integer.parseInt(arr[z-pos])<=4)first = true;

        else if(Integer.parseInt(arr[z-pos])>=5&&Integer.parseInt(arr[z-pos])<=9)second = true;

        if(first==true) {

            int sum = (Integer.parseInt(arr[z-pos])+trans)%10;

            arr[z-pos]=String.valueOf(sum);

        }

        else if(second==true) {

            int sum = Math.abs(Integer.parseInt(arr[z-pos])-trans);

            while(sum>=10)sum/=10;

            arr[z-pos]=String.valueOf(sum);

        }

            for(int i = pos-1;i>0;i--) {

                arr[z-i]="0";

            }

            for(int i = 0;i<z;i++) {

                paper+=arr[i];

            }

            System.out.println(paper);

        }

    }
