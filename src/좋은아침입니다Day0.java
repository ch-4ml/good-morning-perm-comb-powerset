
public class 좋은아침입니다Day0 {
	static char[] src = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {

		// 1. src로 구성할 수 있는 모든 부분집합을 출력하시오.
		System.out.println("부분집합");
		// powerset();

		// 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
		System.out.println("조합");
		// makeCombination(3,new char[3], 0);

		// 3. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
		System.out.println("순열");
		// makePermutation(3, new char[3], new boolean[src.length]);
	}
}
