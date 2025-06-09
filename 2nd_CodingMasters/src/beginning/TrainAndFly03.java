// [AIVLE/초급] 기차와 파리
// 01:44 ~ 01:54 (10분)
// 02:53 ~ 03:21 (28분)
/*
 * X 킬로미터 떨어진 철로
 * 양쪽에 두 대의 기차가 시속 Y킬로미터로 서로를 향해 출발
 * 
 * 두 기차 사이를 시속 Z킬로미터로 왔다 갔다하는 파리
 * 둘 중 한 기차의 방향으로 날다가 기차와 부딪히면 즉시 반대 방향으로 날기 시작
 * 
 * 목표: 두 기차가 충돌할 때까지 파리가 이동한 거리 출력 (소수점은 버림)
 */

package beginning;

import java.util.*;

public class TrainAndFly03 {

	static int X, Y, Z;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt(); // 철로 길이
		Y = sc.nextInt(); // 기차 속도
		Z = sc.nextInt(); // 파리 속도
		sc.close();

		int dist = (X * Z) / (2 * Y);
		System.out.println(dist);
	}
}
