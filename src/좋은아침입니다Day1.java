import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 좋은아침입니다Day1 {
	static char[] src = { 'a', 'b', 'c', 'd' };
	static int count;

	public static void main(String[] args) {

		boolean[] isSelected = new boolean[src.length];
		// 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
		count = 0;
		System.out.println("부분집합: ");
		powerset(isSelected, 0);
		System.out.println("\n" + count);

		// 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		count = 0;
		System.out.print("\n\n조합: ");
		makeCombination(3, new char[3], 0);
		System.out.println("\n" + count);

		// 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		count = 0;
		System.out.print("\n\n순열: ");
		makePermutation(3, new char[3], new boolean[src.length]);
		System.out.println("\n" + count);

	}

	private static void powerset(boolean[] isSelected, int startIndex) {
		List<Character> result = new ArrayList<>();

		// 기저조건
		if (startIndex == src.length) {
			for (int i = 0; i < src.length; i++) {
				if (isSelected[i])
					result.add(src[i]);
			}
			System.out.print(result.toString() + " ");
			count++;
			return;
		}

		// 유도조건
		// 현재 인덱스의 값을 포함
		isSelected[startIndex] = true;
		powerset(isSelected, startIndex + 1);

		// 현재 인덱스의 값을 포함하지 않음
		isSelected[startIndex] = false;
		powerset(isSelected, startIndex + 1);
	}

	private static void makeCombination(int left, char[] combination, int startIndex) {
		// 기저조건
		// 조합하려는 길이만큼 탐색을 완료한 경우
		if (left == 0) {
			System.out.print(Arrays.toString(combination) + " ");
			count++;
			return;
		}

		// 유도조건
		for (int i = startIndex; i < src.length; i++) {
			combination[combination.length - left] = src[i];
			makeCombination(left - 1, combination, i + 1);
		}
	}

	private static void makePermutation(int left, char[] permutation, boolean[] visited) {
		// 기저조건
		// 순열의 길이만큼 탐색을 완료한 경우
		if (left == 0) {
			System.out.print(Arrays.toString(permutation) + " ");
			count++;
			return;
		}

		// 유도조건
		for (int i = 0; i < src.length; i++) {
			if (visited[i])
				continue;
			
			// 선택한 요소를 체크
			visited[i] = true;
			
			// 선택
			permutation[permutation.length - left] = src[i];
			
			// 다음 수 선택
			makePermutation(left - 1, permutation, visited);
			
			// 선택을 해제하고 반복
			visited[i] = false;
		}
	}
}
