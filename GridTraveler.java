import java.util.*;
public class GridTraveler {

	//Brute Force
	//Time Complexity O(2^n+m)
	//Space O(n+m)
	public static int gridTraveler(int n, int m) {
		if(n == 0 || m == 0) {
			return 0;
		}else if(n == 1 && m == 1) {
			return 1;
		}
		return gridTraveler(n-1,m) + gridTraveler(n,m-1);
	}
	//Optimal Solution
	//Time O(n+m)
	//Space O(n+m)
	public static long gridTravelerOptimal(int n, int m) {
		return optimal(n,m,new HashMap<String,Long>());
	}
	public static long optimal(int n, int m, Map<String, Long> map) {
		if(n == 0 || m == 0) {
			return 0;
		}else if(n == 1 && m ==1) {
			return 1;
		}else if(map.containsKey(n + ","+ m)) {
			return map.get(n + ","+ m);
		}
		else if(map.containsKey(m + ","+ n)) {
			return map.get(m + ","+ n);
		}
		long res = optimal(n-1,m,map) + optimal(n,m-1,map);//calculate
		//store results
		map.put(n + ","+ m,res);
		map.put(m + ","+ n,res);
		return res;
	}
	public static void main(String[] args) {
		System.out.println(gridTraveler(2,3));
		System.out.println(gridTravelerOptimal(2,3));
	}
}
