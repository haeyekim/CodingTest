// [AIVLE/초급] 떨어진 숫자
// 03:26 ~ 03:55 (29분)
/*
 * 수 하나 -> 여러 개의 숫자들로 분리
 *
 * 주워 담은 숫자 중 빠진 것 or 원래 갖고 있지 않은 것이 섞여있는지
 * -> "YES" or "NO"
 */

package beginning;

import java.io.*;

public class DroppedNumber04 {

	static String dropped, pickedUp;
	static int[] nums = new int[10]; // 빠진 것 or 원래 갖고 있지 않은 것이 있는지 확인하기 위함

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dropped = br.readLine();	// 땅에 떨어진 숫자
		pickedUp = br.readLine();	// 주워담은 숫자

		// 떨어뜨리고 주워담고
		droppedAndPicked();

		// 모두 주워담았는지 확인
		System.out.println(checkAllPickedUp());
	}

	private static void droppedAndPicked() {
		// 떨어진 수 -> nums[분리된 숫자]++
		for (int i = 0; i < dropped.length(); i++) {
			char c = dropped.charAt(i);
			int idx = c - '0';
			nums[idx]++;
		}

		// 주워담은 숫자 -> nums[주워담은 숫자]--
		for (int i = 0; i < pickedUp.length(); i++) {
			char c = pickedUp.charAt(i);
			int idx = c - '0';
			nums[idx]--;
		}
	}
	
	private static String checkAllPickedUp() {
		// nums 배열에 0이 아닌 값이 있음 == 빠진/새로운 숫자가 있음
		for (int i = 0; i < 10; i++) {
			if (nums[i] != 0) {
				return "NO";
			}
		}
		return "YES";
	}
}
