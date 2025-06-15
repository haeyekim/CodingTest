// [AIVLE/초급] 팬그램
// 23:14 ~ 23:24 (10분)
/*
 * 팬그램: 알파벳의 모든 글자를 사용해서 만든 문장
 * 목표: 입력 문자열이 팬그램인지 여부 출력
 */

package beginning;

import java.util.*;

public class Pangram18 {

	static String input;
	static boolean[] visited = new boolean[26]; // 알파벳 사용 여부 확인

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine().toLowerCase();

		if (isPangram()) System.out.println("YES");
		else System.out.println("NO");
	}

	private static boolean isPangram() {
		for (int i = 0; i < input.length(); i++) {
			char alpha = input.charAt(i);
			visited[alpha - 'a'] = true;
		}

		for (int i = 0; i < 26; i++) {
			if (!visited[i]) return false;
		}

		return true;
	}
}
