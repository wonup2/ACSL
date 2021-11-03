package Stempia.contest1;
//Joseph Jang
//ABCobot Junior 5
//Contest 1

import java.util.*;
import java.io.*;
public class JR_2019_2020_Joseph {
    static Scanner input;
    static int[] nums;
    static int p;
    static int d;
    public static void main(String[] args) throws IOException {
        input = new Scanner(new File("c1jr.in"));
        try {
            for(int count = 0; count < 5; count ++) {
                init();
                solve();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void init() throws IOException {
        String sample;
        sample = input.next();
        nums = new int[sample.length()];
        for(int count = 0; count < sample.length(); count ++) {
            nums[count] = Character.getNumericValue(sample.charAt(count));
        }
        p = input.nextInt();
        d = input.nextInt();
    }
    public static void solve() throws IOException {
        if(nums[nums.length - p] >= 0 && nums[nums.length - p] <= 4) {
            nums[nums.length - p] += d;
            nums[nums.length - p] %= 10;
        }
        else if(nums[nums.length - p] >= 5 && nums[nums.length - p] <= 9) {
            nums[nums.length - p] -= d;
            nums[nums.length - p] = Character.getNumericValue(Integer.toString(Math.abs(nums[nums.length - p])).charAt(0));
        }
        for(int count = nums.length - p + 1; count < nums.length; count ++) {
            nums[count] = 0;
        }
        for(int count = 0; count < nums.length; count ++) {
            System.out.print(nums[count]);
        }
        System.out.println();
    }

}