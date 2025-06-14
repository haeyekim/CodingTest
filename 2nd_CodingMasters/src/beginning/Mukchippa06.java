// [AIVLE/초급] 묵찌빠봇
// 23:38 ~ 00:12 (34분)
// 09:25 ~ 09:41 (16분)
// 20:35 ~ 20:55 (20분)
// gpt 도움 - 20:55 ~ 21:20 (25분)
// 힌트 바탕으로 풀어보자 - 21:20 ~21:30(10분)
// 16:30 ~ 16:40 (10분)
/*
 * 묵찌빠봇 2개가 묵찌빠 하는 놀이
 * 입력: 1, 2, 3으로 이루어진 임의의 길이의 리스트
 * 
 * 1) 첫 번째 턴: 첫 번째 요소가 1이면 가위, 2면 바위, 3이면 보자기
 * 2) 두 번째 턴: 두 번째 요소가 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 * 묵찌바 룰
 * 1) 가위바위보 -> 이긴 쪽이 선공 (선공 못 정했으면 다시 가위바위보)
 * 2) 선공이 후공을 가위바위보로 이기면 그대로 유지 / 아니면 공수 교대 / 같으면 선공 승리
 * 
 * 목표: 어느 쪽이 승리할 지(1 or 2), 혹은 영원히 승부를 계속하게 될 지(0)
 */

package beginning;

import java.util.*;

public class Mukchippa06 {

	static int N, M; // 각각의 리스트의 길이
	static int[] bot1;
	static int[] bot2;
	static boolean[][][] visited = new boolean[50][50][3]; // [aIdx][bIdx][attacker]

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		bot1 = new int[N];
		bot2 = new int[M];

		for (int i = 0; i < N; i++) {
			bot1[i] = sc.nextInt();
		}
		for (int i = 0; i < M; i++) {
			bot2[i] = sc.nextInt();
		}

		System.out.println(findWinner());
	}

	// 가위바위보 승자 반환 함수
	private static int judge(int a, int b) {
		if (a == b) return 0;
		if ((a == 1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)) {
			return 1;
		}
		return 2;
	}

	private static int findWinner () {
		int attacker = 0;
		int bot1Idx = 0;
		int bot2Idx = 0;

		// 선공 정하기
		while (!visited[bot1Idx][bot2Idx][attacker] && attacker == 0) {
			attacker = judge(bot1[bot1Idx], bot2[bot2Idx]);
			visited[bot1Idx][bot2Idx][attacker] = true;

			bot1Idx = (bot1Idx + 1) % N;
			bot2Idx = (bot2Idx + 1) % M;
		}
		if (attacker == 0) return 0; // 선공 못 정함

		// 묵찌빠
		int preAttacker = attacker;
		while (!visited[bot1Idx][bot2Idx][attacker]) {
			attacker = judge(bot1[bot1Idx], bot2[bot2Idx]);
			visited[bot1Idx][bot2Idx][attacker] =true;

			if (attacker == 0) return preAttacker;

			preAttacker = attacker;
			bot1Idx = (bot1Idx + 1) % N;
			bot2Idx = (bot2Idx + 1) % M;
		}

		return 0;
	}
}
