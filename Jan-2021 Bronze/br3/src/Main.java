import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        MyMain m = new MyMain(args);
    }
}

class MyMain {
    long waysForThisCow(int[] stalls, int ht, int max) {
        long count = 0;

        for (int i=max;  i >= 0 && ht <= stalls[i]; i--) {
            count++;
        }
        return count;
    }

    void pr(String s) { System.out.println(s); }

    MyMain(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numCows = sc.nextInt();

        int hts[] = new int[numCows];
        int stalls[] = new int[numCows];

        for (int i=0; i< numCows; ++i) {
            hts[i] = sc.nextInt();
        }

        for (int i=0; i< numCows; ++i) {
            stalls[i] = sc.nextInt();
        }

        Arrays.sort(hts);
        Arrays.sort(stalls);

        long numWays = 1;

        for (int s = numCows - 1; s >= 0; --s) {
            long ways = waysForThisCow(stalls, hts[s], s);
            numWays = numWays * ways;
        }

        pr(""+ numWays);
    }
}



