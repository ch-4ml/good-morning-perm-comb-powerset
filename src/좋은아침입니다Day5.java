import java.util.Arrays;

public class 좋은아침입니다Day5 {
	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
		
//		1. src로 구성할 수 있는 부분집합을 비트 연산을 사용하여 모두 출력하시오
		System.out.println("비트연산 부분집합");
		powerset();
		System.out.println();
		System.out.println();

//		2. src에서 3개를 뽑아서 만들 수 있는 조합을 NP를 이용하여 출력하시오.
		System.out.println("NP 조합");
//		nextPermutation();
		System.out.println();
		System.out.println();
		
//		3. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		System.out.println("조합");
//		combination();
		System.out.println();
		System.out.println();

//		4. src에서 3개를 뽑아서 만들 수 있는 중복조합을 모두 출력하시오.
		System.out.println("중복조합");
//		combinationWithRepetition();
		System.out.println();
		System.out.println();

//		5. src에서 3개를 뽑아서 만들 수 있는 순열을 NP를 이용하여 모두 출력하시오.
		System.out.println("NP");
//		nextPermutation();
		System.out.println();
		System.out.println();
		
//		6. src에서 3개를 뽑아서 만들 수 있는 순열을 비트마스킹을 이용하여 모두 출력하시오.
		System.out.println("비트마스킹 순열");
//		permutationUsingBitMasking();
		System.out.println();
		System.out.println();

//		7. src에서 3개를 뽑아서 만들 수 있는 중복순열을 모두 출력하시오.
		System.out.println("중복순열");
//		permutationWithRepetition();
		System.out.println();
		System.out.println();
	}
	
	private static void powerset() {
		// 1 << src.length: 부분집합 개수(2^n)
		for(int i = 0; i < (1 << src.length); i++) {
			System.out.print("[ ");
			// 각 자리 선택 여부 체크
			for(int j = 0; j < src.length; j++) {
				if ((i & 1 << j) != 0) System.out.print(src[j] + " ");
			}
			System.out.print("] ");
		}
	}
	
	private static void nextPermutation(int[] numbers) { 
		// index 배열 만들기
		int N = numbers.length;
		
		// 1. 전처리 (오름차순 정렬)
		Arrays.sort(numbers);
	
		// 2. 꼭대기 찾기
		int i = N - 1;
		while(i > 0 && numbers[i - 1] >= numbers[i]) i--;
		
		// 3. 내림차순으로 정렬되어 더이상 순열을 만들 수 없는 경우 체크
		if(i == 0) return;
		
		// 4. 꼭대기의 바로 앞 자리(i-1) 값을 크게 만들 교환 값을 뒤에서부터 찾기
		// 항상 존재!!
		int j = N - 1;
		while(numbers[i - 1] >= numbers[j]) j--;
		
		// 5. i-1 위치 값과 j 위치 값 교환
		swap(numbers, i - 1, j);
		
		// 6. i 위치부터 만들어지는 수열을 오름차순으로 정렬
		int k = N - 1;
		while(i < k) swap(numbers, i++, k--);
	}
	
	private static void swap(int[] indice, int i, int j) {
		int temp = indice[i];
		indice[i] = indice[j];
		indice[j] = temp;
	}
}
