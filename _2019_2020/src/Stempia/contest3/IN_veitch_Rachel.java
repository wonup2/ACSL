package Stempia.contest3;
import java.util.*;

import java.io.*;

public class IN_veitch_Rachel {

	

	/*

	 * Name: Rachel Lee

	 * Grade: 11

	 * Division: Intermediate 3

	 * Contest 3

	 */

	

	static Scanner in;

	static String initial,temp;

	static String [] ary;

	static String [][] box;

	static String [][] nums;

	

	public static void main(String [] args) throws FileNotFoundException {

		in = new Scanner(new File("1920c3in.in"));

		

		for(int i = 0; i < 5; i++) {

			try {

				init();

				solve();

			}catch(Exception e) {

				e.printStackTrace();

			}

		}

	}

	static void init()throws IOException{

		ary = in.nextLine().split("\\+");

		temp = "";

		box = new String [4][4];

		nums = new String[4][4];

		box[0][0] = "0AB~C~D B~D A~D A~C AB~D A~C~D";

		box[0][1] = "0ABC~D AC A~D B~D AB~D AC~D";

		box[0][2] = "~ABC~D ~AC ~A~D B~D ~AB~D ~AC~D";

		box[0][3] = "~AB~C~D ~A~D B~D ~A~C ~A~C~D ~AB~D";

		box[1][0] = "0AB~CD A~C BD AD ABD A~CD";

		box[1][1] = "0ABCD AC AD BD ABD ACD";

		box[1][2] = "~ABCD ~AC ~AD BD ~ABD ~ACD";

		box[1][3] = "~AB~CD ~A~C ~AD BD ~ABD ~A~CD";

		box[2][0] = "0A~B~CD A~C AD ~BD A~BD A~CD";

		box[2][1] = "0A~BCD AD AC ~BD A~BD ACD";

		box[2][2] = "~A~BCD ~AD ~BD ~AC ~A~BD ~ACD";

		box[2][3] = "~A~B~CD ~AD ~A~C ~BD ~A~BD ~A~CD";

		box[3][0] = "0A~B~C~D A~C A~D ~B~D A~B~D A~C~D A~B~C~D";

		box[3][1] = "0A~BC~D AC A~D ~B~D A~B~D AC~D";

		box[3][2] = "~A~BC~D ~AC ~A~D ~B~D ~AC~D ~A~B~D";

		box[3][3] = "~A~B~C~D ~B~D ~A~C ~A~D ~A~B~D ~A~C~D";

	}

	static void solve() {

		int x = 0;

		while(x <= 0) {

			for(int i = 0; i < 4; i++) {

				for(int j = 0; j < 4; j++) {

					if(box[i][j].indexOf(ary[x]) >= 0) {

						if(ary[x].indexOf("~") == 0){

							nums[i][j] = "1";

						}else {

							if(box[i][j].charAt(box[i][j].indexOf(ary[x]) - 1) != '~') {

								nums[i][j] = "1";

							}else {

								nums[i][j] = "0";

							}

						}

					}else {

						nums[i][j] = "0";

					}	

				}

			}

			

			x++;

		}

		while(x < ary.length) {

			for(int i = 0; i < 4; i++) {

				for(int j = 0; j < 4; j++) {

					if(nums[i][j].equals("0")) {

						if(box[i][j].indexOf(ary[x]) >= 0) {

							if(ary[x].indexOf("~") == 0) {

								nums[i][j] = "1";

								//System.out.println("reach");

							}else if(box[i][j].charAt(box[i][j].indexOf(ary[x]) -1) != '~') {

								nums[i][j] = "1";

							}else {

								

							}

						}else {

							nums[i][j] = "0";

						}

					}else {

						continue;

					}

				}

			}

			

			x++;

		}

		for(int i = 0; i < 4; i++) {

			for(int j = 0; j < 4; j++) {

				temp+=nums[i][j];

			}

		}

		System.out.println(convertBinaryToHexadecimal(temp));



	}

	public static String convertBinaryToHexadecimal(String number) {

        String hexa = "";

        char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',

                'B', 'C', 'D', 'E', 'F' };

        if (number != null && !number.isEmpty()) {

            int decimal = convertBinaryToDecimal(number);

            while (decimal > 0) {

                hexa = hex[decimal % 16] + hexa;

                decimal /= 16;

            }

        }

        if(hexa.length() == 3) {

        	hexa= "0"+hexa;

        }

        if(hexa.length() == 2) {

        	hexa = "00"+hexa;

        }

        if(hexa.length() == 1) {

        	hexa = "000"+hexa;

        }

        return hexa;

    }

    public static int convertBinaryToDecimal(String number) {

        int length = number.length() - 1;

        int decimal = 0;

        if (isBinary(number)) {

            char[] digits = number.toCharArray();

            for (char digit : digits) {

                if (String.valueOf(digit).equals("1")) {

                    decimal += Math.pow(2, length);

                }

                --length;

            }

        }

        return decimal;

    }

    public static boolean isBinary(String number) {

        boolean isBinary = false;

        if (number != null && !number.isEmpty()) {

            long num = Long.parseLong(number);

            while (num > 0) {

                if (num % 10 <= 1) {

                    isBinary = true;

                } else {

                    isBinary = false;

                    break;

                }

                num /= 10;

            }

        }

        return isBinary;

    }

	

}