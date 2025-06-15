// [AIVLE/초급] 전화번호 입력
// 22:48 ~ 22:58 (10분)
/*
 * 전화번호 입력받기 : 010-XXXX-XXXX
 * 유효한 입력인지 확인
 */

package beginning;

import java.io.*;

public class PhoneNumber14 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String phoneNumber = br.readLine();

		if (isValid(phoneNumber)) System.out.println("valid");
		else System.out.println("invalid");
	}

	public static boolean isValid(String phoneNumber) {
		if (phoneNumber.length() != 13)
			return false;

		for (int i = 0; i < 13; i++) {
			if (i == 3 || i == 8) {
				if (phoneNumber.charAt(i) != '-')
					return false;
			} else if (i == 0 || i == 2) {
				if (phoneNumber.charAt(i) != '0')
					return false;
			} else if (i == 1) {
				if (phoneNumber.charAt(i) != '1')
					return  false;
			} else {
				if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9')
					return false;
			}
		}

		return true;
	}
}
