import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class A3_Thirteen {
    // 카드 순위: 3=0, 4=1, 5=2, 6=3, 7=4, 8=5, 9=6, T=7, J=8, Q=9, K=10, A=11, 2=12
    static final String RANK_ORDER = "3456789TJQKA2";

    static int n;
    static int[][] hands;       // hands[i][r] = 플레이어i가 가진 랭크r 카드 수
    static boolean[] finished;
    static List<Integer> finishOrder;
    static Scanner sc;
    
    public static void main(String[] args) throws IOException {
        sc = new Scanner(new FileReader("A3.in"));

    	int t = 10;
    	while(t-->0) {
    		init();
    		solve();
    	}
    }

    static void init() throws IOException {
        n = sc.nextInt();
        sc.nextLine();

        hands = new int[n][13];
        for (int i = 0; i < n; i++) {
            String[] cards = sc.nextLine().trim().split("\\s+");
            for (String card : cards) {
                int r = RANK_ORDER.indexOf(card.charAt(0));
                hands[i][r]++;
            }
        }

        finished = new boolean[n];
        finishOrder = new ArrayList<>();
    }

    // ── 실제 게임 시뮬레이션 ──
    static void solve() {
        int startPlayer = 0;

        outer:
        while (true) {

            // ── [시작 플레이어] 1. 내 패에서 최대 X 계산 ──
            int X = 0;
            for (int r = 0; r < 13; r++)
                X = Math.max(X, hands[startPlayer][r]);

            // ── [시작 플레이어] 2. X개짜리 중 가장 낮은 랭크 선택 ──
            int currentRank = -1;
            for (int r = 0; r < 13; r++) {
                if (hands[startPlayer][r] == X) { currentRank = r; break; }
            }

            // ── [시작 플레이어] 3. 해당 카드 버리기 ──
            hands[startPlayer][currentRank] -= X;

            // ── [시작 플레이어] 4. 완료 체크 ──
            if (isEmpty(hands[startPlayer]) && !finished[startPlayer]) {
                finished[startPlayer] = true;
                finishOrder.add(startPlayer + 1);
            }
            if (finishOrder.size() >= n - 1) break;  //4명중 3명 완료면 끝

            
            
            
            // ── [나머지 플레이어] sweep 준비 ──
            boolean[] inRound = new boolean[n];
            for (int i = 0; i < n; i++) inRound[i] = !finished[i]; //안끝난 애들만 round 에 낄 수 있음

            int lastPlayer = startPlayer;
            int nextStart = (startPlayer + 1) % n; 

            while (true) {
                boolean anyPlayed = false;  //누군가 어쨌거나 카드를 내면 true 한바퀴 돌동안 한명도 못냈어. 그럼 다시 처음부터 시작.

                // ── [나머지 플레이어] 1. 모든 플레이어 순서대로 돌기 ──
                int p = nextStart;
                
                for (int step = 0; step < n; step++) {                	
                	
                    if (inRound[p]) {
                        // ── [나머지 플레이어] 2. X개 && currentRank보다 높은 랭크 있으면 → 내기 ──
                        int playRank = -1;
                        for (int r = currentRank + 1; r < 13; r++) {
                            if (hands[p][r] == X) { playRank = r; break; }
                        }

                        if (playRank != -1) {
                            hands[p][playRank] -= X;
                            currentRank = playRank;
                            lastPlayer = p;
                            anyPlayed = true;

                            if (isEmpty(hands[p]) && !finished[p]) {
                                finished[p] = true;
                                finishOrder.add(p + 1);
                                inRound[p] = false;
                                if (finishOrder.size() >= n - 1) break outer;
                            }
                        } 
                        
                        else inRound[p] = false;   // ── [나머지 플레이어] 3. 없으면 → 패스 (라운드 제외) ──
                        
                    }
                    p = (p + 1) % n;
                }

                // ── [나머지 플레이어] 4. 한 바퀴 돌았는데 아무도 못 냄 → 라운드 종료 ──
                if (!anyPlayed) break;

                // ── [나머지 플레이어] 5. 누군가 냈으면 → 그 다음 플레이어부터 다시 sweep ──
                nextStart = (lastPlayer + 1) % n;
            }

            // ── 다음 라운드 시작 플레이어 결정 ──
            if (finished[lastPlayer]) {
                int np = (lastPlayer + 1) % n;
                while (finished[np]) np = (np + 1) % n;
                startPlayer = np;
            } else {
                startPlayer = lastPlayer;
            }
        }

        
        // finishOrder 뒤에 remaining 추가
        for (int i = 0; i < n; i++) {
            if (!finished[i]) { finishOrder.add(i + 1); break; }
        }

        // 출력
        for (int i = 0; i < finishOrder.size(); i++) 
            System.out.print(finishOrder.get(i) + " ");
        
        System.out.println();
    }

    static boolean isEmpty(int[] hand) {
        for (int c : hand) if (c > 0) return false;
        return true;
    }
}
