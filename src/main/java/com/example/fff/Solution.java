package com.example.fff;


public class Solution {
    public static int solution(int x, int[] arr) {
        boolean[] leaves = new boolean[arr.length + 1];
        int uncovered = arr.length;

        for (int i = 0; i < arr.length; i++) {
            int position = arr[i];
            if (!leaves[position]) {
                leaves[position] = true;
                uncovered--;

                if (uncovered == 0) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] arrs = args[1].split(",");
	int[] arr = new int[arrs.length];
	for (int i = 0; i < arrs.length;i++) {
            arr[i] = Integer.parseInt(arrs[i]);
	}
        System.out.println(solution(Integer.parseInt(args[0]), arr));
    }
}

