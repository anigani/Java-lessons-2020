package com.company;

import java.util.Scanner;

public class Exercise1 {
    private int m;
    private int n;
    private int d;

    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();

        exercise1.input();

        if (exercise1.isOK()) {
            exercise1.find();
        }
    }

    public void input() {
        Scanner s = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Enter first cup volume: m = ");
        m = s.nextInt();  // Read user input

        System.out.print("Enter second cup volume: n = ");
        n = s.nextInt();  // Read user input

        System.out.print("Required liters: d = ");
        d = s.nextInt();  // Read user input
    }

    public boolean isOK() {
        if (n <= 0) {
            System.out.println("Input must be > 0.");
            return false;
        }

        if (m <= 0) {
            System.out.println("Input must be > 0.");
            return false;
        }

        if (d <= 0) {
            System.out.println("Input must be > 0.");
            return false;
        }

        if (n == m) {
            System.out.println("The cups volumes must be different.");
            return false;
        }

        if (m > n) {
            if (m % n == 0) {
                System.out.println("No solution.");
                return false;
            }
        } else {
            if (n % m == 0) {
                System.out.println("No solution.");
                return false;
            }
        }

        if (d > Math.max(m, n)) {
            System.out.println("Required liters must be <= max(m, n)");
            return false;
        }

        if ((d % gcd(m, n)) != 0) {
            System.out.println("GCD of n and m does not divide d");
            System.out.println("No solution!");
            return false;
        }

        return true;
    }

    public void find() {
        // step 0: initialize
        int mCap = m;
        int nCap = 0;

        if (d == m) {
            print(m, 0);
            System.out.println("Find solution.");
            return;
        }

        if (d == n) {
            print(0, n);
            System.out.println("Find solution.");
            return;
        }

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
                System.out.println("Find solution!");
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

    private int gcd(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }

        return num2;
    }

    private void print(int mCap, int nCap) {
        System.out.printf("mCap=%d, nCap=%d\n", mCap, nCap);
    }
}
