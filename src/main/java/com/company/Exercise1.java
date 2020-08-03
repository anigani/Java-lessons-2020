package com.company;

import java.util.Scanner;

public class Exercise1 {
    private int m;
    private int n;
    private int d;

    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();

        exercise1.input();

        if (exercise1.isInputOK()) {
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

    public boolean isInputOK() {
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
        if (d == m) {
            System.out.printf("mCup=%d, nCup=%d\n", m, 0);
            System.out.println("Find solution.");
            return;
        }

        if (d == n) {
            System.out.printf("mCup=%d, nCup=%d\n", 0, n);
            System.out.println("Find solution.");
            return;
        }

        // step 0: initialize
        Cup mCup = new Cup(m);
        mCup.fill();
        Cup nCup = new Cup(n);
        nCup.empty();

        while (true) {
            print(mCup, nCup);
            // step 1: Fill the m litre cup and empty it into n litre cup.
            if (mCup.getSize() >= nCup.getVolume()) {
                if (nCup.isEmpty()) {
                    mCup.fillOut(nCup.getVolume());
                } else {
                    mCup.fillOut(nCup.getRemain());
                }
                nCup.fill();
            } else {
                if (nCup.getRemain() > mCup.getSize()) {
                    nCup.fillIn(mCup.getSize());
                    mCup.empty();
                } else {
                    mCup.fillOut(nCup.getRemain());
                    nCup.fill();
                }
            }
            print(mCup, nCup);
            // check
            if (mCup.getSize() == d || nCup.getSize() == d) {
                System.out.println("Find solution!");
                return;
            }
            // step 2: Whenever the m litre cup becomes empty fill it.
            if (mCup.isEmpty()) {
                mCup.fill();
            }
            // step 3: Whenever the n litre cup becomes full empty it.
            if (nCup.isFull()) {
                nCup.empty();
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

    private void print(Cup mCup, Cup nCup) {
        System.out.printf("mCup=%d, nCup=%d\n", mCup.getSize(), nCup.getSize());
    }
}
