// [AIVLE/초급] 그림 감상
// 23:45 ~ 00:20 (35분)
/*
 * 4x4 크기의 O, X 문자로만 이루어진 그림
 *
 * 딱 한 번 그림의 O -> X 한 후
 * 2x2 크기의 X로만 이루어진 영역이 있을 수 있는 지 ("yse" or "no")
 */

package beginning;

import java.io.*;

public class painting_02 {

	static char[][] painting = new char[4][4];
	static int[] dr = {0, 1, 1}; // 오른쪽, 아래, 오른쪽 대각선 아래
	static int[] dc = {1, 0, 1}; // 오른쪽, 아래, 오른쪽 대각선 아래
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 그림 정보 입력
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();

			for (int j = 0; j < 4; j++) {
				painting[i][j] = str.charAt(j);
			}
		}

		System.out.println(checkProbability());
	}

	// 2x2 크기의 X로만 이루어진 영역이 있을 수 있는지 판단하는 함수
	private static String checkProbability() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (calXCount(i, j) >= 3) {
					return "yes";
				}
			}
		}

		return "no";
	}

	// 현재 위치, 오른쪽, 아래, 오른쪽 대각선 아래의 'X' 개수 파악
	private static int calXCount(int row, int col) {
		int xCnt = 0; // 3개 -> 가능!

		if (painting[row][col] == 'X') {
			xCnt++;
		}
		for (int i = 0; i < 3; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (painting[nr][nc] == 'X') {
				xCnt++;
			}
		}

		return xCnt;
	}
	
}
