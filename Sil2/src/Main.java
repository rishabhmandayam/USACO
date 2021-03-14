import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        MyMain m = new MyMain(args);
    }
}

class Jump implements Comparable<Jump> {
    int diff;
    boolean jump;

    public int compareTo(Jump other) {
        return this.diff - other.diff;
    }
}

class MyMain {

    int N;
    int K;
    int[] yrs;


    int ceil12(int n) {
        return (n + 11)/12;
    }

    MyMain(String args[]) {
        //StringBuilder sb = new StringBuilder(1000);

        InputStream is = System.in;
        Scanner sc = new Scanner(new BufferedInputStream(is, 128 * 1024));

        OutputStream os = System.out;
        PrintStream writer = new PrintStream(new BufferedOutputStream(os, 128 * 1024));

        N = sc.nextInt();
        K = sc.nextInt();
        yrs = new int[N];
        for (int i = 0; i < N; ++i) {
            yrs[i] = sc.nextInt();
        }
        Arrays.sort(yrs);

        int ceils[] = new int[N];
        int M = 1;
        ceils[M] = 0;
        for (int i=0; i< N; ++i) {
            int c = ceil12(yrs[i]);
            if (c != ceils[M-1]) {
                ceils[M] = c;
                ++M;
            }
        }

//        if (K > M) {
//            writer.println((M-1) * 12);
//            writer.flush();
//            return;
//        }
        yrs = null; // clear the memory

        // find diffs
        Jump jumpedCeils[] = new Jump[M-1];
        Jump diffs[] = new Jump[M-1];

        // add start to end jump
        K = K - 1;

        // compute the rest
        for (int i=0; i< diffs.length; ++i) {
            Jump j = new Jump();
            j.diff = ceils[i+1] - ceils[i];
            j.jump = false;
            diffs[i] = j;
            jumpedCeils[i] = j;
        }

        Arrays.sort(diffs);
        for (int i=diffs.length-1, k=0; i >= 0 && k < K; ++k, --i) {
            diffs[i].jump = true;
        }

        int num12Years = 0;
        for (int i = jumpedCeils.length - 1; i >= 0; --i) {
            Jump j = jumpedCeils[i];

            num12Years += 1;
            if (!j.jump)
                num12Years += j.diff - 1 ;
        }


        writer.println(12 * num12Years);
        writer.flush();
    }

}