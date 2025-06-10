// [AIVLE/초급] 마법의 지팡이
// 22:37 ~ 23:05 (28분)
// 23:10 ~ 23:30 (20분)
/*
 * 마법의 지팡이 3개: 특정한 양의 정수로 변화시킴
 * 1. 2로 나누어 떨어짐 ➡️ 2로 나눔
 * 2. 3으로 나누어 떨어짐 ➡️ 3으로 나눈 뒤 2를 곱함
 * 3. 5로 나누어 떨어짐 ➡️ 5로 나눈 뒤 4를 곱합
 * 
 * 목표: 지팡이를 가능한 한 최소한의 횟수만큼 사용해서 양의 정수를 1로 만들기
 * (불가능한 경우 -1 출력)
 */

package beginning;

import java.util.*;

public class MagicWandDFS05 {

	static int N;
	static int min = Integer.MAX_VALUE;
	static int[] dividingValues = {2, 3, 5};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 1로 만들고 싶은 양의 정수

		dfs(N, 0);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void dfs(int num, int cnt) {
		// 이미 최솟값보다 큰 경로는 탐색 X
		if (cnt >= min) return;

		// 종료 조건: N이 1이 됨
		if (num == 1) {
			min = Math.min(cnt, min); // 지팡이 사용 횟수의 최솟값 갱신
			return;
		}

		// 지팡이 1: 2로 나누기
		if (num % 2 == 0) {
			dfs(num / 2, cnt + 1);
		}

		// 지팡이 2: 3으로 나눈 후 2 곱하기
		if (num % 3 == 0) {
			dfs(num / 3 * 2, cnt + 1);
		}

		// 지팡이 3: 5로 나눈 후 4 곱하기
		if (num % 5 == 0) {
			dfs(num / 5 * 4, cnt + 1);
		}
	}
}
