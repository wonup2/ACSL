


import java.util.*;
import java.io.*;

public class AS1_ACSLBallJr {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i < 2; i++) {
			String[] names = new String[8];
			int[] one = new int[8];
			int[] two = new int[8];
			int[] three = new int[8];
			for (int j = 0; j < 8; j++) {
				names[j] = in.next();
				one[j] = in.nextInt();
				two[j] = in.nextInt();
				three[j] = in.nextInt();
			}
			
			int ans1 = 0;
			for (int j = 0; j < 8; j++) {
				ans1 += three[j];
			}
			System.out.println(ans1);
			
			int[] goals = new int[8];
			for (int j = 0; j < 8; j++) {
				goals[j] = one[j] + two[j] + three[j];
			}
			int max = 0;
			int ans2 = 0;
			for (int j = 0; j < 8; j++) {
				if (max < goals[j]) {
					max = goals[j];
					ans2 = j;
				}
			}
			System.out.println(names[ans2]);
			
			int[] scores = new int[8];
			for (int j = 0; j < 8; j++) {
				scores[j] = (one[j]) + (2 * two[j]) + (3 * three[j]);
			}
			int max2 = 0;
			int ans3 = 0;
			for (int j = 0; j < 8; j++) {
				if (max2 < scores[j]) {
					max2 = scores[j];
					ans3 = j;
				}
			}
			System.out.println(names[ans3]);
			
			int temp = 0;
			int jets = scores[0] + scores[1] + scores[2] + scores[3];
			int sharks = scores[4] + scores[5] + scores[6] + scores[7];
			if (jets > sharks) {
				temp = 1;
				System.out.println(jets);
			}
			else if (sharks > jets) {
				temp = 2;
				System.out.println(sharks);
			}
			
			if (temp == 1) {
				int[] arr = { scores[4], scores[5], scores[6], scores[7] } ;
				Arrays.sort(arr);
				int index = 0;
				for (int j = 4; j < 8; j++) {
					if (scores[j] == arr[2]) {
						index = j;
					}
				}
				System.out.println(names[index]);
			}
			else if (temp == 2) {
				int[] arr = { scores[0], scores[1], scores[2], scores[3] } ;
				Arrays.sort(arr);
				int index = 0;
				for (int j = 0; j < 4; j++) {
					if (scores[j] == arr[2]) {
						index = j;
					}
				}
				System.out.println(names[index]);
			}
		}
	}

}
