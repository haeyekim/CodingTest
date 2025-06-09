// [AIVLE/초급] 그룹ID
// 22:00 ~ 23:25 (85분)
/*
 * 그래프
 * 정점 N개 (1번 ~ N번)
 * 간선 M개 (양방향)
 *
 * u번 정점에서 v번 정점으로 가는 경로가 존재함 == 두 사람이 같은 그룹에 속함
 * 그룹의 ID: 해당 그룹에 포함된 사람들의 번호 중 가장 작은 번호
 * 
 * 목표: 가장 많은 사람이 포함된 그룹의 ID 구하기
 * (해당 조건의 그룹이 여러 개일 경우, 그 중 가장 작은 ID 출력)
 */

package beginning;

import java.util.*;

public class groupID_01 {

	static int N; // 정점 개수
	static int M; // 간선 개수
	static List<Integer>[] graph;
	static boolean[] visited; // 정점 방문 여부
	static int cnt = 0; // 그룹에 속한 사람 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];

		// 그래프 정보 입력
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt(); // u번 정점
			int v = sc.nextInt(); // v번 정점

			// 간선 생성
			graph[u].add(v);
			graph[v].add(u);
		}

		int max = Integer.MIN_VALUE;
		int groupID = 0;
		for (int i = N; i > 0; i--) {
			// 그룹에 속하는 사람 수 구하기
			cnt = 0;
			calCount(i);

			// groupID 구하기
			max = Math.max(max, cnt);
			if (max == cnt) {
				groupID = i;
			}

			// visited 배열 초기화
			for (int j = 0; j <= N; j++) {
				visited[j] = false;
			}
		}

		System.out.println(groupID);
	}

	private static void calCount(int vertex) {
		if (visited[vertex] == false) {
			visited[vertex] = true; // 정점 방문 표시
			cnt++; // 그룹에 속하는 사람 수 + 1
			for (int i = 0; i < graph[vertex].size(); i++) {
				calCount(graph[vertex].get(i));
			}
		}
	}
}

/*
 * 1 -- 2
 * |    |
 * 4 -- 3
 */

/*
 * 5 -- 3 -- 2
 *      |  /
 *      4
 */