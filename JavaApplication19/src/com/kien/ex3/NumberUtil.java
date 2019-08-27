package com.kien.ex3;

public class NumberUtil {
    int value;

    void setValue(int value) {
        this.value = value;
    }

    boolean isPerfectNumber(long value) {
        long S = 0;
        for (long i = 1; i <= value; i++) {
            if (value % i == 0) {
                S += i;
            }
        }
        if (S == 2 * value) {
            return true;
        }
        return false;

    }

    boolean isSymmetryNumber(long value) {
        long bd = value;
        long rsv = 0;
        long orn = value;
        while (bd != 0) {
            rsv = rsv * 10 + bd % 10;
            bd /= 10;
        }
        if (rsv == orn) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NumberUtil nu = new NumberUtil();
        for (long i = 1; i <= 100000000; i++) {
            if (nu.isSymmetryNumber(i) &&nu.isPerfectNumber(i)) {
                System.out.println(i + " ");
            }
        }

    }
}
