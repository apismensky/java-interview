package com.apismensky;

import java.util.BitSet;

public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bs = new BitSet();

        bs.set(0);
        bs.set(1);
        bs.set(4);

        System.out.println(bs);
        BitSet bs2 = new BitSet();

        bs2.set(2);
        bs2.set(3);
        bs2.set(4);
        bs2.set(5);
        bs2.set(3);

        int length = bs2.length();
        System.out.println(length);
        System.out.println(bs2);
    }
}
