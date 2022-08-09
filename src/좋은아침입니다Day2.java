import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 좋은아침입니다Day2 {
	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {

//		1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("부분집합");
		powerset(0, new boolean[src.length]);

//		2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		System.out.println("\n조합");
		makeCombination(3, new char[3], 0);

//		3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("\n순열");
		makePermutation(3, new char[3], new boolean[src.length]);
	}

	private static void powerset(int current, boolean[] isSelected) {
		// 기저 조건
		if (current == src.length) {
			List<Character> result = new ArrayList<>();

			for (int i = 0; i < src.length; i++) {
				if (isSelected[i])
					result.add(src[i]);
			}
			System.out.print(result.toString() + " ");
			return;
		}

		// 사용 했을 때
		isSelected[current] = true;
		powerset(current + 1, isSelected);

		// 사용 안했을 때
		isSelected[current] = false;
		powerset(current + 1, isSelected);
	}

	private static void makeCombination(int left, char[] combination, int startIndex) {
		if (left == 0) {
			System.out.print(Arrays.toString(combination) + " ");
			return;
		}

		for (int i = startIndex; i < src.length; i++) {
			combination[combination.length - left] = src[i];
			makeCombination(left - 1, combination, i + 1);
		}
	}
	
	private static void makePermutation(int left, char[] permutation, boolean[] isSelected) {
		if (left == 0) {
			System.out.print(Arrays.toString(permutation) + " ");
			return;
		}
		
		for(int i = 0; i < src.length; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			permutation[permutation.length - left] = src[i];
			makePermutation(left - 1, permutation, isSelected);
			isSelected[i] = false;
		}
	}
}
