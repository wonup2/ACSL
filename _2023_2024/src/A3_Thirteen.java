import java.io.*;
import java.util.*;

public class A3_2324_Thirteen {

	static Scanner in;
	static int n, hands[][];
	static String order = "3456789TJQKA2";
	static LinkedHashSet<Integer> finishedOrder;  //이미 winner 자꾸 반복해서 넣지 않도록
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new FileReader("A3.in"));
		
		int t = 10;
		while(t-->0) {
			init();
			solve();
		}
	}
	
	static void init() {
		
		n = in.nextInt(); in.nextLine();
		hands = new int[n][13];
		for(int i=0; i<n; i++) {
			String temp[]= in.nextLine().split(" ");
			for(int j=0; j<temp.length; j++) {
				int num = order.indexOf(temp[j].charAt(0));
				hands[i][num]++;
			}
		}		
		
		finishedOrder = new LinkedHashSet<Integer>();
	}
		
	static void solve() {
		
		int player = 0;
		
		while(true) {
			
			int x = 0;
			int rank = -1;

			//시작 player 들고있는 카드중에서 최대 x 찾고, 제일 낮은 rank 찾기
			for(int i=0; i<13; i++) {
				
				if(x < hands[player][i]) {
					x = hands[player][i];
					rank = i;
				}
			}
			
			//이미 이긴 player 인가? 그렇다면 다음 player
			if(rank==-1) {
				player = (player + 1)%n;
				continue;
			}
			
			//그 카드 내려놓기
			hands[player][rank] = 0;
			
			//시작 player 카드가 다 소진됐나? finishOrder 에 그 플레이어를 add
			if(isEmpty(player)) finishedOrder.add(player+1);
						
			//player 한명 남으면 game 끝
			if(finishedOrder.size() >= n-1) break;
			
			//round 시작
			player = (player + 1)%n;
			int play = 1;
			
			while(true) {		
								
				play++;
				
				//각 player 가 가진 x 중에서 currentRank 바로 위에꺼 찾아서 내려놓기
				for(int i=rank+1; i<13; i++) {
					if(hands[player][i] == x) {
						play = 1;
						hands[player][i]=0; 
						rank = i;  
						break;
					}
				}
				
				//Is this player winner? 
				if(isEmpty(player)) finishedOrder.add(player+1);
				
				//player 한명남음
				if(finishedOrder.size()>=n-1) break;
				
				//한바퀴 돌았는데 내려놓은 카드가 없음
				if(play==n+1) break; 	
								
				//다음 player
				player = (player+1)%n;
			}	
		}
		
		//마지막 남은 선수
		for(int i=0; i<n; i++) 
			if(!isEmpty(i))finishedOrder.add(i+1);		


		System.out.println(finishedOrder);
	}

	
	static boolean isEmpty(int n) {
		for(int c:hands[n]) 
			if(c>0) return false;		
		
		return true;
	}
}
