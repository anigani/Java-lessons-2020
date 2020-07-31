package com.company;

public class Exercise1 {
    public static void main(String[] args) {
        int m = 5;
        int n = 3;
        int d = 4;

        find(m, n, d);
    }

    private static void find(int m, int n, int d) {
        // step 0: initialize
        int mCap = m;
        int nCap = 0;

        while (true) {
            print(mCap, nCap);
            // step 1: Fill the m litre cap and empty it into n litre cap.
            if (mCap >= n) {
                if (nCap == 0) {
                    mCap = mCap - n;
                } else {
                    mCap = mCap - (n - nCap);
                }
                nCap = n;
            } else {
                if (n - nCap > mCap) {
                    nCap = nCap + mCap;
                    mCap = 0;
                } else {
                    mCap = mCap - (n - nCap);
                    nCap = n;
                }
            }
            print(mCap, nCap);
            // check
            if (mCap == d || nCap == d) {
                return;
            }
            // step 2: Whenever the m litre cap becomes empty fill it.
            if (mCap == 0) {
                mCap = m;
            }
            // step 3: Whenever the n litre cap becomes full empty it.
            if (nCap == n) {
                nCap = 0;
            }
        }

    }

    private static void print(int mCap, int nCap) {
        System.out.printf("mCap=%d, nCap=%d\n", mCap, nCap);
    }
}
