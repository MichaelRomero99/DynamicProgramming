import java.util.*;
public class FibonacciSequence {
	//Time - O(2^n)
	//Space - O(n)
	public static int bruteForce(int n) {
		if(n <= 2) {
			return 1;
		}
		return bruteForce(n-1) + bruteForce(n-2);
	}
	//Time - O(n)
	//Space - O(n)
	public static int Memoization(int n) {
		int[] memo = new int[n];
		if(n <= 2) {
			return 1;
		}
		Arrays.fill(memo,-1);
		memo[0] = 1;
		memo[1] = 1;
		return optimalMemo(n, memo);
	}
	public static int optimalMemo(int n, int[] memo) {
		if(n <= 2) {
			return 1;
		}else if(memo[n-1] != -1) {
			return memo[n-1];
		}else {
			memo[n-1] = optimalMemo(n-1,memo) + optimalMemo(n-2,memo);
		}
		return memo[n-1];
	}
	public static void main(String[] args) {
		System.out.println(Memoization(7));
		System.out.println(bruteForce(7));
		System.out.println(bruteForce(1));
		System.out.println(Memoization(1));
		System.out.println(bruteForce(2));
		System.out.println(Memoization(2));
		System.out.println(Memoization(3));
		System.out.println(Memoization(9));
		System.out.println(Memoization(9));
	}
}
