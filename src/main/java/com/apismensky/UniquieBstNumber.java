package com.apismensky;

import java.util.HashMap;
import java.util.Map;

public class UniquieBstNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
           System.out.println("map.add(" + i + ", " + numTrees(i) + ");");
    }

    public static int numTrees2(int num) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 5);
        map.put(4, 14);
        map.put(5, 42);
        map.put(6, 132);
        map.put(7, 429);
        map.put(8, 1430);
        map.put(9, 4862);
        map.put(10, 16796);
        map.put(11, 58786);
        map.put(12, 208012);
        map.put(13, 742900);
        map.put(14, 2674440);
        map.put(15, 9694845);
        map.put(16, 35357670);
        map.put(17, 129644790);
        map.put(18, 477638700);
        map.put(19, 1767263190);
        return map.get(num);
    }
    public static int numTrees(int num) {
        if (num == 0 || num == 1) {
           return 1;
        }
        int f[] = new int[num+1];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <= num; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + f[j] * f[i-j-1];
            }
            f[i] = sum;
        }

        return f[num];
    }
}
