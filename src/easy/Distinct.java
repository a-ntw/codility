package easy;

/**
 * 220503 Codility Lesson 6 Sorting Write a function
 * <blockquote>{@code
 *      class Solution { public int solution(int[] A); }
 * }</blockquote>
 * that, given an array A consisting of N integers, returns the number of
 * distinct values in array A.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <blockquite>{@code
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * }</blockquote>
 * the function should return 3, because there are 3 distinct values appearing
 * in array A, namely 1, 2 and 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 *
 * @author antw
 */
public class Distinct {

    public int solution(int[] A) {
        int lgth = A.length, numDistinct = 0, min, max;

        if (lgth < 2) {
            return lgth;
        }

        // search for max and min
        min = lgth;
        max = 0;
        for (int i = 0; i < lgth; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }

        //System.out.println("min: " + min + " max: " + max);
        byte[] B = new byte[max + 1];
        //System.out.println("B lgth: " + B.length);

        for (int i = 0; i < lgth; i++) {
            B[A[i]] = 1;
            //System.out.print("B[" + A[i] + "]  ");
        }
        //System.out.println("");

        for (int b = min; b <= max; b++) {
            if (B[b] == 1) {
                numDistinct++;
            }
        }

        return numDistinct;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Distinct c = new Distinct();
        data.TestData data = new data.TestData();

        int[] A = {2, 1, 1, 0, 100000, 1};
        System.out.println("Solution A: " + c.solution(A));
        int[] B = {2, 1};
        System.out.println("Solution B: " + c.solution(B));
        int[] C = data.endPairOdd(999999);
        System.out.println("Solution C: " + c.solution(C));
        int[] D = data.evenOdd(999999);
        System.out.println("Solution D: " + c.solution(D));

    }
}

/* CodeCheck Report: 75% 
Analysis summary
The following issues have been detected: runtime errors.

For example, for the input [-1, -2, -3, -1, -2] the solution terminated unexpectedly.

▶ large_random1 
chaotic sequence of values from [-1M..1M], length=100K ✘RUNTIME ERROR 
tested program terminated with exit code 1
1. 0.276 s RUNTIME ERROR,  tested program terminated with exit code 1
stderr:
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -949979
	at Solution.solution(Solution.java:34)
	at Exec.run(exec.java:48)
	at Exec.main(exec.java:34)
▶ large_random2 
another chaotic sequence of values from [-1M..1M], length=100K ✘RUNTIME ERROR 
tested program terminated with exit code 1
1. 0.268 s RUNTIME ERROR,  tested program terminated with exit code 1
stderr:
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -182928
	at Solution.solution(Solution.java:34)
	at Exec.run(exec.java:48)
	at Exec.main(exec.java:34)
*/
