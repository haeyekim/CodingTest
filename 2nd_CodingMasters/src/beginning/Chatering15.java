// [AIVLE/초급] 채터링
// 23:05 ~ 23:13 (8분)
/*
 * 채터링: 스위치의 상태가 변하는 순간, 10ms 이내에 열림과 닫힘이 수 회 반복되는 현상
 *
 * 어떤 한 문자를 입력하면 K회 반복해서 출력됨
 *
 * 목표: 주어진 문자열 입력 시 출력되는 문자열을 출력
 */

package beginning;

import java.util.*;

public class Chatering15 {

	static int N, K;
	static String input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 입력하려는 문자열의 길이
		K = sc.nextInt(); // 채터링으로 인해 입력되는 횟수
		sc.nextLine();
		input = sc.nextLine();

		printOutput();
	}

	private static void printOutput() {
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(input.charAt(i));
			}
		}
		System.out.println();
	}
}
