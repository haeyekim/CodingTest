// [AIVLE/초급] 방향 추적
// 16:50 ~ 17:03 (13분, 문제 분석)
// 17:25 ~ 17:44 (19분)
/*
 * (y축 방향: 북쪽, x축 방향: 동쪽)
 * 1. 움직인 방향: 북(1), 동(2), 남(3), 서(4)
 * 2. 이동 거리: 임의의 자연수
 * 
 * 좌표축과 평행하게만 이동
 * 
 * 목표: 위치 추적기가 가영이의 서버로 보내야 할 데이터 만들기
 */

package beginning;

import java.util.Scanner;

public class DirectionTracking07 {
	
	static int N;	// 이동 횟수
	static int[] Y;	// Y좌표
	static int[] X;	// X좌표

	static int[] dir;	// 움직인 방향
	static int[] dist;	// 이동 거리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Y = new int[N];
		X = new int[N];

		for (int i = 0; i < N; i++) {
			Y[i] = sc.nextInt();
			X[i] = sc.nextInt();
		}

		dir = new int[N - 1];
		dist = new int[N - 1];
		trackLoc();
		printTrack();
	}

	private static void trackLoc() {

		for (int i = 0; i < N-1; i++) {
			// y축 이동: 북(1), 남(3)
			if (X[i] == X[i+1]) {
				dist[i] = Math.abs(Y[i] - Y[i+1]);
				if (Y[i] < Y[i+1]) dir[i] = 1; // 북
				else dir[i] = 3; // 남
			}

			// x축 이동: 동(2), 서(4)
			if (Y[i] == Y[i+1]) {
				dist[i] = Math.abs(X[i] - X[i+1]);
				if (X[i] < X[i+1]) dir[i] = 2; // 동
				else dir[i] = 4; // 서
			}
		}
	}

	private static void printTrack() {
		for (int i = 0; i < N-1; i++) {
			System.out.println(dir[i] + " " + dist[i]);
		}
	}

}
