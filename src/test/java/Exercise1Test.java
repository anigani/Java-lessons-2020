import com.company.Exercise1;

public class Exercise1Test {
    public static void main(String[] args) {
        int N = 100;
        for (int m = 1; m < N; m++) {
            for (int n = 1; n < m; n++) {
                for (int d = 1; d < N && d < m; d++) {
                    System.out.printf("m=%d, n=%d, d=%d\n", m, n, d);
                    Exercise1 exercise1 = new Exercise1(m, n, d);

                    if (exercise1.isInputOK()) {
                        exercise1.find();
                    }
                }
            }
        }
    }
}
