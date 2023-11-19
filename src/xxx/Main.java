package xxx;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		System.out.println(min(new int[] { 90, 837, 754, -139, 73, -46, -567, -566 }));
		System.out.println();
		for (double i : bubbleSort(new double[] { 90, 90.01, 837, 754, -139, 73, -46, -567, -566 }))
			System.out.println(i);
		System.out.println();
		System.out.println(factorial(5));
		System.out.println();
		System.out.println(sumOfEvens(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
		System.out.println();
		System.out.println(isPrime(935));
		System.out.println();
		System.out.println(countVovels("Dead man"));
		System.out.println();
		System.out.println(average(new double[] { 12, -13, -5 }));
		System.out.println();
		System.out.println(gcd(26, 88));
		System.out.println();
		System.out.println(fibByIndex(0));
		System.out.println(fibByIndex(7));
		System.out.println();
		for (int i : fibSequence(9))
			System.out.println(i);
		System.out.println();
		System.out.println(findMissingElements(new int[] { 3, 2, 5, 1, 9, 7, 9 }, 9));
		System.out.println();
		System.out.println(isPalindrome("Anna"));
		System.out.println(isPalindrome("Annad"));
		System.out.println(isPalindrome("A man, a plan, a canal, Panama!")); // amanaplanacanalpanama
		System.out.println();
		System.out.println(isAnagram("table", "abtel"));
		System.out.println(isAnagram("ghi", "jkf"));
		System.out.println();
		System.out.println(longestSequence(new int[] {1, 2, 3, 4, 2, 3, 9, 9, 7, 8, 9, 9, 9, 9, 9, 9, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9}));
		System.out.println();
		System.out.println(largestDifference(new int[] {30, 9, 8, 7, -4, -5, 10}));
		System.out.println();
		System.out.println(max(new int[] {4, 2, 9, 7, 5, 10}));
		System.out.println();
		System.out.println(equalElements(new Object[] {"aaa", "f", 78, 90.23, 9999999999L, 762.08F}, new Object[] {"aaa", "f", 7, "32", 93999999, 762.08F}));
	}

	public static int min(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i : arr)
			min = Math.min(i, min);
		return min;
	}

	public static double[] bubbleSort(double[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}

	public static int factorial(int num) {
		int res = 1;
		for (int i = 1; i <= num; i++)
			res *= i;
		return res;
	}

	public static int sumOfEvens(int[] arr) {
		int res = 0;
		for (int i : arr)
			if (i % 2 == 0)
				res += i;
		return res;
	}

	public static boolean isPrime(int num) {
		if (num < 1)
			throw new IllegalArgumentException("num cannot be < 1");

		if (num == 2)
			return true;

		if (num % 2 == 0 || num < 2)
			return false;

		for (int i = 3; i <= num / 2; i += 2)
			if (num % i == 0)
				return false;

		return true;
	}

	public static int countVovels(String s) {
		return s.replaceAll("[^aeiou]", "").length();
	}

	public static double average(double[] arr) {
		double sum = 0;
		for (double i : arr)
			sum += i;
		return sum / arr.length;
	}

	public static int gcd(int a, int b) {
		if (a < 1 || b < 1)
			throw new IllegalArgumentException("a or b cannot be < 1");
		for (int i = Math.min(a, b); i > 1; i--)
			if (a % i == 0 && b % i == 0)
				return i;
		return 1;
	}

	public static int fibByIndex(int i) {
		if (i < 1)
			return 0;
		if (i == 1)
			return 1;
		return fibByIndex(i - 1) + fibByIndex(i - 2);
	}

	public static int[] fibSequence(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = fibByIndex(i);
		return arr;
	}

	public static Set<Integer> findMissingElements(int[] arr, int n) {
		Set<Integer> res = new HashSet<>();
		for (int i = 1; i <= n; i++)
			res.add(i);
		for (int num : arr)
			res.remove(num);
		return res;
	}

	public static boolean isPalindrome(String s) {
        return (s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")).equals(new StringBuilder(s).reverse().toString());
	}

	public static boolean isAnagram(String a, String b) {
        if ((a = a.toLowerCase().replaceAll("[^a-zA-Z0-9]", "")).length() != (b = b.toLowerCase().replaceAll("\\s", "")).length())
            return false;
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        return Arrays.equals(aArr, bArr);
	}
	
	public static int largestDifference(int[] arr) {
		int res = 0;
		for (int i : arr)
			for (int j : arr)
				res = Math.max(res, Math.abs(i - j));
		return res;
	}
	
	public static Set<Integer> longestSequence(int[] arr) {
		Set<Integer> longestSequence = new HashSet<>();
		Set<Integer> sequence;
		for (int i = 0; i < arr.length;) {
        	sequence = new HashSet<>();
	        do {
        		sequence.add(arr[i]);
        		i++;
	        } while(i > 0 && i < arr.length - 1 && arr[i] > arr[i - 1]);
			if (sequence.size() > longestSequence.size())
				longestSequence = sequence;
		}
        return longestSequence;
	}

	public static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i : arr)
			max = Math.max(i, max);
		return max;
	}


	public static Set<Object> equalElements(Object[] a, Object[] b) {
		Set<Object> set = new HashSet<>();
        for (int i = 0; i < a.length; i++)
        	for (int j = 0; j < b.length; j++) {
        		if (a[i].equals(b[j])) {
        			set.add(a[i]);
        		}
        	}
        return set;
	}
}